/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casacontodo;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class CasaConTodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> equipos = new ArrayList<>();

        // Columna 0 = puntos
        int[][] resultados = new int[20][1];
        int opcion;

        do {

            System.out.println("\n===== TORNEO DE FÚTBOL =====");
            System.out.println("1. Añadir equipo");
            System.out.println("2. Introducir puntos");
            System.out.println("3. Mostrar clasificación");
            System.out.println("4. Equipo con más puntos");
            System.out.println("5. Buscar equipo");
            System.out.println("0. Salir");

            opcion = rangoCorrecto(System.console().readLine(), 0, 5);

            switch (opcion) {
                case 1:
                    añadirEquipo(equipos);
                    break;
                case 2:
                    introducirPuntos(equipos, resultados);
                    break;
                case 3:
                    mostrarClasificacion(equipos, resultados);
                    break;
                case 4:
                    equipoMasPuntos(equipos, resultados);
                    break;
                case 5:
                    buscarEquipo(equipos, resultados);
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
            }
        } while (opcion != 0);
    }

    // Añadir equipo
    public static void añadirEquipo(ArrayList<String> equipos) {
        System.out.println("Nombre del equipo:");
        String nombre = System.console().readLine();
        equipos.add(nombre);
        System.out.println("Equipo añadido.");
    }

    // Introducir puntos
    public static void introducirPuntos(
            ArrayList<String> equipos,
            int[][] resultados) {

        System.out.println("Equipo:");
        String nombre = System.console().readLine();
        boolean encontrado = false;

        for (int i = 0; i < equipos.size(); i++) {
            if (nombre.equalsIgnoreCase(equipos.get(i))) {
                encontrado = true;
                System.out.println("Puntos a sumar:");
                int puntos = Integer.parseInt(System.console().readLine());
                resultados[i][0] += puntos;
                System.out.println("Puntos actualizados.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Equipo no encontrado.");
        }
    }

    // Mostrar clasificación
    public static void mostrarClasificacion(
            ArrayList<String> equipos,
            int[][] resultados) {

        System.out.println("\n===== CLASIFICACIÓN =====");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i) + " -> " + resultados[i][0] + " puntos");
        }
    }

    // Equipo con más puntos
    public static void equipoMasPuntos(
            ArrayList<String> equipos,
            int[][] resultados) {

        if (equipos.isEmpty()) {
            System.out.println("No hay equipos.");
            return;
        }

        int posMax = 0;
        for (int i = 1; i < equipos.size(); i++) {
            if (resultados[i][0] > resultados[posMax][0]) {
                posMax = i;
            }
        }

        System.out.println("Equipo líder: " + equipos.get(posMax));
        System.out.println("Puntos: " + resultados[posMax][0]);
    }

    // Buscar equipo
    public static void buscarEquipo(
            ArrayList<String> equipos,
            int[][] resultados) {

        System.out.println("Nombre del equipo:");
        String nombre = System.console().readLine();
        boolean encontrado = false;

        for (int i = 0; i < equipos.size(); i++) {
            if (nombre.equalsIgnoreCase(equipos.get(i))) {
                System.out.println(equipos.get(i) + " -> " + resultados[i][0] + " puntos");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Equipo no encontrado.");
        }
    }

    // Control errores
    public static int rangoCorrecto(String texto, int min, int max) {
        int numero;
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto.");
            return -1;
        }
        if (numero < min || numero > max) {
            System.out.println("Fuera de rango.");
            return -1;
        }
        return numero;
    }
}
