/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej12;

import java.util.Random;

/**
 *
 * @author juand
 */
public class Ej12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores) 
        // Ejercicio 12: Programa que a parƟr de 2 números introducidos por el usuario (inicial y final)
        // te los desordena todos menos los números que se encuentran entre ellos y cambia la posición de ambos.    

        int[] numeros = new int[20];
        Random r = new Random();

        // Generar array original
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(101);
        }

        // Mostrar array original
        System.out.println("Array original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // Pedir números
        System.out.println("\n\nIntroduce el numero inicial:");
        int inicial = Integer.parseInt(System.console().readLine());

        System.out.println("Introduce el numero final:");
        int fin = Integer.parseInt(System.console().readLine());

        // Buscar posiciones
        int posInicial = -1;
        int posFinal = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == inicial && posInicial == -1) {
                posInicial = i;
            }
            if (numeros[i] == fin && posFinal == -1) {
                posFinal = i;
            }
        }

        // Comprobar que existen
        if (posInicial == -1 || posFinal == -1) {
            System.out.println("Alguno de los numeros no existe en el array.");
            return;
        }

        // Intercambiar posiciones si están al revés
        if (posInicial > posFinal) {
            int aux = posInicial;
            posInicial = posFinal;
            posFinal = aux;
        }

        // Crear array resultado
        int[] resultado = new int[20];
        // Copiar tramo fijo
        for (int i = posInicial; i <= posFinal; i++) {
            resultado[i] = numeros[i];
        }

        // Inicializar resto con -1
        for (int i = 0; i < resultado.length; i++) {
            if (i < posInicial || i > posFinal) {
                resultado[i] = -1;
            }
        }

        // Colocar aleatoriamente los números fuera del tramo fijo
        for (int i = 0; i < numeros.length; i++) {
            if (i < posInicial || i > posFinal) {
                int posicion;
                do {
                    posicion = r.nextInt(resultado.length);
                } while (resultado[posicion] != -1);
                resultado[posicion] = numeros[i];
            }
        }

        // Mostrar resultado
        System.out.println("\nArray final:");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
        System.out.println();
    }
}
