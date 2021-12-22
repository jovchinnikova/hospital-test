package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Specialization;

public interface SpecializationService {

    Specialization createOrGet(Specialization specialization);

}
