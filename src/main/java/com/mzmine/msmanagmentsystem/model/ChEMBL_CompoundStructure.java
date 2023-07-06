package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "COMPOUND_STRUCTURES", schema = "chembl")
public class ChEMBL_CompoundStructure {
    @Id
    @Column(name = "MOLREGNO")
    private Long molregno;

    @Column(name = "MOLFILE")
    private String molfile;

    @Column(name = "STANDARD_INCHI")
    private String standardInchi;

    @Column(name = "STANDARD_INCHI_KEY")
    private String standardInchiKey;

    @Column(name = "CANONICAL_SMILES")
    private String canonicalSmiles;

    // Constructors, getters, and setters

    public void CompoundStructure() {
    }

    public void CompoundStructure(Long molregno, String molfile, String standardInchi, String standardInchiKey, String canonicalSmiles) {
        this.molregno = molregno;
        this.molfile = molfile;
        this.standardInchi = standardInchi;
        this.standardInchiKey = standardInchiKey;
        this.canonicalSmiles = canonicalSmiles;
    }

    public Long getMolregno() {
        return molregno;
    }

    public void setMolregno(Long molregno) {
        this.molregno = molregno;
    }

    public String getMolfile() {
        return molfile;
    }

    public void setMolfile(String molfile) {
        this.molfile = molfile;
    }

    public String getStandardInchi() {
        return standardInchi;
    }

    public void setStandardInchi(String standardInchi) {
        this.standardInchi = standardInchi;
    }

    public String getStandardInchiKey() {
        return standardInchiKey;
    }

    public void setStandardInchiKey(String standardInchiKey) {
        this.standardInchiKey = standardInchiKey;
    }

    public String getCanonicalSmiles() {
        return canonicalSmiles;
    }

    public void setCanonicalSmiles(String canonicalSmiles) {
        this.canonicalSmiles = canonicalSmiles;
    }
}
