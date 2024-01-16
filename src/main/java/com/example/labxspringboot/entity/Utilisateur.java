package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.RoleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomUtilisateur;

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private RoleUser role;

    @Column(name="is_deleted")
    private Boolean deleted;

//    @OneToMany(mappedBy = "utilisateur")
//    private List<RapportStatis> generateursRapports;

    public Utilisateur(String nomUtilisateur, String motDePasse, RoleUser role, List<RapportStatis> generateursRapports) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.role = role;
//        this.generateursRapports = generateursRapports;
    }
}
