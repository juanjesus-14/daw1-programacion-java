/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej16;

/**
 *
 * @author juand
 */
public class Ej16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 16: Programa que genera 20 números entre 0 y 400 y después el programa
// pregunta si queremos resaltar los números múlƟplos de 5 o múlƟplos de 7, y estos se
// resaltarán entre corchetes. 

        int[] numeros = new int[20];

        // Generar números aleatorios entre 0 y 400
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 401);
        }

        // Mostrar array original
        System.out.println("Array generado:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // Preguntar opción
        System.out.println("\n\n¿Qué deseas resaltar?");
        System.out.println("1. Multiplos de 5");
        System.out.println("2. Multiplos de 7");

        int opcion = Integer.parseInt(System.console().readLine());
        System.out.println("\nResultado:");
        for (int i = 0; i < numeros.length; i++) {
            if (opcion == 1 && numeros[i] % 5 == 0) {
                System.out.print("[" + numeros[i] + "] ");
            } else if (opcion == 2 && numeros[i] % 7 == 0) {
                System.out.print("[" + numeros[i] + "] ");
            } else {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}
