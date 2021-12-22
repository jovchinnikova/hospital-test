package com.solvd.hospitaltest.persistence;

import com.solvd.hospitaltest.domain.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressRepository {

    void create(Address address);

    void update (@Param("address") Address address, @Param("hospitalId") Long hospitalId);

    Address findById(Long hospitalId);

}
