/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1;

/**
 *
 * @author daw
 */
public class Ordenador extends Equipo {
    private String formato;
    private String ram;
    private String procesador;
    private String hdd;
    private boolean tieneGarantia;
    private Garantia garantia;

    public Ordenador() {
    }

    public Ordenador(String numSerie, String fabricante, String modelo, String formato, String ram, String procesador, String hdd) {
        super(numSerie, fabricante, modelo);
        this.formato = formato;
        this.ram = ram;
        this.procesador = procesador;
        this.hdd = hdd;
    }
    

    public Ordenador(String formato, String ram, String procesador, String hdd, boolean tieneGarantia, Garantia garantia) {
        this.formato = formato;
        this.ram = ram;
        this.procesador = procesador;
        this.hdd = hdd;
        this.tieneGarantia = tieneGarantia;
        this.garantia = garantia;
    }

    public Ordenador(String numSerie, String fabricante, String modelo, String formato, String ram, String procesador, String hdd, boolean tieneGarantia, Garantia garantia) {
        super(numSerie, modelo, fabricante);
        this.formato = formato;
        this.ram = ram;
        this.procesador = procesador;
        this.hdd = hdd;
        this.tieneGarantia = tieneGarantia;
        this.garantia = garantia;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public boolean isTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(boolean tieneGarantia) {
        this.tieneGarantia = tieneGarantia;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
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
        return "Ordenador:\n    " + 
                super.toString() +
                "formato=" + formato + 
                ", ram=" + ram + 
                ", procesador=" + procesador + 
                ", hdd=" + hdd + 
                "\n    Tiene garantia: " + (tieneGarantia ? "No" : "Si") + "--> " + 
                garantia;
    }


    
    
}
