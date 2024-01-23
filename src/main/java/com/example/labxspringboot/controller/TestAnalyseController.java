package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.MaterielEchanDto;
import com.example.labxspringboot.dto.ReactifDto;
import com.example.labxspringboot.dto.TestAnalyseDto;
import com.example.labxspringboot.entity.*;
import com.example.labxspringboot.service.IReactifService;
import com.example.labxspringboot.service.ITestAnalyseService;
import com.example.labxspringboot.service.ITestReactifService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/testanalyse" , produces = "application/json")
@Transactional
public class TestAnalyseController {

    @Autowired
    private ITestAnalyseService testAnalyseService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITestReactifService iTestReactifService;
    @Autowired
    private IReactifService iReactifService;

    @PostMapping
    public ResponseEntity<TestAnalyseDto> saveTestAnalyse(@RequestBody TestAnalyseDto testAnalyseDto) {
        TestAnalyseDto savedTestAnalyse = testAnalyseService.saveTestAnalyse(testAnalyseDto);
        TestAnalyseDto testAnalyseDto1 = savedTestAnalyse;
        if(testAnalyseDto.getTestReactifs() !=null){
            for (TestReactif testReactif :testAnalyseDto.getTestReactifs()){
                Reactif reactif = modelMapper.map(iReactifService.getReactifById(testReactif.getReactif().getId()), Reactif.class);
                testReactif.setTestAnalyse(modelMapper.map(testAnalyseDto1, TestAnalyse.class));
                testReactif.setReactif(reactif);
                iTestReactifService.addTestReactif(testReactif);

                reactif.setQuantiteStock(reactif.getQuantiteStock() - testReactif.getQuantity());
                iReactifService.updateReactif(modelMapper.map(reactif, ReactifDto.class), reactif.getId());            }
        }
        return new ResponseEntity<>(savedTestAnalyse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TestAnalyseDto> getAllTestAnalyses() {
        return testAnalyseService.getTestAnalyses().stream()
                .map(testAnalyse -> modelMapper.map(testAnalyse, TestAnalyseDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestAnalyseDto> getTestAnalyseById(@PathVariable("id") Long testAnalyseId) {
        TestAnalyseDto testAnalyseDto = testAnalyseService.getTestAnalyseById(testAnalyseId);
        return ResponseEntity.ok(testAnalyseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestAnalyseDto> updateTestAnalyse(@PathVariable("id") Long id,
                                                            @RequestBody TestAnalyseDto testAnalyseDto) {
        return ResponseEntity.ok(testAnalyseService.updateTestAnalyse(testAnalyseDto, id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestAnalyse(@PathVariable("id") Long id) {
        testAnalyseService.deleteTestAnalyse(id);
        return ResponseEntity.ok("TestAnalyse with id "+id+"was deleted succes");
    }
}
