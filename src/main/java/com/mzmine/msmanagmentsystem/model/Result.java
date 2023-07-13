package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_id", nullable = false)
    private Dataset dataset;

    @ManyToOne
    @JoinColumn(name = "configuration_id", nullable = false)
    private ProcessingConfiguration configuration;

    @Column(name = "result_data", nullable = false)
    private byte[] resultData;

    public Result() {
    }

    public Result(Long id, Dataset dataset, ProcessingConfiguration configuration, byte[] resultData) {
        this.id = id;
        this.dataset = dataset;
        this.configuration = configuration;
        this.resultData = resultData;
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

    public ProcessingConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ProcessingConfiguration configuration) {
        this.configuration = configuration;
    }

    public byte[] getResultData() {
        return resultData;
    }

    public void setResultData(byte[] resultData) {
        this.resultData = resultData;
    }
}
