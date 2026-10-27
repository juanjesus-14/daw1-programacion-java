/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2_ficheros;
   import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author juand
 */
public class Ex2_Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---- EJERCICIO 1 ----
        System.out.print("Introduce la ruta: ");
        String ruta = System.console().readLine();

        File fichero = new File(ruta);

        if (!fichero.exists() || !fichero.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
        } else {
            File[] archivos = fichero.listFiles();

            if (archivos == null || archivos.length == 0) {
                System.out.println("El directorio está vacío.");
            } else {
                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter("D:\\workspace\\programacion\\UD7\\RECUPERACION\\Examen2\\logMensual.txt", true))) {

                    for (File f : archivos) {
                        String linea = (f.isDirectory() ? "D" : "F") + ";" + f.getName() + ";" + f.getAbsolutePath();
                        bw.write(linea);
                        bw.newLine();
                        System.out.println(linea);
                    }
                    System.out.println("Log generado correctamente.");

                } catch (IOException ioe) {
                    System.out.println("Error al escribir el log: " + ioe.getMessage());
                }
            }
        }

        // ---- EJERCICIO 2 ----
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        // Cargamos los dos ficheros al arrancar
        Utils.cargaPersonas(listaPersonas);
        Utils.cargaMascotas(listaPersonas);

        int opcion;
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Mostrar personas y mascotas");
            System.out.println("2. Insertar persona");
            System.out.println("3. Insertar mascota");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    Utils.mostrarPersonasMascotas(listaPersonas);
                    break;
                case 2:
                    Utils.insertarPersona(listaPersonas);
                    break;
                case 3:
                    Utils.insertarMascota(listaPersonas);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}