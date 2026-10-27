/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.io.*;

/**
 *
 * @author juand
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
//        Ejercicio 2: Crea un programa en Java que permita leer el contenido de un archivo de texto llamado notas.txt, 
//        que contiene una lista de nombres y notas (por ejemplo: "Laura 8.5"). El programa debe mostrar cada línea por 
//        pantalla, y al final debe imprimir el número total de líneas leídas.
//        Este programa debe manejar al menos las siguientes posibles excepciones en caso de no existir el fichero y en caso de encontrar algún error en su lectura.
//        El archivo notas.txt podría tener un contenido como este:
//        Laura 8.5
//        Carlos 7.2
//        Marta 9.1
//        El programa leerá y mostrará cada línea, y al final imprimirá el total de líneas leídas. La salida sería:
//        Laura 8.5
//        Carlos 7.2
//        Marta 9.1
//        Total de líneas leídas: 3
//        Y si el archivo no existe en la carpeta donde se ejecuta el programa, la salida será:
//        El archivo no se encuentra: notas.txt
//        Supongamos que el archivo existe, pero por alguna razón el sistema tiene problemas al leerlo (por ejemplo, 
//        permisos insuficientes o archivo dañado), la salida en este caso será la siguiente (mostrando el mensaje generado por al error de lectura):
//        Error al leer el archivo: Access denied
//        Nota: puedes cambiar los permisos del archivo a solo lectura para probarlo


        // Variable para contar cuántas líneas se leen
        int contador = 0;

        try {

            // Abrimos el fichero notas.txt para lectura
            BufferedReader br = new BufferedReader(new FileReader("notas.txt"));

            // Variable donde guardaremos cada línea
            String linea;

            // Mientras haya líneas en el fichero
            while ((linea = br.readLine()) != null) {

                // Mostramos la línea por pantalla
                System.out.println(linea);

                // Aumentamos el contador de líneas
                contador++;
            }

            // Cerramos el fichero
            br.close();

            // Mostramos el total de líneas leídas
            System.out.println("Total de líneas leídas: " + contador);

        } catch (FileNotFoundException e) {

            // Error si el fichero no existe
            System.out.println("El archivo no se encuentra: notas.txt");

        } catch (IOException e) {

            // Error si ocurre algún problema al leer el fichero
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }

    }
}