package ej1;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int min = 1;
        int max = 40;
        int maquina = 0;
        int usuario = 0;

        System.out.println("Escribe un numero entre el 10 y 30.");
        usuario = sc.nextInt();
        if (usuario >= 10 & usuario <= 30) {

            maquina = (int) (Math.random() * (max - min + 1)) + min;

            if (usuario > maquina) {
                System.out.println("El usuario gana, " + "La maquina saco: " + maquina);
            } else if (usuario < maquina) {
                System.out.println("La maquina gana, " + "La maquina saco: " + maquina);
            } else {
                System.out.println("Empataste");
            }

        } else {
            System.out.println("El numero introducido no esta entre 10 y 30");
        }
    }
}
