/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1;

/**
 *
 * @author daw
 */
public class Garantia {
    private String numSerie;
    private String fechaFin;
    private Double importeAnual;

    public Garantia() {
    }

    public Garantia(String numSerie, String fechaFin, Double importeAnual) {
        this.numSerie = numSerie;
        this.fechaFin = fechaFin;
        this.importeAnual = importeAnual;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getImporteAnual() {
        return importeAnual;
    }

    public void setImporteAnual(Double importeAnual) {
        this.importeAnual = importeAnual;
    }

    @Override
    public String toString() {
        return "Garantia{" + 
                "fechaFin=" + fechaFin + 
                ", importeAnual=" + importeAnual + '}';
    }


    
    
}
