package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Medication;

public interface MedicationService {

    Medication createOrGet(Medication medication);
}
