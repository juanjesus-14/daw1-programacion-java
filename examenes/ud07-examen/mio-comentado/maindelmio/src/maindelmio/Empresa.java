 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindelmio;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Empresa {
    
    private String cif;
    private String nombre;
    private ArrayList<Departamento> listaDepto;

    public Empresa(String cif, String nombre, ArrayList<Departamento> listaDepto) {
        this.cif = cif;
        this.nombre = nombre;
        this.listaDepto = new ArrayList<>();
    }

    public Empresa() {
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

    public ArrayList<Departamento> getListaDepto() {
        return listaDepto;
    }

    public void setListaDepto(ArrayList<Departamento> listaDepto) {
        this.listaDepto = listaDepto;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", nombre=" + nombre + ", listaDepto=" + listaDepto + '}';
    }
   
    
}
