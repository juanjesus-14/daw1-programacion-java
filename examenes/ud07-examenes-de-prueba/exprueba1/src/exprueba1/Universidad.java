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
public class Universidad {

    private String cif;
    private String nombre;
    private ArrayList<Facultad> facultades;

    public Universidad(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.facultades = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(ArrayList<Facultad> facultades) {
        this.facultades = facultades;
    }

    public boolean asignaFacultad(Facultad f) {
        if (f != null) {
            facultades.add(f);
            return true;
        }
        return false;
    }

    public void listaDepartamentos() {
        for (Facultad f : facultades) {
            System.out.println(f);
        }
    }

    @Override
    public String toString() {
        return "Universidad: " + nombre
                + "\nCIF: " + cif
                + "\nNúmero de facultades: " + facultades.size();
    }

}
