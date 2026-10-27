package ej2;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int max = 0;
        int min = 0;
        int media = 0;
        int contador = 0;
        int numero = 0;
        int sumaNumero = 0;

        do {
            System.out.println("Escribe un numero: ");
            numero = sc.nextInt();
            contador++;
            if (numero == 0) {
            }else {
                if (max == 0 && min == 0) {
                    max = numero;
                    min = numero;
                } else {
                    if (numero > max) {
                        max = numero;
                    }
                    if (numero < min) {
                        min = numero;
                    }
                }   
            }
          
            sumaNumero = numero + sumaNumero;
            media = sumaNumero / contador;

        } while (numero != 0);

        System.out.println("Ha introducido " + contador + " numeros.");
        System.out.println("Maximo: " + max);
        System.out.println("Minimo: " + min);
        System.out.println("Media: " + media);
    }

}
