package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.*;
import com.example.labxspringboot.entity.enume.StatusAnalyse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.Analyse}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyseDto implements Serializable {
    Long id;
    Echantillon echantillon;
    String nom;
    Utilisateur utilisateurTechnicien;
    Date dateDebutAnalyse;
    Date dateFinAnalyse;
    StatusAnalyse statusAnalyse;
    String commentaires;
//    @ToString.Exclude
    List<TypeAnalyse> typeAnalyses;
    boolean deleted;

}