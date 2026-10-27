package com.mycompany.mainsubidanota;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSubidaNota {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Utils.generarLog(sc);
        ArrayList<Persona> lista = new ArrayList<>();
        System.out.println(Utils.cargaDatos(lista));
        Utils.listar(lista);

        int opcion = -1;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    ArrayList<Persona> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listar(listaTemp);
                    break;
                case 2:
                    Utils.insertarPersona(sc, lista);
                    break;
                case 3:
                    Utils.insertarMascota(sc, lista);
                    break;
                case 4:
                    Utils.modificarPersona(sc, lista);
                    break;
                case 5:
                    Utils.eliminarMascota(sc, lista);
                    break;
                case 6:
                    Utils.eliminarPersona(sc, lista);
                    break;
                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n-- MENU --");
        System.out.println("1.- Listar");
        System.out.println("2.- Insertar persona");
        System.out.println("3.- Insertar mascota");
        System.out.println("4.- Modificar persona");
        System.out.println("5.- Eliminar mascota");
        System.out.println("6.- Eliminar persona y sus mascotas");
        System.out.println("0.- Salir");
        System.out.print("Opcion: ");
    }
}
