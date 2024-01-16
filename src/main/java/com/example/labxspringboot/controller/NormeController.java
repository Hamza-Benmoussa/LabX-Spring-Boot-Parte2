package com.example.labxspringboot.controller;

import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.Norme;
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
    public ResponseEntity<Norme> saveNorme(@RequestBody Norme norme){
        return new ResponseEntity<Norme>(normeService.saveNorme(norme) , HttpStatus.CREATED);
    }

    @GetMapping
    public List<Norme> getAllNorme(){
        return normeService.getNormes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Norme> getNormeById(@PathVariable ("id") Long normeId){
        return new ResponseEntity<Norme>(normeService.getNormeById(normeId) ,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Norme> updateNorme(@PathVariable ("id") Long id , @RequestBody Norme norme){
        return new ResponseEntity<Norme>(normeService.updateNorme(norme,id) ,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNorme(@PathVariable ("id") Long id){
        normeService.deleteNorme(id);
        return ResponseEntity.noContent().build();
    }
}
