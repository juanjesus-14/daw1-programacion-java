package com.juanjesus.examenbbdd;

/**
 *
 * @author $(user)
 */
public class Vehiculo {

    protected String marca;
    protected String modelo;
    protected String color;

    public Vehiculo(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "-- Vehiculo --"
                + "\nMarca=" + marca
                + "\nModelo=" + modelo
                + "\nColor=" + color;
    }

}
