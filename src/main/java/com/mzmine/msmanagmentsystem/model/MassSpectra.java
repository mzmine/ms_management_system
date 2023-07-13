package com.mzmine.msmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mass_spectra")
public class MassSpectra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dataset_id", nullable = false)
    private Dataset dataset;

    @Column(name = "spectrum_data", nullable = false)
    private byte[] spectrumData;

    public MassSpectra() {
    }

    public MassSpectra(Long id, Dataset dataset, byte[] spectrumData) {
        this.id = id;
        this.dataset = dataset;
        this.spectrumData = spectrumData;
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

    public byte[] getSpectrumData() {
        return spectrumData;
    }

    public void setSpectrumData(byte[] spectrumData) {
        this.spectrumData = spectrumData;
    }
}
