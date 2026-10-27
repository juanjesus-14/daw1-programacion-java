/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenbiblioteca;

import java.util.*;
import java.io.*;

/**
 *
 * @author juand
 */
public class ExamenBiblioteca {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        ArrayList<Libro> lista = new ArrayList<>();

        System.out.println(Utils.cargaDatos(lista));
        Utils.listaLibros(lista);

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
                    ArrayList<Libro> listaTemp = new ArrayList<>();
                    System.out.println(Utils.cargaDatos(listaTemp));
                    Utils.listaLibros(listaTemp);
                    break;
                case 2:
                    System.out.println(Utils.insertarLibro(br, lista));
                    break;
                case 3:
                    System.out.println(Utils.insertarPrestamo(br, lista));
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
        System.out.println("1.- Listar libros");
        System.out.println("2.- Insertar nuevo libro");
        System.out.println("3.- Insertar préstamo a un libro");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}