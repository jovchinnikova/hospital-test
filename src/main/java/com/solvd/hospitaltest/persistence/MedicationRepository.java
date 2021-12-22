package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Medication;

import java.util.Optional;

public interface MedicationRepository {

    void create(Medication medication);

    Optional<Medication> getByName(String name);

}
