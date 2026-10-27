package tiendaapp;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Tiendaapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int opcion;
        int valorTotal = 0;

        do {
            System.out.println("===== MENÚ DE COMPRA =====");
            System.out.println("1. Camiseta - 15€");
            System.out.println("2. Pantalón - 25€");
            System.out.println("3. Zapatillas - 50€");
            System.out.println("4. Gorra - 10€");
            System.out.println("5. Finalizar compra");
            System.out.print("Elige una opción: ");

            Scanner buffer = new Scanner(System.in);

            opcion = buffer.nextInt();

            switch (opcion) {
                case 1:
                    valorTotal = valorTotal + 15;
                    break;
                case 2:
                    valorTotal = valorTotal + 25;
                    break;
                case 3:
                    valorTotal = valorTotal + 50;
                    break;
                case 4:
                    valorTotal = valorTotal + 10;
                    break;
                case 5:
                    System.out.println("Precio total: " + valorTotal);
                    break;
                default:
                    System.out.println("Numero incorrecto");
            }

        } while (opcion != 5);
    }
}
