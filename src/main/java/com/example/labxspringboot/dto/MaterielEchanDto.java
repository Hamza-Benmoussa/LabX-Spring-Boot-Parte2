package com.example.labxspringboot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.labxspringboot.entity.MaterielEchan}
 */
@Data
@NoArgsConstructor
public class MaterielEchanDto implements Serializable {
    Long id;
    String nomechan;
    int quantiteStockEhcna;
    String dateExpirationEchan;
    String fournisseurNom;
    boolean deleted;
}