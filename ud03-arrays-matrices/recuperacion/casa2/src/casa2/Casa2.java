/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casa2;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Casa2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//GESTIÓN DE NOTAS
//
//Crear un programa que permita almacenar notas de alumnos.
//
//Menú:
//
//1. Añadir nota
//2. Mostrar notas
//3. Buscar nota
//4. Mostrar nota máxima y mínima
//5. Calcular media
//0. Salir
//
//Obligatorio:
//
//- ArrayList<Integer>
//- Funciones
//- Control de errores
//- Menú con do while   

        ArrayList<Integer> notas = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE NOTAS =====");
            System.out.println("1. Añadir nota");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Busca nota");
            System.out.println("4. Mostrar nota maxima y minima");
            System.out.println("5. Calcular media");
            System.out.println("0. Salir");

            do {
                System.out.println("Seleccione una opción:");
                opcion = rangoCorrecto(System.console().readLine());
            } while (opcion == -1);

            switch (opcion) {

                case 1:
                    añadirNota(notas);
                    break;

                case 2:
                    mostrarNotas(notas);
                    break;

                case 3:
                    buscaNota(notas);
                    break;

                case 4:
                    mostarNotaMaxMin(notas);
                    break;

                case 5:
                    calcularMedia(notas);
                    break;

                case 0:
                    System.out.println("Fin del programa.");
                    break;

            }
        } while (opcion != 0);
    }

    public static void añadirNota(ArrayList<Integer> notas) {
        int nota;
        do {
            System.out.println("Introduce la nota (0-10):");
            nota = Integer.parseInt(System.console().readLine());
        } while (nota < 0 || nota > 10);
        notas.add(nota);
        System.out.println("Nota añadida correctamente.");
    }

    public static void mostrarNotas(ArrayList<Integer> notas) {
        System.out.println("\n----- LISTA DE NOTAS -----");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println((i + 1) + ". " + notas.get(i));
        }
    }

    public static void buscaNota(ArrayList<Integer> notas) {
        int busca;
        boolean encontrado = false;

        System.out.println("Nota que quieres buscar:");
        busca = Integer.parseInt(System.console().readLine());
        for (int i = 0; i < notas.size(); i++) {
            if (busca == notas.get(i)) {
                System.out.println("Nota encontrada.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe esa nota.");
        }
    }

    public static void mostarNotaMaxMin(ArrayList<Integer> notas) {

        if (notas.isEmpty()) {
            System.out.println("No hay notas almacenadas.");
            return;
        }

        int max = notas.get(0);
        int min = notas.get(0);

        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i) > max) {
                max = notas.get(i);
            }

            if (notas.get(i) < min) {
                min = notas.get(i);
            }
        }

        System.out.println("Nota máxima: " + max);
        System.out.println("Nota mínima: " + min);
    }

    public static void calcularMedia(ArrayList<Integer> notas) {
        if (notas.isEmpty()) {
            System.out.println("No hay notas almacenadas.");
            return;
        }

        double suma = 0;
        for (int i = 0; i < notas.size(); i++) {
            suma = suma + notas.get(i);
        }

        double media = suma / notas.size();
        System.out.printf("La media es: %.2f\n", media);
    }

    // Función que comprueba que el dato introducido es un número entre 0 y 5
    public static int rangoCorrecto(String comp) {
        int numero;
        try {
            numero = Integer.parseInt(comp);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto.");
            return -1;
        }

        do {
            if ((numero >= 0) && (numero <= 5)) {
                return numero;
            } else {
                System.out.println("Debe ser un numero entre 0 y 5");
                numero = Integer.parseInt(System.console().readLine());
            }
        } while ((numero > 5) || (numero < 0));
        return numero;
    }
}
