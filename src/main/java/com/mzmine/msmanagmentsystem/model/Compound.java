package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compound")
public class Compound {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "canonical_smiles", length = 1000)
    private String canonicalSmiles;

    @Column(name = "isomeric_smiles", length = 1000)
    private String isomericSmiles;

    @Column(name = "inchi", length = 1000)
    private String inchi;

    @Column(name = "inchi_key", length = 1000)
    private String inchiKey;

    @Column(name = "formula")
    private String formula;

    @Column(name = "mass")
    private Double mass;

    public Compound() {
    }

    public Compound(Long id, String name, String canonicalSmiles, String isomericSmiles, String inchi, String inchiKey, String formula, Double mass) {
        this.id = id;
        this.name = name;
        this.canonicalSmiles = canonicalSmiles;
        this.isomericSmiles = isomericSmiles;
        this.inchi = inchi;
        this.inchiKey = inchiKey;
        this.formula = formula;
        this.mass = mass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCanonicalSmiles() {
        return canonicalSmiles;
    }

    public void setCanonicalSmiles(String canonicalSmiles) {
        this.canonicalSmiles = canonicalSmiles;
    }

    public String getIsomericSmiles() {
        return isomericSmiles;
    }

    public void setIsomericSmiles(String isomericSmiles) {
        this.isomericSmiles = isomericSmiles;
    }

    public String getInchi() {
        return inchi;
    }

    public void setInchi(String inchi) {
        this.inchi = inchi;
    }

    public String getInchiKey() {
        return inchiKey;
    }

    public void setInchiKey(String inchiKey) {
        this.inchiKey = inchiKey;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }
}