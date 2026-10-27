package ejer4;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ejer4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la altura (5 como mínimo): ");
        int altura = sc.nextInt();
        System.out.println("Introduzca el número de espacios entre los números (1 como mínimo): ");
        int espacio = sc.nextInt();

        System.out.println(" * **** **** ");
        System.out.println(" * *    *    ");
        System.out.println(" * **** **** ");
        System.out.println(" *    *    * ");
        System.out.println(" * **** **** ");
    }
}
