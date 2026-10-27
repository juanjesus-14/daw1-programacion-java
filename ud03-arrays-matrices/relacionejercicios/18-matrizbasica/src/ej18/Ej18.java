/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej18;

/**
 *
 * @author juand
 */
public class Ej18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 18: Define un array de números enteros de 3 filas y 6 columnas y asignar los valores a la tabla y mostrarla. 

        int[][] numeros = new int[3][6];

        // Asignar valores
        numeros[0][0] = 0;
        numeros[0][1] = 3;
        numeros[0][2] = 2;
        numeros[0][3] = 0;
        numeros[0][4] = 0;
        numeros[0][5] = 5;

        numeros[1][0] = 5;
        numeros[1][1] = 0;
        numeros[1][2] = 0;
        numeros[1][3] = 0;
        numeros[1][4] = 0;
        numeros[1][5] = 0;

        numeros[2][0] = 0;
        numeros[2][1] = 0;
        numeros[2][2] = 2;
        numeros[2][3] = 9;
        numeros[2][4] = 0;
        numeros[2][5] = 1;

        // Mostrar matriz
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
            System.out.print(numeros[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
