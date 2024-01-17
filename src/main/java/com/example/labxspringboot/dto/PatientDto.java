package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Echantillon;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.Patient}
 */
@Data
@NoArgsConstructor
public class PatientDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String dateNaissance;
    String sexe;
    String adresse;
    String numeroTelephone;
    List<Echantillon> historiqueEchantillon;
    boolean deleted;
}