package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Specialization;

import java.util.Optional;

public interface SpecializationRepository {

    void create(Specialization specialization);

    Optional<Specialization> getByName(String name);

}
