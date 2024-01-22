package com.example.labxspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "materielechan")
public class MaterielEchan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomechan;

    private int quantiteStockEhcna;

    private String dateExpirationEchan;

    private String fournisseurNom;

    @OneToOne(mappedBy = "materielEchan" , cascade = CascadeType.ALL)
    @JsonIgnore  // Add this annotation to break the loop
    private Echantillon echantillon;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    public MaterielEchan(String s, int i, String s1, String hello) {
    }
}
