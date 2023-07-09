package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.Column;
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
@Table(name = "local_storage")
public class LocalStorage {

    @Id
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Dataset dataset;

    @Column(name = "file_path")
    private String filePath;

    public LocalStorage(Long id, Dataset dataset, String filePath) {
        this.id = id;
        this.dataset = dataset;
        this.filePath = filePath;
    }

    public LocalStorage() {

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
