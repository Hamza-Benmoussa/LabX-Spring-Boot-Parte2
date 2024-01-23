package com.example.labxspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchantillonMaterial {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    Echantillon echantillon;
    @ManyToOne
    MaterielEchan materielEchan;

    private int quantity;
}
