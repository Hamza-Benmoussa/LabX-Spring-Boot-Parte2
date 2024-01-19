package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.StatusResultat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
public class TestAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    private Utilisateur utilisateurRespo;

    @Enumerated(EnumType.STRING)
    private StatusResultat statusResultat;

    private float resultatNmbr;

    @ManyToOne
    private TypeAnalyse typeAnalyse;


    @ManyToOne
    private Reactif reactif;
    @ManyToOne
    private Norme norme;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;
}
