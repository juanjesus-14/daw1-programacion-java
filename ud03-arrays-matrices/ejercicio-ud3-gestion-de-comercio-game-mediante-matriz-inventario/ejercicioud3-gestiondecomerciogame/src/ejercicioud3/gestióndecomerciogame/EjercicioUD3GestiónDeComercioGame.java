/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioud3.gestióndecomerciogame;

import java.util.Scanner;

/**
 *
 * @author juand
 */
public class EjercicioUD3GestiónDeComercioGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        String[][] inventario = new String[10][2];

        inventario[0][0] = "Marvel's Spider-Man 2";
        inventario[0][1] = "12";

        inventario[1][0] = "God of War: Ragnarök";
        inventario[1][1] = "8";

        inventario[2][0] = "Horizon Forbidden West";
        inventario[2][1] = "5";

        inventario[3][0] = "Final Fantasy XVI";
        inventario[3][1] = "9";

        inventario[4][0] = "The Last of Us Part I";
        inventario[4][1] = "6";

        inventario[5][0] = "Gran Turismo 7";
        inventario[5][1] = "7";

        inventario[6][0] = "Demon's Souls Remake";
        inventario[6][1] = "4";

        inventario[7][0] = "Resident Evil 4 Remake";
        inventario[7][1] = "10";

        inventario[8][0] = "Elden Ring";
        inventario[8][1] = "3";

        inventario[9][0] = "Assassin's Creed Mirage";
        inventario[9][1] = "11";

        int opcion;

        do {
            System.out.println("\n--- MENU TIENDA GAME ---");
            System.out.println("1. Alquilar juego");
            System.out.println("2. Devolver juego");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:  {
                    // Mostrar juegos
                    for (int i = 0; i < inventario.length; i++) {
                        System.out.println((i + 1) + " : " + inventario[i][0]);
                    }
                    System.out.print("Número del juego a alquilar: ");
                    int pos = sc.nextInt() - 1;
                    int stock = Integer.parseInt(inventario[pos][1]);
                    if (stock > 0) {
                        stock--;
                        inventario[pos][1] = String.valueOf(stock);
                        System.out.println("Juego alquilado.");
                    } else {
                        System.out.println("No hay stock.");
                    }
                    break;
                }
                case 2: {
                    // Mostrar juegos
                    for (int i = 0; i < inventario.length; i++) {
                        System.out.println((i + 1) + " : " + inventario[i][0]);
                    }
                    System.out.print("Número del juego a devolver: ");
                    int pos = sc.nextInt() - 1;
                    int stock = Integer.parseInt(inventario[pos][1]);
                    stock++;
                    inventario[pos][1] = String.valueOf(stock);
                    System.out.println("Juego devuelto.");
                    break;
                }
                case 3:
                    System.out.println("\n--- INVENTARIO ---");
                    for (int i = 0; i < inventario.length; i++) {
                        System.out.println(
                                (i + 1) + ". " + inventario[i][0]
                                + " - Stock: " + inventario[i][1]
                        );
                    }
                    break;
                case 4:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

        } while (opcion != 4);
    }
}
