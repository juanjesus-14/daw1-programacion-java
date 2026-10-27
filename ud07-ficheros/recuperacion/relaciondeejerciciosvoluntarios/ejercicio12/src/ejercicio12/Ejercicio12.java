/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio12;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio12 {

    // Scanner para leer datos desde teclado
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        Ejercicio 12. Sistema de matriculación con ficheros
//        Desarrollar una aplicación que gestione:
//             alumnos.txt
//             modulos.txt
//             matriculas.txt
//             profesores.txt
//             grados.txt
//        Requisitos:
//             Menú principal
//             Persistencia mediante ficheros
//             Separación en clases
//             Control de errores completo.

        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE MATRICULACIÓN =====");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Añadir profesor");
            System.out.println("3. Añadir módulo");
            System.out.println("4. Añadir matrícula");
            System.out.println("5. Añadir grado");
            System.out.println("6. Mostrar alumnos");
            System.out.println("7. Mostrar profesores");
            System.out.println("8. Mostrar módulos");
            System.out.println("9. Mostrar matrículas");
            System.out.println("10. Mostrar grados");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    Utils.añadirAlumno();
                    break;
                case 2:
                    Utils.añadirProfesor();
                    break;
                case 3:
                    Utils.añadirModulo();
                    break;
                case 4:
                    Utils.añadirMatricula();
                    break;
                case 5:
                    Utils.añadirGrado();
                    break;
                case 6:
                    Utils.mostrar("alumnos.txt");
                    break;
                case 7:
                    Utils.mostrar("profesores.txt");
                    break;
                case 8:
                    Utils.mostrar("modulos.txt");
                    break;
                case 9:
                    Utils.mostrar("matriculas.txt");
                    break;
                case 10:
                    Utils.mostrar("grados.txt");
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
