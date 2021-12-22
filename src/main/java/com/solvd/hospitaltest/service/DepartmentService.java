package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Department;

import java.util.List;

public interface DepartmentService {

    void create(Department department, Long hospitalId);

    List<Department> retrieveAll();

}
