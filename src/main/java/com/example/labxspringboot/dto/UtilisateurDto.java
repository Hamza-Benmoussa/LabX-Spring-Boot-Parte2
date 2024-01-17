package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.entity.enume.RoleUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Utilisateur}
 */
@Data
@NoArgsConstructor
public class UtilisateurDto implements Serializable {
    Long id;
    String nomUtilisateur;
    String motDePasse;
    RoleUser role;
    boolean deleted;
}