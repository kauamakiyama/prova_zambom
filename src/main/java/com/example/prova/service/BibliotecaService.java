package com.example.prova.service;

import com.example.prova.dto.BibliotecaDTO;
import com.example.prova.exception.BibliotecaNotFoundException;
import com.example.prova.model.Biblioteca; // aqui precisa ter a entidade model
import com.example.prova.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository repository;

    public BibliotecaDTO create(BibliotecaDTO dto) {
        Biblioteca livro = Biblioteca.fromDTO(dto);
        Biblioteca saved = repository.save(livro);
        return BibliotecaDTO.fromModel(saved);
    }

    public List<BibliotecaDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(BibliotecaDTO::fromModel)
                .toList();
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new BibliotecaNotFoundException("livro n encontrado");
        }
        repository.deleteById(id);
    }
}
