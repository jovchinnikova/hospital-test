package com.solvd.hospitaltest.persistence.impl;

import com.solvd.hospitaltest.domain.Equipment;
import com.solvd.hospitaltest.persistence.EquipmentRepository;
import com.solvd.hospitaltest.persistence.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class EquipmentMapperImpl implements EquipmentRepository {

    @Override
    public void create(Equipment equipment) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            EquipmentRepository equipmentRepository =
                    session.getMapper(EquipmentRepository.class);
            equipmentRepository.create(equipment);
        }
    }

    @Override
    public Optional<Equipment> getByName(String name) {
        try(SqlSession session = MyBatisConfig.getSessionFactory().openSession(true);) {
            EquipmentRepository equipmentRepository =
                    session.getMapper(EquipmentRepository.class);
            return equipmentRepository.getByName(name);
        }
    }
}
