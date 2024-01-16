package com.example.labxspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "responsable_labo")
//@PrimaryKeyJoinColumn(name = "utilisateur_id")
public class ResponsableLabo extends Utilisateur {
    private String fonctionResponsable;
    @OneToMany(mappedBy = "responsableLaboTest" , cascade = CascadeType.ALL)
    private List<TestAnalyse> testAnalyses;

    @OneToMany(mappedBy = "responsableLaboAnalyse" , cascade = CascadeType.ALL)
    private List<Analyse> analyses;

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

}
