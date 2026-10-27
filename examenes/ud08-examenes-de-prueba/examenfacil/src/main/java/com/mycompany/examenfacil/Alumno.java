/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfacil;

/**
 *
 * @author juand
 */
public class Alumno {

    private int numAlumno;
    private String dni;
    private String nombre;
    private String apellidos;
    private String curso;

    public Alumno(int numAlumno, String dni, String nombre, String apellidos, String curso) {
        this.numAlumno = numAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
    }

    public Alumno() {
    }

    public int getNumAlumno() {
        return numAlumno;
    }

    public void setNumAlumno(int numAlumno) {
        this.numAlumno = numAlumno;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numAlumno=" + numAlumno + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + '}';
    }

}
