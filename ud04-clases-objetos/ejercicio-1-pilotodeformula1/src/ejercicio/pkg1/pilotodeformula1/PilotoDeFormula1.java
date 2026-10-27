/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.pkg1.pilotodeformula1;

/**
 *
 * @author juand
 */
public class PilotoDeFormula1 {

    private String nombre;
    private String apellidos;
    private String escuderia;
    private double peso;
    private double altura;
    private String nacionalidad;
    private int edad;
    private int debut;
    private int ranking;
    private int numeroPuntos;

    public PilotoDeFormula1(String nombre, String apellidos, String escuderia,
            double peso, double altura, String nacionalidad,
            int edad, int debut, int ranking, int numeroPuntos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.escuderia = escuderia;
        this.peso = peso;
        this.altura = altura;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.debut = debut;
        this.ranking = ranking;
        this.numeroPuntos = numeroPuntos;
    }

    @Override
    public String toString() {
        return "PilotoDeFormula1 {"
                + "nombre='" + nombre + '\''
                + ", apellidos='" + apellidos + '\''
                + ", escuderia='" + escuderia + '\''
                + ", peso=" + peso
                + ", altura=" + altura
                + ", nacionalidad='" + nacionalidad + '\''
                + ", edad=" + edad
                + ", debut=" + debut
                + ", ranking=" + ranking
                + ", numeroPuntos=" + numeroPuntos
                + '}';
    }
}
