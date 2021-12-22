package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Employee;
import com.solvd.hospitaltest.domain.Specialization;
import com.solvd.hospitaltest.persistence.EmployeeRepository;
import com.solvd.hospitaltest.persistence.impl.EmployeeMapperImpl;
import com.solvd.hospitaltest.service.EmployeeService;
import com.solvd.hospitaltest.service.SpecializationService;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository = new EmployeeMapperImpl();
    private final SpecializationService specializationService = new SpecializationServiceImpl();

    @Override
    public void createHead(Employee employee) {
        employee.setId(null);
        Specialization empSpecialization = employee.getSpecialization();
        if (empSpecialization != null) {
            Specialization specialization = specializationService.createOrGet(empSpecialization);
            if (specialization != null) {
                empSpecialization.setId(specialization.getId());
            }
            employeeRepository.createHead(employee, empSpecialization.getId());
        }
    }

    @Override
    public void create(Employee employee, Long departmentId) {
        employee.setId(null);
        Specialization empSpecialization = employee.getSpecialization();
        if (empSpecialization != null) {
            Specialization specialization = specializationService.createOrGet(empSpecialization);
            if (specialization != null) {
                empSpecialization.setId(specialization.getId());
            }
            employeeRepository.create(employee, empSpecialization.getId(), departmentId);
        }
    }
}
