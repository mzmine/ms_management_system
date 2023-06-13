package com.mzmine.msmanagmentsystem.service;
import com.mzmine.msmanagmentsystem.model.Compound;

import java.util.List;

public interface CompoundService {

    Compound createCompound(Compound compound);

    Compound getCompoundById(Long id);

    List<Compound> getAllCompounds();

    Compound updateCompound(Long id, Compound updatedCompound);

    boolean deleteCompound(Long id);
}
