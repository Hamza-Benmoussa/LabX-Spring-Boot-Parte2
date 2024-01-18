package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.AnalyseDto;
import com.example.labxspringboot.entity.Analyse;
import com.example.labxspringboot.entity.Norme;
import com.example.labxspringboot.entity.TestAnalyse;
import com.example.labxspringboot.entity.TypeAnalyse;
import com.example.labxspringboot.repository.ITestAnalyseRepository;
import com.example.labxspringboot.service.ITypeAnalyseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeAnalyseServiceImpl implements ITypeAnalyseService {
    @Autowired
    private ITestAnalyseRepository testAnalyseRepository;
    @Autowired
    private TestAnalyseServiceImpl testAnalyseService;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveAnalyse(AnalyseDto analyseDto) {
     TypeAnalyse typeAnalyseDto = analyseDto.getTypeAnalyse();
        List<Norme> normeList = typeAnalyseDto.getNormes();
        for (Norme norme : normeList){
            TestAnalyse testAnalyse = new TestAnalyse();
            testAnalyse.setUtilisateurRespo(analyseDto.getUtilisateurRespo());
            testAnalyse.setNorme(norme);
            testAnalyse.setAnalyse(modelMapper.map(analyseDto , Analyse.class));
            testAnalyse.setDescription(testAnalyse.toString());
//            testAnalyse.setStatusResultat(testAnalyseService.generateStatusTest(testAnalyse));
            testAnalyseRepository.save(testAnalyse);
        }
    }
}
