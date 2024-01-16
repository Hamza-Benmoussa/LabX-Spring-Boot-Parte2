package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.service.IAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseController {

    @Autowired
    private IAnalyseService analyseService;

    @PostMapping
    public ResponseEntity<AnalyseDto> saveAnalyse(@RequestBody AnalyseDto analyseDto) {
        AnalyseDto savedAnalyseDto = analyseService.saveAnalyse(analyseDto);
        return new ResponseEntity<>(savedAnalyseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnalyseDto>> getAllAnalyses() {
        List<AnalyseDto> analyses = analyseService.getAnalyses();
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
public ResponseEntity<AnalyseDto> getAnalyseById(@PathVariable("id") Long analyseId) {
    AnalyseDto analyseDto = analyseService.getAnalyseById(analyseId);
    if (analyseDto != null) {
        return new ResponseEntity<>(analyseDto, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@PutMapping("/{id}")
public ResponseEntity<AnalyseDto> updateAnalyse(@PathVariable("id") Long id, @RequestBody AnalyseDto analyseDto) {
    AnalyseDto updatedAnalyseDto = analyseService.updateAnalyse(analyseDto, id);
    if (updatedAnalyseDto != null) {
        return new ResponseEntity<>(updatedAnalyseDto, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteAnalyseById(@PathVariable("id") Long id) {
    analyseService.deleteAnalyse(id);
    return ResponseEntity.noContent().build();
}
}