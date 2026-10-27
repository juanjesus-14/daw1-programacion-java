/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_ficheros;

/**
 *
 * @author juand
 */
import java.io.*;
import java.util.ArrayList;

public class Utils {

    // Carga personas.txt → formato: nombre;apellidos;dni;email;telefono;direccion
    public static void cargaPersonas(ArrayList<Persona> listaPersonas) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("personas.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 6) {
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    String dni = datos[2];
                    String email = datos[3];
                    String telefono = datos[4];
                    String direccion = datos[5];

                    Persona p = new Persona(dni, nombre, apellidos, email, telefono, direccion);
                    listaPersonas.add(p);
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero personas.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer personas.txt");
        }
    }

    // Carga mascotas.txt → formato: dniPersona;nombreMascota;edad;raza
    public static void cargaMascotas(ArrayList<Persona> listaPersonas) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("mascotas.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 4) {
                    String dniPersona = datos[0];
                    String nombre = datos[1];
                    int edad;
                    try {
                        edad = Integer.parseInt(datos[2]);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Edad incorrecta en línea: " + linea);
                        continue;
                    }
                    String raza = datos[3];

                    Mascota m = new Mascota(dniPersona, nombre, edad, raza);

                    // Buscar la persona por DNI y asignarle la mascota
                    boolean encontrado = false;
                    for (Persona p : listaPersonas) {
                        if (p.getDni().equals(dniPersona)) {
                            p.asignaMascota(m);
                            m.asignaPersona(p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró persona con DNI: " + dniPersona);
                    }

                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero mascotas.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer mascotas.txt");
        }
    }

    // Insertar persona pidiendo cada campo 1 a 1
    public static void insertarPersona(ArrayList<Persona> listaPersonas) {
        System.out.print("DNI: ");
        String dni = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Apellidos: ");
        String apellidos = System.console().readLine();
        System.out.print("Email: ");
        String email = System.console().readLine();
        System.out.print("Teléfono: ");
        String telefono = System.console().readLine();
        System.out.print("Dirección: ");
        String direccion = System.console().readLine();

        Persona p = new Persona(dni, nombre, apellidos, email, telefono, direccion);
        listaPersonas.add(p);

        // Escribir en el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("personas.txt", true))) {
            // formato: nombre;apellidos;dni;email;telefono;direccion
            bw.write(nombre + ";" + apellidos + ";" + dni + ";" + email + ";" + telefono + ";" + direccion);
            bw.newLine();
            System.out.println("Persona insertada correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en personas.txt");
        }
    }

    // Insertar mascota pidiendo cada campo 1 a 1
    public static void insertarMascota(ArrayList<Persona> listaPersonas) {
        System.out.print("DNI de la persona: ");
        String dniPersona = System.console().readLine();
        System.out.print("Nombre de la mascota: ");
        String nombre = System.console().readLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(System.console().readLine());
        System.out.print("Raza: ");
        String raza = System.console().readLine();

        Mascota m = new Mascota(dniPersona, nombre, edad, raza);

        // Buscar la persona y asignarle la mascota
        boolean encontrado = false;
        for (Persona p : listaPersonas) {
            if (p.getDni().equals(dniPersona)) {
                p.asignaMascota(m);
                m.asignaPersona(p);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró persona con DNI: " + dniPersona);
        }

        // Escribir en el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("mascotas.txt", true))) {
            bw.write(dniPersona + ";" + nombre + ";" + edad + ";" + raza);
            bw.newLine();
            System.out.println("Mascota insertada correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en mascotas.txt");
        }
    }

    // Mostrar todas las personas con sus mascotas
    public static void mostrarPersonasMascotas(ArrayList<Persona> listaPersonas) {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas cargadas.");
            return;
        }
        for (Persona p : listaPersonas) {
            System.out.println(p);
            System.out.println("-- Mascotas --");
            p.listarMascotas();
        }
    }
}
