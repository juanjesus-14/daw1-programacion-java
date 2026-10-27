/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8.equipobaloncesto;

/**
 *
 * @author juand
 */
public class Cancha {

    private String nombre;
    private String ciudad;
    private int capacidad;

    public Cancha() {
    }

    public Cancha(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Cancha{" + nombre + ", " + ciudad + ", cap=" + capacidad + "}";
    }
}
