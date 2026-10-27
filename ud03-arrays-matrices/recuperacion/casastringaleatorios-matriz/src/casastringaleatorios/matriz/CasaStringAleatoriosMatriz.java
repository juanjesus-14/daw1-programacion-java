/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casastringaleatorios.matriz;

/**
 *
 * @author juand
 */
public class CasaStringAleatoriosMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ==========================
        // CREAR MATRIZ
        // ==========================
// Matriz donde guardar las letras
        char[][] matriz = new char[5][5];

// Array con las letras posibles
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // ==========================
        // RELLENAR MATRIZ
        // ==========================
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = letras[(int) (Math.random() * letras.length)];
                                                                                 // letras.length vale 26
                                                    // Math.random() genera un número decimal entre 0 y 1
                                                                          // Al multiplicarlo por letras.length obtenemos un número entre 0 y 25
                                       // Ese número se convierte a entero y se usa como índice del array letras
                        // La letra obtenida se almacena en la posición [i][j] de la matriz
            }
        }

        // ==========================
        // MOSTRAR MATRIZ
        // ==========================
        System.out.println("----- MATRIZ -----");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        // ==========================
        // CONTAR VOCALES Y CONSONANTES
        // ==========================
        int vocales = 0;
        int consonantes = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                char letra = matriz[i][j];
                if (esVocal(letra)) {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }
        System.out.println("\nVocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);

        // ==========================
        // BUSCAR LETRA
        // ==========================
        System.out.println("\nIntroduce una letra:");
        char buscar = System.console().readLine().toUpperCase().charAt(0);

        boolean encontrado = false;
        int veces = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == buscar) {
                    encontrado = true;
                    veces++;
                    System.out.println("Encontrada en (" + i + "," + j + ")");
                }
            }
        }
        if (encontrado) {
            System.out.println("Aparece " + veces + " veces.");
        } else {
            System.out.println("No aparece.");
        }

        // ==========================
        // LETRA MÁS REPETIDA
        // ==========================
        char masRepetida = ' ';
        int maxRepeticiones = 0;
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            int contador = 0;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] == letra) {
                        contador++;
                    }
                }
            }
            if (contador > maxRepeticiones) {
                maxRepeticiones = contador;
                masRepetida = letra;
            }
        }

        System.out.println("\nLetra más repetida: " + masRepetida);
        System.out.println("Veces: " + maxRepeticiones);

        // ==========================
        // DIAGONAL PRINCIPAL
        // ==========================
        System.out.println(
                "\n----- DIAGONAL PRINCIPAL -----");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();

        // ==========================
        // CONTAR CADA VOCAL
        // ==========================
        int a = 0;
        int e = 0;
        int ii = 0;
        int o = 0;
        int u = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                switch (matriz[i][j]) {
                    case 'A':
                        a++;
                        break;
                    case 'E':
                        e++;
                        break;
                    case 'I':
                        ii++;
                        break;
                    case 'O':
                        o++;
                        break;
                    case 'U':
                        u++;
                        break;
                }
            }
        }
        System.out.println("\nA: " + a);
        System.out.println("E: " + e);
        System.out.println("I: " + ii);
        System.out.println("O: " + o);
        System.out.println("U: " + u);
    }

    // ==========================
    // FUNCIÓN ES VOCAL
    // ==========================
    public static boolean esVocal(char letra) {
        return letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U';
    }
}
