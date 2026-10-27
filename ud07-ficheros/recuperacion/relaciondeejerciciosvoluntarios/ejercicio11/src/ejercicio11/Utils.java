/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11;

/**
 *
 * @author juand
 */
import java.io.*;

public class Utils {

    // ---- AÑADIR MATRÍCULA ----
    public static void añadirMatricula() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Alumno: ");
        String alumno = System.console().readLine();
        System.out.print("Grado: ");
        String grado = System.console().readLine();
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fecha = System.console().readLine();

        try {
            FileWriter fw = new FileWriter("matriculas.txt", true);
            fw.write(id + ";" + alumno + ";" + grado + ";" + fecha + "\n");
            fw.close();
            System.out.println("Matrícula guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la matrícula: " + e.getMessage());
        }
    }

    // ---- LISTAR MATRÍCULAS ----
    public static void listarMatriculas() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("matriculas.txt"));
            String linea;

            System.out.println("\n--- MATRÍCULAS ---");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                System.out.println("ID: " + datos[0] + " | Alumno: " + datos[1]
                        + " | Grado: " + datos[2] + " | Fecha: " + datos[3]);
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay matrículas guardadas todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer las matrículas: " + e.getMessage());
        }
    }

    // ---- BUSCAR POR GRADO ----
    public static void buscarPorGrado() {
        System.out.print("Grado a buscar: ");
        String gradoBuscar = System.console().readLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("matriculas.txt"));
            String linea;
            boolean encontrado = false;

            System.out.println("\n--- RESULTADOS ---");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[2].equalsIgnoreCase(gradoBuscar)) {
                    System.out.println("ID: " + datos[0] + " | Alumno: " + datos[1]
                            + " | Fecha: " + datos[3]);
                    encontrado = true;
                }
            }
            br.close();

            if (!encontrado) {
                System.out.println("No se encontraron matrículas para ese grado.");
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay matrículas guardadas todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer las matrículas: " + e.getMessage());
        }
    }

    // ---- CONTAR POR GRADO ----
    public static void contarPorGrado() {
        System.out.print("Grado a contar: ");
        String gradoContar = System.console().readLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("matriculas.txt"));
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[2].equalsIgnoreCase(gradoContar)) {
                    contador++;
                }
            }
            br.close();

            System.out.println("Matrículas en " + gradoContar + ": " + contador);

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay matrículas guardadas todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer las matrículas: " + e.getMessage());
        }
    }
}
