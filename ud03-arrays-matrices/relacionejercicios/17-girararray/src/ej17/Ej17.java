/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej17;

/**
 *
 * @author juand
 */
public class Ej17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS UNIDIMENSIONALES (Vectores) 
// Ejercicio 17: Programa que genera un array de 10 números entre 0 y 100, el usuario deberá
// introducir uno de esos números y posteriormente se deberá girar el array hacia la derecha
// (desplazar todos los números 1 posición, el úlƟmo se pone en la posición 0) cuantas veces haga
// falta hasta que el número elegido por el usuario se encuentre en la posición 0.

        int[] numeros = new int[10];

        // Generar números aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 101);
        }

        // Mostrar array
        System.out.println("Array generado:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // Pedir número
        System.out.println("\n\nIntroduce uno de los números del array:");
        int buscado = Integer.parseInt(System.console().readLine());

        // Buscar posición
        int posicion = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("Ese número no está en el array.");
        } else {

            // Girar hasta que llegue a la posición 0
            while (posicion != 0) {
                int ultimo = numeros[numeros.length - 1];
                for (int i = numeros.length - 1; i > 0; i--) {
                    numeros[i] = numeros[i - 1];
                }
                numeros[0] = ultimo;
                posicion--;
            }

            // Mostrar resultado
            System.out.println("\nArray desplazado:");
            for (int i = 0; i < numeros.length; i++) {
                System.out.print(numeros[i] + " ");
            }
        }
    }
}
