package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.mapper.AnalyseMapper;
import com.example.labxspringboot.repository.IAnalyseRepository;
import com.example.labxspringboot.service.IAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalyseServiceImpl implements IAnalyseService {

    @Autowired
    private IAnalyseRepository iAnalyseRepository;

    @Autowired
    private AnalyseMapper analyseMapper;

    @Override
    public AnalyseDto saveAnalyse(AnalyseDto analyseDto) {
        Analyse analyse = analyseMapper.toEntity(analyseDto);
        Analyse savedAnalyse = iAnalyseRepository.save(analyse);
        return analyseMapper.toDto(savedAnalyse);
    }

    @Override
    public List<AnalyseDto> getAnalyses() {
        List<Analyse> analyses = iAnalyseRepository.findAll();
        return analyses.stream().map(analyseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AnalyseDto getAnalyseById(Long id) {
        Analyse analyse = iAnalyseRepository.findById(id).orElse(null);
        return analyse != null ? analyseMapper.toDto(analyse) : null;
    }

    @Override
    public AnalyseDto updateAnalyse(AnalyseDto analyseDto, Long id) {
        Analyse existingAnalyse = iAnalyseRepository.findById(id).orElse(null);
        if (existingAnalyse != null) {
            Analyse updatedAnalyse = analyseMapper.toEntity(analyseDto);
            updatedAnalyse.setId(id);
            Analyse savedAnalyse = iAnalyseRepository.save(updatedAnalyse);
            return analyseMapper.toDto(savedAnalyse);
        }
        return null;
    }

    @Override
    public void deleteAnalyse(Long id) {
        Analyse analyse = iAnalyseRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (analyse != null) {
            analyse.setDeleted(true);
            iAnalyseRepository.save(analyse);
        }
    }
}
