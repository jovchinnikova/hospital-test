package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Medication;
import com.solvd.hospitaltest.persistence.MedicationRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class MedicationMapperImpl implements MedicationRepository {

    @Override
    public void create(Medication medication) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            MedicationRepository medicationRepository = session.getMapper(MedicationRepository.class);
            medicationRepository.create(medication);
        }
    }

    @Override
    public Optional<Medication> getByName(String name) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            MedicationRepository medicationRepository = session.getMapper(MedicationRepository.class);
            return medicationRepository.getByName(name);
        }
    }
}
