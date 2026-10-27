/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindelmio;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Empleado extends Persona {

    private int numeroEmpleado;
    private LocalDate fechaContratacion;
    private Departamento depto;

    public Empleado(int numeroEmpleado, LocalDate fechaContratacion, String dni, String nombre, String apellidos, String email) {
        super(dni, nombre, apellidos, email);
        this.numeroEmpleado = numeroEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.depto = depto;
    }
    
    public Empleado(String dni, String nombre, String apellidos, String email) {
        super(dni, nombre, apellidos, email);
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public boolean asignaDepto(Departamento depto) {
        this.depto = depto;
        return true;
    }

    @Override
    public String toString() {
        return numeroEmpleado + " - "
                + nombre + " "
                + apellidos + " - "
                + fechaContratacion;
    }

}
