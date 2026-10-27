/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebacasa1;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Instituto {

    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Instituto(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    public boolean insertaAlumno(Alumno a) {
        // Añade el alumno al ArrayList
        // Devuelve true si se ha insertado correctamente
        return alumnos.add(a);
    }

    public void listaAlumnos() {
        // Muestra el nombre del instituto
        System.out.println("INSTITUTO: " + nombre);
        // Recorre el ArrayList de alumnos
        for (Alumno a : alumnos) {
            // Muestra los datos de cada alumno
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return "Instituto{"
                + "nombre='" + nombre + '\''
                + ", alumnos=" + alumnos
                + '}';
    }
}
