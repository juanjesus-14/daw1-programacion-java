/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Ex1 {

    public static void main(String[] args) {
        // ArrayList donde se almacenan los ordenadores
        ArrayList<Ordenador> listaOrdenador = new ArrayList<>();

        // Carga los datos desde la BD o fichero
        System.out.println(Utils.cargaDatos(listaOrdenador));

        // Muestra los ordenadores cargados
        Utils.listaOrdenador(listaOrdenador);

        // Scanner para leer datos por teclado
        Scanner sc = new Scanner(System.in);

        // Variable para guardar la opción elegida
        int opcion = -1;
        boolean correcto = false;

        // Menú principal
        do {
            // Muestra las opciones disponibles
            mostrarMenu();
            // Lee la opción introducida por el usuario
            opcion = Utils.obtenNumeroEntero(sc.nextLine());
            System.out.println(opcion);

            switch (opcion) {
                case 1:
                    // Crear lista temporal
                    ArrayList<Ordenador> listaOrdenadorTemp = new ArrayList<>();
                    // Cargar datos actualizados
                    Utils.cargaDatos(listaOrdenadorTemp);
                    // Mostrar todos los ordenadores
                    Utils.listaOrdenador(listaOrdenadorTemp);
                    break;
                case 2:
                    // Insertar un nuevo ordenador
                    Utils.insertarOrdenador(sc);
                    break;
                case 3:
                    // Insertar una nueva garantía
                    Utils.insertarGarantia(sc);
                    break;
                case 0:
                    // Salir de la aplicación
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
        // Cierra el Scanner
        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("1.- Listar los Equipos");
        System.out.println("2.- Insertar nuevo Ordenador");
        System.out.println("3.- Insertar nueva Garantía"); // 
        System.out.println("0.- Salir");
        System.out.print("Opción:");
    }
}
