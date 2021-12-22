package com.solvd.hospitaltest;

import com.solvd.hospitaltest.domain.Patient;
import com.solvd.hospitaltest.domain.Ward;
import com.solvd.hospitaltest.persistence.PatientRepository;
import com.solvd.hospitaltest.persistence.WardRepository;
import com.solvd.hospitaltest.persistence.impl.PatientMapperImpl;
import com.solvd.hospitaltest.persistence.impl.WardMapperImpl;
import com.solvd.hospitaltest.service.WardService;
import com.solvd.hospitaltest.service.impl.WardServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class WardTest {

    private final WardRepository wardRepository = new WardMapperImpl();
    private final WardService wardService = new WardServiceImpl();
    private final PatientRepository patientRepository = new PatientMapperImpl();
    private Ward testWard = new Ward();

    @BeforeClass
    public void createTestWard(){
        Patient patient1 = new Patient();
        patient1.setFirstName("Mikhail");
        patient1.setLastName("Medvedev");
        patient1.setAge(103);
        patient1.setDiagnosis("cancer");

        Patient patient2 = new Patient();
        patient2.setFirstName("Lubov");
        patient2.setLastName("Petrova");
        patient2.setAge(39);
        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);

        testWard.setFloor(10);
        testWard.setNumber(109);
        testWard.setPatients(patients);
    }

    @DataProvider
    public Object[][] idList(){
        return new Object[][]{
                {3L}, {7L}, {9L},{11L}
        };
    }

    @Test(dataProvider = "idList", groups = "findTests")
    public void findByIdTest(Long id){
        SoftAssert softAssert = new SoftAssert();
        List<Ward> wards = wardRepository.getById(id);
        softAssert.assertFalse(wards.isEmpty(), "Wards of the department not found");
    }

    @Test
    public void create(){
        SoftAssert softAssert = new SoftAssert();
        wardService.create(testWard, 10L);
        List<Ward> wards = wardRepository.getById(10L);
        softAssert.assertTrue(wards.contains(testWard),"Ward wasn't created");
        List<Patient> patients = patientRepository.getById(testWard.getId());
        softAssert.assertFalse(patients.isEmpty(),"Patients were not created");
        softAssert.assertAll();
    }

    @AfterClass
    public void deleteTestWard(){
        testWard = null;
    }
}
