/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej13;

/**
 *
 * @author juand
 */
public class Ej13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 13: Programa que rellene un array con 100 números comprendidos entre 0 y 500 y
// que a conƟnuación pregunte si quiere ver el máximo o el mínimo y el programa volverá a
// escribir el array con la opción elegida destacándola entre asteriscos. 

        int[] numeros = new int[10];
        int mayor = 0;
        int menor = 0;

        // Generar números aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 501);
            if (i == 0) {
                mayor = numeros[i];
                menor = numeros[i];
            } else {
                if (numeros[i] > mayor) {
                    mayor = numeros[i];
                }
                if (numeros[i] < menor) {
                    menor = numeros[i];
                }
            }
        }

        // Mostrar array original
        System.out.println("Array original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");

        }

        // Preguntar opción
        System.out.println("\n\n¿Que quieres destacar?");
        System.out.println("1. Maximo");
        System.out.println("2. Minimo");
        int opcion = Integer.parseInt(System.console().readLine());

        // Mostrar array destacando la opción elegida
        System.out.println("\nResultado:");
        for (int i = 0; i < numeros.length; i++) {
            if (opcion == 1 && numeros[i] == mayor) {
                System.out.print("*" + numeros[i] + "* ");
            } else if (opcion == 2 && numeros[i] == menor) {
                System.out.print("*" + numeros[i] + "* ");
            } else {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}
