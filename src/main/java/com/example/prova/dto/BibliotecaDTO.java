package com.example.prova.dto;

import com.example.prova.model.Biblioteca;
import java.time.LocalDate;

public class BibliotecaDTO {

    private Integer id;
    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPublicacao;
    private LocalDate dataCadastro;

    public BibliotecaDTO() {}

    public static BibliotecaDTO fromModel(Biblioteca livro) {
        BibliotecaDTO dto = new BibliotecaDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setGenero(livro.getGenero());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        dto.setDataCadastro(livro.getDataCadastro());
        return dto;
    }

    // Getters
    public Integer getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public LocalDate getDataCadastro() { return dataCadastro; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
}
