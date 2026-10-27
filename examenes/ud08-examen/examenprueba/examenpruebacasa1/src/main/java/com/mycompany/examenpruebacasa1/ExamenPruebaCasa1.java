/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenpruebacasa1;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class ExamenPruebaCasa1 {

    public static void main(String[] args) {
        //Probar conexionBBDD
        Connection cn = Conexion.creaConexion();

        if (cn != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No conectado");
        }

        // Crear instituto
        Instituto instituto = new Instituto("IES Salduba");

        // Crear alumnos
        Alumno a1 = new Alumno(1, "12345678A", "Juan");

        Alumno a2 = new Alumno(2, "87654321B", "Lucia");

        Alumno a3 = new Alumno(3, "11111111C", "Pepe");

        // Insertar alumnos
        instituto.insertaAlumno(a1);
        instituto.insertaAlumno(a2);
        instituto.insertaAlumno(a3);

        // Mostrar alumnos
        instituto.listaAlumnos();

        ArrayList<Alumno> listaAlumno = new ArrayList<>();

        Utils.cargaDatos(listaAlumno);

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            mostrarMenu();
            opcion = Utils.obtenNumeroEntero(sc.nextLine());
            switch (opcion) {
                case 1:
                    Utils.listaAlumnos(listaAlumno);
                    break;
                case 2:
                    Alumno a = new Alumno(1, "12345678A", "Juan");
                    listaAlumno.add(a);
                    System.out.println("Alumno insertado");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {

        System.out.println();
        System.out.println("1. Listar alumnos");
        System.out.println("2. Insertar alumno");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }
}
