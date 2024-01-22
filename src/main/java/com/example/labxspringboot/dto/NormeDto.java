package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.Reactif;
import com.example.labxspringboot.entity.TypeAnalyse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * DTO for {@link Norme}
 */
@Data
@NoArgsConstructor
public class NormeDto implements Serializable {
    Long id;
    String description;
    double min;
    double max;
    String unite;
    private TypeAnalyse typeAnalyse;

    private Reactif reactif;

    boolean deleted;
}