/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej8.pkg3;

/**
 *
 * @author juand
 */
public class Ej83 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores)        
        // Ejercicio 8: Programa que a parƟr de los datos introducidos por el usuario (una temperatura
        // media para cada mes introducidos en formato 9;10;12;14;15;16;20;22;20;19;14;12 – usa split)
        // pinta un diagrama de barras con la temperatura media de cada mes del año. Por ejemplo
        // puedes utilizar para ello una matriz. (recomendado – nivel 3 puntos).    

        System.out.println("Introduce las temperaturas medias de los 12 meses separadas por ;");
        String entrada = System.console().readLine();
        String[] temperaturas = entrada.split(";");
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        if (temperaturas.length != 12) {
            System.out.println("No has introducido los datos de los 12 meses.");
        } else {

            // =====================================
            // SOLUCION 1 - BARRAS HORIZONTALES
            // =====================================
            System.out.println("\nDIAGRAMA HORIZONTAL:");
            for (int i = 0; i < 12; i++) {
                System.out.print(meses[i] + ": ");
                int temperatura = Integer.parseInt(temperaturas[i]);
                for (int j = 0; j < temperatura; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }

            // =====================================
            // SOLUCION 2 - BARRAS VERTICALES
            // =====================================
            int maxTemp = Integer.parseInt(temperaturas[0]);

            // Buscar temperatura máxima
            for (int i = 1; i < temperaturas.length; i++) {
                if (Integer.parseInt(temperaturas[i]) > maxTemp) {
                    maxTemp = Integer.parseInt(temperaturas[i]);
                }
            }
            System.out.println("\nDIAGRAMA VERTICAL:");

            // Dibujar niveles
            for (int nivel = maxTemp; nivel > 0; nivel--) {
                for (int i = 0; i < temperaturas.length; i++) {
                    if (Integer.parseInt(temperaturas[i]) >= nivel) {
                        System.out.print(" *  ");
                    } else {
                        System.out.print("    ");
                    }
                }
                System.out.println("");
            }

            // Dibujar nombres de los meses
            for (int i = 0; i < meses.length; i++) {
                System.out.print(meses[i] + "|");
            }
            System.out.println("");
        }
    }
}
