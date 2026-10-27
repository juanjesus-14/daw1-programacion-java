package primeramatriz;

import java.util.Random;

/**
 *
 * @author DAW
 */
public class PrimeraMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] matrizAleatorios;
        Random numAleatorio = new Random();

        //Inicializo matriz
        int tam_matriz = 4;
        matrizAleatorios = new int[tam_matriz][tam_matriz];

        //Relleno la matriz con aleatorios de 10 a 100
        for (int filas = 0; filas < tam_matriz; filas++) {
            for (int colum = 0; colum < tam_matriz; colum++) {
                //matrizAleatorios[filas][colum] = (int) ((Math.random() * (100 - 10 + 1)) + 10);
                matrizAleatorios[filas][colum] = numAleatorio.nextInt(90) + 10;
            }
        }

        //muestro la matriz y muestro numero, maximo, minimo y media
        double acumulado = 0;
        int max = 0;
        int min = 100;
        double media = 0;

        for (int filas = 0; filas < tam_matriz; filas++) {
            for (int colum = 0; colum < tam_matriz; colum++) {
                System.out.print(matrizAleatorios[filas][colum] + " ");

                acumulado = (acumulado + matrizAleatorios[filas][colum]);

                if (max < matrizAleatorios[filas][colum]) {
                    max = matrizAleatorios[filas][colum];
                }

                if (min > matrizAleatorios[filas][colum]) {
                    min = matrizAleatorios[filas][colum];
                }

            }
            System.out.println("");

        }
        media = acumulado / (tam_matriz * tam_matriz);
        System.out.printf("Tu media es %.2f\n", media);
        System.out.println("Max es " + max);
        System.out.println("Min es " + min);
    }
}
