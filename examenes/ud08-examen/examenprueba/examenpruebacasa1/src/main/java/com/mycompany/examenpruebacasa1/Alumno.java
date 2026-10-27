/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebacasa1;

/**
 *
 * @author juand
 */
public class Alumno extends Persona {

    private int expediente;

    public Alumno(int expediente, String dni, String nombre) {
        super(dni, nombre);
        this.expediente = expediente;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Expediente: " + expediente;
    }
}
