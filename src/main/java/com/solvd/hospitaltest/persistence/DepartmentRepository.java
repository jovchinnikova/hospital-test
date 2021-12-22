package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentRepository {

    void create(@Param("department") Department department, @Param("departmentHeadId") Long departmentHeadId,
                @Param("hospitalId") Long hospitalId);

    List<Department> getAll();

}
