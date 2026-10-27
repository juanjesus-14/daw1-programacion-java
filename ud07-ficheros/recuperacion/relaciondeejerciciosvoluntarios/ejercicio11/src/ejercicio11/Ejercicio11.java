/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio11;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio11 {

    public static void main(String[] args) {

//        Ejercicio 11 – Simulación de matrícula
//        Fichero: matriculas.txt
//        Formato: id;nombreAlumno;grado;fecha
//        El programa debe permitir:
//            1. Añadir matrícula
//            2. Listar matrículas
//            3. Buscar por grado
//            4. Contar matrículas por grado
        int opcion;
        do {
            System.out.println("\n===== MATRÍCULAS =====");
            System.out.println("1. Añadir matrícula");
            System.out.println("2. Listar matrículas");
            System.out.println("3. Buscar por grado");
            System.out.println("4. Contar matrículas por grado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    Utils.añadirMatricula();
                    break;
                case 2:
                    Utils.listarMatriculas();
                    break;
                case 3:
                    Utils.buscarPorGrado();
                    break;
                case 4:
                    Utils.contarPorGrado();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
