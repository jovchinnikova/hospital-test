package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Equipment;
import org.apache.ibatis.annotations.Param;

public interface DepartmentEquipmentsRepository {

    void create(@Param("equipment") Equipment equipment, @Param("departmentId") Long departmentId);

}
