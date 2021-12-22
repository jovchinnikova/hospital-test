package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Equipment;

import java.util.Optional;

public interface EquipmentRepository {

    void create(Equipment equipment);

    Optional<Equipment> getByName(String name);

}
