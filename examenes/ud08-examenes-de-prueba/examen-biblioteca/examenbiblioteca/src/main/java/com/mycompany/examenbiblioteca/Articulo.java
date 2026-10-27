/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenbiblioteca;

/**
 *
 * @author juand
 */
public class Articulo {

    protected String codArticulo;
    protected String titulo;
    protected String autor;

    public Articulo(String codArticulo, String titulo, String autor) {
        this.codArticulo = codArticulo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Articulo() {
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

    @Override
    public String toString() {
        return "Articulo{" + "codArticulo=" + codArticulo + ", titulo=" + titulo + ", autor=" + autor + '}';
    }
    
}
