/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej29_tiendavideojuegos;

/**
 *
 * @author juand
 */
public class Ej29_TiendaVideojuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inventario [nombre][stock]
        String[][] inventario = {
            {"Marvel's Spider-Man 2", "12"},
            {"God of War: Ragnarök", "8"},
            {"Horizon Forbidden West", "5"},
            {"Final Fantasy XVI", "9"},
            {"The Last of Us Part I", "6"},
            {"Gran Turismo 7", "7"},
            {"Demon's Souls Remake", "4"},
            {"Resident Evil 4 Remake", "10"},
            {"Elden Ring", "3"},
            {"Assassin's Creed Mirage", "11"}
        };

        int opcion;

        do {

            System.out.println("\n===== TIENDA GAME =====");
            System.out.println("1. Alquilar juego");
            System.out.println("2. Devolver juego");
            System.out.println("3. Mostrar inventario");
            System.out.println("0. Salir");

            do {
                System.out.println("Seleccione una opción:");
                opcion = rangoCorrecto(System.console().readLine(), 0, 3);
            } while (opcion == -1);

            switch (opcion) {

                case 1:
                    mostrarInventario(inventario);
                    int alquilar;
                    do {
                        System.out.println("Número del juego a alquilar:");
                        alquilar = rangoCorrecto(System.console().readLine(), 1, inventario.length);
                    } while (alquilar == -1);
                    alquilarJuego(inventario, alquilar - 1);
                    break;

                case 2:
                    mostrarInventario(inventario);
                    int devolver;
                    do {
                        System.out.println("Número del juego a devolver:");
                        devolver = rangoCorrecto(System.console().readLine(), 1, inventario.length);
                    } while (devolver == -1);
                    devolverJuego(inventario, devolver - 1);
                    break;

                case 3:
                    mostrarInventario(inventario);
                    break;

                case 0:
                    System.out.println("Fin del programa.");
                    break;

            }
        } while (opcion != 0);
    }

    // Mostrar inventario
    public static void mostrarInventario(String[][] inventario) {
        System.out.println("\n----- INVENTARIO -----");
        for (int i = 0; i < inventario.length; i++) {
            System.out.println((i + 1) + ". " + inventario[i][0] + " | Stock: " + inventario[i][1]);
        }
    }

    // Alquilar juego
    public static void alquilarJuego(String[][] inventario, int posicion) {
        int stock = Integer.parseInt(inventario[posicion][1]);
        if (stock > 0) {
            stock--;
            inventario[posicion][1] = String.valueOf(stock);
            System.out.println("Juego alquilado correctamente.");
        } else {
            System.out.println("No hay stock disponible.");
        }
    }

    // Devolver juego
    public static void devolverJuego(String[][] inventario, int posicion) {
        int stock = Integer.parseInt(inventario[posicion][1]);
        stock++;
        inventario[posicion][1] = String.valueOf(stock);
        System.out.println("Juego devuelto correctamente.");
    }

    // Control de errores y rango
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
