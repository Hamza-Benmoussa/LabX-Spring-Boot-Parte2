package com.example.labxspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "materielechan")
public class MaterielEchan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomechan;

    private int quantiteStockEhcna;

    private String dateExpirationEchan;

    private String fournisseurNom;

    @OneToMany(mappedBy = "materielEchan" , cascade = CascadeType.ALL)
    @JsonIgnore  // Add this annotation to break the loop
    @Fetch(FetchMode.SUBSELECT)
    private List<Echantillon> echantillon;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    public MaterielEchan(String s, int i, String s1, String hello) {
    }
}
