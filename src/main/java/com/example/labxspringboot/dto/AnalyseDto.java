package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.enume.StatusAnalyse;
import com.example.labxspringboot.entity.enume.StatusResultat;
import com.example.labxspringboot.entity.enume.TypeAnalyse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.Analyse}
 */
@Data
@NoArgsConstructor
public class AnalyseDto implements Serializable {
    Long id;
    Long echantillonId;
    Long utilisateurId;
    List<Long> testAnalysisIds;
    TypeAnalyse typeAnalyse;
    String dateDebutAnalyse;
    String dateFinAnalyse;
    StatusResultat status;
    StatusAnalyse statusAnalyse;
    String commentaires;
    boolean deleted;

}