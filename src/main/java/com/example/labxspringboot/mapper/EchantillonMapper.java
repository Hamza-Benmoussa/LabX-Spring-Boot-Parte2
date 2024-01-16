package com.example.labxspringboot.mapper;

import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Echantillon;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EchantillonMapper {

    private final ModelMapper modelMapper;

    public EchantillonMapper (ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public EchantillonDto toDto(Echantillon echantillon){
        return modelMapper.map(echantillon,EchantillonDto.class);
    }

    public Echantillon toEntity(EchantillonDto echantillonDto){
        return modelMapper.map(echantillonDto,Echantillon.class);
    }
}
