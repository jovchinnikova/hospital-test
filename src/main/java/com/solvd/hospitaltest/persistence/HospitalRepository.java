package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Hospital;
import org.apache.ibatis.annotations.Param;

public interface HospitalRepository {

    void create(@Param("hospital") Hospital hospital, @Param("chiefDoctorId") Long chiefDoctorId, @Param("addressId") Long addressId);

}
