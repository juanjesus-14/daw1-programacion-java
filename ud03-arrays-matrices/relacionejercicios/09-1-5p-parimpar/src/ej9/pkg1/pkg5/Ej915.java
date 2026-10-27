/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej9.pkg1.pkg5;

/**
 *
 * @author juand
 */
public class Ej915 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 9: Programa que pida 8 números enteros y que luego muestre los números junto a
// par o impar (recomendado – nivel 1,5puntos). 

        // =====================================================
        // OPCION 1: PEDIR LOS 8 NUMEROS UNO A UNO
        // =====================================================
        int[] numeros = new int[8];

        // Pedir los números
        for (int i = 0; i < 8; i++) {
            System.out.println("Introduce los numeros:");
            numeros[i] = Integer.parseInt(System.console().readLine());
        }

        // Mostrar si son pares o impares
        System.out.println("\nLos números introducidos son:");
        for (int i = 0; i < 8; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i] + " --> par");
            } else {
                System.out.println(numeros[i] + " --> impar");
            }
        }

        // =====================================================
        // OPCION 2: EL USUARIO INTRODUCE UN CHORIZO
        // =====================================================
        System.out.println("Introduce los numeros separados por ;");
        String chorizo = System.console().readLine();
        String[] texto = chorizo.split(";");
        System.out.println("\nLos números introducidos son:");

        for (int i = 0; i < texto.length; i++) {
            if (Integer.parseInt(texto[i]) % 2 == 0) {
                System.out.println(texto[i] + " --> par");
            } else {
                System.out.println(texto[i] + " --> impar");
            }
        }
    }
}
