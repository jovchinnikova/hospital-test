package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Specialization;
import com.solvd.hospitaltest.persistence.SpecializationRepository;
import com.solvd.hospitaltest.persistence.impl.SpecializationMapperImpl;
import com.solvd.hospitaltest.service.SpecializationService;

public class SpecializationServiceImpl implements SpecializationService {

    private final SpecializationRepository specializationRepository = new SpecializationMapperImpl();

    @Override
    public Specialization createOrGet(Specialization specialization) {
        return specializationRepository.getByName(specialization.getName())
                .orElseGet(() -> create(specialization));
    }

    private Specialization create(Specialization specialization) {
        specialization.setId(null);
        specializationRepository.create(specialization);
        return specialization;
    }
}
