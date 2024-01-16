//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Utilisateur;
//import com.example.labxspringboot.entity.enume.RoleUser;
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
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@Transactional
//public class UtilisateurServiceImplTest {
//
//    @Autowired
//    private IUtilisateurService utilisateurService;
//
//    private Utilisateur testUtilisateur;
//
//    @BeforeEach
//    void setUp() {
//        // Create a new Utilisateur before each test
//        testUtilisateur = new Utilisateur();
//        testUtilisateur.setNomUtilisateur("benmoussa");
//        testUtilisateur.setMotDePasse("password");
//        testUtilisateur.setRole(RoleUser.TECHNICIEN);
//        utilisateurService.saveUtilisateur(testUtilisateur);
//        // Save the Utilisateur
//
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (utilisateurService.getUtilisateurById(testUtilisateur.getId()) != null) {
//            utilisateurService.deleteUtilisateur(testUtilisateur.getId());
//        }
//    }
//    @Test
//    void saveUtilisateur() {
//        assertNotNull(testUtilisateur.getId());
//    }
//    @Test
//    void getUtilisateurById() {
//        Utilisateur retrievedUtilisateur = utilisateurService.getUtilisateurById(testUtilisateur.getId());
//        assertNotNull(retrievedUtilisateur, "Retrieved user should not be null");
//        assertEquals(testUtilisateur.getId(), retrievedUtilisateur.getId(), "IDs should match");
//    }
//    @Test
//    void updateUtilisateur() {
//        assertNotNull(testUtilisateur.getId(), "Utilisateur ID should not be null before updating");
//        testUtilisateur.setMotDePasse("newPassword");
//        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(testUtilisateur);
//        assertNotNull(updatedUtilisateur, "Updated user should not be null");
//        assertEquals("newPassword", updatedUtilisateur.getMotDePasse(), "Password should be updated");
//    }
//    @Test
//    void getAllUtilisateurs() {
//        List<Utilisateur> utilisateurs = utilisateurService.getUtilisateurs();
//        assertFalse(utilisateurs.isEmpty());
//    }
//    @Test
//    void deleteUtilisateur() {
//        utilisateurService.deleteUtilisateur(testUtilisateur.getId());
//        assertNull(utilisateurService.getUtilisateurById(testUtilisateur.getId()), "User should be deleted");
//    }
//}
