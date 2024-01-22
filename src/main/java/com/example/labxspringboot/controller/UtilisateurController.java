package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.MaterielEchanDto;
import com.example.labxspringboot.dto.UtilisateurDto;
import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.exception.exept.UtilisateurFoundException;
import com.example.labxspringboot.service.impl.UtilisateurServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurServiceImpl utilisateurService;
    @PostMapping
    public ResponseEntity<UtilisateurDto>saveUtilisateur(@RequestBody @Valid UtilisateurDto utilisateurDto){
        UtilisateurDto saveUtilisateurDto = utilisateurService.saveUtilisateur(utilisateurDto);
        return  new ResponseEntity<>(saveUtilisateurDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable("id")  Long utilisateurId) throws UtilisateurFoundException {
        UtilisateurDto utilisateurDto = utilisateurService.getUtilisateurById(utilisateurId);
        return ResponseEntity.ok(utilisateurDto);
    }
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getUtilisateurs());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUtilisateur(@PathVariable("id") Long id, @RequestBody @Valid UtilisateurDto utilisateurDto) {
        return ResponseEntity.ok(utilisateurService.updateUtilisateur(utilisateurDto ,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUtilisateurById(@PathVariable("id") Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.ok("Utilisateur with id : " + id + "was deleted");
    }



}
