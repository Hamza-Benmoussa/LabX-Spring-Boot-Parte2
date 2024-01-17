package com.example.labxspringboot.ControllersTesting;

import com.example.labxspringboot.controller.UtilisateurController;
import com.example.labxspringboot.dto.UtilisateurDto;
import com.example.labxspringboot.entity.Utilisateur;
import com.example.labxspringboot.entity.enume.RoleUser;
import com.example.labxspringboot.service.impl.UtilisateurServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UtilisateurController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class UtilisateurControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UtilisateurServiceImpl utilisateurService;

    @Autowired
    private ObjectMapper objectMapper;
    private UtilisateurDto utilisateurDto;
    private Utilisateur utilisateur;

    @BeforeEach
    public void init() {
        utilisateurDto = new UtilisateurDto(); // Initialize utilisateurDto
        utilisateurDto.setNomUtilisateur("Raichu");
        utilisateurDto.setMotDePasse("123");
        utilisateurDto.setRole(RoleUser.TECHNICIEN);
    }
    @Test
    public void createUtilisateurTest() throws Exception {
        given(utilisateurService.saveUtilisateur(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        // Performing HTTP POST request
        ResultActions response = mockMvc.perform(post("/api/utilisateurs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(utilisateurDto))); // Setting JSON content

        // Verifying HTTP status and JSON content
        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.nomUtilisateur", CoreMatchers.is(utilisateurDto.getNomUtilisateur())))
                .andExpect(jsonPath("$.motDePasse", CoreMatchers.is(utilisateurDto.getMotDePasse())))
                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateurDto.getRole().toString())));
    }
    @Test
    public void getUtilisateurTest() throws Exception {
        Long utilisateurId = 1L;
        when(utilisateurService.getUtilisateurById(utilisateurId)).thenReturn(utilisateurDto);

        ResultActions response = mockMvc.perform(get("/api/utilisateurs/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(utilisateurDto)));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nomUtilisateur", CoreMatchers.is(utilisateurDto.getNomUtilisateur())))
               // .andExpect(MockMvcResultMatchers.jsonPath("$.motDePasse", CoreMatchers.is(utilisateurDto.getMotDePasse())))
                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateurDto.getRole().toString())));
    }
    @Test
    public void GetAllUsers() throws Exception{
        UtilisateurDto user1 = new UtilisateurDto();
        user1.setId(1L);
        user1.setNomUtilisateur("Dazai");
        user1.setMotDePasse("123456");
        user1.setRole(RoleUser.TECHNICIEN);
        UtilisateurDto user2 = new UtilisateurDto();
        user2.setId(2L);
        user2.setNomUtilisateur("Ossamu");
        user2.setMotDePasse("123456");
        user2.setRole(RoleUser.RESPONSABLE_LABORATOIRE);
        List<UtilisateurDto> userDTOList = Arrays.asList(user1, user2);
        when(utilisateurService.getUtilisateurs()).thenReturn(userDTOList);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/utilisateurs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nomUtilisateur").value("Dazai"))
                .andExpect(jsonPath("$[0].role").value("TECHNICIEN"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nomUtilisateur").value("Ossamu"))
                .andExpect(jsonPath("$[1].role").value("RESPONSABLE_LABORATOIRE"))

                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertNotNull(response);
    }



    @Test
    public void UpdateUtilisateurDtoTest() throws Exception {
        Long utilisateurId = 1L;
        when(utilisateurService.updateUtilisateur(utilisateurDto, utilisateurId)).thenReturn(utilisateurDto);

        ResultActions response = mockMvc.perform(put("/api/utilisateurs/1/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(utilisateurDto)));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.nomUtilisateur", CoreMatchers.is(utilisateurDto.getNomUtilisateur())))
                .andExpect(jsonPath("$.role", CoreMatchers.is(utilisateurDto.getRole().toString())));
    }
    @Test
    public void DeleteUtilisateurTest() throws Exception {
        Long utilisateurId = 1L;
        doNothing().when(utilisateurService).deleteUtilisateur(1L);

        ResultActions response = mockMvc.perform(delete("/api/utilisateurs/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }



}