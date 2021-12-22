package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Equipment;
import com.solvd.hospitaltest.persistence.EquipmentRepository;
import com.solvd.hospitaltest.persistence.impl.EquipmentMapperImpl;
import com.solvd.hospitaltest.service.EquipmentService;
import com.solvd.hospitaltest.service.EquipmentSuppliersService;

public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository = new EquipmentMapperImpl();
    private final EquipmentSuppliersService equipmentSuppliersService = new EquipmentSuppliersServiceImpl();

    @Override
    public Equipment createOrGet(Equipment equipment) {
        return equipmentRepository.getByName(equipment.getName())
                .orElseGet(() -> create(equipment));
    }

    private Equipment create(Equipment equipment) {
        equipment.setId(null);
        equipmentSuppliersService.create(equipment);
        return equipment;
    }
}
