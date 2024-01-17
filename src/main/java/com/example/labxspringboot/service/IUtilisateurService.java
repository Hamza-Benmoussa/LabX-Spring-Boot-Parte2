package com.example.labxspringboot.service;

import com.example.labxspringboot.dto.UtilisateurDto;
import com.example.labxspringboot.entity.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    List<UtilisateurDto> getUtilisateurs();
    UtilisateurDto getUtilisateurById(Long id);
    UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto,Long id);
    void deleteUtilisateur(Long id);
}
