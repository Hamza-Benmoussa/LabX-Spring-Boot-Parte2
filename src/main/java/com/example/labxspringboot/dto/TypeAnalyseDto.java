package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.enume.TypeAnalyseName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.labxspringboot.entity.TypeAnalyse}
 */
//@Value
@Data
@NoArgsConstructor
public class TypeAnalyseDto implements Serializable {
    Long id;
    TypeAnalyseName typeAnalyseName;
    List<Norme> normes ;
}