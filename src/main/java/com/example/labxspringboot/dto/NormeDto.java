package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.Reactif;
<<<<<<< HEAD
=======
import com.example.labxspringboot.entity.TestAnalyse;
>>>>>>> main
import com.example.labxspringboot.entity.TypeAnalyse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

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
<<<<<<< HEAD
    private TypeAnalyse typeAnalyse;

    private Reactif reactif;

=======
    @ToString.Exclude
    List<TestAnalyse> testAnalyses;
>>>>>>> main
    boolean deleted;
}