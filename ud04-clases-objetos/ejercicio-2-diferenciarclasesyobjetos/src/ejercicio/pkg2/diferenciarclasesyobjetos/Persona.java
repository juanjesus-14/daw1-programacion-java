/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg2.diferenciarclasesyobjetos;

/**
 *
 * @author juand
 */
public class Persona {

    private String nombre;
    private int edad;
    private String nacionalidad;
    private double altura;

    public Persona(String nombre, int edad, String nacionalidad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona {"
                + "nombre='" + nombre + '\''
                + ", edad=" + edad
                + ", nacionalidad='" + nacionalidad + '\''
                + ", altura=" + altura
                + '}';
    }
}
