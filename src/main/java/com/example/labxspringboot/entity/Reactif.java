package com.example.labxspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reactif")

public class Reactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private int quantiteStock;

    private String dateExpiration;

    private String fournisseurNom;

    @Column(name="is_deleted" , nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "reactif" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore  // Add this annotation to break the loop
    private Norme norme;

}
