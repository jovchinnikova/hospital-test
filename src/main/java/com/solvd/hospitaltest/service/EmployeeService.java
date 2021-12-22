package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Employee;

public interface EmployeeService {

    void createHead(Employee employee);

    void create(Employee employee, Long departmentId);

}
