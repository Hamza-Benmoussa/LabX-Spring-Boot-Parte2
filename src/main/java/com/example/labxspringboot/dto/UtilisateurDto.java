package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.entity.enume.RoleUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
@Data
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"motDePasse"})

public class UtilisateurDto implements Serializable {
    Long id;
    String nomUtilisateur;
    //@JsonIgnore
    String motDePasse;
    RoleUser role;
    boolean deleted;

    public UtilisateurDto(String s1, String s, RoleUser technicien) {

    }
}