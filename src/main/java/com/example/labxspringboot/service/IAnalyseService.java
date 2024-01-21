package com.example.labxspringboot.service;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.Echantillon;

import java.util.List;

public interface IAnalyseService {
    AnalyseDto saveAnalyse(AnalyseDto analyseDto);
    List<AnalyseDto> getAnalyses();
    AnalyseDto getAnalyseById(Long id);
    AnalyseDto updateAnalyse(AnalyseDto analyseDto, Long id);
    AnalyseDto createAnalyseForEchantillon(Echantillon echantillon ,AnalyseDto analyseDto);

    void deleteAnalyse(Long id);

    List<Object[]> printResultAnalyse(Long id);

}
