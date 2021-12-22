package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Hospital;
import com.solvd.hospitaltest.persistence.AddressRepository;
import com.solvd.hospitaltest.persistence.HospitalRepository;
import com.solvd.hospitaltest.persistence.impl.AddressMapperImpl;
import com.solvd.hospitaltest.persistence.impl.HospitalMapperImpl;
import com.solvd.hospitaltest.service.DepartmentService;
import com.solvd.hospitaltest.service.EmployeeService;
import com.solvd.hospitaltest.service.HospitalService;

public class HospitalServiceImpl implements HospitalService {

    private final AddressRepository addressesRepository = new AddressMapperImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final DepartmentService departmentService = new DepartmentServiceImpl();
    private final HospitalRepository hospitalRepository = new HospitalMapperImpl();


    @Override
    public void create(Hospital hospital) {
        if (hospital.getAddress() != null) {
            addressesRepository.create(hospital.getAddress());
        }
        if (hospital.getChiefDoctor() != null) {
            employeeService.createHead(hospital.getChiefDoctor());
        }

        hospital.setId(null);
        hospitalRepository.create(hospital, hospital.getChiefDoctor().getId(), hospital.getAddress().getId());

        if (hospital.getDepartments() != null) {
            hospital.getDepartments().stream()
                    .forEach(department -> departmentService.create(department, hospital.getId()));
        }
    }
}
