package com.example.labxspringboot.service.impl;

import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.EchantillonMaterial;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.repository.IEchantillonMaterialRepository;
import com.example.labxspringboot.service.IEchantillonMaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IEchantillonMaterialServiceImpl implements IEchantillonMaterialService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IEchantillonMaterialRepository iEchantillonMaterialRepository;

    @Transactional
    @Override
    public void addEchantillon(Echantillon echantillon) {
        List<EchantillonMaterial> echantillonMaterials = echantillon.getEchantillonMaterials();
        MaterielEchan materielEchan = echantillon.getMaterielEchan();

        for (EchantillonMaterial echantillonMaterial : echantillonMaterials) {
            // Check if EchantillonMaterial already exists
            Optional<EchantillonMaterial> existingEchantillonMaterial = materielEchan.getEchantillonMaterials().stream()
                    .filter(em -> em.getEchantillon().equals(echantillon) && em.getMaterielEchan().equals(echantillonMaterial.getMaterielEchan()))
                    .findFirst();

            if (existingEchantillonMaterial.isPresent()) {
                // Increment quantity if EchantillonMaterial exists
                EchantillonMaterial existingMaterial = existingEchantillonMaterial.get();
                existingMaterial.setQuantity(existingMaterial.getQuantity() + 1);
                iEchantillonMaterialRepository.save(existingMaterial);
            } else {
                // Add new EchantillonMaterial if it doesn't exist
                EchantillonMaterial echantillonMaterial1 = new EchantillonMaterial();
                echantillonMaterial1.setMaterielEchan(echantillon.getMaterielEchan());
                echantillonMaterial1.setQuantity(1);
                echantillonMaterial1.setEchantillon(echantillon);
                iEchantillonMaterialRepository.save(echantillonMaterial1);
            }
        }

        // Decrement quantity of MaterielEchan in the database
        int decrementValue = echantillon.getEchantillonMaterials().size();
        int currentStock = materielEchan.getQuantiteStockEhcna();

        if (currentStock >= decrementValue) {
            materielEchan.setQuantiteStockEhcna(currentStock - decrementValue);
        } else {
            // Handle the case where the requested quantity is greater than the current stock
            // You might want to throw an exception or log a message
            System.out.println("Requested quantity exceeds current stock.");
        }
    }
}

