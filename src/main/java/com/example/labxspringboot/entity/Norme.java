package com.example.labxspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "norme")
public class Norme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double min;

    private double max;

    private String unite;

    @Column(name="is_deleted")
    private Boolean deleted;

    @OneToOne(mappedBy = "norme" ,cascade = CascadeType.ALL)
    private TestAnalyse testAnalyse;
}
