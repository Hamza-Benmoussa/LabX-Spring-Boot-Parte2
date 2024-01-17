package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.MaterielEchanDto;
import com.example.labxspringboot.service.IMaterialEchanService;
import com.example.labxspringboot.service.impl.MaterialEchanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@AllArgsConstructor
public class MaterialEchanController {

    @Autowired
    private MaterialEchanServiceImpl materialEchanService;

    @PostMapping
    public ResponseEntity<MaterielEchanDto> saveMaterial(@RequestBody MaterielEchanDto materielEchanDto) {
        MaterielEchanDto materielEchanDto1 = materialEchanService.saveMaterialEchan(materielEchanDto);
        return new ResponseEntity<>(materielEchanDto1,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaterielEchanDto>> getAllMaterial() {
        return ResponseEntity.ok(materialEchanService.getMaterialEchans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterielEchanDto> getMaterialById(@PathVariable("id") Long materialId) {
        MaterielEchanDto materielEchanDto = materialEchanService.getMaterialEchanById(materialId);
        return ResponseEntity.ok(materielEchanDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterielEchanDto> updateMaterial(@PathVariable("id") Long id, @RequestBody MaterielEchanDto materielEchanDto) {
        return ResponseEntity.ok(materialEchanService.updateMaterialEchan(materielEchanDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaterial(@PathVariable("id") Long id) {
        materialEchanService.deleteMaterialEchan(id);
        return ResponseEntity.ok("Material with id : " + id + "was deleted");
    }
}
