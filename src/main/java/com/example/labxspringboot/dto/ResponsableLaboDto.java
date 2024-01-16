package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.ResponsableLabo;
import com.example.labxspringboot.entity.enume.RoleUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ResponsableLabo}
 */
@Data
@NoArgsConstructor
public class ResponsableLaboDto implements Serializable {
    Long id;
    String nomUtilisateur;
    String motDePasse;
    RoleUser role;
    String fonctionResponsable;
    List<Long> testAnalysisIds;
    List<Long> analysisIds;
    boolean deleted;
}