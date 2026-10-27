package examenejercicio1;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ExamenEjercicio1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta: ");
        String ruta = sc.nextLine();

        File fichero = new File(ruta);

        if (!fichero.exists() || !fichero.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
            return;
        }

        File[] archivos = fichero.listFiles();

        // Primero comprobamos null, LUEGO usamos .length
        if (archivos == null || archivos.length == 0) {
            System.out.println("El directorio está vacío.");
            return;
        }

        System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
        System.out.println("Longitud: " + archivos.length);

        // BufferedWriter FUERA del bucle + true para no sobrescribir
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("D:\\workspace\\programacion\\UD7\\EXAMEN\\Examen-UD07(nota1,5)\\logMensual.txt", true))) {

            for (File f : archivos) {
                String linea = (f.isDirectory() ? "DIR; " : "FICH; ") + f.getName();
                bw.write(linea);
                bw.newLine();
                System.out.println(linea);
            }

            System.out.println("\nLog generado correctamente.");

        } catch (IOException ioe) {
            System.out.println("Error al escribir el log: " + ioe.getMessage());
        }
    }
}
