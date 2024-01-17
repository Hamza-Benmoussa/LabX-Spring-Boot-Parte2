package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.entity.Patient;
import com.example.labxspringboot.entity.Technicien;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Echantillon}
 */
@Data
@NoArgsConstructor
public class EchantillonDto implements Serializable {
    Long id;
    Patient patient;
    MaterielEchan materielEchan;
    Technicien technicienEch;
    String datePrelevement;
    boolean deleted;
}