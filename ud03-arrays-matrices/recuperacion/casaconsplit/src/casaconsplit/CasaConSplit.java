/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casaconsplit;

/**
 *
 * @author juand
 */
public class CasaConSplit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // =====================================================
        // EJERCICIO 1 - NÚMEROS SEPARADOS POR ;
        // =====================================================
        System.out.println("Introduce números separados por ;");
        String texto = System.console().readLine();
        String[] datos = texto.split(";");

        int mayor = Integer.parseInt(datos[0]);
        int menor = Integer.parseInt(datos[0]);
        int suma = 0;
        int pares = 0;
        int impares = 0;

        System.out.println("\n----- NÚMEROS -----");
        for (int i = 0; i < datos.length; i++) {
            int numero = Integer.parseInt(datos[i]);
            System.out.print(numero + " ");
            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
            suma += numero;
            if (numero % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        double media = (double) suma / datos.length;
        System.out.println("\n\n----- ESTADÍSTICAS -----");
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.printf("Media: %.2f\n", media);
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);

        // Buscar número
        System.out.println("\nNúmero a buscar:");
        int buscarNumero = Integer.parseInt(System.console().readLine());
        int vecesNumero = 0;
        for (int i = 0; i < datos.length; i++) {
            int numero = Integer.parseInt(datos[i]);
            if (numero == buscarNumero) {
                vecesNumero++;
                System.out.println("Encontrado en posición: " + i);
            }
        }
        System.out.println("Aparece " + vecesNumero + " veces.");

        // =====================================================
        // EJERCICIO 2 - FRASE
        // =====================================================
        System.out.println("\n\nIntroduce una frase:");
        String frase = System.console().readLine();
        String[] palabras = frase.split(" ");
        System.out.println("\nCantidad palabras: " + palabras.length);

        // Más larga y más corta
        String masLarga = palabras[0];
        String masCorta = palabras[0];

        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > masLarga.length()) {
                masLarga = palabras[i];
            }
            if (palabras[i].length() < masCorta.length()) {
                masCorta = palabras[i];
            }
        }
        System.out.println("Palabra más larga: " + masLarga);
        System.out.println("Palabra más corta: " + masCorta);

        // Buscar palabra
        System.out.println("\nPalabra a buscar:");
        String buscarPalabra = System.console().readLine();
        int vecesPalabra = 0;
        for (int i = 0; i < palabras.length; i++) {
            if (buscarPalabra.equalsIgnoreCase(palabras[i])) {
                vecesPalabra++;
                System.out.println("Encontrada en posición: " + i);
            }
        }
        System.out.println("Aparece " + vecesPalabra + " veces.");

        // Ordenar palabras
        for (int i = 0; i < palabras.length - 1; i++) {
            for (int j = i + 1; j < palabras.length; j++) {
                if (palabras[i].compareToIgnoreCase(palabras[j]) > 0) {
                    String aux = palabras[i];
                    palabras[i] = palabras[j];
                    palabras[j] = aux;
                }
            }
        }

        System.out.println(
                "\n----- PALABRAS ORDENADAS -----");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

        // Frase al revés
        System.out.println(
                "\n----- FRASE AL REVÉS -----");
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(frase.charAt(i));
        }
        System.out.println();
    }
}
