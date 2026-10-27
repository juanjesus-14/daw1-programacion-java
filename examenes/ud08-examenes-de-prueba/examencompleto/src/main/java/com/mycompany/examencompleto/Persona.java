/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examencompleto;

/**
 *
 * @author juand
 */
public class Persona {

    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String nacionalidad;

    public Persona(String dni, String nombre, String apellidos, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }

    public Persona() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacinalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @Override
    public String toString() {
        return "DNI: " + dni
                + "\nNombre: " + nombre + " " + apellidos
                + "\nNacionalidad: " + nacionalidad;
    }
}
