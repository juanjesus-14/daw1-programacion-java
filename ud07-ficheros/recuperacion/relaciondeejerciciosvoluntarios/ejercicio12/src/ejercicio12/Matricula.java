/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12;

/**
 *
 * @author juand
 */
public class Matricula {

    private String id;
    private String alumno;
    private String grado;
    private String fecha;

    public Matricula(String id, String alumno, String grado, String fecha) {
        this.id = id;
        this.alumno = alumno;
        this.grado = grado;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toFile() {
        return id + ";" + alumno + ";" + grado + ";" + fecha;
    }

    @Override
    public String toString() {
        return "Matricula{id=" + id + ", alumno=" + alumno + ", grado=" + grado + ", fecha=" + fecha + "}";
    }
}
