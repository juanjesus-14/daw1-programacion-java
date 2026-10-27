/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ex2bbdd;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2BBDD {

    public static void main(String[] args) {

        // ArrayList compartido en toda la sesión
        ArrayList<Ordenador> listaOrdenador = new ArrayList<>();

        // Carga inicial desde la BBDD
        System.out.println(UtilsEx2.cargaDatos(listaOrdenador));
        UtilsEx2.listaOrdenador(listaOrdenador);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = UtilsEx2.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Lista temporal para no duplicar
                    ArrayList<Ordenador> listaOrdenadorTemp = new ArrayList<>();
                    UtilsEx2.cargaDatos(listaOrdenadorTemp);
                    UtilsEx2.listaOrdenador(listaOrdenadorTemp);
                    break;
                case 2:
                    // Solo recibe Scanner — no actualiza el ArrayList
                    UtilsEx2.insertarOrdenador(sc);
                    break;
                case 3:
                    // Solo recibe Scanner — no actualiza el ArrayList
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