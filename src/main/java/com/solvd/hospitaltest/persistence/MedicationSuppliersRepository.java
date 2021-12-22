package com.solvd.hospitaltest.persistence;

import org.apache.ibatis.annotations.Param;

public interface MedicationSuppliersRepository {

    void create(@Param("medicationId") Long medicationId, @Param("supplierId") Long supplierId);

}
