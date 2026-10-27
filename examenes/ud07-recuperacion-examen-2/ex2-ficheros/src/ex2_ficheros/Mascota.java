/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_ficheros;

/**
 *
 * @author juand
 */
public class Mascota {

    private String dniPersona;
    private String nombre;
    private int edad;
    private String raza;
    private Persona per;

    public Mascota(String dniPersona, String nombre, int edad, String raza) {
        this.dniPersona = dniPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.per = null;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public boolean asignaPersona(Persona per) {
        this.per = per;
        return true;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + '}';
    }
}
