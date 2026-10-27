/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej2;

/**
 *
 * @author juand
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 2: Programa que establece un array de notas 15 valores numéricos 
// aleatorios que van de 0 a 10 y a continuación calcula la media.

        // Array para almacenar 15 notas
        int[] notas = new int[15];

        // Rellenar el array con notas aleatorias entre 0 y 10
        for (int i = 0; i < notas.length; i++) {
            notas[i] = (int) (Math.random() * 11);
        }
        // Mostrar la media
        System.out.printf("\nLa nota media es: %.2f\n", calculaMedia(notas));
    }

    public static double calculaMedia(int[] notas) {
        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media = media + notas[i];
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }
        return media / notas.length;
    }
}
