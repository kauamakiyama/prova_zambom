package com.example.prova.controller;

import com.example.prova.dto.BibliotecaDTO;
import com.example.prova.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;


    @PostMapping
    public BibliotecaDTO create(@RequestBody BibliotecaDTO dto) {
        return service.create(dto);
    }


    @GetMapping
    public List<BibliotecaDTO> listAll() {
        return service.listAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
