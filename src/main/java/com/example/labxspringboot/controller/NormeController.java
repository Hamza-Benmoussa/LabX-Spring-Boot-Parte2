package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.NormeDto;
import com.example.labxspringboot.service.impl.NormeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/normes")
public class NormeController {

    @Autowired
    private NormeServiceImpl normeService;

    @PostMapping
    public ResponseEntity<NormeDto> saveNorme(@RequestBody NormeDto normeDto) {
        NormeDto savedNormeDto = normeService.saveNorme(normeDto);
        return new ResponseEntity<>(savedNormeDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NormeDto>> getAllNormes() {
        return ResponseEntity.ok(normeService.getNormes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NormeDto> getNormeById(@PathVariable("id") Long normeId) {
        NormeDto normeDto = normeService.getNormeById(normeId);
        return ResponseEntity.ok(normeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NormeDto> updateNorme(@PathVariable("id") Long id, @RequestBody NormeDto normeDto) {
        return ResponseEntity.ok(normeService.updateNorme(normeDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNormeById(@PathVariable("id") Long id) {
        normeService.deleteNorme(id);
        return ResponseEntity.ok("Norme with id : " + id + " was deleted");
    }
}
