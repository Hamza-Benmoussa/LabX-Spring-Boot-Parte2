package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.entity.Reactif;
import com.example.labxspringboot.repository.IReactifRepository;
import com.example.labxspringboot.service.IReactifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactifServiceImpl implements IReactifService {

    @Autowired
    private IReactifRepository reactifRepository;

    @Override
    public Reactif saveReactif(Reactif reactif) {
        return reactifRepository.save(reactif);
    }

    @Override
    public List<Reactif> getReactifs() {
        return reactifRepository.findAll();
    }

    @Override
    public Reactif getReactifById(Long id) {
        return reactifRepository.findById(id).orElse(null);
    }

    @Override
    public Reactif updateReactif(Reactif reactif ,Long id) {
        return reactifRepository.save(reactif);
    }

    @Override
    public void deleteReactif(Long id) {
        reactifRepository.deleteById(id);
    }
}
