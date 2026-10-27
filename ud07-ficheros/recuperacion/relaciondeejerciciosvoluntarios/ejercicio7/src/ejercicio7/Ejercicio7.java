/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio7 {

    public static void main(String[] args) {

//        Ejercicio 7 – Agenda básica
//        Crear una agenda que permita:
//            1. Añadir contacto (nombre;telefono)
//            2. Buscar contacto por nombre
//            3. Mostrar todos los contactos
//            4. Guardar los datos en agenda.txt
//        Menú por consola con bucle do-while.
        int opcion;
        do {
            System.out.println("\n===== AGENDA =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Mostrar contactos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    añadirContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    mostrarContactos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    // ---- AÑADIR CONTACTO ----
    public static void añadirContacto() {
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Teléfono: ");
        String telefono = System.console().readLine();

        try {
            // true → append, no borra lo que ya hay
            FileWriter fw = new FileWriter("agenda.txt", true);
            fw.write(nombre + ";" + telefono + "\n");
            fw.close();
            System.out.println("Contacto guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el contacto: " + e.getMessage());
        }
    }

    // ---- BUSCAR CONTACTO ----
    public static void buscarContacto() {
        System.out.print("Nombre a buscar: ");
        String buscar = System.console().readLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("agenda.txt"));
            String linea;
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                // Comprobamos si la línea contiene el nombre buscado
                if (linea.toLowerCase().contains(buscar.toLowerCase())) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            br.close();

            if (!encontrado) {
                System.out.println("No se encontró ningún contacto con ese nombre.");
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay contactos guardados todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer la agenda: " + e.getMessage());
        }
    }

    // ---- MOSTRAR CONTACTOS ----
    public static void mostrarContactos() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("agenda.txt"));
            String linea;

            System.out.println("\n--- CONTACTOS ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay contactos guardados todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer la agenda: " + e.getMessage());
        }
    }

}
