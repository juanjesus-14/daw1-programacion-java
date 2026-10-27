/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6;

import java.io.*;

/**
 *
 * @author juand
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio 6 – Contador de líneas, palabras y caracteres
//        Crear un programa que:
//            1. Lea un fichero texto.txt
//            2. Muestre:
//                o Número de líneas
//                o Número de palabras
//                o Número total de caracteres
   
// Contadores
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;

        try {

            // Abrimos el fichero texto.txt
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));

            String linea;

            // Mientras haya líneas
            while ((linea = br.readLine()) != null) {

                // Contamos una línea
                lineas++;

                // Sumamos caracteres
                caracteres += linea.length();

                // Separamos la línea en palabras
                String[] partes = linea.split(" ");

                // Sumamos las palabras
                palabras += partes.length;
            }

            br.close();

            // Mostramos resultados
            System.out.println("Numero de lineas: " + lineas);
            System.out.println("Numero de palabras: " + palabras);
            System.out.println("Numero de caracteres: " + caracteres);

        } catch (IOException e) {

            System.out.println("Error al leer el fichero");
        }
    }
}
