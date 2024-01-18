package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.enume.TypeAnalyseName;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.TypeAnalyse}
 */
@Value
public class TypeAnalyseDto implements Serializable {
    Long id;
    TypeAnalyseName typeAnalyseName;
    List<Norme> normes ;
}