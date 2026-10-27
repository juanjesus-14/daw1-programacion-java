/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12;

/**
 *
 * @author juand
 */
import java.io.*;

public class Utils {

    // ---- ALUMNOS ----
    public static void añadirAlumno() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();

        Alumno a = new Alumno(id, nombre);
        guardar("alumnos.txt", a.toFile());
    }

    // ---- PROFESORES ----
    public static void añadirProfesor() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();

        Profesor p = new Profesor(id, nombre);
        guardar("profesores.txt", p.toFile());
    }

    // ---- MÓDULOS ----
    public static void añadirModulo() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();

        Modulo m = new Modulo(id, nombre);
        guardar("modulos.txt", m.toFile());
    }

    // ---- MATRÍCULAS ----
    public static void añadirMatricula() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Alumno: ");
        String alumno = System.console().readLine();
        System.out.print("Grado: ");
        String grado = System.console().readLine();
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fecha = System.console().readLine();

        Matricula m = new Matricula(id, alumno, grado, fecha);
        guardar("matriculas.txt", m.toFile());
    }

    // ---- GRADOS ----
    public static void añadirGrado() {
        System.out.print("ID: ");
        String id = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();

        Grado g = new Grado(id, nombre);
        guardar("grados.txt", g.toFile());
    }

    // ---- GUARDAR EN FICHERO (método auxiliar) ----
    public static void guardar(String fichero, String linea) {
        try {
            // true → append, no borra lo que ya hay
            FileWriter fw = new FileWriter(fichero, true);
            fw.write(linea + "\n");
            fw.close();
            System.out.println("Guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // ---- MOSTRAR FICHERO ----
    public static void mostrar(String fichero) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;

            System.out.println("\n--- " + fichero + " ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay datos guardados todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
