package com.example.labxspringboot.entity;

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
    private Echantillon echantillon;

    @Column(name="is_deleted")
    private Boolean deleted;

    public MaterielEchan(String nomechan, int quantiteStockEhcna, String dateExpirationEchan, String fournisseurNom) {
        this.nomechan = nomechan;
        this.quantiteStockEhcna = quantiteStockEhcna;
        this.dateExpirationEchan = dateExpirationEchan;
        this.fournisseurNom = fournisseurNom;

    }
}
