package com.example.labxspringboot.controller;

import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.service.impl.MaterialEchanServiceImpl;
import com.example.labxspringboot.service.impl.NormeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/material")
public class MaterialEchanController {

    @Autowired
    private MaterialEchanServiceImpl materialEchanService;


    @PostMapping
    public ResponseEntity<MaterielEchan> saveMaterial(@RequestBody MaterielEchan materielEchan){
        return new ResponseEntity<MaterielEchan>(materialEchanService.saveMaterialEchan(materielEchan) , HttpStatus.CREATED);
    }

    @GetMapping
    public List<MaterielEchan> getAllMaterial(){
        return materialEchanService.getMaterialEchans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterielEchan> getMaterialById(@PathVariable("id") Long materialId){
        return new ResponseEntity<MaterielEchan>(materialEchanService.getMaterialEchanById(materialId) ,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MaterielEchan> updateMaterial(@PathVariable ("id") Long id, @RequestBody MaterielEchan materielEchan){
        return new ResponseEntity<MaterielEchan>(materialEchanService.updateMaterialEchan(materielEchan ,id) ,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNorme(@PathVariable ("id") Long id){
        materialEchanService.deleteMaterialEchan(id);
        return ResponseEntity.noContent().build();
    }
}
