/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej23.pkg3;

/**
 *
 * @author juand
 */
public class Ej233 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 23: Programa que rellena un array bidimensional sin que se repitan sus valores (recomendado – nivel 3 puntos). 

// Crear matriz
        int[][] matriz;

        int filas;
        int columnas;

// Pedir dimensiones
        System.out.println("Dime el número de filas:");
        filas = Integer.parseInt(System.console().readLine());
        System.out.println("Dime el número de columnas:");
        columnas = Integer.parseInt(System.console().readLine());

// Crear matriz
        matriz = new int[filas][columnas];

// Inicializar matriz con -1
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = -1;
            }
        }

// Variable para guardar el aleatorio generado
        int numAleatorio;

// Rellenar matriz sin repetir números
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    // Generar número aleatorio entre 0 y 99
                    numAleatorio = (int) (Math.random() * 100);
                } while (numRepetido(matriz, numAleatorio));
                // Guardar el número en la matriz
                matriz[i][j] = numAleatorio;
            }
        }

// Mostrar matriz
        System.out.println("\nMATRIZ RESULTADO:");
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
    }

    // Comprueba si un número ya existe en la matriz
    public static boolean numRepetido(int[][] matriz, int numAleatorio) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == numAleatorio) {
                    return true;
                }
            }
        }
        return false;
    }
}
