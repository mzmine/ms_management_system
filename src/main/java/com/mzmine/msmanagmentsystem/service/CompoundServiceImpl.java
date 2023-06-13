package com.mzmine.msmanagmentsystem.service;

import com.mzmine.msmanagmentsystem.model.Compound;
import com.mzmine.msmanagmentsystem.repository.CompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompoundServiceImpl implements CompoundService {

    private final CompoundRepository compoundRepository;

    @Autowired
    public CompoundServiceImpl(CompoundRepository compoundRepository) {
        this.compoundRepository = compoundRepository;
    }

    @Override
    public Compound createCompound(Compound compound) {
        return compoundRepository.save(compound);
    }

    @Override
    public Compound getCompoundById(Long id) {
        Optional<Compound> compoundOptional = compoundRepository.findById(id);
        return compoundOptional.orElse(null);
    }

    @Override
    public List<Compound> getAllCompounds() {
        return compoundRepository.findAll();
    }

    @Override
    public Compound updateCompound(Long id, Compound updatedCompound) {
        Optional<Compound> compoundOptional = compoundRepository.findById(id);
        if (compoundOptional.isPresent()) {
            Compound compound = compoundOptional.get();
            compound.setName(updatedCompound.getName());
            compound.setCanonicalSmiles(updatedCompound.getCanonicalSmiles());
            compound.setIsomericSmiles(updatedCompound.getIsomericSmiles());
            compound.setInchi(updatedCompound.getInchi());
            compound.setInchiKey(updatedCompound.getInchiKey());
            compound.setFormula(updatedCompound.getFormula());
            compound.setMass(updatedCompound.getMass());
            return compoundRepository.save(compound);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCompound(Long id) {
        Optional<Compound> compoundOptional = compoundRepository.findById(id);
        if (compoundOptional.isPresent()) {
            compoundRepository.delete(compoundOptional.get());
            return true;
        } else {
            return false;
        }
    }
}
