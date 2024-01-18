package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.StatusAnalyse;
import com.example.labxspringboot.entity.enume.TypeAnalyseName;
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
@Table(name = "analyses")
public class Analyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Echantillon echantillon;

    @ManyToOne
    private Utilisateur utilisateurRespo;
    @ToString.Exclude
    @OneToMany(mappedBy = "analyse" , cascade = CascadeType.ALL)
    @JsonIgnore  // Add this annotation to break the loop
    private List<TestAnalyse> testAnalyses;



    private String dateDebutAnalyse;

    private String dateFinAnalyse;

    @Enumerated(EnumType.STRING)
    private StatusAnalyse statusAnalyse;

    private String commentaires;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    @ManyToOne
    private TypeAnalyse TypeAnalyseDeAnalyse;

}
