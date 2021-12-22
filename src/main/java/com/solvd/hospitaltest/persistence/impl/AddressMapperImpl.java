package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Address;
import com.solvd.hospitaltest.persistence.AddressRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

public class AddressMapperImpl implements AddressRepository {

    @Override
    public void create(Address address) {
        try (SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            addressRepository.create(address);
        }
    }

    @Override
    public void update(Address address, Long hospitalId) {
        try (SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            addressRepository.update(address, hospitalId);
        }
    }

    @Override
    public Address findById(Long hospitalId) {
        try (SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            return addressRepository.findById(hospitalId);
        }
    }
}
