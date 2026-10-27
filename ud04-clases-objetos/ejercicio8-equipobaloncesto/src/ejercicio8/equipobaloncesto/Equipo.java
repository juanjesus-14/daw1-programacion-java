/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8.equipobaloncesto;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Equipo {

    private String nombre;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Cancha cancha;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public void setCancha(Cancha c) {
        this.cancha = c;
    }

    @Override
    public String toString() {
        return "Equipo{" + nombre + ", jugadores=" + jugadores.size() + ", cancha=" + cancha + "}";
    }
}
