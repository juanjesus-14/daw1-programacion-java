/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebavehiculococherevision;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Revision {

    private String matricula;
    private LocalDate fechaRevision;
    private double coste;

    public Revision(String matricula, LocalDate fechaRevision, double coste) {
        this.matricula = matricula;
        this.fechaRevision = fechaRevision;
        this.coste = coste;
    }

    public Revision() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "-Revision: " + "fechaRevision= " + fechaRevision + ", coste= " + coste;
    }

}
