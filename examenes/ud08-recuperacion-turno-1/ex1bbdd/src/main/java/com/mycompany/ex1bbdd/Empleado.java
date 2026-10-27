/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1bbdd;

/**
 *
 * @author juand
 */
public class Empleado extends Persona {

    private int numeroEmpleado;
    private Pareja pareja;

    public Empleado(int numeroEmpleado, String dni, String nombre, String apellidos, String email) {
        super(dni, nombre, apellidos, email);
        this.numeroEmpleado = numeroEmpleado;
        this.pareja = new Pareja();  // ← vacía, nunca null
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    //Métodos
// Método que asigna nombre y apellidos a la pareja del empleado
    public boolean asignaPareja(String nombre, String apellidos) {
        // Variable que indica si la asignación se realizó correctamente
        boolean asignado = false;
        // Asignar nombre a la pareja
        this.pareja.setNombre(nombre);
        // Asignar apellidos a la pareja
        this.pareja.setApellidos(apellidos);
        // Marcar como asignado correctamente
        asignado = true;
        // Devolver resultado
        return asignado;
    }

// Método que asigna el DNI a la pareja
    public void setDniPareja(String dni) {
        // Comprobar que el DNI no esté vacío
        if (!dni.isEmpty()) {
            // Asignar DNI a la pareja
            this.pareja.setDni(dni);
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNumero de Empleado: " + numeroEmpleado
                + (pareja.getNombre() == null ? "" : "Pareja: " + this.pareja);
    }

}
