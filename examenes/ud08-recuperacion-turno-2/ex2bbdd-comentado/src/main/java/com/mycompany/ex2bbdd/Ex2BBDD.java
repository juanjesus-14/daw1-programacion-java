package com.mycompany.ex2bbdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Ex2BBDD — clase PRINCIPAL (Main).
 *
 * Estructura idéntica al Examen 1, solo cambian:
 * - El tipo del ArrayList: ArrayList<Ordenador> en lugar de ArrayList<Empleado>
 * - Los métodos de Utils que se llaman
 * - Las opciones del menú
 */
public class Ex2BBDD {

    public static void main(String[] args) {

        // ArrayList compartido durante toda la sesión
        ArrayList<Ordenador> listaOrdenador = new ArrayList<>();

        // Carga inicial — SELECT en BBDD → llena listaOrdenador
        System.out.println(UtilsEx2.cargaDatos(listaOrdenador));
        UtilsEx2.listaOrdenador(listaOrdenador);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = UtilsEx2.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Listar: usamos lista TEMPORAL para no duplicar los datos
                    // Si usáramos listaOrdenador, cada vez que listamos
                    // se añadirían los mismos ordenadores otra vez
                    ArrayList<Ordenador> listaOrdenadorTemp = new ArrayList<>();
                    UtilsEx2.cargaDatos(listaOrdenadorTemp);
                    UtilsEx2.listaOrdenador(listaOrdenadorTemp);
                    break;

                case 2:
                    // Insertar ordenador — solo recibe Scanner
                    // No actualiza listaOrdenador en memoria (versión simplificada)
                    // Para ver el nuevo ordenador hay que usar la opción 1
                    UtilsEx2.insertarOrdenador(sc);
                    break;

                case 3:
                    // Insertar garantía — INSERT en garantia + UPDATE en equipos
                    UtilsEx2.insertarGarantia(sc);
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
        System.out.println("1.- Listar los Equipos");
        System.out.println("2.- Insertar nuevo Ordenador");
        System.out.println("3.- Insertar nueva Garantía");
        System.out.println("0.- Salir");
        System.out.print("Opción:");
    }
}
