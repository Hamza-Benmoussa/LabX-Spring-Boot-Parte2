package com.example.labxspringboot.controller;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.Reactif;
import com.example.labxspringboot.service.impl.NormeServiceImpl;
import com.example.labxspringboot.service.impl.ReactifServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactifs")
public class ReactifController {

    @Autowired
    private ReactifServiceImpl reactifService;


    @PostMapping
    public ResponseEntity<Reactif> saveReactif(@RequestBody Reactif reactif){
        return new ResponseEntity<Reactif>(reactifService.saveReactif(reactif) , HttpStatus.CREATED);
    }

    @GetMapping
    public List<Reactif> getAllReactif(){
        return reactifService.getReactifs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reactif> getReactifById(@PathVariable ("id") Long reactifId){
        return new ResponseEntity<Reactif>(reactifService.getReactifById(reactifId) ,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reactif> updateReactif(@PathVariable ("id") Long id , @RequestBody Reactif reactif){
        return new ResponseEntity<Reactif>(reactifService.updateReactif(reactif,id) ,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReactif(@PathVariable ("id") Long id){
        reactifService.deleteReactif(id);
        return ResponseEntity.noContent().build();
    }
}
