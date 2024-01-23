package com.example.labxspringboot.ControllersTesting;
import com.example.labxspringboot.controller.NormeController;
import com.example.labxspringboot.controller.UtilisateurController;
import com.example.labxspringboot.dto.NormeDto;
import com.example.labxspringboot.dto.ReactifDto;
import com.example.labxspringboot.dto.TypeAnalyseDto;
import com.example.labxspringboot.dto.UtilisateurDto;
import com.example.labxspringboot.entity.*;
import com.example.labxspringboot.entity.enume.RoleUser;
import com.example.labxspringboot.service.impl.NormeServiceImpl;
import com.example.labxspringboot.service.impl.UtilisateurServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = NormeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class NormeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NormeServiceImpl normeService;

    @Autowired
    private ObjectMapper objectMapper;
    private NormeDto normeDto;
    private Norme norme;
private ReactifDto reactifDto;
private TypeAnalyseDto typeAnalyseDto;
    ModelMapper modelMapper=new ModelMapper();

    @BeforeEach
    public void init() {

//////////////////////
        reactifDto=new ReactifDto();
        reactifDto.setNom("hello");
        reactifDto.setQuantiteStock(13);
        reactifDto.setFournisseurNom("bio");
        reactifDto.setDateExpiration("12/01/2014");
////////////////////////
        typeAnalyseDto =new TypeAnalyseDto();
        typeAnalyseDto.setId(1L);
       // typeAnalyseDto.setTypeAnalyseName(TypeAnalyseName.HEMATOLOGIE);
    ///////////////
        normeDto = new NormeDto(); // Initialize utilisateurDto
        normeDto.setId(1L);
        normeDto.setMin(12);
        normeDto.setMax(20);
        normeDto.setDescription("for use");
        normeDto.setReactif(modelMapper.map(reactifDto, Reactif.class));
    }
    @Test
    void getNorme() throws Exception {

        // Mock the service to return the Analyse object
        when(normeService.getNormeById(1L)).thenReturn(normeDto);

        // Perform the HTTP GET request
        MvcResult mvcResult = mockMvc.perform(get("/api/normes/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        // Assert that the response is not null
        assertNotNull(mvcResult.getResponse().getContentAsString());
    }

}
