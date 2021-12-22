package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.persistence.MedicationSuppliersRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

public class MedicationSuppliersMapperImpl implements MedicationSuppliersRepository {

    @Override
    public void create(Long medicationId, Long supplierId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            MedicationSuppliersRepository medicationSuppliersRepository =
                    session.getMapper(MedicationSuppliersRepository.class);
            medicationSuppliersRepository.create(medicationId, supplierId);
        }
    }
}
