package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Medication;
import com.solvd.hospitaltest.persistence.MedicationRepository;
import com.solvd.hospitaltest.persistence.impl.MedicationMapperImpl;
import com.solvd.hospitaltest.service.MedicationService;
import com.solvd.hospitaltest.service.MedicationSuppliersService;

public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository = new MedicationMapperImpl();
    private final MedicationSuppliersService medicationSuppliersService = new MedicationSuppliersServiceImpl();

    @Override
    public Medication createOrGet(Medication medication) {
        return medicationRepository.getByName(medication.getName())
                .orElseGet(() -> create(medication));
    }

    private Medication create(Medication medication) {
        medication.setId(null);
        medicationSuppliersService.create(medication);
        return medication;
    }
}
