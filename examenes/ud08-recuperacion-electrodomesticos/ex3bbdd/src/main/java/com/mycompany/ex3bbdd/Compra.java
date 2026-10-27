/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex3bbdd;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Compra {

    private String codProducto;
    private LocalDate fechaCompra;  // en lugar de String
    private Double importe;

    public Compra() {
    }

    public Compra(String codProducto, LocalDate fechaCompra, Double importe) {
        this.codProducto = codProducto;
        this.fechaCompra = fechaCompra;
        this.importe = importe;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fecha) {
        this.fechaCompra = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        // Muestra los datos de la compra
        return "fechaCompra=" + fechaCompra + ", importe=" + importe;
    }
}
