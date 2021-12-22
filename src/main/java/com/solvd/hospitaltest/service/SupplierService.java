package com.solvd.hospitaltest.service;

import com.solvd.hospitaltest.domain.Supplier;

public interface SupplierService {

    Supplier createOrGet(Supplier supplier);

    void delete(String name);

    void update(Supplier supplier, String country);

}
