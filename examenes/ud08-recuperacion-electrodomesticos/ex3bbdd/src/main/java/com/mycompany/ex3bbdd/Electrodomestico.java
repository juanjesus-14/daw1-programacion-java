/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex3bbdd;

/**
 *
 * @author juand
 */
public class Electrodomestico extends Producto {

    private String tipo;
    private String caracteristicas;
    private String consumo;
    private boolean tieneGarantia;
    private Compra datosCompra;    // null si no tiene compra registrada

    public Electrodomestico() {
    }

    // Constructor sin compra
    public Electrodomestico(String fabricante, String modelo, String codProducto,
            String tipo, String caracteristicas,
            String consumo, boolean tieneGarantia) {
        super(fabricante, modelo, codProducto);
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.consumo = consumo;
        this.tieneGarantia = tieneGarantia;
        // datosCompra queda null hasta que se le asigne
    }

    // Constructor con compra incluida
    public Electrodomestico(String fabricante, String modelo, String codProducto,
            String tipo, String caracteristicas,
            String consumo, boolean tieneGarantia, Compra datosCompra) {
        super(fabricante, modelo, codProducto);
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.consumo = consumo;
        this.tieneGarantia = tieneGarantia;
        this.datosCompra = datosCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String c) {
        this.caracteristicas = c;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public boolean isTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(boolean tg) {
        this.tieneGarantia = tg;
    }

    public Compra getDatosCompra() {
        return datosCompra;
    }

    public void setDatosCompra(Compra datosCompra) {
        this.datosCompra = datosCompra;
    }

    @Override
    public String toString() {
        return "\nElectrodomestico: "
                // Los tres campos heredados de Producto
                + "\n     Fabricante: " + fabricante
                + ", modelo: " + modelo
                + ", codProducto: " + codProducto
                + ", tipo: " + tipo
                + ", caracteristicas: " + caracteristicas
                + ", consumo: " + consumo
                // TERNARIA booleano — true muestra "Si", false muestra "No"
                + ", tieneGarantia: " + (tieneGarantia ? "Si" : "No")
                // TERNARIA objeto — si datosCompra es null avisa, si no lo muestra
                + (datosCompra == null
                        ? " No hay fecha de compra."
                        : "\n     Compra: " + datosCompra);
    }
}
