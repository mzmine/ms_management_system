package com.mzmine.msmanagmentsystem.controller;

import com.mzmine.msmanagmentsystem.model.Compound;
import com.mzmine.msmanagmentsystem.service.CompoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/compounds")
public class CompoundController {

    private final CompoundService compoundService;

    @Autowired
    public CompoundController(CompoundService compoundService) {
        this.compoundService = compoundService;
    }

    @PostMapping
    public ResponseEntity<List<Compound>> createCompound(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Compound> createdCompounds = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");

                if (fields.length != 8) {
                    // Invalid line format
                    continue;
                }

                String name = fields[0];
                String formula = fields[1];
                String canonicalSmiles = fields[2];
                String isomericSmiles = fields[3];
                String inchi = fields[4];
                String inchiKey = fields[5];
                Double mass = Double.parseDouble(fields[6]);

                Compound compound = new Compound(null, name, canonicalSmiles, isomericSmiles, inchi, inchiKey, formula, mass);
                createdCompounds.add(compoundService.createCompound(compound));
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(createdCompounds);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Compound> getCompound(@PathVariable Long id) {
        Compound compound = compoundService.getCompoundById(id);
        if (compound != null) {
            return ResponseEntity.ok(compound);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more API methods for updating, deleting, or listing compounds
}
