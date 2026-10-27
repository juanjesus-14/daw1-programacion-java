/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casanivel1b;

/**
 *
 * @author juand
 */
public class CasaNivel1B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ==========================
        // ARRAY DE NOMBRES
        // ==========================
        String[] nombres = {"Juan", "Pedro", "Ana", "Manuel", "Lucia", "Juan", "Sergio", "Eva", "Antonio", "Ana"};

        // ==========================
        // MOSTRAR TODOS LOS NOMBRES
        // ==========================
        System.out.println("----- TODOS LOS NOMBRES -----");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println((i + 1) + ". " + nombres[i]);
        }

        // ==========================
        // MÁS LARGO Y MÁS CORTO
        // ==========================
        String masLargo = nombres[0];
        String masCorto = nombres[0];
        int posLargo = 0;
        int posCorto = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].length() > masLargo.length()) {
                masLargo = nombres[i];
                posLargo = i;
            }
            if (nombres[i].length() < masCorto.length()) {
                masCorto = nombres[i];
                posCorto = i;
            }
        }
        System.out.println("\n----- ESTADÍSTICAS -----");
        System.out.println("Nombre más largo: " + masLargo);
        System.out.println("Posición: " + posLargo);
        System.out.println("Nombre más corto: " + masCorto);
        System.out.println("Posición: " + posCorto);

        // ==========================
        // BUSCAR NOMBRE
        // ==========================
        System.out.println("\nNombre a buscar:");
        String buscar = System.console().readLine();
        boolean encontrado = false;
        int veces = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (buscar.equalsIgnoreCase(nombres[i])) {
                encontrado = true;
                veces++;
                System.out.println("Encontrado en posición: " + i);
            }
        }
        if (encontrado) {
            System.out.println("Aparece " + veces + " veces.");
        } else {
            System.out.println("No existe.");
        }

        // ==========================
        // ORDENAR ALFABÉTICAMENTE
        // ==========================
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                if (nombres[i].compareToIgnoreCase(nombres[j]) > 0) {
                    String aux = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = aux;
                }
            }
        }

        // ==========================
        // MOSTRAR ORDENADOS
        // ==========================
        System.out.println("\n----- NOMBRES ORDENADOS -----");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }

        // ==========================
        // NOMBRES CON MÁS DE 5 LETRAS
        // ==========================
        System.out.println("\n----- MÁS DE 5 LETRAS -----");
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].length() > 5) {
                System.out.println(nombres[i]);
            }
        }

        // ==========================
        // EMPIEZAN POR A
        // ==========================
        System.out.println("\n----- EMPIEZAN POR A -----");
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].toUpperCase().startsWith("A")) {
                System.out.println(nombres[i]);
            }
        }

        // ==========================
        // NOMBRES AL REVÉS (ARRAY)
        // ==========================
        System.out.println("\n----- NOMBRES AL REVÉS -----");
        for (int i = nombres.length - 1; i >= 0; i--) {
            System.out.println(nombres[i]);
        }

        // ==========================
        // CONTAR VOCALES
        // ==========================
        int vocales = 0;
        for (int i = 0; i < nombres.length; i++) {
            String palabra = nombres[i].toLowerCase();
            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    vocales++;
                }
            }
        }
        System.out.println("\nTotal vocales: " + vocales);

        // ==========================
        // CONTAR CONSONANTES
        // ==========================
        int consonantes = 0;
        for (int i = 0; i < nombres.length; i++) {
            String palabra = nombres[i].toLowerCase();
            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                if (Character.isLetter(letra) && letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                    consonantes++;
                }
            }
        }
        System.out.println("Total consonantes: " + consonantes);

        // ==========================
        // TOTAL DE LETRAS
        // ==========================
        int totalLetras = 0;
        for (int i = 0; i < nombres.length; i++) {
            totalLetras += nombres[i].length();
        }
        System.out.println("Total letras: " + totalLetras);

        // ==========================
        // PRIMERA Y ÚLTIMA ALFABÉTICAMENTE
        // ==========================
        System.out.println("\nPrimera alfabéticamente: " + nombres[0]);
        System.out.println("Última alfabéticamente: " + nombres[nombres.length - 1]);

        // ==========================
        // PEDIR NOMBRE Y MOSTRARLO AL REVÉS
        // ==========================
        System.out.println("\nIntroduce un nombre:");
        String nombreUsuario = System.console().readLine();
        System.out.print("Nombre al revés: ");
        for (int i = nombreUsuario.length() - 1; i >= 0; i--) {
            System.out.print(nombreUsuario.charAt(i));
        }
        System.out.println();
    }
}
