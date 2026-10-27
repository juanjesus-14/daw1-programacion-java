package com.mycompany.ex3bbdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Ex3BBDD — clase PRINCIPAL (Main).
 *
 * Estructura idéntica a los Exámenes 1 y 2.
 * Solo cambia el tipo del ArrayList y los métodos que se llaman.
 *
 * DIFERENCIA respecto a Examen 2:
 * - insertarElectrodomestico() y insertarCompra() reciben el ArrayList
 *   porque ambos lo actualizan en memoria
 * - En Examen 2, insertarOrdenador() e insertarGarantia() NO recibían lista
 */
public class Ex3BBDD {

    public static void main(String[] args) {

        // ArrayList compartido durante toda la sesión
        ArrayList<Electrodomestico> lista = new ArrayList<>();

        // Carga inicial — SELECT en BBDD → llena lista
        System.out.println(UtilsEx3.cargaDatos(lista));
        UtilsEx3.listar(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = UtilsEx3.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Lista temporal para no duplicar al recargar
                    ArrayList<Electrodomestico> listaTemp = new ArrayList<>();
                    System.out.println(UtilsEx3.cargaDatos(listaTemp));
                    UtilsEx3.listar(listaTemp);
                    break;

                case 2:
                    // Insertar electrodoméstico — recibe lista para añadirlo en memoria
                    UtilsEx3.insertarElectrodomestico(sc, lista);
                    break;

                case 3:
                    // Insertar compra — recibe lista para actualizarla en memoria
                    UtilsEx3.insertarCompra(sc, lista);
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
        System.out.println("2.- Insertar nuevo electrodoméstico");
        System.out.println("3.- Insertar compra a un electrodoméstico");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
