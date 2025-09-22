package com.example.prova.model;

import com.example.prova.dto.BibliotecaDTO;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String autor;
    private String genero;
    private Integer anoPublicacao;
    private LocalDate dataCadastro;

    public Biblioteca() {
        this.dataCadastro = LocalDate.now(); // sempre define a data no cadastro
    }

    public static Biblioteca fromDTO(BibliotecaDTO dto) {
        Biblioteca livro = new Biblioteca();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setGenero(dto.getGenero());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        return livro;
    }


    public Integer getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getAutor() { return autor; }

    public String getGenero() { return genero; }

    public Integer getAnoPublicacao() { return anoPublicacao; }

    public LocalDate getDataCadastro() { return dataCadastro; }



    public void setId(Integer id) { this.id = id; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setAutor(String autor) { this.autor = autor; }

    public void setGenero(String genero) { this.genero = genero; }

    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

}
