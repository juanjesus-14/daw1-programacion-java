/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1;

/**
 *
 * @author juand
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//ARRAYS UNIDIMENSIONALES (Vectores)
//* Ejercicio 1: Programa que solicita por pantalla hasta 20 frases, finaliza al llegar a 20 o bien al
//escribir Terminar (se recomienda el uso de toLowerCase). Al finalizar muestra las frases que se
//han incluido en el array en diferentes líneas. 

        String[] frases = new String[20];   // Array para almacenar hasta 20 frases
        String texto;    // Variable donde se guardará cada frase introducida
        int contador = 0;  // Contador de frases almacenadas

        // Pedir frases hasta completar el array o escribir "Terminar"
        while (contador < 20) {
            System.out.println("Introduce una frase (o escribe 'Terminar'):");
            texto = System.console().readLine();
            // Comprobar si el usuario quiere finalizar
            if (texto.toLowerCase().equals("terminar")) {
                break;
            }
            // Guardar la frase en el array
            frases[contador] = texto;
            contador++;
        }
        // Mostrar las frases almacenadas
        System.out.println("\nFrases guardadas:");
        for (int i = 0; i < contador; i++) {
            System.out.println(frases[i]);
        }
    }
}
