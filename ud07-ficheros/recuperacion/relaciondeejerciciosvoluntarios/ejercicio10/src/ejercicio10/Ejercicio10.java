/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10;

import java.io.*;

/**
 *
 * @author juand
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Ejercicio 10
//        Dado un fichero con números (uno por línea):
//            1. Crear dos ficheros nuevos:
//                o pares.txt
//                o impares.txt
//            2. Guardar cada número donde corresponda.

        
    try {

            // Abrimos fichero de números
            BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));

            // Ficheros para pares e impares
            FileWriter pares = new FileWriter("pares.txt");
            FileWriter impares = new FileWriter("impares.txt");

            String linea;

            while ((linea = br.readLine()) != null) {

                // Convertimos texto a número
                int num = Integer.parseInt(linea);

                // Si el número es par
                if (num % 2 == 0) {

                    pares.write(num + "\n");

                } else {

                    impares.write(num + "\n");
                }
            }

            br.close();
            pares.close();
            impares.close();

        } catch (IOException e) {

            System.out.println("Error al procesar el fichero");
        }
    }
}