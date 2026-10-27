/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8;

import java.io.*;
import java.time.LocalDateTime;

/**
 *
 * @author juand
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Ejercicio 8 – Registro de logs
//        Simular un sistema que:
//            1. Cada vez que se ejecute el programa
//            2. Añada una línea al fichero log.txt con:
//            3. Fecha y hora - Usuario - Acción realizada
//        Usar LocalDateTime + FileWriter en modo append (FileWriter fw = new FileWriter("datos.txt", true);).

          try {

            // Abrimos el fichero log.txt en modo añadir
            FileWriter fw = new FileWriter("log.txt", true);

            // Obtener usuario del sistema
            String usuario = System.getProperty("user.name");

            // Obtener fecha y hora actual
            LocalDateTime fecha = LocalDateTime.now();

            // Guardar log en el fichero
            fw.write(fecha + " - " + usuario + " - Programa ejecutado\n");

            fw.close();

        } catch (IOException e) {

            System.out.println("Error al escribir el log");
        }
    }
}