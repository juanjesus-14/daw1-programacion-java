package maxminmedia;

/**
 *
 * @author DAW
 */
public class MaxMinMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Ejercicio en java que a partir de 10 números aleatorios comprendidos 
//        entre 1 y 50 los incluye en un array y saca finalmente el "maximo", "minimo" y media.
        int[] numeros = new int[10];
        int max = 0;
        int min = 51;
        double acumulado = 0;
        double media = 0;

        //Inicializo y relleno array
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * (50 - 1 + 1)) + 1;
            System.out.println("Tus numeros son " + numeros[i]);
            acumulado = (acumulado + numeros[i]);

            if (max < numeros[i]) {
                max = numeros[i];
            }

            if (min > numeros[i]) {
                min = numeros[i];
            }

        }

        media = acumulado / numeros.length;
        System.out.printf("Tu media es %.2f\n", media);
        System.out.println("Max es " + max);
        System.out.println("Min es " + min);

    }
}
