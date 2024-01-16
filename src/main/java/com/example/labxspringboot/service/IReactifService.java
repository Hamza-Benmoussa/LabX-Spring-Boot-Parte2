package com.example.labxspringboot.service;

import com.example.labxspringboot.entity.Reactif;

import java.util.List;

public interface IReactifService {
    Reactif saveReactif(Reactif reactif);
    List<Reactif> getReactifs();
    Reactif getReactifById(Long id);
    Reactif updateReactif(Reactif reactif , Long id);
    void deleteReactif(Long id);
}
