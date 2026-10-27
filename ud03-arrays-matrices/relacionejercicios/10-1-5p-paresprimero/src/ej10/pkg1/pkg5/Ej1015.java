/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej10.pkg1.pkg5;

/**
 *
 * @author juand
 */
public class Ej1015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 10: Programa que genera 20 números aleatorios entre 0 y 100 y que te muestra los
// números pares primero y los impares después (recomendado – nivel 1,5puntos). 

        int[] numeros = new int[20];

        // Generar números aleatorios entre 0 y 100
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);
        }

        // Mostrar pares
        System.out.println("Pares:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i]);
            }
        }

        // Mostrar impares
        System.out.println("\nImpares:");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.println(numeros[i]);
            }
        }
    }
}
