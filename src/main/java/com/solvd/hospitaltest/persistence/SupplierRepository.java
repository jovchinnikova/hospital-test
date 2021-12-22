package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface SupplierRepository {

    void create(Supplier supplier);

    void update(@Param("supplier") Supplier supplier, @Param("country") String country);

    void delete(String name);

    Optional<Supplier> getByName(String name);

}
