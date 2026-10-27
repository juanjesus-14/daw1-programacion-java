/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej4;

/**
 *
 * @author juand
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores) 
        // Ejercicio 4: Programa que usa 3 arrays de 20 valores, el primero son números aleatorios, el
        // segundo es el cuadrado de esos números y el tercero son los números al cubo. 

        int[] numeros = new int[20];  // Array de números aleatorios
        int[] cuadrados = new int[20]; // Array de cuadrados
        int[] cubos = new int[20]; // Array de cubos

        // Rellenar los arrays
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);  // Número aleatorio entre 0 y 100
            cuadrados[i] = numeros[i] * numeros[i]; // Cuadrado del número
            cubos[i] = numeros[i] * numeros[i] * numeros[i]; // Cubo del número
        }

        // Mostrar resultados
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Numero: " + numeros[i] + " Cuadrado: " + cuadrados[i] + " Cubo: " + cubos[i]);
        }
    }
}
