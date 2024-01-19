package com.example.labxspringboot.ServiceTest;

import com.example.labxspringboot.controller.UtilisateurController;
import com.example.labxspringboot.dto.MaterielEchanDto;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.repository.IMaterialRepository;
import com.example.labxspringboot.service.impl.MaterialEchanServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
class MaterialEchanServiceImplTest {

    @Mock
    private IMaterialRepository materialRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MaterialEchanServiceImpl materialEchanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMaterialEchan() {
        // Arrange
        MaterielEchanDto inputDto = new MaterielEchanDto();
        MaterielEchan entityToSave = new MaterielEchan();
        MaterielEchan savedEntity = new MaterielEchan();

        when(modelMapper.map(inputDto, MaterielEchan.class)).thenReturn(entityToSave);
        when(materialRepository.save(entityToSave)).thenReturn(savedEntity);
        when(modelMapper.map(savedEntity, MaterielEchanDto.class)).thenReturn(new MaterielEchanDto());

        // Act
        MaterielEchanDto result = materialEchanService.saveMaterialEchan(inputDto);

        // Assert
        assertNotNull(result);
        verify(modelMapper, times(1)).map(inputDto, MaterielEchan.class);
        verify(materialRepository, times(1)).save(entityToSave);
        verify(modelMapper, times(1)).map(savedEntity, MaterielEchanDto.class);
    }

    @Test
    void getMaterialEchans() {
        // Arrange
        List<MaterielEchan> entities = Arrays.asList(new MaterielEchan(), new MaterielEchan());

        when(materialRepository.findByDeletedFalse()).thenReturn(entities);
        when(modelMapper.map(any(), eq(MaterielEchanDto.class))).thenReturn(new MaterielEchanDto());

        // Act
        List<MaterielEchanDto> result = materialEchanService.getMaterialEchans();

        // Assert
        assertEquals(2, result.size());
        verify(materialRepository, times(1)).findByDeletedFalse();
        verify(modelMapper, times(2)).map(any(), eq(MaterielEchanDto.class));
    }

    @Test
    void getMaterialEchanById() {
        // Arrange
        Long materialEchanId = 1L;
        MaterielEchan entity = new MaterielEchan();

        when(materialRepository.findByIdAndDeletedFalse(materialEchanId)).thenReturn(Optional.of(entity));
        when(modelMapper.map(entity, MaterielEchanDto.class)).thenReturn(new MaterielEchanDto());

        // Act
        MaterielEchanDto result = materialEchanService.getMaterialEchanById(materialEchanId);

        // Assert
        assertNotNull(result);
        verify(materialRepository, times(1)).findByIdAndDeletedFalse(materialEchanId);
        verify(modelMapper, times(1)).map(entity, MaterielEchanDto.class);
    }

    @Test
    void updateMaterialEchan() {
        // Arrange
        Long materialEchanId = 1L;
        MaterielEchanDto inputDto = new MaterielEchanDto();
        MaterielEchan existingEntity = new MaterielEchan();
        MaterielEchan updatedEntity = new MaterielEchan();

        when(materialRepository.findByIdAndDeletedFalse(materialEchanId)).thenReturn(Optional.of(existingEntity));
        when(materialRepository.save(existingEntity)).thenReturn(updatedEntity);

        // Act
        MaterielEchanDto result = materialEchanService.updateMaterialEchan(inputDto, materialEchanId);

        // Assert
        assertNotNull(result);
        verify(materialRepository, times(1)).findByIdAndDeletedFalse(materialEchanId);
        verify(materialRepository, times(1)).save(existingEntity);
        // Additional verifications based on your specific logic
    }

    @Test
    void deleteMaterialEchan() {
        // Arrange
        Long materialEchanId = 1L;
        MaterielEchan existingEntity = new MaterielEchan();

        when(materialRepository.findByIdAndDeletedFalse(materialEchanId)).thenReturn(Optional.of(existingEntity));

        // Act
        materialEchanService.deleteMaterialEchan(materialEchanId);

        // Assert
        verify(materialRepository, times(1)).findByIdAndDeletedFalse(materialEchanId);
        verify(materialRepository, times(1)).save(existingEntity);
        // Additional verifications based on your specific logic
    }
}
