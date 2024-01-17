package com.example.labxspringboot.service;

import com.example.labxspringboot.dto.AnalyseDto;

import java.util.List;

public interface IAnalyseService {
    AnalyseDto saveAnalyse(AnalyseDto analyseDto);
    List<AnalyseDto> getAnalyses();
    AnalyseDto getAnalyseById(Long id);
    AnalyseDto updateAnalyse(AnalyseDto analyseDto, Long id);
    void deleteAnalyse(Long id);

}
