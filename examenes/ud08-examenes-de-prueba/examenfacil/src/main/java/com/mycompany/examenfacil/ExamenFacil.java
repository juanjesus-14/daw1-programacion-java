/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenfacil;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author juand
 */
public class ExamenFacil {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        ArrayList<Alumno> lista = new ArrayList<>();

        System.out.println(Utils.cargaDatos(lista));
        Utils.listaAlumnos(lista);

        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = Utils.obtenNumeroEntero(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opcion) {
                case 1:
                    ArrayList<Alumno> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listaAlumnos(listaTemp);
                    break;
                case 2:
                    System.out.println(Utils.insertarAlumno(br, lista));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n-- MENÚ --");
        System.out.println("1.- Listar alumnos");
        System.out.println("2.- Insertar nuevo alumno");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
