package com.example.labxspringboot.dto;

<<<<<<< HEAD
import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.enume.TypeAnalyseName;
=======
import com.example.labxspringboot.dto.TestAnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.entity.TypeAnalyse;
import lombok.AllArgsConstructor;
>>>>>>> main
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link TypeAnalyse}
 */
<<<<<<< HEAD
//@Value
@Data
=======
@Data
@AllArgsConstructor
>>>>>>> main
@NoArgsConstructor
public class TypeAnalyseDto implements Serializable {
    Long id;
    String nom;
    List<TestAnalyse> testAnalyses;
    Analyse analyse;

}