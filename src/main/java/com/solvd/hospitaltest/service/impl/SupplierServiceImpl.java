package com.solvd.hospitaltest.service.impl;

import com.solvd.hospitaltest.domain.Supplier;
import com.solvd.hospitaltest.persistence.SupplierRepository;
import com.solvd.hospitaltest.persistence.impl.SupplierMapperImpl;
import com.solvd.hospitaltest.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository = new SupplierMapperImpl();

    @Override
    public Supplier createOrGet(Supplier supplier) {
        return supplierRepository.getByName(supplier.getName())
                .orElseGet(() -> create(supplier));
    }

    private Supplier create(Supplier supplier) {
        supplier.setId(null);
        supplierRepository.create(supplier);
        return supplier;
    }

    public void delete(String name) {
        supplierRepository.delete(name);
    }

    public void update(Supplier supplier, String country){
       supplierRepository.update(supplier, country);
    }

}
