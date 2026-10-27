/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.io.*;

/**
 *
 * @author juand
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio 4 – Leer fichero completo
//        Leer el contenido de alumnos.txt y mostrarlo por pantalla línea a línea.

try {
            // Abrimos el fichero alumnos.txt para lectura
            BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));

            // Variable para guardar cada línea
            String linea;

            // Leemos el fichero línea a línea
            while ((linea = br.readLine()) != null) {

                // Mostramos la línea por pantalla
                System.out.println(linea);
            }

            // Cerramos el fichero
            br.close();

        } catch (IOException e) {

            // Mensaje si ocurre algún error
            System.out.println("Error al leer el fichero");

        }
    }
}
