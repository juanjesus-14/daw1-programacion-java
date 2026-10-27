package com.mycompany.ex1bbdd;

/**
 * Clase Persona — clase PADRE (superclase) de Empleado.
 * Contiene los atributos y métodos comunes a cualquier persona.
 * 
 * Al ser la clase padre, sus atributos son 'protected' para que
 * la clase hija (Empleado) los pueda usar directamente sin getters.
 */
public class Persona {

    // ─── ATRIBUTOS ───────────────────────────────
    // 'protected' → accesibles desde esta clase Y desde las clases hijas (Empleado)
    // Si fueran 'private', Empleado no podría usarlos directamente
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String email;

    // ─── CONSTRUCTORES ───────────────────────────

    // Constructor vacío
    public Persona() {
    }

    // Constructor completo — recibe los 4 datos básicos de una persona
    public Persona(String dni, String nombre, String apellidos, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

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

    // ─── MÉTODOS ─────────────────────────────────

    // Devuelve nombre y apellidos concatenados con un espacio
    // Ejemplo: "Juan Pérez García"
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    // toString() de Persona — muestra los 4 campos básicos
    // Empleado llamará a super.toString() para reutilizar esto
    @Override
    public String toString() {
        return "DNI: " + dni
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nEmail: " + email;
    }
}
