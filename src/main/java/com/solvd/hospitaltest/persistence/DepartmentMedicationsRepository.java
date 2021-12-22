package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Medication;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMedicationsRepository {

    void create(@Param("medication") Medication medication, @Param("departmentId") Long departmentId);

}
