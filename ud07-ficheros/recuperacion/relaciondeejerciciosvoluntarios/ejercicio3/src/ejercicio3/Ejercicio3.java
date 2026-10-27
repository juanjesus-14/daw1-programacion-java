/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio 3 – Escribir líneas en un fichero
//        Crear un programa que:
//            1. Pida por teclado el nombre de 5 alumnos.
//            2. Los guarde en alumnos.txt.
//            3. Cada alumno en una línea diferente.
//            4. Preguntar si quiere sobrescribir o añadir contenido ¿?.
        // Scanner para leer datos del teclado
        
        Scanner sc = new Scanner(System.in);

        try {

            // Preguntamos si quiere sobrescribir o añadir contenido
            System.out.println("¿Sobrescribir (s) o añadir (a)?");

            String opcion = sc.nextLine();

            // Variable para activar el modo append
            boolean modoAnadir = false;

            // Si el usuario escribe "a" se añadirá al final del fichero
            if (opcion.equalsIgnoreCase("a")) {
                modoAnadir = true;
            }

            // Creamos el FileWriter (true = añadir contenido)
            FileWriter fw = new FileWriter("alumnos.txt", modoAnadir);

            // Pedimos el nombre de 5 alumnos
            for (int i = 1; i <= 5; i++) {

                System.out.print("Alumno " + i + ": ");

                String nombre = sc.nextLine();

                // Guardamos el nombre en el fichero
                fw.write(nombre + "\n");

            }

            // Cerramos el fichero
            fw.close();

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {

            // Error si ocurre algún problema al escribir
            System.out.println("Error al escribir en el fichero");

        }

    }
}
