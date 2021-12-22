package com.solvd.hospitaltest;

import com.solvd.hospitaltest.domain.Address;
import com.solvd.hospitaltest.persistence.AddressRepository;
import com.solvd.hospitaltest.persistence.impl.AddressMapperImpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressTest {

    private final AddressRepository addressRepository = new AddressMapperImpl();
    public Address testAddress = new Address();

    @BeforeClass
    public void createTestAddress(){
        testAddress.setCity("Minsk");
        testAddress.setStreet("Plehanova");
        testAddress.setBuildingNumber("87A");
    }

    @Test
    public void createTest(){
        addressRepository.create(testAddress);
        Address address = addressRepository.findById(1L);
        Assert.assertNotNull(address,"Address wasn't created");
    }

    @AfterClass
    public void deleteTestAddress(){
        testAddress = null;
    }
}
