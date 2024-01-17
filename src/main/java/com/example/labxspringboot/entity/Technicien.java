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
    @Table(name = "technicien")
    public class Technicien extends Utilisateur {



        private String specialiteTechnicien;

        @OneToMany(mappedBy = "technicienEch" ,cascade = CascadeType.ALL)
        private List<Echantillon> echantillon;

        @Column(name="is_deleted" ,nullable = false)
        private boolean deleted;


    }
