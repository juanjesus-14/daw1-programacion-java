/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casafigurasasteriscos;

/**
 *
 * @author juand
 */
public class CasaFigurasAsteriscos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int ancho, alto, opcion;

        System.out.println("Introduce el ancho:");
        ancho = Integer.parseInt(System.console().readLine());

        System.out.println("Introduce el alto:");
        alto = Integer.parseInt(System.console().readLine());

        do {

            System.out.println("\n===== FIGURAS =====");
            System.out.println("1. Rectángulo");
            System.out.println("2. Marco");
            System.out.println("3. Triángulo creciente");
            System.out.println("4. Triángulo invertido");
            System.out.println("5. Pirámide");
            System.out.println("6. Rombo");
            System.out.println("7. X");
            System.out.println("8. Diagonal");
            System.out.println("9. Tablero");
            System.out.println("10. Letra L");
            System.out.println("11. Letra T");
            System.out.println("12. Triángulo hueco");
            System.out.println("13. Cuadrado con diagonales");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    for (int i = 0; i < alto; i++) {
                        for (int j = 0; j < ancho; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 2:

                    for (int i = 0; i < alto; i++) {
                        for (int j = 0; j < ancho; j++) {
                            if (i == 0 || i == alto - 1 || j == 0 || j == ancho - 1) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 3:

                    for (int i = 1; i <= alto; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 4:

                    for (int i = alto; i >= 1; i--) {

                        for (int j = 1; j <= i; j++) {

                            System.out.print("*");

                        }

                        System.out.println();

                    }

                    break;

                case 5:

                    for (int i = 1; i <= alto; i++) {

                        for (int j = 1; j <= alto - i; j++) {

                            System.out.print(" ");

                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {

                            System.out.print("*");

                        }

                        System.out.println();

                    }

                    break;

                case 6:

                    for (int i = 1; i <= alto; i++) {

                        for (int j = 1; j <= alto - i; j++) {

                            System.out.print(" ");

                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {

                            System.out.print("*");

                        }

                        System.out.println();

                    }

                    for (int i = alto - 1; i >= 1; i--) {

                        for (int j = 1; j <= alto - i; j++) {

                            System.out.print(" ");

                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {

                            System.out.print("*");

                        }

                        System.out.println();

                    }

                    break;

                case 7:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if (i == j
                                    || j == ancho - 1 - i) {

                                System.out.print("* ");

                            } else {

                                System.out.print("  ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 8:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if (i == j) {

                                System.out.print("* ");

                            } else {

                                System.out.print("  ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 9:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if ((i + j) % 2 == 0) {

                                System.out.print("* ");

                            } else {

                                System.out.print("  ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 10:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if (j == 0 || i == alto - 1) {

                                System.out.print("*");

                            } else {

                                System.out.print(" ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 11:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if (i == 0 || j == ancho / 2) {

                                System.out.print("*");

                            } else {

                                System.out.print(" ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 12:

                    for (int i = 1; i <= alto; i++) {

                        for (int j = 1; j <= alto - i; j++) {

                            System.out.print(" ");

                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {

                            if (i == alto
                                    || j == 1
                                    || j == (2 * i - 1)) {

                                System.out.print("*");

                            } else {

                                System.out.print(" ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 13:

                    for (int i = 0; i < alto; i++) {

                        for (int j = 0; j < ancho; j++) {

                            if (i == 0
                                    || i == alto - 1
                                    || j == 0
                                    || j == ancho - 1
                                    || i == j
                                    || j == ancho - 1 - i) {

                                System.out.print("*");

                            } else {

                                System.out.print(" ");

                            }

                        }

                        System.out.println();

                    }

                    break;

                case 0:

                    System.out.println("Fin del programa.");

                    break;

                default:

                    System.out.println("Opción incorrecta.");

            }

        } while (opcion != 0);

    }

}
