/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej6;

/**
 *
 * @author juand
 */
public class Ej6 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 6: Programa que lea 15 números por teclado y que los desordene añadiéndole una
// posición a cada uno. 
        
        int[] numeros = new int[5];

        // Introducir los números
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un numero:");
            numeros[i] = Integer.parseInt(System.console().readLine());
        }

        System.out.println("\nArray original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // ============================================
        // OPCION 1 - DESPLAZAR UNA POSICION
        // ============================================
        int[] desplazado = new int[5];
        // El último elemento pasa a la primera posición
        desplazado[0] = numeros[numeros.length - 1];
        // El resto avanza una posición
        for (int i = 0; i < numeros.length - 1; i++) {
            desplazado[i + 1] = numeros[i];
        }
        
        System.out.println("\n\nArray desplazado una posicion:");
        for (int i = 0; i < desplazado.length; i++) {
            System.out.print(desplazado[i] + " ");
        }

        // ============================================
        // OPCION 2 - DESORDENAR ALEATORIAMENTE
        // ============================================
        int[] desordenado = new int[5];
        // Inicializar con -1
        for (int i = 0; i < desordenado.length; i++) {
            desordenado[i] = -1;
        }
        // Colocar cada número en una posición aleatoria libre
        for (int i = 0; i < numeros.length; i++) {
            int posicion;
            do {
                posicion = (int) (Math.random() * desordenado.length);
            } while (desordenado[posicion] != -1);
            desordenado[posicion] = numeros[i];
        }
        
        System.out.println("\n\nArray desordenado aleatoriamente:");
        for (int i = 0; i < desordenado.length; i++) {
            System.out.print(desordenado[i] + " ");
        }
    }
}
