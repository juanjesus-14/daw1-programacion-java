/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej11;

/**
 *
 * @author juand
 */
public class Ej11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 11: Programa que a parƟr de 10 números introducidos por el usuario te ordena los
// mismos mostrando los primos primero. 

        int[] numeros = new int[10];

        // Pedir números
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Escribe un numero:");
            numeros[i] = Integer.parseInt(System.console().readLine());
        }

        // Mostrar primero los primos
        System.out.println("\nNumeros primos:");
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                System.out.print(numeros[i] + " ");
            }
        }

        // Mostrar después los no primos
        System.out.println("\n\nNumeros no primos:");
        for (int i = 0; i < numeros.length; i++) {
            if (!esPrimo(numeros[i])) {
                System.out.print(numeros[i] + " ");
            }
        }
    }

    public static boolean esPrimo(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
