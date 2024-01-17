package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.entity.enume.StatusResultat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestAnalyse}
 */
@Data
@NoArgsConstructor
public class TestAnalyseDto implements Serializable {
    Long id;
    String description;
    Long utilisateurId;
    StatusResultat statusResultat;
    float resultatNmbr;
    Long analyseId;
    Long reactifId;
    Long normeId;
    boolean deleted;
}