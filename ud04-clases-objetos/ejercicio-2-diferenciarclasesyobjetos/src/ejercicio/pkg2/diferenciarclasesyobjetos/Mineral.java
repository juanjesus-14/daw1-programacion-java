/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg2.diferenciarclasesyobjetos;

/**
 *
 * @author juand
 */
public class Mineral {

    private String nombre;
    private String color;
    private double dureza; // según la escala de Mohs
    private String origen;

    public Mineral(String nombre, String color, double dureza, String origen) {
        this.nombre = nombre;
        this.color = color;
        this.dureza = dureza;
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "Mineral {"
                + "nombre='" + nombre + '\''
                + ", color='" + color + '\''
                + ", dureza=" + dureza
                + ", origen='" + origen + '\''
                + '}';
    }
}
