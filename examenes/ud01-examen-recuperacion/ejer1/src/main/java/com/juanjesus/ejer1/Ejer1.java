package com.juanjesus.ejer1;

/**
 *
 * @author DAW
 */
public class Ejer1 {

    public static void main(String[] args) {

        final int MIN = 1;
        final int MAX = 6;

        int numeroAleatorio1 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        int numeroAleatorio2 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        int numeroAleatorio3 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        int numeroAleatorio4 = (int) (Math.random() * (MAX - MIN + 1)) + MIN;

        System.out.println("Primer dado: " + numeroAleatorio1);
        System.out.println("Segundo dado: " + numeroAleatorio2);
        System.out.println("Tercer dado: " + numeroAleatorio3);
        System.out.println("Cuarto dado: " + numeroAleatorio4);
        System.out.println("");
        

        int acumuladoA = numeroAleatorio1 + numeroAleatorio2;
        int acumuladoB = numeroAleatorio3 + numeroAleatorio4;

        System.out.println("AcumuladoA: " + acumuladoA);
        System.out.println("AcumuladoB: " + acumuladoB);
        System.out.println("");

        if (acumuladoA > acumuladoB) {
            System.out.println(" gana Jugador A");
        } else if (acumuladoA < acumuladoB) {
            System.out.println("gana Jugador B");
        } else {
            System.out.println("Empate");
        }
    }
}
