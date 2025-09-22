package com.example.prova.controller;

import com.example.prova.dto.BibliotecaDTO;
import com.example.prova.service.BibliotecaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BibliotecaController.class)
class BibliotecaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BibliotecaService service;

    @Test
    void deveCriarLivro() throws Exception {
        BibliotecaDTO dto = new BibliotecaDTO();
        dto.setId(1);
        dto.setTitulo("Dom Casmurro");
        dto.setAutor("Machado de Assis");
        dto.setGenero("Romance");
        dto.setAnoPublicacao(1899);
        dto.setDataCadastro(LocalDate.now());

        when(service.create(any(BibliotecaDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\":\"Dom Casmurro\",\"autor\":\"Machado de Assis\",\"genero\":\"Romance\",\"anoPublicacao\":1899}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Dom Casmurro"));
    }

    @Test
    void deveListarLivros() throws Exception {
        BibliotecaDTO dto = new BibliotecaDTO();
        dto.setId(1);
        dto.setTitulo("Dom Casmurro");
        dto.setAutor("Machado de Assis");
        dto.setGenero("Romance");
        dto.setAnoPublicacao(1899);
        dto.setDataCadastro(LocalDate.now());

        when(service.listAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/livros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Dom Casmurro"));
    }

    @Test
    void deveDeletarLivro() throws Exception {
        Mockito.doNothing().when(service).delete(1);

        mockMvc.perform(delete("/livros/1"))
                .andExpect(status().isOk());
    }
}
