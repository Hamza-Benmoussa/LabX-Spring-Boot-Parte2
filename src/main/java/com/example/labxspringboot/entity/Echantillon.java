package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.StatusAnalyse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "echantillon")

public class Echantillon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @OneToOne
    private MaterielEchan materielEchan;

    @OneToMany(mappedBy = "echantillon" ,cascade = CascadeType.ALL)
    private List<Analyse> analyses;

    @ManyToOne
    private Technicien technicienEch;

    private String datePrelevement;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    public Echantillon(Patient patient, MaterielEchan materielEchan, List<Analyse> analyses, Technicien technicien, String datePrelevement) {
        this.patient = patient;
        this.materielEchan = materielEchan;
        this.analyses = analyses;
        this.technicienEch = technicien;
        this.datePrelevement = datePrelevement;
    }
}

