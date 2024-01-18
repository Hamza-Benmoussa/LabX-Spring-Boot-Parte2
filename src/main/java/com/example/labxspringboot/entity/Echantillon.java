package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.StatusAnalyse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    @OneToMany(mappedBy = "echantillon" ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JsonIgnore  // Add this annotation to break the loop
    private List<Analyse> analyses;

    @ManyToOne
    private Utilisateur utilisateurTechnicien;

    private String datePrelevement;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

}

