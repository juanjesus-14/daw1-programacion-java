/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej25;

/**
 *
 * @author juand
 */
public class Ej25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 25 del tema 7: Ejercicio de la ficha del Alfil del Ajedrez (movimientos en el tablero sin salirse).
        int fila;
        int columna;

        // Pedir fila
        do {
            System.out.println("Introduce fila (1-8):");
            fila = rangoCorrecto(System.console().readLine(), 1, 8);
        } while (fila == -1);

        // Pedir columna
        do {
            System.out.println("Introduce columna (1-8):");
            columna = rangoCorrecto(System.console().readLine(), 1, 8);
        } while (columna == -1);

        System.out.println("\nMovimientos posibles:");

        // Diagonal superior izquierda
        for (int i = 1; fila - i >= 1 && columna - i >= 1; i++) {
            System.out.println("(" + (fila - i) + "," + (columna - i) + ")");
        }

        // Diagonal superior derecha
        for (int i = 1; fila - i >= 1 && columna + i <= 8; i++) {
            System.out.println("(" + (fila - i) + "," + (columna + i) + ")");
        }

        // Diagonal inferior izquierda
        for (int i = 1; fila + i <= 8 && columna - i >= 1; i++) {
            System.out.println("(" + (fila + i) + "," + (columna - i) + ")");
        }

        // Diagonal inferior derecha
        for (int i = 1; fila + i <= 8 && columna + i <= 8; i++) {
            System.out.println("(" + (fila + i) + "," + (columna + i) + ")");
        }
    }

    public static int rangoCorrecto(String texto, int min, int max) {
        int numero;
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto.");
            return -1;
        }
        if (numero < min || numero > max) {
            System.out.println("Valor fuera de rango.");
            return -1;
        }
        return numero;
    }
}
