package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.repository.IEchantillonRepository;
import com.example.labxspringboot.service.IEchantillonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EchantillonServiceImpl implements IEchantillonService {

    @Autowired
    private IEchantillonRepository echantillonRepository;

    private final ModelMapper modelMapper;

    @Override
    public EchantillonDto saveEchantillon(EchantillonDto echantillonDto) {
        Echantillon echantillon = modelMapper.map(echantillonDto, Echantillon.class);
        Echantillon savedEchantillon = echantillonRepository.save(echantillon);
        return modelMapper.map(savedEchantillon, EchantillonDto.class);
    }

    @Override
    public List<EchantillonDto> getEchantillons() {
        List<Echantillon> echantillons = echantillonRepository.findByDeletedFalse();
        return echantillons.stream().map(echantillon -> modelMapper.map(echantillon, EchantillonDto.class)).collect(Collectors.toList());
    }

    @Override
    public EchantillonDto getEchantillonById(Long id) {
        return echantillonRepository.findByIdAndDeletedFalse(id)
                .map(echantillon -> modelMapper.map(echantillon, EchantillonDto.class))
                .orElse(null);
    }

    @Override
    public EchantillonDto updateEchantillon(EchantillonDto echantillonDto, Long id) {
        Echantillon existingEchantillon = echantillonRepository.findById(id).orElse(null);
        if (existingEchantillon != null) {
            modelMapper.map(echantillonDto, existingEchantillon);
            existingEchantillon.setId(id);
            Echantillon savedEchantillon = echantillonRepository.save(existingEchantillon);
            return modelMapper.map(savedEchantillon, EchantillonDto.class);
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
