package com.solvd.hospitaltest.persistence.impl;


import com.solvd.hospitaltest.domain.Medication;
import com.solvd.hospitaltest.persistence.DepartmentMedicationsRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

public class DepartmentMedicationsMapperImpl implements DepartmentMedicationsRepository {

    @Override
    public void create(Medication medication, Long departmentId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            DepartmentMedicationsRepository departmentMedicationsRepository =
                    session.getMapper(DepartmentMedicationsRepository.class);
            departmentMedicationsRepository.create(medication, departmentId);
        }
    }
}
