package com.mycompany.ex1bbdd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Ex1BBDD — clase PRINCIPAL (Main).
 * 
 * Es el punto de entrada de la aplicación.
 * Solo se encarga de:
 *   1. Crear el ArrayList
 *   2. Cargar datos iniciales
 *   3. Mostrar el menú en bucle
 *   4. Llamar a los métodos de UtilsEx1 según la opción elegida
 * 
 * TODA la lógica está en UtilsEx1, aquí solo orquestamos.
 */
public class Ex1BBDD {

    public static void main(String[] args) {

        // ArrayList compartido durante toda la sesión del programa
        // Aquí guardamos los empleados cargados de la BBDD
        // y se va actualizando cuando insertamos nuevos
        ArrayList<Empleado> lista = new ArrayList<>();

        // ── Carga inicial ────────────────────────────────────────────
        // Llama a cargaDatos() que hace SELECT en la BBDD y llena 'lista'
        // Devuelve un String con el informe → lo mostramos con println
        System.out.println(UtilsEx1.cargaDatos(lista));

        // Mostramos todos los empleados cargados
        UtilsEx1.listar(lista);

        // ── Menú principal ───────────────────────────────────────────
        Scanner sc = new Scanner(System.in);
        int opcion = -1; // -1 para que entre al do-while la primera vez

        do {
            mostrarMenu();

            // sc.nextLine() → lee lo que escribe el usuario como String
            // obtenNumeroEntero() → lo convierte a int con validación
            opcion = UtilsEx1.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Listar: recargamos desde BBDD en una lista TEMPORAL
                    // No usamos 'lista' para no duplicar los empleados ya cargados
                    ArrayList<Empleado> listaTemp = new ArrayList<>();
                    System.out.println(UtilsEx1.cargaDatos(listaTemp));
                    UtilsEx1.listar(listaTemp);
                    break;

                case 2:
                    // Insertar empleado nuevo
                    // Pasamos 'lista' para que el método lo añada también en memoria
                    UtilsEx1.insertaEmp(lista);
                    break;

                case 3:
                    // Insertar pareja a un empleado existente
                    // Pasamos 'lista' para actualizar el objeto en memoria
                    UtilsEx1.insertaPar(lista);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    // Cualquier número que no sea 0, 1, 2 o 3
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0); // repetimos hasta que el usuario elija 0

        sc.close(); // cerramos el Scanner al salir
    }

    /**
     * Muestra las opciones del menú por pantalla.
     * Método separado para no ensuciar el main con printlns.
     */
    public static void mostrarMenu() {
        System.out.println("\n-- MENÚ --");
        System.out.println("1.- Listar empleados");
        System.out.println("2.- Insertar nuevo empleado");
        System.out.println("3.- Insertar pareja a un empleado");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
