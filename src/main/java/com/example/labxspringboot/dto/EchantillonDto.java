package com.example.labxspringboot.dto;

import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.entity.Patient;
import com.example.labxspringboot.entity.Technicien;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Echantillon}
 */
@Data
@NoArgsConstructor
public class EchantillonDto implements Serializable {
    Long id;
<<<<<<< HEAD
    Patient patient;
    MaterielEchan materielEchan;
    Technicien technicienEch;
=======
    Long patientId;
    Long materielEchanId;
    Long utilisateurId;
>>>>>>> c04dae5fe873337257bfafc5d897e2585aaf0247
    String datePrelevement;
    boolean deleted;
}