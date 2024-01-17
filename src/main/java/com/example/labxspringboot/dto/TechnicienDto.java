package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Technicien;
import com.example.labxspringboot.entity.enume.RoleUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Technicien}
 */
@Data
@NoArgsConstructor
public class TechnicienDto implements Serializable {
    Long id;
    String nomUtilisateur;
    String motDePasse;
    RoleUser role;
    String specialiteTechnicien;
    List<Long> echantillonIds;
    boolean deleted;
}