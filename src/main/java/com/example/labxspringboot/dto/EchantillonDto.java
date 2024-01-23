package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.*;
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
    Utilisateur utilisateurTechnicien;
    String datePrelevement;
    List<Analyse> analyses;
    List<EchantillonMaterial> echantillonMaterials;
    boolean deleted;
}