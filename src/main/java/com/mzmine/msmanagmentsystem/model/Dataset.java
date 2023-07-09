package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "datasets")
public class Dataset {

    @Id
    private Long id;

    private String name;

    private String description;

    @Column(name = "acquisition_date")
    private Date acquisitionDate;

    @Column(name = "nfiles")
    private int nFiles;

    @OneToOne(mappedBy = "dataset")
    private LocalStorage localStorage;

    @OneToOne(mappedBy = "dataset")
    private RepositoryStorage repositoryStorage;

    public Dataset(Long id, String name, String description, Date acquisitionDate, int nFiles, LocalStorage localStorage, RepositoryStorage repositoryStorage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.acquisitionDate = acquisitionDate;
        this.nFiles = nFiles;
        this.localStorage = localStorage;
        this.repositoryStorage = repositoryStorage;
    }

    public Dataset() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getnFiles() {
        return nFiles;
    }

    public void setnFiles(int nFiles) {
        this.nFiles = nFiles;
    }

    public LocalStorage getLocalStorage() {
        return localStorage;
    }

    public void setLocalStorage(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    public RepositoryStorage getRepositoryStorage() {
        return repositoryStorage;
    }

    public void setRepositoryStorage(RepositoryStorage repositoryStorage) {
        this.repositoryStorage = repositoryStorage;
    }
}
