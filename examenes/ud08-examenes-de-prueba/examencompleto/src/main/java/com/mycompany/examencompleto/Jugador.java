/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examencompleto;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Jugador extends Persona {

    private int dorsal;
    private String posicion;
    private boolean disponible;
    private Contrato contrato;

    public Jugador(String dni, String nombre, String apellidos, String nacionalidad, int dorsal, String posicion, boolean disponible) {
        super(dni, nombre, apellidos, nacionalidad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.disponible = disponible;
        this.contrato = new Contrato();
    }

    public Jugador() {
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public boolean asignaContrato(String dniContrato, LocalDate fechaInicio, double salarioAnual) {
        boolean asignado = false;

        this.contrato.setDniContrato(dniContrato);
        this.contrato.setFechaInicio(fechaInicio);
        this.contrato.setSalarioAnual(salarioAnual);

        asignado = true;

        return asignado;
    }

    public boolean asignaContrato(Contrato c) {
        this.contrato = c;
        return true;
    }

    @Override
    public String toString() {
        return "----------------------------------"
                + "\n" + super.toString()
                + "\nDorsal: " + dorsal + ", Posicion: " + posicion
                + "\nDisponible: " + (disponible ? "Si" : "No")
                + (contrato.getDniContrato() == null
                ? "\nSin contrato."
                : "\n" + contrato);
    }

}
