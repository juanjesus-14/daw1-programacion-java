/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej19;

/**
 *
 * @author juand
 */
public class Ej19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS BIDIMENSIONALES (MATRICES) 
        // Ejercicio 19: Programa que pide 25 números enteros y que te hace la suma de cada fila, cada
        // columna y la suma total de las filas y las columnas (matriz 5x5) (recomendado). 

        int[][] matriz = new int[5][5];
        String linea;

        // Pedimos los 25 números
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Introduce un número (" + i + "," + j + "): ");
                linea = System.console().readLine();
                matriz[i][j] = Integer.parseInt(linea);
            }
        }
        // Mostrar matriz
        System.out.println("\nMATRIZ:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int sumaTotal = 0;

        // Suma de cada fila
        for (int i = 0; i < 5; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 5; j++) {
                sumaFila += matriz[i][j];
            }
            System.out.println("Suma fila " + i + ": " + sumaFila);
            sumaTotal += sumaFila;
        }

        System.out.println();

        // Suma de cada columna
        for (int j = 0; j < 5; j++) {
            int sumaCol = 0;
            for (int i = 0; i < 5; i++) {
                sumaCol += matriz[i][j];
            }
            System.out.println("Suma columna " + j + ": " + sumaCol);
        }

        System.out.println("\nSuma total de todos los valores: " + sumaTotal);
    }
}
