package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.TestAnalyseDto;
import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.service.ITestAnalyseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/testanalyse")
public class TestAnalyseController {

    @Autowired
    private ITestAnalyseService testAnalyseService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TestAnalyseDto> saveTestAnalyse(@RequestBody TestAnalyseDto testAnalyseDto) {
        TestAnalyseDto savedTestAnalyse = testAnalyseService.saveTestAnalyse(testAnalyseDto);
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
