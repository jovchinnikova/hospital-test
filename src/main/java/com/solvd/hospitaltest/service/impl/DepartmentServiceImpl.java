package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Department;
import com.solvd.hospitaltest.persistence.DepartmentEquipmentsRepository;
import com.solvd.hospitaltest.persistence.DepartmentMedicationsRepository;
import com.solvd.hospitaltest.persistence.DepartmentRepository;
import com.solvd.hospitaltest.persistence.impl.DepartmentEquipmentsMapperImpl;
import com.solvd.hospitaltest.persistence.impl.DepartmentMapperImpl;
import com.solvd.hospitaltest.persistence.impl.DepartmentMedicationsMapperImpl;
import com.solvd.hospitaltest.service.*;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository = new DepartmentMapperImpl();
    private final EquipmentService equipmentService = new EquipmentServiceImpl();
    private final DepartmentEquipmentsRepository departmentEquipmentsRepository = new DepartmentEquipmentsMapperImpl();
    private final DepartmentMedicationsRepository departmentMedicationsRepository = new DepartmentMedicationsMapperImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final WardService wardService = new WardServiceImpl();
    private final MedicationService medicationService = new MedicationServiceImpl();

    @Override
    public void create(Department department, Long hospitalId) {
        if (department.getDepartmentHead() != null) {
            employeeService.createHead(department.getDepartmentHead());
        }
        department.setId(null);
        departmentRepository.create(department, department.getDepartmentHead().getId(), hospitalId);

        if (department.getEquipments() != null) {
            department.getEquipments().stream()
                    .map(equipment -> equipmentService.createOrGet(equipment))
                    .forEach(equipment -> departmentEquipmentsRepository.create(equipment, department.getId()));
        }
        if (department.getMedications() != null) {
            department.getMedications().stream()
                    .map(medication -> medicationService.createOrGet(medication))
                    .forEach(medication -> departmentMedicationsRepository.create(medication, department.getId()));
        }
        if (department.getEmployees() != null) {
            department.getEmployees().stream()
                    .forEach(employee -> employeeService.create(employee, department.getId()));
        }
        if (department.getWards() != null) {
            department.getWards().stream()
                    .forEach(ward -> wardService.create(ward, department.getId()));
        }
    }

    public List<Department> retrieveAll(){
        return departmentRepository.getAll();
    }
}
