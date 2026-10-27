/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainanimal;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class MainAnimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

// A) INSTANCIACIÓN DE OBJETOS
        Animal a1 = new Perro("Pastor Alemán", "Rocky", 4);
        Animal a2 = new Gato("Persa", "Misu", 3);
        Animal a3 = new Caballo("Árabe", "Rayo", 5);

        System.out.println(a1);
        System.out.println("-----------------------");
        System.out.println(a2);
        System.out.println("-----------------------");
        System.out.println(a3);

// B) MENÚ
        ArrayList<Animal> inventario = new ArrayList<>();
        inventario.add(a1);
        inventario.add(a2);
        inventario.add(a3);

        String opcion;
        boolean terminar = false;

        do {
            System.out.println("\n-- Menú Tienda de Animales --");
            System.out.println("1. Añadir Perro");
            System.out.println("2. Añadir Gato");
            System.out.println("3. Añadir Caballo");
            System.out.println("4. Mostrar inventario");
            System.out.println("Escribe 0 para salir");

            opcion = System.console().readLine();

            if (opcion.equals("0")) {
                terminar = true;
            } else {
                switch (Integer.parseInt(opcion)) {
                    case 1:
                        inventario.add(creaPerro());
                        break;
                    case 2:
                        inventario.add(creaGato());
                        break;
                    case 3:
                        inventario.add(creaCaballo());
                        break;
                    case 4:
                        System.out.println("\n--- Inventario ---");
                        for (Animal a : inventario) {
                            System.out.println(a);
                            System.out.println("------------------");
                        }
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
            }

        } while (!terminar);

        System.out.println("Saliendo de la tienda...");
    }


    public static Perro creaPerro() {
        String nombre = System.console().readLine("Nombre del perro: ");
        int edad = obtenNumeroEntero(System.console().readLine("Edad: "));
        String raza = System.console().readLine("Raza: ");
        return new Perro(raza, nombre, edad);
    }

    public static Gato creaGato() {
        String nombre = System.console().readLine("Nombre del gato: ");
        int edad = obtenNumeroEntero(System.console().readLine("Edad: "));
        String raza = System.console().readLine("Raza: ");
        return new Gato(raza, nombre, edad);
    }

    public static Caballo creaCaballo() {
        String nombre = System.console().readLine("Nombre del caballo: ");
        int edad = obtenNumeroEntero(System.console().readLine("Edad: "));
        String raza = System.console().readLine("Raza: ");
        return new Caballo(raza, nombre, edad);
    }

    
    public static int obtenNumeroEntero(String input) {
        int numero = 0;
        boolean correcto = false;
        do {
            try {
                numero = Integer.parseInt(input);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Introduce de nuevo:");
                input = System.console().readLine();
            }
        } while (!correcto);
        return numero;
    }
}
