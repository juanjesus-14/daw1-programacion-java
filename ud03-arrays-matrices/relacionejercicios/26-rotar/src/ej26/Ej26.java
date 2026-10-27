/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej26;

/**
 *
 * @author juand
 */
public class Ej26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 26 del tema 7: Ejercicio de rotar una matriz en el senƟdo de las agujas del reloj

        int filas;
        int columnas;

        // Pedir filas
        do {
            System.out.println("Introduce el número de filas:");
            filas = numeroValido(System.console().readLine());
        } while (filas <= 0);

        // Pedir columnas
        do {
            System.out.println("Introduce el número de columnas:");
            columnas = numeroValido(System.console().readLine());
        } while (columnas <= 0);

        // Crear matrices
        int[][] matriz = new int[filas][columnas];
        int[][] girada = new int[columnas][filas];

        // Rellenar matriz con aleatorios
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 100);
            }
        }

        // Mostrar matriz original
        System.out.println("\nMATRIZ ORIGINAL:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] < 10) {
                    System.out.print("0" + matriz[i][j] + " ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Girar matriz 90 grados
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                girada[j][filas - 1 - i] = matriz[i][j];
            }
        }

        // Mostrar matriz girada
        System.out.println("\nMATRIZ GIRADA:");
        for (int i = 0; i < girada.length; i++) {
            for (int j = 0; j < girada[0].length; j++) {
                if (girada[i][j] < 10) {
                    System.out.print("0" + girada[i][j] + " ");
                } else {
                    System.out.print(girada[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

// Función para validar números
    public static int numeroValido(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Debes introducir un número.");
            return -1;
        }
    }
}
