package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.*;
import com.example.labxspringboot.entity.enume.StatusResultat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestAnalyse}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestAnalyseDto implements Serializable {
    Long id;
    String description;
    Utilisateur utilisateurRespo;
    StatusResultat statusResultat;
    float resultatNmbr;
    TypeAnalyse typeAnalyse;
    Reactif reactif;
    Norme norme;
    boolean deleted;

}