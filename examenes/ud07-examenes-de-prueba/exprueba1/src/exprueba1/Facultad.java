/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exprueba1;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Facultad {

    private String codFacultad;
    private String nombreFacultad;
    private ArrayList<Profesor> profesores;

    public Facultad(String codFacultad, String nombreFacultad) {
        this.codFacultad = codFacultad;
        this.nombreFacultad = nombreFacultad;
        this.profesores = new ArrayList<>();
    }

    public Facultad() {
    }

    public String getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public boolean asignaProfesor(Profesor p) {
        if (p != null) {
            profesores.add(p);
            p.asignaFacultad(this);
            return true;
        }
        return false;
    }

    public void listarProfesores() {
        for (Profesor p : profesores) {
            System.out.println(p.getNombreCompleto());
        }
    }

    @Override
    public String toString() {
        return "Facultad: " + nombreFacultad
                + "\nCódigo: " + codFacultad
                + "\nNúmero profesores: " + profesores.size();
    }
}
