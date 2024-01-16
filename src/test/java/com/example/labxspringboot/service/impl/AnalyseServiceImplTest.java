//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.*;
//import com.example.labxspringboot.entity.enume.RoleUser;
//import com.example.labxspringboot.entity.enume.StatusAnalyse;
//import com.example.labxspringboot.entity.enume.StatusResultat;
//import com.example.labxspringboot.entity.enume.TypeAnalyse;
//import com.example.labxspringboot.service.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
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
//public class AnalyseServiceImplTest {
//
//    @Autowired
//    private IAnalyseService iAnalyseService;
//
//    @Autowired
//    private IEchantillonService iEchantillonService;
//
//    @Autowired
//    private IUtilisateurService iUtilisateurService;
//    @Autowired
//    private IPatientService iPatientService;
//
//    @Autowired
//    private IMaterialEchanService iMaterialEchanService;
//
//    private Analyse testAnalyse;
//    private Echantillon testEchantillon;
//    private MaterielEchan testMaterielEchan;
//    private Technicien testTechnicien;
//    private Patient testPatient;
//
//    @Rollback(value = false)
// @Test
//    void setUp() {
//        // Create a Patient
//        Patient patient = new Patient();
//        patient.setNom("TestPatient");
//        patient.setPrenom("khona");
//        patient.setDateNaissance("2002");
//        patient.setSexe("homme");
//        patient.setAdresse("casa");
//        patient.setNumeroTelephone("044654645");
//        iPatientService.savePatient(patient);
//
////         Create a Technicien
//        Technicien technicien = new Technicien();
//
//        technicien.setNomUtilisateur("miko");
//        technicien.setMotDePasse("152");
//        technicien.setSpecialiteTechnicien("technicien");
//        technicien.setRole(RoleUser.TECHNICIEN);
//        iUtilisateurService.saveUtilisateur(technicien);
//
//        ResponsableLabo responsableLabo = new ResponsableLabo();
//
//        responsableLabo.setNomUtilisateur("TestResponsable");
//        responsableLabo.setMotDePasse("1234");
//        responsableLabo.setFonctionResponsable("responsable");
//        responsableLabo.setRole(RoleUser.RESPONSABLE_LABORATOIRE);
//        iUtilisateurService.saveUtilisateur(responsableLabo);
//
//        // Create a MaterielEchan
//        testMaterielEchan = new MaterielEchan("TestMaterielEchan", 10, "2025-01-01", "TestFournisseur");
//        iMaterialEchanService.saveMaterialEchan(testMaterielEchan);
//
//        // Create an Echantillon
//        testEchantillon = new Echantillon(testPatient, testMaterielEchan, new ArrayList<>(), testTechnicien, "2023-01-01");
//        testEchantillon.setTechnicienEch(technicien);
//        testEchantillon.setMaterielEchan(testMaterielEchan);
//        testEchantillon.setPatient(patient);
//        iEchantillonService.saveEchantillon(testEchantillon);
//
//        // Create and save an Analyse
//        testAnalyse = new Analyse(testEchantillon, null, null, TypeAnalyse.HEMATOLOGIE, "2022", "2023", StatusResultat.NORMAL, StatusAnalyse.EN_COURS_ANALYSE, "Test Comment");
//        testAnalyse.setResponsableLaboAnalyse(responsableLabo);
//        iAnalyseService.saveAnalyse(testAnalyse);
//    }
//
////    @AfterEach
////    void tearDown() {
////        if (iAnalyseService.getAnalyseById(testAnalyse.getId()) != null) {
////
////            iAnalyseService.deleteAnalyse(testAnalyse.getId());
////            iMaterialEchanService.deleteMaterialEchan(testMaterielEchan.getId());
////            iPatientService.deletePatient(testPatient.getId());
////            iUtilisateurService.deleteUtilisateur(testTechnicien.getId());
////
////            iUtilisateurService.deleteUtilisateur();
////        }
////    }
//
//    @Rollback(value = false)
//    @Test
//    void saveAnalyse() {
//
//        assertNotNull(1L, "Analyse ID should not be null after saving");
//    }
//
//    @Rollback(value = false)
//    @Test
//    void getAnalyseById() {
//        Analyse retrievedAnalyse = iAnalyseService.getAnalyseById(1L);
//        assertNotNull(retrievedAnalyse, "Retrieved analysis should not be null");
//        assertEquals(1L, retrievedAnalyse.getId(), "IDs should match");
//    }
//
//    @Rollback(value = false)
//    @Test
//    void updateAnalyse() {
//        assertNotNull(1L, "Analyse ID should not be null before updating");
//        testAnalyse.setCommentaires("Updated Comment");
//        Analyse updatedAnalyse = iAnalyseService.updateAnalyse(testAnalyse,1L) ;
//        assertEquals("Updated Comment", updatedAnalyse.getCommentaires(), "Comment should be updated");
//    }
//
//    @Rollback(value = false)
//    @Test
//    void getAllAnalyses() {
//        List<Analyse> analyses = iAnalyseService.getAnalyses();
//        assertFalse(analyses.isEmpty());
//    }
//
//    @Rollback(value = false)
//    @Test
//    void deleteAnalyse() {
//        iAnalyseService.deleteAnalyse(1L);
//        assertNull(iAnalyseService.getAnalyseById(testAnalyse.getId()), "Analysis should be deleted");
//    }
//}
