/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenpractica;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class ExamenPractica {

    public static void main(String[] args) {

        // Inicio ejercicio
        System.out.println("------Inicio Ejercicio------");

        // Variable donde guardaremos
        // cada línea del fichero
        String linea = "";

        // Contador de líneas
        int contLinea = 0;

        // ArrayList donde almacenaremos
        // todas las categorías
        ArrayList<Categoria> listaCategorias = new ArrayList<>();

        // Ruta del fichero
        String ruta = "D:\\workspace\\programacion\\UD7\\EXAMEN\\ExamenPractica\\productos5-26.txt";

        try {

            // Apertura del fichero para lectura
            BufferedReader br = new BufferedReader(new FileReader(ruta));

            // Mostrar título
            System.out.println("Datos del fichero:");

            // Leer primera línea
            linea = br.readLine();

            // Mientras existan líneas
            while (linea != null) {

                // Mostrar línea
                System.out.println(linea);

                // Crear categorías y productos
                Utils.creaCatYProd(linea, listaCategorias, contLinea);

                // Leer siguiente línea
                linea = br.readLine();

                // Incrementar contador
                contLinea++;
            }

            // Cerrar fichero
            br.close();

        } catch (FileNotFoundException fnfe) {

            // Error si no existe fichero
            System.out.println("Fichero no encontrado");

        } catch (IOException ioe) {

            // Error lectura
            System.out.println("Error de lectura");

        } catch (Exception e) {

            // Error inesperado
            System.out.println("Error inesperado");
        }

    }

}
