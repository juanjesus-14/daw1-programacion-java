/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.alumno;

/**
 *
 * @author juand
 */
public class Nota {
    
  private String nombreAsignatura;
    private double calificacion;

    public Nota(String nombreAsignatura, double calificacion) {
        this.nombreAsignatura = nombreAsignatura;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return nombreAsignatura + ": " + calificacion;
    }
}
