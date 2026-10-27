/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej28;

/**
 *
 * @author juand
 */
public class Ej28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 28 del tema 7: Ejercicio que muestra por pantalla un array de 10 filas y 10 columnas
// con valores comprendidos entre 200 y 300 y te dice el numero mayor, el numero menor y la
// media de los números de la diagonal junto con estos. 

        int[][] matriz = new int[10][10];

        int mayor = 0;
        int menor = 0;

        int sumaDiagonal = 0;

        // Rellenar matriz
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = (int) (Math.random() * 101) + 200;
                // Inicializar mayor y menor
                if (i == 0 && j == 0) {
                    mayor = matriz[i][j];
                    menor = matriz[i][j];
                } else {
                    if (matriz[i][j] > mayor) {
                        mayor = matriz[i][j];
                    }
                    if (matriz[i][j] < menor) {
                        menor = matriz[i][j];
                    }
                }
            }
        }

        // Mostrar matriz
        System.out.println("MATRIZ:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Mostrar diagonal principal y calcular suma
        System.out.println("\nDIAGONAL PRINCIPAL:");
        for (int i = 0; i < 10; i++) {
            System.out.print(matriz[i][i] + " ");
            sumaDiagonal += matriz[i][i];
        }

        // Calcular media
        double media = (double) sumaDiagonal / 10;

        // Mostrar resultados
        System.out.println("\n\nNumero mayor: " + mayor);
        System.out.println("Numero menor: " + menor);
        System.out.printf("Media diagonal: %.2f\n", media);

    }

}
