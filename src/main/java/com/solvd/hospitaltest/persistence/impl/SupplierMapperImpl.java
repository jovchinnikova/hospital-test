package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.persistence.SupplierRepository;
import com.solvd.hospitaltest.domain.Supplier;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class SupplierMapperImpl implements SupplierRepository {

    @Override
    public void create(Supplier supplier) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SupplierRepository supplierRepository = session.getMapper(SupplierRepository.class);
            supplierRepository.create(supplier);
        }
    }

    @Override
    public void update(Supplier supplier, String country) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SupplierRepository supplierRepository = session.getMapper(SupplierRepository.class);
            supplierRepository.update(supplier, country);
        }
    }

    @Override
    public void delete(String name) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SupplierRepository supplierRepository = session.getMapper(SupplierRepository.class);
            supplierRepository.delete(name);
        }

    }

    @Override
    public Optional<Supplier> getByName(String name) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            SupplierRepository supplierRepository = session.getMapper(SupplierRepository.class);
            return supplierRepository.getByName(name);
        }
    }
}
