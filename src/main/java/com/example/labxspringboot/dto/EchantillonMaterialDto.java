package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.EchantillonMaterial;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link EchantillonMaterial}
 */
@Value
public class EchantillonMaterialDto implements Serializable {
    Long id;
    Long echantillonId;
    String echantillonDatePrelevement;
    Long materielEchanId;
    String materielEchanNomechan;
    int materielEchanQuantiteStockEhcna;
    String materielEchanDateExpirationEchan;
    String materielEchanFournisseurNom;
    int quantity;
}