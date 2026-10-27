/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarearefuerzoymejora;

/**
 *
 * @author juand
 */
public class Mascota {

    private String dniPersona;
    private String nombre;
    private int edad;
    private String raza;

    public Mascota(String dniPersona, String nombre, int edad, String raza) {
        this.dniPersona = dniPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public Mascota() {
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

//    @Override
//    public String toString() {
//        return "Mascota{" + "dniPersona=" + dniPersona + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + '}';
//    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + " años, Raza: " + raza;
    }
}
