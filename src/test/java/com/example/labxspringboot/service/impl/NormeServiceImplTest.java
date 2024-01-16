//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Norme;
//import com.example.labxspringboot.service.INormeService;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//class NormeServiceImplTest {
//@Autowired
//private INormeService iNormeService;
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/listTest.csv", numLinesToSkip = 1)
//    void saveNorme(String Name,double Min,double Max,String Unit) {
//            Norme norme=new Norme();
//            norme.setDescription(Name);
//            norme.setUnite(Unit);
//            norme.setMax(Max);
//            norme.setMin(Min);
//            iNormeService.saveNorme(norme);
//
//    }
//}