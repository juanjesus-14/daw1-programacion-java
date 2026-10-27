/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej21;

/**
 *
 * @author juand
 */
public class Ej21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
// ARRAYS BIDIMENSIONALES (MATRICES) 
//Ejercicio 21: Programa igual que el anterior pero que tarde (Thread.sleep(200);) un poco de Ɵempo en mostrar los sumatorios.

        int[][] matriz = new int[5][5];
        int sumaTotal = 0;

        // Rellenar matriz con aleatorios
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = (int) (Math.random() * 100);
            }
        }

        // Mostrar matriz
        System.out.println("MATRIZ:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] < 10) {
                    System.out.print("0" + matriz[i][j] + " ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Suma filas
        System.out.println("\nSUMA DE FILAS:");

        for (int i = 0; i < 5; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 5; j++) {
                sumaFila += matriz[i][j];
            }
            Thread.sleep(1000);
            System.out.println("Fila " + (i + 1) + ": " + sumaFila);
            sumaTotal += sumaFila;
        }

        // Suma columnas
        System.out.println("\nSUMA DE COLUMNAS:");
        for (int j = 0; j < 5; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < 5; i++) {
                sumaColumna += matriz[i][j];
            }
            Thread.sleep(1000);
            System.out.println("Columna " + (j + 1) + ": " + sumaColumna);
        }
        Thread.sleep(1000);
        System.out.println("\nSUMA TOTAL: " + sumaTotal);
    }
}
