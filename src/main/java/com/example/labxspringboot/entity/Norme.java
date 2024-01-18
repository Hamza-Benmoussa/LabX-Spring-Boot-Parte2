package com.example.labxspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name="is_deleted" ,nullable = false)
    private boolean deleted;

    @ManyToOne
    private TypeAnalyse typeAnalyse;

    @ManyToOne
    private Reactif reactif;

    @OneToOne(mappedBy = "norme" ,cascade = CascadeType.ALL)
    @JsonIgnore  // Add this annotation to break the loop
    private TestAnalyse testAnalyse;
}
