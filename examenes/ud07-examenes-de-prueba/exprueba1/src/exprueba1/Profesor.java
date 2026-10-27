/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exprueba1;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Profesor extends Persona {

    private int numProfesor;
    private LocalDate fechaContratacion;
    private Facultad facultad;

    public Profesor(int numProfesor, String dni, String nombre, String apellidos, String email, LocalDate fechaContratacion) {
        super(dni, nombre, apellidos, email);
        this.numProfesor = numProfesor;
        this.fechaContratacion = fechaContratacion;
    }

    public int getNumProfesor() {
        return numProfesor;
    }

    public void setNumProfesor(int numProfesor) {
        this.numProfesor = numProfesor;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

  
    public boolean asignaFacultad(Facultad f) {
    if (f != null) {
        this.facultad = f;
        return true;
    }
    return false;
}
    
    

    @Override
    public String toString() {
        return "Profesor{" + "numProfesor=" + numProfesor + ", fechaContratacion=" + fechaContratacion + ", facultad=" + facultad + '}';
    }

}
