package com.solvd.hospitaltest.persistence.impl;


import com.solvd.hospitaltest.domain.Employee;
import com.solvd.hospitaltest.persistence.EmployeeRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

public class EmployeeMapperImpl implements EmployeeRepository {

    @Override
    public void createHead(Employee employee, Long specializationId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            EmployeeRepository employeeRepository =
                    session.getMapper(EmployeeRepository.class);
            employeeRepository.createHead(employee, specializationId);
        }

    }

    @Override
    public void create(Employee employee, Long specializationId, Long departmentId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            EmployeeRepository employeeRepository =
                    session.getMapper(EmployeeRepository.class);
            employeeRepository.create(employee, specializationId, departmentId);
        }
    }
}
