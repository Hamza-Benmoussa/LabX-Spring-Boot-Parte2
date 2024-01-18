package com.example.labxspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String dateNaissance;

    private String sexe;

    private String adresse;

    private String numeroTelephone;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;
    @ToString.Exclude
    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL  , fetch = FetchType.LAZY)
//    @ElementCollection(fetch = FetchType.LAZY)
    @JsonIgnore  // Add this annotation to break the loop
    private List<Echantillon> historiqueEchantillon;


}
