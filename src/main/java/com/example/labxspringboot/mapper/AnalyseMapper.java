package com.example.labxspringboot.mapper;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AnalyseMapper {


    private final ModelMapper modelMapper;

    public AnalyseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AnalyseDto toDto(Analyse analyse) {
        return modelMapper.map(analyse, AnalyseDto.class);
    }

    public Analyse toEntity(AnalyseDto analyseDto) {
        return modelMapper.map(analyseDto, Analyse.class);
    }
}
