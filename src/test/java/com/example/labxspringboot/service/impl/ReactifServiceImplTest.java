//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Reactif;
//import com.example.labxspringboot.service.IReactifService;
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
//public class ReactifServiceImplTest {
//
//    @Autowired
//    private IReactifService reactifService;
//
//    private Reactif testReactif;
//
//    @BeforeEach
//    void setUp() {
//        // Create a new Reactif before each test
//        testReactif = new Reactif();
//        testReactif.setNom("TestReactif");
//        testReactif.setQuantiteStock(10);
//        testReactif.setDateExpiration("2025-01-01");
//
//        // Save the Reactif
//        reactifService.saveReactif(testReactif);
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (reactifService.getReactifById(testReactif.getId()) != null) {
//            reactifService.deleteReactif(testReactif.getId());
//        }
//    }
//    @Test
//    void saveReactif() {
//        assertNotNull(testReactif.getId(), "Reactif ID should not be null after saving");
//    }
//    @Test
//    void getReactifById() {
//        Reactif retrievedReactif = reactifService.getReactifById(testReactif.getId());
//        assertNotNull(retrievedReactif, "Retrieved reactif should not be null");
//        assertEquals(testReactif.getId(), retrievedReactif.getId(), "IDs should match");
//    }
//    @Test
//    void updateReactif() {
//        assertNotNull(testReactif.getId(), "Reactif ID should not be null before updating");
//        testReactif.setQuantiteStock(20);
//        Reactif updatedReactif = reactifService.updateReactif(testReactif ,testReactif.getId());
//        assertNotNull(updatedReactif, "Updated reactif should not be null");
//        assertEquals(20, updatedReactif.getQuantiteStock(), "QuantiteStockReactif should be updated");
//    }
//    @Test
//    void getAllReactifs() {
//        List<Reactif> reactifs = reactifService.getReactifs();
//        assertFalse(reactifs.isEmpty());
//    }
//    @Test
//    void deleteReactif() {
//        reactifService.deleteReactif(testReactif.getId());
//        assertNull(reactifService.getReactifById(testReactif.getId()), "Reactif should be deleted");
//    }
//}
