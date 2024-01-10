package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.StatusAnalyse;
import com.example.labxspringboot.entity.enume.StatusResultat;
import com.example.labxspringboot.entity.enume.TypeAnalyse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "analyses")
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Echantillon echantillon;

    @ManyToOne
    private Utilisateur technicienResponsable;

    @OneToMany(mappedBy = "analyse")
    private List<Test> tests;

    @Enumerated(EnumType.STRING)
    private TypeAnalyse typeAnalyse; // Ajout de l'attribut typeAnalyse

    private String dateDebutAnalyse;

    private String dateFinAnalyse;

    @Enumerated(EnumType.STRING)
    private StatusResultat status;

    @Enumerated(EnumType.STRING)
    private StatusAnalyse statusAnalyse;

    private String commentaires;

}
