package ej3;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int num = 0;
        int resto = 0;
        String resultado = "";

        System.out.println("Escribe un numero: ");
        num = sc.nextInt();

        do {
            resto = num % 10;
            num = num / 10;
            if (resto == 0 || resto == 8) {
            } else {
                resultado = resto + resultado;
            }
        } while (num > 0);
        System.out.println("resultado: " + resultado);
    }
}
