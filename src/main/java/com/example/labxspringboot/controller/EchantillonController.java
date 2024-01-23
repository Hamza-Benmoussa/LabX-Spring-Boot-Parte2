package com.example.labxspringboot.controller;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.dto.MaterielEchanDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.EchantillonMaterial;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.service.IEchantillonMaterialService;
import com.example.labxspringboot.service.IMaterialEchanService;
import com.example.labxspringboot.service.impl.EchantillonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/echantillons" ,produces = "application/json")
@Transactional
public class EchantillonController {

    @Autowired
    private EchantillonServiceImpl echantillonService;
    @Autowired
    private IMaterialEchanService iMaterialEchanService;
    @Autowired
    private IEchantillonMaterialService iEchantillonMaterialService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<EchantillonDto> saveEchantillon(@RequestBody EchantillonDto echantillonDto) {
        EchantillonDto saveEchantillonDto = echantillonService.saveEchantillon(echantillonDto);
        EchantillonDto echantillonDto1 = saveEchantillonDto;
        if (echantillonDto.getEchantillonMaterials() != null) {
            for (EchantillonMaterial echantillonMaterial : echantillonDto.getEchantillonMaterials()) {
                MaterielEchan materielEchan = modelMapper.map(iMaterialEchanService.getMaterialEchanById(echantillonMaterial.getMaterielEchan().getId()), MaterielEchan.class);
                echantillonMaterial.setEchantillon(modelMapper.map(echantillonDto1, Echantillon.class));
                echantillonMaterial.setMaterielEchan(materielEchan);
                iEchantillonMaterialService.addEchantillon(echantillonMaterial);

                materielEchan.setQuantiteStockEhcna(materielEchan.getQuantiteStockEhcna() - echantillonMaterial.getQuantity());
                iMaterialEchanService.updateMaterialEchan(modelMapper.map(materielEchan, MaterielEchanDto.class), materielEchan.getId());
            }
        }
        return new ResponseEntity<>(saveEchantillonDto , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EchantillonDto>> getAllEchantillons() {
        return ResponseEntity.ok(echantillonService.getEchantillons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EchantillonDto> getEchantillonById(@PathVariable("id") Long echantillonId) {
        EchantillonDto echantillonDto = echantillonService.getEchantillonById(echantillonId);
        return ResponseEntity.ok(echantillonDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EchantillonDto> updateEchantillon(@PathVariable("id") Long id, @RequestBody EchantillonDto echantillonDto) {
       return ResponseEntity.ok(echantillonService.updateEchantillon(echantillonDto ,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEchantillonById(@PathVariable("id") Long id) {
        echantillonService.deleteEchantillon(id);
        return ResponseEntity.ok("Echantillon with id : " + id + "was deleted");
    }
}
