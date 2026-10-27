/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex3bbdd;

/**
 *
 * @author juand
 */
public class Producto {

    // Atributos comunes a cualquier producto — protected para que la clase hija los herede
    protected String fabricante;
    protected String modelo;
    protected String codProducto;

    public Producto() {
    }

    public Producto(String fabricante, String modelo, String codProducto) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.codProducto = codProducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fab) {
        this.fabricante = fab;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }

    @Override
    public String toString() {
        return "fabricante=" + fabricante
                + ", modelo=" + modelo
                + ", codProducto=" + codProducto;
    }
}
