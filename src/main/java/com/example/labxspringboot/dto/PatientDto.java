package com.example.labxspringboot.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.Patient}
 */
@Value
public class PatientDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String dateNaissance;
    String sexe;
    String adresse;
    String numeroTelephone;
    List<Long> historiqueAnalysisIds;
}