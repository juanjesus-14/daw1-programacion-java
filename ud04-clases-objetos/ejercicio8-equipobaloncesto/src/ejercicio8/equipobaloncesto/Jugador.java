/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8.equipobaloncesto;

/**
 *
 * @author juand
 */
public class Jugador {

    private String nombre;
    private int dorsal;
    private String posicion;

    public Jugador() {
    }

    public Jugador(String nombre, int dorsal, String posicion) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" + nombre + ", dorsal=" + dorsal + ", pos=" + posicion + "}";
    }
}
