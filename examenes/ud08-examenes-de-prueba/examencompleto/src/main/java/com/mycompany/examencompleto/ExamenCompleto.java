/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examencompleto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class ExamenCompleto {

    public static void main(String[] args) {
        // ArrayList compartido en toda la sesión
        ArrayList<Jugador> lista = new ArrayList<>();

        // Carga inicial desde la BBDD
        System.out.println(Utils.cargaDatos(lista));
        Utils.listarJugadores(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Recarga desde BBDD en lista temporal para no duplicar
                    ArrayList<Jugador> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listarJugadores(listaTemp);
                    break;
                case 2:
                    // Insertar nuevo empleado
                    Utils.insertarJugador(sc, lista);
                    break;
                case 3:
                    // Insertar pareja a empleado existente
                    Utils.insertarContrato(sc, lista);
                    break;
                case 4:
                    // Insertar nuevo empleado
                    Utils.modificarJugador(lista);
                    break;
                case 5:
                    // Insertar pareja a empleado existente
                    Utils.eliminarJugador(lista);
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
        System.out.println("1.- Listar jugadores");
        System.out.println("2.- Insertar nuevo jugador");
        System.out.println("3.- Insertar contrato a un jugador");
        System.out.println("4.- Modificar jugador");
        System.out.println("5.- Eliminar jugador");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
