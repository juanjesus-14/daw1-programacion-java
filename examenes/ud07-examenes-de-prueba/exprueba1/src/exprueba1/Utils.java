/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exprueba1;

/**
 *
 * @author juand
 */

import java.io.*;
import java.time.LocalDate;

import java.util.ArrayList;

public class Utils {

    // Apartado a) - genera el log de la ruta indicada
    public static void generaLog(String ruta) {
        File dir = new File(ruta);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
            return;
        }

        File[] elementos = dir.listFiles();
        if (elementos == null) {
            System.out.println("No se pudo leer el contenido de la ruta.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\workspace\\programacion\\UD7\\RECUPERACION\\ExamenesDePrueba\\ExPrueba1\\logFacultades.txt", true))) {
            for (File f : elementos) {
                if (f.isDirectory()) {
                    bw.write("directorio;" + f.getName());
                } else {
                    bw.write("fichero;" + f.getName());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el log: " + e.getMessage());
        }
    }

    // Construye el nombre dinámico profesoresMes-Año.txt
    public static String construyeNombreFichero() {
        LocalDate hoy = LocalDate.now();
        return "profesores" + hoy.getMonthValue() + "-" + (hoy.getYear() % 100) + ".txt";
    }

    // Apartado b) - lee el fichero y construye la Universidad con sus Facultades y Profesores
    public static Universidad cargaDatos(String ruta) {
        Universidad uni = new Universidad("U001", "Mi Universidad");
        File fichero = new File(ruta);

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return uni;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            ArrayList<String> lineas = new ArrayList<>();

            System.out.println("Datos del fichero:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);
            }

            for (String l : lineas) {
                String[] campos = l.split(";");
                if (campos.length != 8) {
                    continue; // línea mal formada, se descarta
                }

                String codFacultad = campos[0];
                String nombreFacultad = campos[1];
                int numProfesor = Integer.parseInt(campos[2]);
                String dni = campos[3];
                String nombre = campos[4];
                String apellidos = campos[5];
                String email = campos[6];
                LocalDate fechaContratacion = LocalDate.parse(campos[7]);

                Facultad facultad = buscaFacultad(uni, codFacultad);
                if (facultad == null) {
                    facultad = new Facultad(codFacultad, nombreFacultad);
                    uni.asignaFacultad(facultad);
                }

                Profesor profesor = new Profesor(numProfesor, dni, nombre, apellidos, email, fechaContratacion);
                facultad.asignaProfesor(profesor);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException | java.time.format.DateTimeParseException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }

        return uni;
    }

    private static Facultad buscaFacultad(Universidad uni, String codFacultad) {
        for (Facultad f : uni.getFacultades()) {
            if (f.getCodFacultad().equals(codFacultad)) {
                return f;
            }
        }
        return null;
    }

    public static void mostrarOrganigrama(Universidad uni) {
        System.out.println("\n-- Organigrama --");
        for (Facultad f : uni.getFacultades()) {
            System.out.println(f);
        }
    }

    public static void mostrarProfesoresPorFacultad(Universidad uni) {
        System.out.println("\n-- Profesores por facultad --");
        for (Facultad f : uni.getFacultades()) {
            System.out.println("\nFacultad: " + f.getNombreFacultad());
            f.listarProfesores();
        }
    }
}
