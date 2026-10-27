package com.juanjesus.exmanud08;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ExmanUD08 {

    public static void main(String[] args) {

        // ArrayList compartido en toda la sesión
        ArrayList<Electrodomestico> lista = new ArrayList<>();

        // Carga inicial desde la BBDD
        System.out.println(Utils.cargaDatos(lista));
        Utils.listaElectrodomestico(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Vuelve a cargar desde BBDD (usa una lista temporal para no duplicar)
                    ArrayList<Electrodomestico> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listaElectrodomestico(listaTemp);
                    break;

                case 2:
                    // Inserta electrodoméstico y lo añade a lista
                    System.out.println(Utils.insertarElectrodomestico(sc, lista));
                    break;

                case 3:
                    // Inserta compra para un electrodoméstico existente y actualiza lista
                    System.out.println(Utils.insertarCompras(sc, lista));
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
        System.out.println("1.- Listar electrodomésticos");
        System.out.println("2.- Insertar electrodoméstico");
        System.out.println("3.- Insertar fecha de compra");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
