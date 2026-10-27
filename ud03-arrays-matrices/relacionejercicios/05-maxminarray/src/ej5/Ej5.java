/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej5;

/**
 *
 * @author juand
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores)
// Ejercicio 5: Programa que a partir de 10 números introducidos por el usuario al lado del
// mayor y del menor pone "máximo" o "mínimo" respecƟvamente (recomendado – nivel 1,5puntos). 

        int numMayor = 0; // Variable para almacenar el número mayor
        int numMenor = 0; // Variable para almacenar el número menor
        int[] numeros = new int[10]; // Array para almacenar 10 números

// Solicitar los números al usuario
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce los numeros:");
            numeros[i] = Integer.parseInt(System.console().readLine());

            // Primera posición del array
            if (i == 0) {
                numMayor = numeros[i];
                numMenor = numeros[i];
            } else {
                // Comprobar si es el mayor número encontrado
                if (numMayor < numeros[i]) {
                    numMayor = numeros[i];
                }
                // Comprobar si es el menor número encontrado
                if (numMenor > numeros[i]) {
                    numMenor = numeros[i];
                }
            }
        }

// Mostrar los números indicando cuál es el máximo y el mínimo
        System.out.println("Los números que nos han salido son:");
        for (int i = 0; i < 10; i++) {
            if (numeros[i] == numMayor) {
                System.out.println(numeros[i] + " --> maximo");
            } else if (numeros[i] == numMenor) {
                System.out.println(numeros[i] + " --> minimo");
            } else {
                System.out.println(numeros[i]);
            }
        }
    }
}
