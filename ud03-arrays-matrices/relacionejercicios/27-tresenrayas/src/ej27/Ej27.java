/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej27;

/**
 *
 * @author juand
 */
public class Ej27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// ARRAYS BIDIMENSIONALES (MATRICES)
// Ejercicio 27 del tema 7: Juego del tres en raya.

        // Crear tablero 3x3
        String[][] tablero = new String[3][3];
        // Inicializar tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "-";
            }
        }

        String jugador = "X";
        boolean finJuego = false;
        int jugadas = 0;
        
        do {
            // Mostrar tablero
            mostrarTablero(tablero);
            int fila;
            int columna;
            // Pedir fila válida
            do {
                System.out.println("Jugador " + jugador + " - Introduce fila (0-2):");
                fila = rangoCorrecto(System.console().readLine(), 0, 2);
            } while (fila == -1);
            // Pedir columna válida
            do {
                System.out.println("Jugador " + jugador + " - Introduce columna (0-2):");
                columna = rangoCorrecto(System.console().readLine(), 0, 2);
            } while (columna == -1);
            // Comprobar si la posición está ocupada
            if (!tablero[fila][columna].equals("-")) {
                System.out.println("Casilla ocupada.");
                continue;
            }
            // Colocar ficha
            tablero[fila][columna] = jugador;
            jugadas++;
            // Comprobar ganador
            if (hayGanador(tablero, jugador)) {
                mostrarTablero(tablero);
                System.out.println("Ha ganado el jugador " + jugador);
                finJuego = true;
            } // Comprobar empate
            else if (jugadas == 9) {
                mostrarTablero(tablero);
                System.out.println("Empate.");
                finJuego = true;
            } // Cambiar jugador
            else {
                if (jugador.equals("X")) {
                    jugador = "O";
                } else {
                    jugador = "X";
                }
            }
        } while (!finJuego);
    }

    public static void mostrarTablero(String[][] tablero) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean hayGanador(String[][] tablero, String jugador) {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(jugador)
                    && tablero[i][1].equals(jugador)
                    && tablero[i][2].equals(jugador)) {
                return true;
            }
        }
        // Columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j].equals(jugador)
                    && tablero[1][j].equals(jugador)
                    && tablero[2][j].equals(jugador)) {
                return true;
            }
        }
        // Diagonal principal
        if (tablero[0][0].equals(jugador)
                && tablero[1][1].equals(jugador)
                && tablero[2][2].equals(jugador)) {
            return true;
        }
        // Diagonal secundaria
        if (tablero[0][2].equals(jugador)
                && tablero[1][1].equals(jugador)
                && tablero[2][0].equals(jugador)) {
            return true;
        }
        return false;
    }

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
