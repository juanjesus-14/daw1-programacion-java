package mainequipofutbol;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author DAW
 */
public class MainEquipoFutbol {

    public static void main(String[] args) {

        LinkedList<Jugador> lista = new LinkedList<>();
        String rutaFichero = "equiposFutbol.txt";

        Utils.cargaFichero(lista, rutaFichero);

        int opcion;
        do {
            System.out.println("\n======= EQUIPO DE FÚTBOL =======");
            System.out.println("1. Listar jugadores");
            System.out.println("2. Añadir jugador");
            System.out.println("3. Eliminar jugador");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    Utils.listarJugadores(lista);
                    break;
                case 2:
                    Utils.añadirJugador(lista);
                    break;
                case 3:
                    Utils.eliminarJugador(lista);
                    break;
                case 0:
                    Utils.guardarFichero(lista, rutaFichero);
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
