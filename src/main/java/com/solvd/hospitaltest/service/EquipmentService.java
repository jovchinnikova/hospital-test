package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Equipment;

public interface EquipmentService {

    Equipment createOrGet(Equipment equipment);

}
