/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9;

import java.io.*;

/**
 *
 * @author juand
 */
public class Ejercicio9 {

    public static void main(String[] args) {

//        Ejercicio 9 – Copiar fichero
//        Crear un programa que:
//            1. Pida ruta de origen
//            2. Pida ruta destino
//            3. Copie el contenido

        // Pedimos las rutas al usuario
        System.out.print("Ruta origen: ");
        String origen = System.console().readLine();
        System.out.print("Ruta destino: ");
        String destino = System.console().readLine();

        try {
            // Abrimos el fichero origen para lectura
            BufferedReader br = new BufferedReader(new FileReader(origen));
            // Creamos el fichero destino para escritura
            FileWriter fw = new FileWriter(destino);

            String linea;
            // Copiamos línea a línea
            while ((linea = br.readLine()) != null) {
                fw.write(linea + "\n");
            }

            br.close();
            fw.close();

            System.out.println("Fichero copiado correctamente.");

        } catch (FileNotFoundException fnfe) {
            System.out.println("El fichero origen no existe.");
        } catch (IOException e) {
            System.out.println("Error al copiar el fichero: " + e.getMessage());
        }
    }
}