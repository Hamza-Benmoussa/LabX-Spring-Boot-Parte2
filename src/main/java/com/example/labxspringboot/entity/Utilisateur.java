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


    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    public Utilisateur(String s1, String s, RoleUser technicien) {

    }

//    @OneToMany(mappedBy = "utilisateur")
//    private List<RapportStatis> generateursRapports;


}
