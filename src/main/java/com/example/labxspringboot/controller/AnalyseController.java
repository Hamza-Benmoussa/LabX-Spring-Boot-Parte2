package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.service.IAnalyseService;
import com.example.labxspringboot.service.impl.AnalyseServiceImpl;
import com.example.labxspringboot.service.impl.TypeAnalyseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseController {

    @Autowired
    private AnalyseServiceImpl analyseService;
    @Autowired
    TypeAnalyseServiceImpl typeAnalyseService ;

    @PostMapping
    public ResponseEntity<AnalyseDto> saveAnalyse(@RequestBody AnalyseDto analyseDto) {
        typeAnalyseService.saveAnalyse(analyseDto);
        AnalyseDto savedAnalyseDto = analyseService.saveAnalyse(analyseDto);
        return new ResponseEntity<>(savedAnalyseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnalyseDto>> getAllAnalyses() {
        return ResponseEntity.ok(analyseService.getAnalyses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalyseDto> getAnalyseById(@PathVariable("id") Long analyseId) {
    AnalyseDto analyseDto = analyseService.getAnalyseById(analyseId);
    return ResponseEntity.ok(analyseDto);
 }

    @PutMapping("/{id}")
    public ResponseEntity<AnalyseDto> updateAnalyse(@PathVariable("id") Long id, @RequestBody AnalyseDto analyseDto) {
    return ResponseEntity.ok(analyseService.updateAnalyse(analyseDto,id));
 }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnalyseById(@PathVariable("id") Long id) {
    analyseService.deleteAnalyse(id);
    return ResponseEntity.ok("Analyse with : "+id+"has benn deleted succes");
 }
}