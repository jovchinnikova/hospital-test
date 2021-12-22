package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Ward;


public interface WardService {

    void create(Ward ward, Long departmentId);

}
