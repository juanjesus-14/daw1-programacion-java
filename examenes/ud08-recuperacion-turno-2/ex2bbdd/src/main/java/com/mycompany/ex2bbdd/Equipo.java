/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex2bbdd;

/**
 *
 * @author juand
 */
public class Equipo {

    // Atributos comunes a cualquier equipo
    protected String numSerie;
    protected String fabricante;
    protected String modelo;

    public Equipo() {
    }

    public Equipo(String fabricante, String modelo, String numSerie) {
        this.numSerie = numSerie;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
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

    @Override
    public String toString() {
        return "numSerie='" + numSerie + "'"
                + ", fabricante='" + fabricante + "'"
                + ", modelo='" + modelo + "'";
    }
}
