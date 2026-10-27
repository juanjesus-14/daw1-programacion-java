/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej22.pkg1.pkg5;

import java.util.Random;

/**
 *
 * @author juand
 */
public class Ej2215 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 22: Programa que rellena un array de 6 filas y 10 columnas con números enteros
// posiƟvos comprendidos entre el 0 y el 1000 y se deberá dar la posición del máximo y del
// mínimo (recomendado – nivel 1,5puntos).

        int[][] matrizAleatorios = new int[6][10];

// Objeto para generar números aleatorios
        Random numAleatorio = new Random();

// Variables para almacenar el valor máximo y mínimo
        int numMayor = 0;
        int numMenor = 0;

// Variables donde guardaremos el texto con la posición
        String posMax = "";
        String posMin = "";

// =========================
// RELLENAR MATRIZ
// =========================
        for (int i = 0; i < matrizAleatorios.length; i++) {
            for (int j = 0; j < matrizAleatorios[0].length; j++) {
                // Generamos números entre 0 y 1000
                matrizAleatorios[i][j] = numAleatorio.nextInt(1001);
                // Inicializamos máximo y mínimo con la primera posición
                if (i == 0 && j == 0) {
                    numMayor = matrizAleatorios[i][j];
                    numMenor = matrizAleatorios[i][j];
                } else {
                    // Comprobar si hemos encontrado un nuevo máximo
                    if (matrizAleatorios[i][j] > numMayor) {
                        numMayor = matrizAleatorios[i][j];
                    }
                    // Comprobar si hemos encontrado un nuevo mínimo
                    if (matrizAleatorios[i][j] < numMenor) {
                        numMenor = matrizAleatorios[i][j];
                    }
                }
            }
        }

// =========================
// MOSTRAR MATRIZ
// =========================
        System.out.println("MATRIZ GENERADA:");
        for (int i = 0; i < matrizAleatorios.length; i++) {
            for (int j = 0; j < matrizAleatorios[0].length; j++) {
                // Mostrar todos los números con 3 cifras
                if (matrizAleatorios[i][j] < 10) {
                    System.out.print("00" + matrizAleatorios[i][j] + " ");
                } else if (matrizAleatorios[i][j] < 100) {
                    System.out.print("0" + matrizAleatorios[i][j] + " ");
                } else {
                    System.out.print(matrizAleatorios[i][j] + " ");
                }
                // Si encontramos el máximo guardamos su posición
                if (matrizAleatorios[i][j] == numMayor) {
                    posMax = "La posicion del maximo es (" + (i + 1) + ", " + (j + 1) + ") y su valor es " + numMayor;
                }
                // Si encontramos el mínimo guardamos su posición
                if (matrizAleatorios[i][j] == numMenor) {
                    posMin = "La posicion del minimo es (" + (i + 1) + ", " + (j + 1) + ") y su valor es " + numMenor;
                }
            }
            // Salto de línea al terminar cada fila
            System.out.println();
        }
// =========================
// MOSTRAR RESULTADOS
// =========================
        System.out.println("\n" + posMax);
        System.out.println(posMin);
    }
}
