//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Echantillon;
//import com.example.labxspringboot.entity.MaterielEchan;
//import com.example.labxspringboot.entity.Patient;
//import com.example.labxspringboot.entity.Technicien;
//import com.example.labxspringboot.entity.enume.RoleUser;
//import com.example.labxspringboot.service.IEchantillonService;
//import com.example.labxspringboot.service.IMaterialEchanService;
//import com.example.labxspringboot.service.IPatientService;
//import com.example.labxspringboot.service.IUtilisateurService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@Transactional
//public class EchantillonServiceImplTest {
//
//    @Autowired
//    private IEchantillonService echantillonService;
//    @Autowired
//    private IUtilisateurService iUtilisateurService;
//    @Autowired
//    private IMaterialEchanService iMaterialEchanService;
//    @Autowired
//    private IPatientService iPatientService;
//
//    private Echantillon testEchantillon;
//
//    @BeforeEach
//    void setUp() {
//        // Create a new Echantillon before each test
//        Patient testPatient = new Patient("TestNom", "TestPrenom", "2000-01-01", "Male", "TestAdresse", "123456789", new ArrayList<>());
//        testPatient = iPatientService.savePatient(testPatient); // Save the Patient
//
//        // Create and save MaterielEchan first
//        MaterielEchan testMaterielEchan = new MaterielEchan("TestMaterielEchan", 10, "2025-01-01", "TestFournisseur");
//        testMaterielEchan = iMaterialEchanService.saveMaterialEchan(testMaterielEchan);
//
//        Technicien technicien = new Technicien();
//        technicien.setNomUtilisateur("miko");
//        technicien.setMotDePasse("152");
//        technicien.setSpecialiteTechnicien("technicien");
//        technicien.setRole(RoleUser.TECHNICIEN);
//        iUtilisateurService.saveUtilisateur(technicien);
//
//        testEchantillon = new Echantillon(testPatient, testMaterielEchan, new ArrayList<>(), technicien, "2023-01-01");
//
//        // Save the Echantillon
//        testEchantillon = echantillonService.saveEchantillon(testEchantillon);
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        if (echantillonService.getEchantillonById(testEchantillon.getId()) != null) {
//            echantillonService.deleteEchantillon(testEchantillon.getId());
//        }
//    }
//
//    @Test
//    void saveEchantillon() {
//        assertNotNull(testEchantillon.getId(), "Echantillon ID should not be null after saving");
//    }
//
//    @Test
//    void getEchantillonById() {
//        Echantillon retrievedEchantillon = echantillonService.getEchantillonById(testEchantillon.getId());
//        assertNotNull(retrievedEchantillon, "Retrieved echantillon should not be null");
//        assertEquals(testEchantillon.getId(), retrievedEchantillon.getId(), "IDs should match");
//    }
//
//    @Test
//    void getEchantillons() {
//        List<Echantillon> echantillons = echantillonService.getEchantillons();
//        assertFalse(echantillons.isEmpty(), "List of echantillons should not be empty");
//    }
//
//    @Test
//    void updateEchantillon() {
//        assertNotNull(testEchantillon.getId(), "Echantillon ID should not be null before updating");
//
//        // Modify some property of the Echantillon
//        testEchantillon.setDatePrelevement("2023-02-01");
//        Echantillon updatedEchantillon = echantillonService.updateEchantillon(testEchantillon, testEchantillon.getId());
//
//        assertNotNull(updatedEchantillon, "Updated echantillon should not be null");
//        assertEquals("2023-02-01", updatedEchantillon.getDatePrelevement(), "DatePrelevement should be updated");
//    }
//
//    @Test
//    void deleteEchantillon() {
//        echantillonService.deleteEchantillon(testEchantillon.getId());
//        assertNull(echantillonService.getEchantillonById(testEchantillon.getId()), "Echantillon should be deleted");
//    }
//}
