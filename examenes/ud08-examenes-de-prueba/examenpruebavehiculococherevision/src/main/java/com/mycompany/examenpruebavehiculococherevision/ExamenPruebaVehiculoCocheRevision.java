/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenpruebavehiculococherevision;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class ExamenPruebaVehiculoCocheRevision {

    public static void main(String[] args) {
 // 1. Crear ArrayList
        ArrayList<Coche> lista = new ArrayList<>();

        // 2. Carga inicial
        System.out.println(Utils.cargaDatos(lista));
        Utils.listarCoches(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    ArrayList<Coche> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listarCoches(listaTemp);
                    break;
                case 2:
                    Utils.insertarCoche(sc, lista);
                    break;
                case 3:
                    Utils.insertarRevision(sc, lista);
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
        System.out.println("1.- Listar coches");
        System.out.println("2.- Insertar nuevo coche");
        System.out.println("3.- Insertar revision a un coche");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
