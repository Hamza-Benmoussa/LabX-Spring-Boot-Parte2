package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.mapper.EchantillonMapper;
import com.example.labxspringboot.service.IEchantillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/echantillons")
public class EchantillonController {

    @Autowired
    private  IEchantillonService echantillonService;



    @PostMapping
    public ResponseEntity<EchantillonDto> saveEchantillon(@RequestBody EchantillonDto echantillonDto) {
        EchantillonDto saveEchantillonDto = echantillonService.saveEchantillon(echantillonDto);
        return new ResponseEntity<>(saveEchantillonDto , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EchantillonDto>> getAllEchantillons() {
        List<EchantillonDto> echantillons = echantillonService.getEchantillons();
        return new ResponseEntity<>(echantillons ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EchantillonDto> getEchantillonById(@PathVariable("id") Long echantillonId) {
        EchantillonDto echantillonDto = echantillonService.getEchantillonById(echantillonId);
        if (echantillonDto != null) {
            return new ResponseEntity<>(echantillonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EchantillonDto> updateEchantillon(@PathVariable("id") Long id, @RequestBody EchantillonDto echantillonDto) {
        EchantillonDto updatedEchantillonDto = echantillonService.updateEchantillon(echantillonDto, id);
        if (updatedEchantillonDto != null) {
            return new ResponseEntity<>(updatedEchantillonDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEchantillonById(@PathVariable("id") Long id) {
        echantillonService.deleteEchantillon(id);
        return ResponseEntity.noContent().build();
    }
}
