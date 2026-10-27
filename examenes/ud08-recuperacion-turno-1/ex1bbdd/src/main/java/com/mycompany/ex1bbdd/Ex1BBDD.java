/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ex1bbdd;

import java.io.*;
import java.util.*;

public class Ex1BBDD {

    public static void main(String[] args) {

        // ArrayList compartido en toda la sesión
        ArrayList<Empleado> lista = new ArrayList<>();

        // Carga inicial desde la BBDD
        System.out.println(UtilsEx1.cargaDatos(lista));
        UtilsEx1.listar(lista);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = UtilsEx1.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Recarga desde BBDD en lista temporal para no duplicar
                    ArrayList<Empleado> listaTemp = new ArrayList<>();
                    System.out.println(UtilsEx1.cargaDatos(listaTemp));
                    UtilsEx1.listar(listaTemp);
                    break;
                case 2:
                    // Insertar nuevo empleado
                    UtilsEx1.insertaEmp(lista);
                    break;
                case 3:
                    // Insertar pareja a empleado existente
                    UtilsEx1.insertaPar(lista);
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
        System.out.println("1.- Listar empleados");
        System.out.println("2.- Insertar nuevo empleado");
        System.out.println("3.- Insertar pareja a un empleado");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
