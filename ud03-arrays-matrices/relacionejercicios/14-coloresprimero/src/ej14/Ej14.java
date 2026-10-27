/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej14;

/**
 *
 * @author juand
 */
public class Ej14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores) 
        // Ejercicio 14: Programa que pide 8 palabras y después te las ordena mostrando primero las
        // palabras que se refieran a colores. 

        String[] palabras = new String[8];
        String[] colores = {"rojo", "verde", "azul", "amarillo", "negro", "blanco", "rosa", "morado", "naranja", "gris", "marron"};

        // Pedir palabras
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Introduce una palabra:");
            palabras[i] = System.console().readLine().toLowerCase();
        }

        System.out.println("\nPalabras ordenadas:");
        // Mostrar primero los colores
        for (int i = 0; i < palabras.length; i++) {
            if (esColor(palabras[i], colores)) {
                System.out.print(palabras[i] + " ");
            }
        }

        // Mostrar después el resto
        for (int i = 0; i < palabras.length; i++) {
            if (!esColor(palabras[i], colores)) {
                System.out.print(palabras[i] + " ");
            }
        }
    }

// Comprueba si una palabra es un color
    public static boolean esColor(String palabra, String[] colores) {
        for (int i = 0; i < colores.length; i++) {
            if (palabra.equals(colores[i])) {
                return true;
            }
        }
        return false;
    }
}
