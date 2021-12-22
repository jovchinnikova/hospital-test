package com.solvd.hospitaltest;

import com.solvd.hospitaltest.domain.Supplier;
import com.solvd.hospitaltest.persistence.SupplierRepository;
import com.solvd.hospitaltest.persistence.impl.SupplierMapperImpl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SupplierTest {

    private final SupplierRepository supplierRepository = new SupplierMapperImpl();
    private Supplier testSupplier = new Supplier();

    @Test(dataProvider = "names",groups = "findTests")
    public void findByNameTest(String name){
        SoftAssert softAssert = new SoftAssert();
       Supplier supplier = supplierRepository.getByName(name)
               .orElse(new Supplier());
       softAssert.assertNotNull(supplier.getId(),"Supplier not found");
       softAssert.assertAll();
    }

    @DataProvider
    public Object[][] updateData(){
        Supplier supplier1 = supplierRepository.getByName("DealMed")
                .orElse(new Supplier());
        Supplier supplier2 = supplierRepository.getByName("Glavpharm")
                .orElse(new Supplier());
        return new Object[][]{
                {supplier1,"Ukraine"},
                {supplier2,"Belgium"}
        };
    }

    @Test(dataProvider = "updateData")
    public void updateTest(Supplier supplier, String country){
        SoftAssert softAssert = new SoftAssert();
        supplierRepository.update(supplier, country);
        Supplier testSupplier = supplierRepository.getByName(supplier.getName())
                .orElse(new Supplier());
        softAssert.assertEquals(testSupplier.getCountry(),country,"Supplier's country wasn't updated");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] names(){
        return new Object[][]{
                {"Sigma"},
                {"Tagler"}
        };
    }

    @Test(dataProvider = "names")
    public void deleteTest(String name){
        supplierRepository.delete(name);
        Supplier supplier = supplierRepository.getByName(name)
                        .orElse(new Supplier());
        Assert.assertNull(supplier.getId(),"Supplier wasn't deleted");
    }

    @Test
    public void create(){
        supplierRepository.create(testSupplier);
        Supplier resultSupplier = supplierRepository.getByName(testSupplier.getName())
                .orElse(new Supplier());
        Assert.assertNotNull(resultSupplier,"Supplier wasn't created");
    }

    @BeforeClass
    public void createTestSupplier(){
        testSupplier.setName("Belpharmazia");
        testSupplier.setCountry("Belarus");
    }

    @AfterClass
    public void deleteTestSupplier(){
        testSupplier = null;
    }
}
