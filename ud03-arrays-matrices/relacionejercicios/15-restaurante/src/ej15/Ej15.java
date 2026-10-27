/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej15;

/**
 *
 * @author juand
 */
public class Ej15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ARRAYS UNIDIMENSIONALES (Vectores) 
            // Ejercicio 15: Funcionamiento de un restaurante (reservas). Disponemos de 
            //10 mesas y cada mesa puede ocuparse de 1 a 4 comensales, si junto 2 mesas 
            //puedo disponer de 6 comensales y si junto 3 mesas puedo disponer de 8 comensales
            //y si junto 4 mesas tengo 10 comensales. Gestionar el programa que ofrece un menú 
            //con la opción 1 para reservar y la opción 0 para terminar.

            final int NUM_MESAS = 10;
            int[] mesas = new int[NUM_MESAS];

            int opcion = 2;
            int comensales = 0;

            // inicializo mesas
            for (int i = 0; i < NUM_MESAS; i++) {
                mesas[i] = -1;
            }
            System.out.println("Bienvenido al restaurante IES Salduba");

            do {
                System.out.println("Pulse 1 para reservar o 0 para salir.");
                opcion = Integer.parseInt(System.console().readLine());
                if (opcion == 1) {
                    if (mesaLibre(mesas, 0) <= 0) {
                        System.out.println("Estamos completos");
                    } else {
                        System.out.println("Dime el número de comensales:");
                        comensales = Integer.parseInt(System.console().readLine());
                        //Realizo reserva - hazReserva(mesas,comensales);
                        int numMesasAReservar = 0;
                        if (comensales <= 4) {
                            numMesasAReservar = 1;
                        } else if (comensales >= 5 && comensales <= 6) {
                            numMesasAReservar = 2;
                        } else if (comensales >= 7 && comensales <= 8) {
                            numMesasAReservar = 3;
                        } else if (comensales >= 9 && comensales <= 10) {
                            numMesasAReservar = 4;
                        } else {
                            System.out.println("No aceptamos reservas de más de 10.");
                            numMesasAReservar = -1;
                        }
                        if (numMesasAReservar > 0 && mesaLibre(mesas, numMesasAReservar) < 0) {
                            System.out.println("Lo siento no tenemos espacio para su grupo.");
                        } else if (numMesasAReservar > 0) {
                            // Reservo ya que tenemos espacio
                            do {
                                for (int i = 0; i < mesas.length; i++) {
                                    if (mesas[i] == -1) {
                                        if (comensales > 4) {
                                            mesas[i] = 4;
                                            comensales = comensales - 4;
                                        } else if (comensales > 0 && comensales <= 4) {
                                            mesas[i] = comensales;
                                            comensales = -1;
                                        }
                                        System.out.println("Reserva completada.");
                                        mostrarMesas(mesas);
                                        break;
                                    }
                                }
                                numMesasAReservar--;
                            } while (numMesasAReservar > 0);
                        }
                    }
                } else if ((opcion > 1) || (opcion < 0)) {
                    System.out.println("Opción incorrecta.");
                }

            } while (opcion != 0);
            System.out.println("Gracias por utilizar nuestro servicio.");
        }

        public static int mesaLibre(int[] mesas, int numMesasNecesarias) {
            int mesasDisponibles = 0;
            for (int i = 0; i < mesas.length; i++) {
                if (mesas[i] == -1) {
                    mesasDisponibles++;
                }
            }
            if (numMesasNecesarias == 0) {
                return mesasDisponibles;
            } else if (numMesasNecesarias > 0) {
                if (numMesasNecesarias > mesasDisponibles) {
                    return -1;
                } else {
                    return mesasDisponibles;
                }
            }
            return mesasDisponibles;
        }

        // Función para mostrar el estado actual de las mesas ---
        public static void mostrarMesas(int[] mesas) {
            System.out.println("\n=== Estado actual de las mesas ===");
            for (int i = 0; i < mesas.length; i++) {
                if (mesas[i] == -1) {
                    System.out.printf("Mesa %2d: Libre\n", i + 1);
                } else {
                    System.out.printf("Mesa %2d: Ocupada (%d comensales)\n", i + 1, mesas[i]);
                }
            }
            System.out.println();
        }

    }

