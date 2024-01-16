package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.mapper.EchantillonMapper;
import com.example.labxspringboot.repository.IEchantillonRepository;
import com.example.labxspringboot.service.IEchantillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EchantillonServiceImpl implements IEchantillonService {

    @Autowired
    private  IEchantillonRepository echantillonRepository;

    @Autowired
    private  EchantillonMapper echantillonMapper;


    @Override
    public EchantillonDto saveEchantillon(EchantillonDto echantillonDto) {
        Echantillon echantillon = echantillonMapper.toEntity(echantillonDto);
        Echantillon saveEchantillon = echantillonRepository.save(echantillon);
        return echantillonMapper.toDto(saveEchantillon);
    }

    @Override
    public List<EchantillonDto> getEchantillons() {
        List<Echantillon> echantillons = echantillonRepository.findAll();
        return echantillons.stream().map(echantillonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EchantillonDto getEchantillonById(Long id) {
        Echantillon echantillon = echantillonRepository.findById(id).orElse(null);
        return echantillon != null ? echantillonMapper.toDto(echantillon) : null;
    }

    @Override
    public EchantillonDto updateEchantillon(EchantillonDto echantillonDto, Long id) {
        Echantillon existingEchantillon = echantillonRepository.findById(id).orElse(null);
        if (existingEchantillon != null) {
            Echantillon updatedEchantillon = echantillonMapper.toEntity(echantillonDto);
            updatedEchantillon.setId(id);
            Echantillon savedEchantillon = echantillonRepository.save(updatedEchantillon);
            return echantillonMapper.toDto(savedEchantillon);
        }
        return null;
    }

    @Override
    public void deleteEchantillon(Long id) {
        Echantillon echantillon = echantillonRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (echantillon != null) {
            echantillon.setDeleted(true);
            echantillonRepository.save(echantillon);
        }
    }
}
