package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Echantillon;
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
    Long patientId;
    Long materielEchanId;
    Long utilisateurId;
    String datePrelevement;
    boolean deleted;
}