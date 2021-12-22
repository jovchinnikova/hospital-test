package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Ward;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import com.solvd.hospitaltest.persistence.WardRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WardMapperImpl implements WardRepository {

    @Override
    public void create(Ward ward, Long departmentId) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            WardRepository wardRepository = session.getMapper(WardRepository.class);
            wardRepository.create(ward, departmentId);
        }
    }

    @Override
    public List<Ward> getById(Long departmentId) {
        try (SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            WardRepository wardRepository = session.getMapper(WardRepository.class);
            return wardRepository.getById(departmentId);
        }
    }
    }