/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author juand
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Ejercicio 1 – Crear y comprobar fichero
//            Crear un programa que:
//                1. Compruebe si existe un fichero llamado alumnos.txt.
//                2. Si no existe, lo cree.
//                3. Muestre:
//                    ◦ Ruta absoluta
//                    ◦ Tamaño en bytes
//                    ◦ Si tiene permisos de lectura y escritura
//                            
//               Usar: File
//        
        // Creamos un objeto File que representa el fichero alumnos.txt
        File fichero = new File("alumnos.txt");

        try {

            // Comprobamos si el fichero existe
            if (!fichero.exists()) {

                // Si no existe lo creamos
                fichero.createNewFile();
                System.out.println("Fichero creado.");

            } else {

                // Si ya existe mostramos un mensaje
                System.out.println("El fichero ya existe.");
            }

            // Mostramos la ruta absoluta del fichero
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());

            // Mostramos el tamaño del fichero en bytes
            System.out.println("Tamaño: " + fichero.length());

            // Comprobamos si se puede leer
            System.out.println("Permiso lectura: " + fichero.canRead());

            // Comprobamos si se puede escribir
            System.out.println("Permiso escritura: " + fichero.canWrite());

        } catch (IOException e) {

            // Si ocurre algún error al crear el fichero
            System.out.println("Error al crear el fichero");

        }

    }
}
