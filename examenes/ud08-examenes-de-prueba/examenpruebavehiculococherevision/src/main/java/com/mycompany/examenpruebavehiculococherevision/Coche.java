/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebavehiculococherevision;

/**
 *
 * @author juand
 */
public class Coche extends Vehiculo {

    private String color;
    private int km;
    private boolean tieneRevision;
    private Revision revision;  // null si no tiene revision registrada

    public Coche(String matricula, String marca, String modelo,
            String color, int km, boolean tieneRevision) {
        super(matricula, marca, modelo);
        this.color = color;
        this.km = km;
        this.tieneRevision = tieneRevision;
        // revision queda null hasta que se asigne con setRevision()
    }

    public Coche() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isTieneRevision() {
        return tieneRevision;
    }

    public void setTieneRevision(boolean tieneRevision) {
        this.tieneRevision = tieneRevision;
    }

    public Revision getRevision() {
        return revision;
    }

    // setRevision() — se llama desde cargaDatos() cuando encontramos
    // una revision asociada a este coche
    public void setRevision(Revision r) {
        this.revision = r;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nColor: " + color + ", Km: " + km
                + "\nTieneRevision: " + (tieneRevision ? "Si" : "No")
                + (revision == null ? " - Sin revision." : "\n" + revision);
    }
}
