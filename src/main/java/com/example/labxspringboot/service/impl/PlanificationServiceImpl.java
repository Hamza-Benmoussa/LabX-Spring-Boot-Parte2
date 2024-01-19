//package com.example.labxspringboot.service.impl;
//
//import com.example.labxspringboot.entity.Analyse;
//import com.example.labxspringboot.entity.Echantillon;
//import com.example.labxspringboot.entity.TestAnalyse;
//import com.example.labxspringboot.entity.Utilisateur;
//
//import com.example.labxspringboot.repository.IAnalyseRepository;
//import com.example.labxspringboot.repository.IEchantillonRepository;
//import com.example.labxspringboot.repository.ITestAnalyseRepository;
//
//import com.example.labxspringboot.service.IPlanificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PlanificationServiceImpl implements IPlanificationService {
//
//    @Autowired
//    private ITestAnalyseRepository testAnalyseRepository;
//
//    @Autowired
//    private IEchantillonRepository echantillonRepository;
//
//    @Autowired
//    private IAnalyseRepository analyseRepository;
//
//
//    @Override
//    public void ChangerDateAnalyse(Analyse analyse, String dateDebut, String dateFin) {
//        analyse.setDateDebutAnalyse(dateDebut);
//        analyse.setDateFinAnalyse(dateFin);
//        analyseRepository.save(analyse);
//    }
//
//    @Override
//    public void ChangerTechnicien(Utilisateur utilisateurTech, Echantillon echantillon) {
//        echantillon.setUtilisateurTechnicien(utilisateurTech);
//        echantillonRepository.save(echantillon);
//    }
//
//    @Override
//    public void ChangerResponsable(Utilisateur utilisateurRespo, Analyse analyse) {
//        List<TestAnalyse> testAnalyses = analyse.getTestAnalyses();
//     for (TestAnalyse testAnalyse :testAnalyses){
//         testAnalyse.setUtilisateurRespo(utilisateurRespo);
//         testAnalyseRepository.save(testAnalyse);
//     }
//        analyse.setUtilisateurRespo(utilisateurRespo);
//        analyseRepository.save(analyse);
//    }
//
//    @Override
//    public void AjouterTest(Analyse analyse, TestAnalyse testAnalyse) {
//        analyse.getTestAnalyses().add(testAnalyse);
//        analyseRepository.save(analyse);
//    }
//}
