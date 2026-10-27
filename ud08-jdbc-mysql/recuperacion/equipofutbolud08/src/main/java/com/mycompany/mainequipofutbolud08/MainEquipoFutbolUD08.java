package com.mycompany.mainequipofutbolud08;

import java.util.LinkedList;
import java.util.Scanner;

public class MainEquipoFutbolUD08 {

    public static void main(String[] args) {

        // LinkedList en memoria — se usa durante toda la sesión
        LinkedList<Jugador> lista = new LinkedList<>();
        Scanner sc     = new Scanner(System.in);
        int     opcion = -1;

        // 1) Leemos el fichero y cargamos la LinkedList
        System.out.println(Utils.leerFichero(lista, "equiposFutbol.txt"));

        // 2) Insertamos los datos del fichero en la BBDD
        // Solo inserta los que no existen ya — evita duplicados
        System.out.println(Utils.insertarFicheroEnBBDD(lista));

        // 3) Menú principal
        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Alta — pide datos, inserta en BBDD y añade al LinkedList
                    System.out.println(Utils.altaJugador(sc, lista));
                    break;
                case 2:
                    // Baja — elimina de BBDD y del LinkedList
                    System.out.println(Utils.bajaJugador(sc, lista));
                    break;
                case 3:
                    // Listado — lee directamente de la BBDD
                    Utils.listarJugadores();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n-- MENÚ --");
        System.out.println("1.- Alta jugador");
        System.out.println("2.- Baja jugador");
        System.out.println("3.- Listado jugadores");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
