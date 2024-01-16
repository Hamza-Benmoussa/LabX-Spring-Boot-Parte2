package com.example.labxspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Echantillon> historiqueAnalyses;

    public Patient(String nom, String prenom, String dateNaissance, String sexe, String adresse, String numeroTelephone, List<Echantillon> historiqueAnalyses) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.historiqueAnalyses = historiqueAnalyses;
    }
}
