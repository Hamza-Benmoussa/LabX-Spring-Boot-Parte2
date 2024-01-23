package com.example.labxspringboot.ControllersTesting;

import com.example.labxspringboot.controller.ReactifController;
import com.example.labxspringboot.dto.ReactifDto;
import com.example.labxspringboot.entity.Reactif;
import com.example.labxspringboot.service.impl.ReactifServiceImpl;
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
        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ReactifController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ReactifControllerTest  {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReactifServiceImpl reactifService;

    @Autowired
    private ObjectMapper objectMapper;
    private ReactifDto reactifDto;
    private Reactif reactif;

    @BeforeEach
    public void init() {
        reactifDto = new ReactifDto(); // Initialize utilisateurDto
        reactifDto.setNom("Raichu");
        reactifDto.setFournisseurNom("Him");
        reactifDto.setQuantiteStock(12);
        reactifDto.setDescription("for all");
        reactifDto.setDateExpiration("12/01/2012");
    }
//    @Test
//    public void createReatifTest() throws Exception {
//        given(reactifService.saveReactif(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
//
//        // Performing HTTP POST request
//        ResultActions response = mockMvc.perform(post("/api/reactifs")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(reactifDto))); // Setting JSON content
//
//        // Verifying HTTP status and JSON content
//        response.andExpect(status().isCreated())
//                .andExpect(jsonPath("$.nom", CoreMatchers.is(reactifDto.getNom())))
//                .andExpect(jsonPath("$.description", CoreMatchers.is(reactifDto.getDescription())))
//                .andExpect(jsonPath("$.quantiteStock", CoreMatchers.is(reactifDto.getQuantiteStock())));
//    }
    @Test
    public void getReactifTest() throws Exception {

        when(reactifService.getReactifById(1L)).thenReturn(reactifDto);

        ResultActions response = mockMvc.perform(get("/api/reactifs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reactifDto)));

        response.andExpect(status().isOk())
                .andDo(print());


    }
    @Test
    public void GetAllUsers() throws Exception{

        List<ReactifDto> reactifList = Arrays.asList(reactifDto);
        when(reactifService.getReactifs()).thenReturn(reactifList);

        mockMvc.perform(get("/api/reactifs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }



    @Test
    public void UpdateUtilisateurDtoTest() throws Exception {
        when(reactifService.updateReactif(reactifDto, 1L)).thenReturn(reactifDto);

        ResultActions response = mockMvc.perform(put("/api/reactifs/1/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reactifDto)));

        response.andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void DeleteUtilisateurTest() throws Exception {
        doNothing().when(reactifService).deleteReactif(1L);

        ResultActions response = mockMvc.perform(delete("/api/reactifs/1")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk());
    }



}