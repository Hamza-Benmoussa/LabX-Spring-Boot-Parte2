package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.entity.TypeAnalyse;
import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.entity.enume.StatusAnalyse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.Analyse}
 */
@Data
@NoArgsConstructor
public class AnalyseDto implements Serializable {
    Long id;
    Echantillon echantillon;
    String nom;
    Utilisateur utilisateurRespo;
    String dateDebutAnalyse;
    String dateFinAnalyse;
    StatusAnalyse statusAnalyse;
    String commentaires;
//    @ToString.Exclude
//    List<TypeAnalyse> typeAnalyses;
    boolean deleted;

}