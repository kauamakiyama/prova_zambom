package com.example.prova.service;

import com.example.prova.dto.BibliotecaDTO;
import com.example.prova.exception.BibliotecaNotFoundException;
import com.example.prova.model.Biblioteca;
import com.example.prova.repository.BibliotecaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BibliotecaServiceTest {

    @Mock
    private BibliotecaRepository repository;

    @InjectMocks
    private BibliotecaService service;

    private Biblioteca livro;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        livro = new Biblioteca();
        livro.setId(1);
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setGenero("Romance");
        livro.setAnoPublicacao(1899);
        livro.setDataCadastro(LocalDate.now());
    }

    @Test
    void deveCriarLivro() {
        when(repository.save(any(Biblioteca.class))).thenReturn(livro);

        BibliotecaDTO dto = new BibliotecaDTO();
        dto.setTitulo("Dom Casmurro");
        dto.setAutor("Machado de Assis");
        dto.setGenero("Romance");
        dto.setAnoPublicacao(1899);

        BibliotecaDTO result = service.create(dto);

        assertNotNull(result.getId());
        assertEquals("Dom Casmurro", result.getTitulo());
        verify(repository, times(1)).save(any(Biblioteca.class));
    }

    @Test
    void deveListarLivros() {
        when(repository.findAll()).thenReturn(List.of(livro));

        List<BibliotecaDTO> result = service.listAll();

        assertEquals(1, result.size());
        assertEquals("Dom Casmurro", result.get(0).getTitulo());
    }

    @Test
    void deveDeletarLivroExistente() {
        when(repository.existsById(1)).thenReturn(true);

        service.delete(1);

        verify(repository, times(1)).deleteById(1);
    }

    @Test
    void deveLancarExcecaoQuandoDeletarLivroInexistente() {
        when(repository.existsById(2)).thenReturn(false);

        assertThrows(BibliotecaNotFoundException.class, () -> service.delete(2));
    }
}
