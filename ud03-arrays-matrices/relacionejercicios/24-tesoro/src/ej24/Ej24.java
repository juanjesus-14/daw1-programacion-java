/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej24;

/**
 *
 * @author juand
 */
public class Ej24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES) 
// Ejercicio 24 del tema 7: Ejercicio de mejorar el juego de buscar el tesoro Matriz para mostrar las posiciones visitadas
        // Matriz para mostrar las posiciones visitadas
        String[][] tablero = new String[5][4];

        // Inicializar tablero con ?
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = "?";
            }
        }

        // Posición aleatoria del tesoro
        int filaTesoro = (int) (Math.random() * 5);
        int colTesoro = (int) (Math.random() * 4);

        // Posición aleatoria de la mina
        int filaMina;
        int colMina;

        do {
            filaMina = (int) (Math.random() * 5);
            colMina = (int) (Math.random() * 4);
        } while (filaMina == filaTesoro && colMina == colTesoro);

        boolean finJuego = false;

        do {
            // Mostrar tablero
            System.out.println("\nTABLERO");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }

            int fila;
            int columna;

            // Pedir fila con control de errores
            do {
                System.out.println("\nIntroduce fila (0-4):");
                fila = rangoCorrecto(System.console().readLine(), 0, 4);
            } while (fila == -1);
            
            // Pedir columna con control de errores
            do {
                System.out.println("Introduce columna (0-3):");
                columna = rangoCorrecto(System.console().readLine(), 0, 3);
            } while (columna == -1);
            // Comprobar tesoro
            if (fila == filaTesoro && columna == colTesoro) {
                tablero[fila][columna] = "T";
                System.out.println("\n¡¡HAS ENCONTRADO EL TESORO!!");
                finJuego = true;
            } // Comprobar mina
            else if (fila == filaMina && columna == colMina) {
                tablero[fila][columna] = "M";
                System.out.println("\nBOOM. Has encontrado la mina.");
                finJuego = true;
            } // Casilla vacía
            else {
                tablero[fila][columna] = "X";
                System.out.println("\nNo hay nada aquí.");
            }
        } while (!finJuego);

        // Mostrar tablero final
        System.out.println("\nTABLERO FINAL");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

// Función que comprueba formato y rango
    public static int rangoCorrecto(String texto, int min, int max) {
        int numero;
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto.");
            return -1;
        }
        if (numero < min || numero > max) {
            System.out.println("Valor fuera de rango.");
            return -1;
        }
        return numero;
    }
}
