/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej7;

/**
 *
 * @author juand
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores) 
        // Ejercicio 7: Programa que genera 100 números aleatorios (de 0 a 20 incluidos) y a partir de
        // dos números introducidos intercambie las ocurrencias de uno por el otro (intercambia
        // posiciones).

        int[] numeros = new int[100];

        int valor1;
        int valor2;

        // Generar números aleatorios entre 0 y 20
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 21);
        }

        // Mostrar array original
        System.out.println("Array original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println("");
        // Pedir los dos números a intercambiar
        System.out.println("\nIntroduce el primer numero:");
        valor1 = Integer.parseInt(System.console().readLine());
        System.out.println("Introduce el segundo numero:");
        valor2 = Integer.parseInt(System.console().readLine());

        // Intercambiar ocurrencias
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == valor1) {
                numeros[i] = valor2;
            } else if (numeros[i] == valor2) {
                numeros[i] = valor1;
            }
        }

        // Mostrar array modificado
        System.out.println("\nArray modificado:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
