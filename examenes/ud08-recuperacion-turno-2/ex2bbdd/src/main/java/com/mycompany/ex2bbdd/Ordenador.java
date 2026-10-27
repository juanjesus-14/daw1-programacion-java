/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex2bbdd;

/**
 *
 * @author juand
 */
public class Ordenador extends Equipo {

    private String formato;
    private String ram;
    private String procesador;
    private String hdd;
    private boolean tieneGarantia;
    private Garantia garantia;      // null si no tiene garantía registrada

    public Ordenador() {
    }

    // Constructor sin garantía
    public Ordenador(String numSerie, String fabricante, String modelo, String formato, String ram, String procesador, String hdd, boolean tieneGarantia) {
        super(fabricante, modelo, numSerie);  // mismo orden que el constructor de Equipo
        this.formato = formato;
        this.ram = ram;
        this.procesador = procesador;
        this.hdd = hdd;
        this.tieneGarantia = tieneGarantia;
        // garantia queda null hasta que se le asigne
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

    public void setTieneGarantia(boolean tg) {
        this.tieneGarantia = tg;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "\nOrdenador: "
                + "\n     " + super.toString() // numSerie, fabricante, modelo
                + ", formato=" + formato
                + ", ram=" + ram
                + ", procesador=" + procesador
                + ", hdd=" + hdd
                // ternaria booleano — true=Si, false=No
                + ", tieneGarantia: " + (tieneGarantia ? "Si" : "No")
                // ternaria objeto — si garantia es null avisa, si no la muestra
                + (garantia == null
                        ? " - Sin datos de garantía."
                        : "\n     Garantia: " + garantia);
    }
}
