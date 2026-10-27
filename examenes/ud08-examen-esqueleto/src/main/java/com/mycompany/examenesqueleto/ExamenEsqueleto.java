/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenesqueleto;

import java.util.*;

/**
 *
 * @author juand
 */
public class ExamenEsqueleto {

    public static void main(String[] args) {
        // 1. Crear ArrayList
        ArrayList<Jugador> lista = new ArrayList<>();

        // 2. Carga inicial
        System.out.println(Utils.cargaDatos(lista));
        Utils.listarJugadores(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    ArrayList<Jugador> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listarJugadores(listaTemp);
                    break;
                case 2:
                    Utils.insertarJugador(lista);
                    break;
                case 3:
                    Utils.insertarContrato(lista);
                    break;
                case 4:
                    Utils.modificarJugador(lista);
                    break;
                case 5:
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
        System.out.println("1.- Listar");
        System.out.println("2.- Insertar principal");
        System.out.println("3.- Insertar secundario");
        System.out.println("4.- Modificar");
        System.out.println("5.- Eliminar");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
