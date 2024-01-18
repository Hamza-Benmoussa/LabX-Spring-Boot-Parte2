package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.service.impl.EchantillonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/echantillons")
public class EchantillonController {

    @Autowired
    private EchantillonServiceImpl echantillonService;

    @PostMapping
    public ResponseEntity<EchantillonDto> saveEchantillon(@RequestBody EchantillonDto echantillonDto) {
        EchantillonDto saveEchantillonDto = echantillonService.saveEchantillon(echantillonDto);
        return new ResponseEntity<>(saveEchantillonDto , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EchantillonDto>> getAllEchantillons() {
        return ResponseEntity.ok(echantillonService.getEchantillons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EchantillonDto> getEchantillonById(@PathVariable("id") Long echantillonId) {
        EchantillonDto echantillonDto = echantillonService.getEchantillonById(echantillonId);
        return ResponseEntity.ok(echantillonDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EchantillonDto> updateEchantillon(@PathVariable("id") Long id, @RequestBody EchantillonDto echantillonDto) {
       return ResponseEntity.ok(echantillonService.updateEchantillon(echantillonDto ,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEchantillonById(@PathVariable("id") Long id) {
        echantillonService.deleteEchantillon(id);
        return ResponseEntity.ok("Echantillon with id : " + id + "was deleted");
    }
}
