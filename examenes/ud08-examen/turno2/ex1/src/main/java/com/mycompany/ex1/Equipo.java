/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1;

/**
 *
 * @author daw
 */
public class Equipo {
    protected String fabricante;
    protected String modelo;
    protected String numSerie;

    public Equipo() {
    }

    public Equipo(String numSerie, String fabricante, String modelo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public String toString() {
        return "Fabricante=" + "'" + fabricante + "'" + 
                ", modelo=" + "'" + modelo + "'" + 
                ", numSerie=" + "'" + numSerie + "'";
    }
    
    
}
