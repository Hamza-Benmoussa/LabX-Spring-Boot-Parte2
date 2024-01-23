package com.example.labxspringboot.ControllersTesting;

import com.example.labxspringboot.controller.EchantillonController;
import com.example.labxspringboot.controller.UtilisateurController;
import com.example.labxspringboot.dto.EchantillonDto;
import com.example.labxspringboot.dto.PatientDto;
import com.example.labxspringboot.dto.UtilisateurDto;
import com.example.labxspringboot.entity.Echantillon;
import com.example.labxspringboot.entity.MaterielEchan;
import com.example.labxspringboot.entity.Patient;
import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.entity.enume.RoleUser;
import com.example.labxspringboot.repository.IAnalyseRepository;
import com.example.labxspringboot.repository.IEchantillonRepository;
import com.example.labxspringboot.service.impl.EchantillonServiceImpl;
import com.example.labxspringboot.service.impl.PatientServiceImpl;
import com.example.labxspringboot.service.impl.UtilisateurServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EchantillonController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)

public class EchantillonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EchantillonServiceImpl echantillonService;
    @MockBean
    private PatientServiceImpl patientService;

    @Autowired
    private ObjectMapper objectMapper;

    private EchantillonDto echantillonDto ;
    private PatientDto patientDto;
    private UtilisateurDto utilisateurDto;
    ModelMapper modelMapper=new ModelMapper();


    @BeforeEach
    public void init()  {
        patientDto = new PatientDto("Pikachu", "Pokemon", "Male", "Yellow 123", "0123456789", "25/02/1995");
        utilisateurDto = new UtilisateurDto("Raichu", "123", RoleUser.TECHNICIEN);
        echantillonDto = new EchantillonDto();
        echantillonDto.setId(1L);
        echantillonDto.setPatient(modelMapper.map(patientDto, Patient.class));
        echantillonDto.setUtilisateurTechnicien(modelMapper.map(utilisateurDto, Utilisateur.class));
        echantillonDto.setMaterielEchan(new MaterielEchan("123", 12, "12/12/2021", "hello"));
        echantillonDto.setDatePrelevement("01/01/2023");

    }

    @Test
    public void createEchantillionTest() throws Exception {
         given(echantillonService.saveEchantillon(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        // Performing HTTP POST request
        ResultActions response = mockMvc.perform(post("/api/echantillons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(echantillonDto)));

        // Verifying HTTP status and JSON content
        response.andExpect(status().isCreated()).andReturn();

    }
   @Test
    public void getEchantillonTest() throws Exception {

        when(echantillonService.getEchantillonById(Mockito.anyLong())).thenReturn(echantillonDto);

        ResultActions response = mockMvc.perform(get("/api/echantillons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(echantillonDto)));

        response.andExpect(status().isOk())
                .andDo(print());

    }
    @Test
    void getAllEchantillons() throws Exception {
        List<EchantillonDto> echantillonsdto= Arrays.asList(echantillonDto);
        when(echantillonService.getEchantillons()).thenReturn(echantillonsdto);
        mockMvc.perform(get("/api/echantillons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void UpdateEchantillonTest() throws Exception {
        when(echantillonService.updateEchantillon(echantillonDto, 1L)).thenReturn(echantillonDto);

        ResultActions response = mockMvc.perform(put("/api/echantillons/1/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(echantillonDto)));

        response.andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void DeleteEchantillonTest() throws Exception {
        doNothing().when(echantillonService).deleteEchantillon(1L);

        ResultActions response = mockMvc.perform(delete("/api/echantillons/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }
}