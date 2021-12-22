package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Medication;
import com.solvd.hospitaltest.domain.Supplier;
import com.solvd.hospitaltest.persistence.MedicationRepository;
import com.solvd.hospitaltest.persistence.MedicationSuppliersRepository;
import com.solvd.hospitaltest.persistence.impl.MedicationMapperImpl;
import com.solvd.hospitaltest.persistence.impl.MedicationSuppliersMapperImpl;
import com.solvd.hospitaltest.service.MedicationSuppliersService;
import com.solvd.hospitaltest.service.SupplierService;

import java.util.List;

public class MedicationSuppliersServiceImpl implements MedicationSuppliersService {

    private final MedicationRepository medicationRepository = new MedicationMapperImpl();
    private final SupplierService supplierService = new SupplierServiceImpl();
    private final MedicationSuppliersRepository medicationSuppliersRepository = new MedicationSuppliersMapperImpl();

    @Override
    public Medication create(Medication medication) {
        medication.setId(null);
        List<Supplier> medSuppliers = medication.getSuppliers();
        medicationRepository.create(medication);
        medSuppliers.stream()
                .filter(supplier -> supplier != null)
                .map(supplier -> supplierService.createOrGet(supplier))
                .forEach(supplier -> medicationSuppliersRepository.create(medication.getId(), supplier.getId()));
        return medication;
    }
}
