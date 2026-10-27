/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casa1;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Casa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//     GESTIÓN DE ALUMNOS CON ARRAYLIST
//
//      Crear un programa que permita gestionar una lista de alumnos.
//
//  Menú:
//  1. Añadir alumno
//  2. Eliminar alumno
//  3. Mostrar alumnos
//  4. Buscar alumno
//  0. Salir
//
//  Obligatorio:
//  - Usar ArrayList<String>
//  - Menú mediante do while
//  - Uso de funciones
//  - Control de errores
        ArrayList<String> alumnos = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE ALUMNOS =====");
            System.out.println("1. Añadir Alumno");
            System.out.println("2. Eliminar Alumno");
            System.out.println("3. Mostrar Alumnos");
            System.out.println("4. Buscar alumno");
            System.out.println("0. Salir");

            do {
                System.out.println("Seleccione una opción:");
                opcion = rangoCorrecto(System.console().readLine());
            } while (opcion == -1);

            switch (opcion) {

                case 1:
                    añadirAlumno(alumnos);
                    break;

                case 2:
                    borrarAlumno2(alumnos);
                    break;

                case 3:
                    mostrarAlumno(alumnos);
                    break;

                case 4:
                    buscarAlumno(alumnos);
                    break;

                case 0:
                    System.out.println("Fin del programa.");
                    break;

            }
        } while (opcion != 0);
    }

    public static void añadirAlumno(ArrayList<String> alumnos) {
        String nombre;
        System.out.println("\n----- LISTA DE ALUMNOS -----");
        System.out.println("Nombre del alumno: ");
        nombre = System.console().readLine();
        alumnos.add(nombre);
        System.out.println("Alumno añadido correctamente.");
    }

    public static void borrarAlumno(ArrayList<String> alumnos) {
        String nombre;
        boolean encontrado = false;

        System.out.println("Nombre del alumno a borrar:");
        nombre = System.console().readLine();

        for (int i = 0; i < alumnos.size(); i++) {
            if (nombre.equalsIgnoreCase(alumnos.get(i))) {
                alumnos.remove(i);
                System.out.println("Alumno eliminado correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No existe ese alumno.");
        }
    }
    
    public static void borrarAlumno2(ArrayList<String> alumnos) {
    System.out.println("Nombre del alumno:");
    String nombre = System.console().readLine();
    if (alumnos.remove(nombre)) {
        System.out.println("Alumno eliminado.");
    } else {
        System.out.println("No existe ese alumno.");
    }
}

    public static void buscarAlumno(ArrayList<String> alumnos) {
        String busca;
        boolean encontrado = false;

        System.out.println("Nombre que quieres buscar:");
        busca = System.console().readLine();
        for (int i = 0; i < alumnos.size(); i++) {
            if (busca.equalsIgnoreCase(alumnos.get(i))) {
                System.out.println("Alumno encontrado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe ese alumno.");
        }
    }

    public static void mostrarAlumno(ArrayList<String> alumnos) {
        System.out.println("\n----- LISTA DE ALUMNOS -----");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println((i + 1) + ". " + alumnos.get(i));
        }
    }

    // Función que comprueba que el dato introducido es un número entre 0 y 4
    public static int rangoCorrecto(String comp) {
        int numero;
        try {
            numero = Integer.parseInt(comp);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto.");
            return -1;
        }

        do {
            if ((numero >= 0) && (numero <= 4)) {
                return numero;
            } else {
                System.out.println("Debe ser un numero entre 0 y 4");
                numero = Integer.parseInt(System.console().readLine());
            }
        } while ((numero > 4) || (numero < 0));
        return numero;
    }
}
