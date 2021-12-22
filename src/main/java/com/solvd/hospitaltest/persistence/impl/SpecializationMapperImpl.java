package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Specialization;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import com.solvd.hospitaltest.persistence.SpecializationRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class SpecializationMapperImpl implements SpecializationRepository {

    @Override
    public void create(Specialization specialization) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SpecializationRepository specializationRepository = session.getMapper(SpecializationRepository.class);
            specializationRepository.create(specialization);
        }
    }

    @Override
    public Optional<Specialization> getByName(String name) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SpecializationRepository specializationRepository = session.getMapper(SpecializationRepository.class);
            return specializationRepository.getByName(name);
        }
    }
}
