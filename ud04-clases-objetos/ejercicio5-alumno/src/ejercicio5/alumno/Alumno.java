/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5.alumno;

/**
 *
 * @author juand
 */
public class Alumno {

    private String apellidos;
    private double estatura;
    private int edad;
    private double peso;
    private Nota[] notas;    // array de objetos Nota

    public Alumno(String apellidos, double estatura, int edad, double peso, int cantidadNotas) {
        this.apellidos = apellidos;
        this.estatura = estatura;
        this.edad = edad;
        this.peso = peso;
        this.notas = new Nota[cantidadNotas];  // tamaño variable
    }

    // Método para asignar una nota en una posición del array
    public void ponerNota(int posicion, Nota nota) {
        if (posicion < 0 || posicion >= notas.length) {
            System.out.println("Posición de nota no válida.");
        } else {
            notas[posicion] = nota;
        }
    }

    @Override
    public String toString() {
        String textoNotas = "";
        for (int i = 0; i < notas.length; i++) {
            textoNotas += (notas[i] == null ? "sin nota" : notas[i].toString());
            if (i < notas.length - 1) {
                textoNotas += ", ";
            }
        }

        return "Alumno {"
                + "apellidos='" + apellidos + '\''
                + ", estatura=" + estatura
                + ", edad=" + edad
                + ", peso=" + peso
                + ", notas=[" + textoNotas + "]"
                + '}';
    }
}
