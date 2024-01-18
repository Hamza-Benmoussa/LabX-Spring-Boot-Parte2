package com.example.labxspringboot.entity;

import com.example.labxspringboot.entity.enume.TypeAnalyseName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeAnalyse {
    @Id
    @GeneratedValue
    private Long id ;
    @Enumerated(EnumType.STRING)
    private TypeAnalyseName typeAnalyseName;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "typeAnalyse" , cascade = CascadeType.ALL )
    @Fetch(FetchMode.SUBSELECT)
    List<Norme> normes;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "TypeAnalyseDeAnalyse" ,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    List<Analyse> analyses;
}
