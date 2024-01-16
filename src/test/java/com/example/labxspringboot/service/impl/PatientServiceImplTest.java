//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Patient;
//import com.example.labxspringboot.service.IPatientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@Transactional
//public class PatientServiceImplTest {
//
//    @Autowired
//    private IPatientService patientService;
//
//    private Patient testPatient;
//
//    @BeforeEach
//    void setUp() {
//        // Create a new Patient before each test
//        testPatient = new Patient();
//        testPatient.setNom("TestPatient");
//        testPatient.setPrenom("TestPrenom");
//        testPatient.setDateNaissance("2000-01-01");
//        testPatient.setSexe("Femme");
//        testPatient.setAdresse("TestAdresse");
//        testPatient.setNumeroTelephone("123456789");
//
//        // Save the Patient
//        patientService.savePatient(testPatient);
//    }
//
////    @AfterEach
////    void tearDown() {
////        if (patientService.getPatientById(testPatient.getId()) != null) {
////            patientService.deletePatient(testPatient.getId());
////        }
////    }
//    @Test
//    void savePatient() {
//        assertNotNull(testPatient.getId(), "Patient ID should not be null after saving");
//    }
//    @Test
//    void getPatientById() {
//        Patient retrievedPatient = patientService.getPatientById(testPatient.getId());
//        assertNotNull(retrievedPatient, "Retrieved patient should not be null");
//        assertEquals(testPatient.getId(), retrievedPatient.getId(), "IDs should match");
//    }
//    @Test
//    void updatePatient() {
//        assertNotNull(testPatient.getId(), "Patient ID should not be null before updating");
//        testPatient.setPrenom("UpdatedPrenom");
//        Patient updatedPatient = patientService.updatePatient(testPatient);
//        assertNotNull(updatedPatient, "Updated patient should not be null");
//        assertEquals("UpdatedPrenom", updatedPatient.getPrenom(), "Prenom should be updated");
//    }
//    @Test
//    void getAllPatients() {
//        List<Patient> patients = patientService.getPatients();
//        assertFalse(patients.isEmpty());
//    }
////    @Test
////    void deletePatient() {
////        patientService.deletePatient(testPatient.getId());
////        assertNull(patientService.getPatientById(testPatient.getId()), "Patient should be deleted");
////    }
//}
