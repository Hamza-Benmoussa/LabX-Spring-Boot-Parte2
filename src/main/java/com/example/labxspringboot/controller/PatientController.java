package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.PatientDto;
import com.example.labxspringboot.entity.Patient;
import com.example.labxspringboot.service.IPatientService;
import com.example.labxspringboot.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public ResponseEntity<PatientDto> savePatient(@RequestBody PatientDto patientDto){
        PatientDto savePatientDto = patientService.savePatient(patientDto);
        return new  ResponseEntity<>(savePatientDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable ("id") Long patientId){
        PatientDto patientDto = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDto);
    }

    @PutMapping("/{id}")

    public ResponseEntity<PatientDto> updatePatient(@PathVariable ("id") Long id, @RequestBody PatientDto patientDto){
        return ResponseEntity.ok(patientService.updatePatient(patientDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable ("id") Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with id : " + id + "was deleted");
    }
}
