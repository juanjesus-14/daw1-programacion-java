/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author juand
 */
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = UtilsEj3.obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    UtilsEj3.listarAlumnos();
                    break;
                case 2:
                    System.out.println(UtilsEj3.insertarAlumno(sc));
                    break;
                case 3:
                    System.out.println(UtilsEj3.insertarCalificacion(sc));
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
        System.out.println("1.- Listar alumnos y calificaciones");
        System.out.println("2.- Insertar nuevo alumno");
        System.out.println("3.- Insertar calificación");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
