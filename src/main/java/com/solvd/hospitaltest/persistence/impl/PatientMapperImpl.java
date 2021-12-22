package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Patient;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import com.solvd.hospitaltest.persistence.PatientRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PatientMapperImpl implements PatientRepository {

    @Override
    public void create(Patient patient, Long wardId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            PatientRepository patientRepository = session.getMapper(PatientRepository.class);
            patientRepository.create(patient, wardId);
        }
    }

    @Override
    public List<Patient> getById(Long wardId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            PatientRepository patientRepository = session.getMapper(PatientRepository.class);
            return patientRepository.getById(wardId);
        }
    }
}
