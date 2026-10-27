package matrizdinamica;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MatrizDinamica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrizAleatorios;
        Random numAleatorio = new Random();

        //Scanner buffer = new Scanner();
        // inicializo matriz
        int filas = 0;
        int columnas = 0;
        System.out.println("Introduce las filas.");
        filas = Integer.parseInt(System.console().readLine());
        System.out.println("Introduce las columnas.");
        columnas = Integer.parseInt(System.console().readLine());
        matrizAleatorios = new int[filas][columnas];

        // relleno la matriz con aleatorios (10 a 100)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizAleatorios[i][j] = numAleatorio.nextInt(90) + 10;
            }
        }
        // muestro la matriz y muestro número máximo, mínimo y media.
        double acumulado = 0;
        int max = 0;
        int min = 100;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matrizAleatorios[i][j] + " ");
                acumulado = acumulado + matrizAleatorios[i][j];
                if (matrizAleatorios[i][j] > max) {
                    max = matrizAleatorios[i][j];
                }
                if (matrizAleatorios[i][j] < min) {
                    min = matrizAleatorios[i][j];
                }
            }
            System.out.println("");
        }
        System.out.println("El máximo es: " + max);
        System.out.println("El mínimo es: " + min);
        System.out.printf("La media es: %.2f\n", (acumulado / (filas * columnas)));
    }
}
