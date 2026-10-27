/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7.viviendaenalquiler.agencia;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Ejercicio7ViviendaEnAlquilerAgencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      EJERCICIO 7—ViviendaEnAlquiler (agencia)--
//      Para el ejercicio anterior, generar un menú que permita incluir viviendasEnAlquiler y permita mediante métodos 
//      realizar el alquiler de una vivienda, pasar a disponible la vivienda, listar todas las viviendas, listar todas 
//      las viviendas alquiladas, listar todas las viviendas disponibles.
//      Gestionar mediante ArrayList.

        Vivienda v1 = new Vivienda(100, 5, 3, "Una cualquiera", 20, true, true, "Piso", 900.0, true);
        System.out.println("Vivienda 1: \n" + v1);
        Vivienda v2 = new Vivienda(200, 7, 4, "Otra cualquiera", 200, true, true, "Casa", 1400.0, true);
        System.out.println("Vivienda 2: \n" + v2);

        ArrayList<Vivienda> lista = new ArrayList<>();
        int opcion = -1;
        do {
            System.out.println("----------Menú----------");
            System.out.println("1.- Incluye vivienda.");
            System.out.println("2.- Elimina vivienda.");
            System.out.println("3.- Pasa vivienda a disponible");
            System.out.println("4.- Alquila vivienda.");
            System.out.println("5.- Listar todas las viviendas alquiladas.");
            System.out.println("6.- Listar todas las viviendas disponibles.");
            System.out.println("7.- Listar todas las viviendas.");
            System.out.println("8.- Salir.");
            opcion = Integer.parseInt(System.console().readLine());

            Vivienda temp;
            String direccion;
            switch (opcion) {
                case 1:
                    temp = new Vivienda();
                    temp.setMetros(obtenNumeroEntero("Dime número de metros"));
                    temp.setNumeroVentanas(obtenNumeroEntero("Dime número de ventanas."));
                    temp.setNumeroHabitaciones(obtenNumeroEntero("Dime número de habitaciones."));
                    System.out.println("Introduce la dirección:");
                    temp.setDireccion(System.console().readLine());
                    temp.setMetrosTerraza(obtenNumeroEntero("Dime número de metros de terraza."));
                    System.out.println("Tiene piscina (S/N):");
                    //opcion 1
                    //String valor = System.console().readLine().toLowerCase();
//                    if (valor.equals("S") || valor.equals("s")){
//                        temp.setTienePiscina(true);
//                    } else {
//                        temp.setTienePiscina(false);
//                    }
                    // opcion 2
                    //temp.setTienePiscina(valor.equals("s") ? true : false);

                    // opcion 3
                    temp.setTienePiscina(System.console().readLine().toLowerCase().equals("s") ? true : false);

                    System.out.println("Tiene garaje (S/N):");
                    temp.setTieneGaraje(System.console().readLine().toLowerCase().equals("s") ? true : false);
                    System.out.println("Tipo de vivienda:");
                    temp.setTipo(System.console().readLine());
                    temp.setPrecioAlquiler(obtenNumeroDouble("Dime precio del alquiler."));
                    temp.setDisponible(true);

                    lista.add(temp);
                    break;
                case 2:
                    System.out.println("Introduce la dirección de la vivienda a eliminar:");
                    direccion = System.console().readLine();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getDireccion().equals(direccion)) {
                            lista.remove(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce la dirección de la vivienda a eliminar:");
                    direccion = System.console().readLine();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getDireccion().equals(direccion)) {
                            lista.get(i).setDisponible(true);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Introduce la dirección de la vivienda a eliminar:");
                    direccion = System.console().readLine();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getDireccion().equals(direccion)) {
                            lista.get(i).setDisponible(false);
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }
                    break;
                case 6:
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).isDisponible()) {
                            System.out.println(lista.get(i));
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < lista.size(); i++) {
                        if (!lista.get(i).isDisponible()) {
                            System.out.println(lista.get(i));
                        }
                    }
                    break;
                case 8:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 8);

    }

// Fuera del main
    public static int obtenNumeroEntero(String mensaje) {
        int numero = -1;
        do {
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

    public static double obtenNumeroDouble(String mensaje) {
        double numero = -1;
        do {
            System.out.println(mensaje);
            try {
                numero = Double.parseDouble(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }
}
