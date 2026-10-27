/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenbiblioteca;

/**
 *
 * @author juand
 */
public class Prestamo {

    private String codArticulo;
    private String fechaDevolucion;
    private double fianza;

    public Prestamo(String codArticulo, String fechaDevolucion, double fianza) {
        this.codArticulo = codArticulo;
        this.fechaDevolucion = fechaDevolucion;
        this.fianza = fianza;
    }

    public Prestamo() {
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getFianza() {
        return fianza;
    }

    public void setFianza(double fianza) {
        this.fianza = fianza;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codArticulo=" + codArticulo + ", fechaDevolucion=" + fechaDevolucion + ", fianza=" + fianza + '}';
    }

}
