package com.juanjesus.ejer2;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ejer2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        int suma = 0;
        int contador = 0;
        int max = 0;
        int min = 0;

        System.out.println("Por favor, vaya introduciendo números enteros positivos. Para terminar, introduzca Fin: ");
        numero = sc.nextInt();

        if (numero != 0 ) {
            max = numero;
            min = numero;
        }

        while (numero != 0) {
            suma += numero;
            contador++;

            if (numero > max) {
                max = numero;
            }

            if (numero < min) {
                min = numero;
            }

            numero = sc.nextInt();
        }

        double media = (double) suma / contador;

        System.out.println("Ha introducido " + contador + " números.");
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Media: " + media);
    }
}
