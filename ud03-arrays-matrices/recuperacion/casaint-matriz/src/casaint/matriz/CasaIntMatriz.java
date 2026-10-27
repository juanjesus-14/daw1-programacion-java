/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casaint.matriz;

/**
 *
 * @author juand
 */
public class CasaIntMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ==========================
        // CREAR MATRIZ
        // ==========================
        int[][] matriz = new int[5][5];

        // ==========================
        // RELLENAR MATRIZ
        // ==========================
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * 99) + 1;
            }
        }

        // ==========================
        // MOSTRAR MATRIZ
        // ==========================
        System.out.println("----- MATRIZ -----");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%02d ", matriz[i][j]);
            }
            System.out.println();
        }

        // ==========================
        // VARIABLES AUXILIARES
        // ==========================
        int mayor = matriz[0][0];
        int menor = matriz[0][0];

        int filaMayor = 0;
        int colMayor = 0;

        int filaMenor = 0;
        int colMenor = 0;

        int sumaTotal = 0;

        int contPares = 0;
        int contImpares = 0;

        int contPrimos = 0;

        // ==========================
        // RECORRIDO GENERAL
        // ==========================
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                // Mayor
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    colMayor = j;
                }

                // Menor
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    filaMenor = i;
                    colMenor = j;
                }

                // Suma total
                sumaTotal += matriz[i][j];

                // Pares e impares
                if (matriz[i][j] % 2 == 0) {
                    contPares++;
                } else {
                    contImpares++;
                }

                // Primos
                if (esPrimo(matriz[i][j])) {
                    contPrimos++;
                }
            }
        }

        // ==========================
        // MEDIA
        // ==========================
        double media = (double) sumaTotal                / (matriz.length * matriz[0].length);

        // ==========================
        // ESTADÍSTICAS
        // ==========================
        System.out.println("\n----- ESTADÍSTICAS -----");
        System.out.println("Mayor: " + mayor);
        System.out.println("Posición: (" + filaMayor + "," + colMayor + ")");
        System.out.println("Menor: " + menor);
        System.out.println("Posición: (" + filaMenor + "," + colMenor + ")");
        System.out.printf("Media: %.2f\n", media);
        System.out.println("Cantidad pares: " + contPares);
        System.out.println("Cantidad impares: " + contImpares);
        System.out.println("Cantidad primos: " + contPrimos);

        // ==========================
        // SUMA DE FILAS
        // ==========================
        System.out.println("\n----- SUMA FILAS -----");
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                sumaFila += matriz[i][j];
            }
            System.out.println("Fila " + i + ": " + sumaFila);
        }

        // ==========================
        // SUMA DE COLUMNAS
        // ==========================
        System.out.println("\n----- SUMA COLUMNAS -----");
        for (int j = 0; j < matriz[0].length; j++) {
            int sumaCol = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaCol += matriz[i][j];
            }
            System.out.println("Columna " + j + ": " + sumaCol);
        }

        // ==========================
        // DIAGONAL PRINCIPAL
        // ==========================
        System.out.println("\n----- DIAGONAL PRINCIPAL -----");
        int sumaDiagonal = 0;
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
            sumaDiagonal += matriz[i][i];
        }
        System.out.println("\nSuma diagonal: " + sumaDiagonal);

        // ==========================
        // BUSCAR NÚMERO
        // ==========================
        System.out.println("\nNúmero a buscar:");
        int buscar = Integer.parseInt(                System.console().readLine());
        boolean encontrado = false;
        int veces = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == buscar) {
                    encontrado = true;
                    veces++;
                    System.out.println(                            "Encontrado en ("                            + i + ","                            + j + ")");
                }
            }
        }
        if (encontrado) {
            System.out.println(                    "Aparece "                    + veces                    + " veces.");
        } else {
            System.out.println(                    "No existe en la matriz.");
        }
    }

    // ==========================
    // FUNCIÓN PRIMO
    // ==========================
    public static boolean esPrimo(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
    

