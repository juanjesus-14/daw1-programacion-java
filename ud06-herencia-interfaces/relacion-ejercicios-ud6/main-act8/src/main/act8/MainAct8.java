/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main.act8;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class MainAct8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ArrayList<Animal> animales = new ArrayList<>();
//
//        animales.add(new Gato("Misu", 3));
//        animales.add(new Perro("Rex", 5));
//        animales.add(new Pinguino("Pingo", 2));
//        animales.add(new Ballena("Azul", 12));
//
//        for (Animal a : animales) {
//
//            System.out.println("Nombre: " + a.getNombre());
//            System.out.println("Edad: " + a.getEdad());
//
//            a.comer();
//            a.dormir();
//
//            // Uso de instanceof para diferenciar comportamiento
//            if (a instanceof AnimalTerrestre) {
//                ((AnimalTerrestre) a).desplazarse();
//            }
//
//            if (a instanceof AnimalAcuatico) {
//                ((AnimalAcuatico) a).nadar();
//            }
//
//            System.out.println("-----------------------");
//        }
//    }
//}

        ArrayList<Animal> animales = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- CENTRO DE CONSERVACIÓN ---");
            System.out.println("1. Añadir Gato");
            System.out.println("2. Añadir Perro");
            System.out.println("3. Añadir Pingüino");
            System.out.println("4. Añadir Ballena");
            System.out.println("5. Mostrar animales");
            System.out.println("0. Salir");

            opcion = Utils.obtenNumeroEntero("Seleccione opción: ");

            switch (opcion) {

                case 1:
                    String nombreGato = System.console().readLine("Nombre: ");
                    int edadGato = Utils.obtenNumeroEntero("Edad: ");
                    animales.add(new Gato(nombreGato, edadGato));
                    break;

                case 2:
                    String nombrePerro = System.console().readLine("Nombre: ");
                    int edadPerro = Utils.obtenNumeroEntero("Edad: ");
                    animales.add(new Perro(nombrePerro, edadPerro));
                    break;

                case 3:
                    String nombrePinguino = System.console().readLine("Nombre: ");
                    int edadPinguino = Utils.obtenNumeroEntero("Edad: ");
                    animales.add(new Pinguino(nombrePinguino, edadPinguino));
                    break;

                case 4:
                    String nombreBallena = System.console().readLine("Nombre: ");
                    int edadBallena = Utils.obtenNumeroEntero("Edad: ");
                    animales.add(new Ballena(nombreBallena, edadBallena));
                    break;

                case 5:
                    System.out.println("\n--- LISTADO ---");

                    for (Animal a : animales) {

                        System.out.println("Nombre: " + a.getNombre());
                        System.out.println("Edad: " + a.getEdad());

                        a.comer();
                        a.dormir();

                        if (a instanceof AnimalTerrestre) {
                            ((AnimalTerrestre) a).desplazarse();
                        }

                        if (a instanceof AnimalAcuatico) {
                            ((AnimalAcuatico) a).nadar();
                        }

                        System.out.println("---------------------");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);
    }
}
