package com.example.labxspringboot.controller;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.service.impl.NormeServiceImpl;
import com.example.labxspringboot.service.impl.TestAnalyseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testanalyse")
public class TestAnalyseController {
    @Autowired
    private TestAnalyseServiceImpl testAnalyseService;


    @PostMapping
    public ResponseEntity<TestAnalyse> saveTestAnalyse(@RequestBody TestAnalyse testAnalyse){
        return new ResponseEntity<TestAnalyse>(testAnalyseService.saveTestAnalyse(testAnalyse) , HttpStatus.CREATED);
    }

    @GetMapping
    public List<TestAnalyse> getAllTestAnalyses(){
        return testAnalyseService.getTestAnalyses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestAnalyse> getTestAnalyseById(@PathVariable ("id") Long testAnalyseId){
        return new ResponseEntity<TestAnalyse>(testAnalyseService.getTestAnalyseById(testAnalyseId) ,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TestAnalyse> updateTestAnalyse(@PathVariable ("id") Long id , @RequestBody TestAnalyse testAnalyse){
        return new ResponseEntity<TestAnalyse>(testAnalyseService.updateTestAnalyse(testAnalyse,id) ,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTestAnalyse(@PathVariable ("id") Long id){
        testAnalyseService.deleteTestAnalyse(id);
        return ResponseEntity.noContent().build();
    }
}
