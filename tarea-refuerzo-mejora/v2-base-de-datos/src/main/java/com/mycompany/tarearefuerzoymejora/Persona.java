/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarearefuerzoymejora;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Persona {

    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private ArrayList<Mascota> mascotas;

    public Persona(String dni, String nombre, String apellidos, String email, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();  // lista vacía, nunca null
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void asignaMascota(Mascota m) {
        this.mascotas.add(m);
    }

//    @Override
//    public String toString() {
//        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + '}';
//    }

    @Override
    public String toString() {
        String resultado = "\n----------------------------------"
                + "\nDNI: " + dni
                + "\nNombre: " + nombre + " " + apellidos
                + "\nEmail: " + email
                + "\nTeléfono: " + telefono
                + "\nDirección: " + direccion;
        if (mascotas.isEmpty()) {
            resultado += "\nMascotas: Sin mascotas.";
        } else {
            resultado += "\nMascotas:";
            for (int i = 0; i < mascotas.size(); i++) {
                resultado += "\n     " + (i + 1) + ". " + mascotas.get(i);
            }
        }
        resultado += "\n----------------------------------";
        return resultado;
    }
}
