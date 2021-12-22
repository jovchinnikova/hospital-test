package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Ward;
import com.solvd.hospitaltest.persistence.PatientRepository;
import com.solvd.hospitaltest.persistence.WardRepository;
import com.solvd.hospitaltest.persistence.impl.PatientMapperImpl;
import com.solvd.hospitaltest.persistence.impl.WardMapperImpl;
import com.solvd.hospitaltest.service.WardService;

public class WardServiceImpl implements WardService {

    private final WardRepository wardRepository = new WardMapperImpl();
    private final PatientRepository patientRepository = new PatientMapperImpl();

    @Override
    public void create(Ward ward, Long departmentId) {
        ward.setId(null);
        wardRepository.create(ward, departmentId);
        if (ward.getPatients() != null) {
            ward.getPatients().stream()
                    .forEach(patient -> patientRepository.create(patient, ward.getId()));
        }
    }
}
