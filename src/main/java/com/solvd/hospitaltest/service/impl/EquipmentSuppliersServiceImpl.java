package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Equipment;
import com.solvd.hospitaltest.domain.Supplier;
import com.solvd.hospitaltest.persistence.EquipmentRepository;
import com.solvd.hospitaltest.persistence.EquipmentSuppliersRepository;
import com.solvd.hospitaltest.persistence.impl.EquipmentMapperImpl;
import com.solvd.hospitaltest.persistence.impl.EquipmentSuppliersMapperImpl;
import com.solvd.hospitaltest.service.EquipmentSuppliersService;
import com.solvd.hospitaltest.service.SupplierService;

import java.util.List;

public class EquipmentSuppliersServiceImpl implements EquipmentSuppliersService {

    private final SupplierService supplierService = new SupplierServiceImpl();
    private final EquipmentRepository equipmentRepository = new EquipmentMapperImpl();
    private final EquipmentSuppliersRepository equipmentSuppliersRepository = new EquipmentSuppliersMapperImpl();

    @Override
    public Equipment create(Equipment equipment) {
        equipment.setId(null);
        List<Supplier> eqSuppliers = equipment.getSuppliers();
        equipmentRepository.create(equipment);
        eqSuppliers.stream()
                .filter(supplier -> supplier != null)
                .map(supplier -> supplierService.createOrGet(supplier))
                .forEach(supplier -> equipmentSuppliersRepository.create(equipment.getId(), supplier.getId()));
        return equipment;
    }
}
