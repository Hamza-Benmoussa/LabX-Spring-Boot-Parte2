package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.repository.IAnalyseRepository;
import com.example.labxspringboot.service.IAnalyseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnalyseServiceImpl implements IAnalyseService {

    @Autowired
    private IAnalyseRepository iAnalyseRepository;


    private final ModelMapper modelMapper;

    @Override
    public AnalyseDto saveAnalyse(AnalyseDto analyseDto) {
        Analyse analyse = modelMapper.map(analyseDto ,Analyse.class);
        Analyse analyseSave = iAnalyseRepository.save(analyse);
        return modelMapper.map(analyseSave,AnalyseDto.class);
    }

    @Override
    public List<AnalyseDto> getAnalyses() {
        List<Analyse> analyses = iAnalyseRepository.findByDeletedFalse();
        return analyses.stream().map(analyse -> modelMapper.map(analyse,AnalyseDto.class)).collect(Collectors.toList());
    }

    @Override
    public AnalyseDto getAnalyseById(Long id) {
        return iAnalyseRepository.findByIdAndDeletedFalse(id).map(analyse -> modelMapper.map(analyse,AnalyseDto.class)).orElse(null);
    }

    @Override
    public AnalyseDto updateAnalyse(AnalyseDto analyseDto, Long id) {
        Analyse existingAnalyse = iAnalyseRepository.findById(id).orElse(null);
        if (existingAnalyse != null) {
            modelMapper.map(analyseDto, existingAnalyse);
            existingAnalyse.setId(id);
            Analyse savedAnalyse = iAnalyseRepository.save(existingAnalyse);
            return modelMapper.map(savedAnalyse, AnalyseDto.class);
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

    @Override
    public List<Object[]> printResultAnalyse(Long id) {
        return iAnalyseRepository.getAnalysisReport(id);
    }

    @Override
    public AnalyseDto createAnalyseForEchantillon(Echantillon echantillon, AnalyseDto analyseDto) {
        Analyse analyse = modelMapper.map(analyseDto, Analyse.class);
        analyse.setEchantillon(echantillon);
        Analyse savedAnalyse = iAnalyseRepository.save(analyse);
        return modelMapper.map(savedAnalyse, AnalyseDto.class);
    }


}
