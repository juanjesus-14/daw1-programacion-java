/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenbiblioteca;

/**
 *
 * @author juand
 */
public class Libro extends Articulo {

    private String genero;
    private String numPaginas;
    private String idioma;
    private Boolean estaPrestado;
    private Prestamo prestamo;

    public Libro(String codArticulo, String titulo, String autor, String genero, String numPaginas, String idioma, boolean estaPrestado) {
        super(codArticulo, titulo, autor);
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.estaPrestado = estaPrestado;
    }

    public Libro() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Boolean getEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(Boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean asignaPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.estaPrestado = true;
        return true;
    }

    @Override
    public String toString() {
        return "Libro{" + "genero=" + genero + ", numPaginas=" + numPaginas + ", idioma=" + idioma + ", estaPrestado=" + estaPrestado + ", prestamo=" + prestamo + '}';
    }

}
