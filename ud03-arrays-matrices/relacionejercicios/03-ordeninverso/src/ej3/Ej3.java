/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej3;

/**
 *
 * @author juand
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 3: Programa que muestra en orden inverso 10 números introducidos por el usuario. 

// Array para almacenar 10 números
        int[] numeros = new int[10];

// Recorrer el array para introducir los números
        for (int i = 0; i < numeros.length; i++) {
            // Solicitar el número al usuario
            System.out.println("Introduce el número " + (i + 1) + ":");
            // Leer y guardar el número en el array
            numeros[i] = Integer.parseInt(System.console().readLine());
        }
        
// Recorrer el array desde la última posición hasta la primera
        for (int i = numeros.length - 1; i >= 0; i--) {
            // Mostrar el número almacenado
            System.out.println(numeros[i]);
        }
    }

}
