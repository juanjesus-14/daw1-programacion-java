/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainequipofutbol;

/**
 *
 * @author juand
 */
import java.io.*;
import java.util.LinkedList;

public class Utils {

    public static void cargaFichero(LinkedList<Jugador> lista, String rutaFichero) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 5) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String posicion = datos[2];
                    int dorsal = Integer.parseInt(datos[3]);
                    int edad = Integer.parseInt(datos[4]);

                    lista.add(new Jugador(id, nombre, posicion, dorsal, edad));
                }
            }
            br.close();
            System.out.println("Fichero cargado. " + lista.size() + " jugadores.");

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero no encontrado, se creará al salir.");
        } catch (IOException ioe) {
            System.out.println("Error al leer el fichero.");
        }
    }

    public static void listarJugadores(LinkedList<Jugador> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores.");
            return;
        }
        System.out.println("\nLISTADO DE JUGADORES:");
        for (Jugador j : lista) {
            System.out.println(j);
        }
    }

    public static void añadirJugador(LinkedList<Jugador> lista) {
        System.out.print("ID: ");
        int id = Integer.parseInt(System.console().readLine());
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Posición: ");
        String posicion = System.console().readLine();
        System.out.print("Dorsal: ");
        int dorsal = Integer.parseInt(System.console().readLine());
        System.out.print("Edad: ");
        int edad = Integer.parseInt(System.console().readLine());

        lista.add(new Jugador(id, nombre, posicion, dorsal, edad));
        System.out.println("Jugador añadido correctamente.");
    }

    public static void eliminarJugador(LinkedList<Jugador> lista) {
        System.out.print("ID del jugador a eliminar: ");
        int id = Integer.parseInt(System.console().readLine());

        boolean eliminado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                eliminado = true;
                System.out.println("Jugador eliminado correctamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún jugador con ID " + id);
        }
    }

    public static void guardarFichero(LinkedList<Jugador> lista, String rutaFichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero))) {
            for (Jugador j : lista) {
                bw.write(j.toFichero());
                bw.newLine();
            }
            System.out.println("Fichero guardado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al guardar el fichero.");
        }
    }
}
