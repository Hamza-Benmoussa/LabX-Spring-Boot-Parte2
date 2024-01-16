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
    private ResponsableLabo responsableLaboAnalyse;

    @OneToMany(mappedBy = "analyse" , cascade = CascadeType.ALL)
    private List<TestAnalyse> testAnalyses;

    @Enumerated(EnumType.STRING)
    private TypeAnalyse typeAnalyse;

    private String dateDebutAnalyse;

    private String dateFinAnalyse;

    @Enumerated(EnumType.STRING)
    private StatusResultat status;

    @Enumerated(EnumType.STRING)
    private StatusAnalyse statusAnalyse;

    private String commentaires;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    public Analyse(Echantillon echantillon, ResponsableLabo responsableLaboAnalyse, List<TestAnalyse> testAnalyses, TypeAnalyse typeAnalyse, String dateDebutAnalyse, String dateFinAnalyse, StatusResultat status, StatusAnalyse statusAnalyse, String commentaires) {
        this.echantillon = echantillon;
        this.responsableLaboAnalyse = responsableLaboAnalyse;
        this.testAnalyses = testAnalyses;
        this.typeAnalyse = typeAnalyse;
        this.dateDebutAnalyse = dateDebutAnalyse;
        this.dateFinAnalyse = dateFinAnalyse;
        this.status = status;
        this.statusAnalyse = statusAnalyse;
        this.commentaires = commentaires;
    }
}
