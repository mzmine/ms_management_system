package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "repository_storage")
public class RepositoryStorage {

    @Id
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Dataset dataset;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DataRepository repository;

    private String accession;

    public RepositoryStorage(Long id, Dataset dataset, DataRepository repository, String accession) {
        this.id = id;
        this.dataset = dataset;
        this.repository = repository;
        this.accession = accession;
    }

    public RepositoryStorage() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public DataRepository getRepository() {
        return repository;
    }

    public void setRepository(DataRepository repository) {
        this.repository = repository;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }
}
