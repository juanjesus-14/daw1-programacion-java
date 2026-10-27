package ex07recuperacion;

import java.io.*;
import java.util.*;

/**
 *
 * @author DAW
 */
public class Ex07recuperacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ---- EJERCICIO 1 ----
//        System.out.println("Dime la ruta del fichero");
//        String ruta = System.console().readLine();
//        File fichero = new File(ruta);
//
//        if (fichero.exists()) {
//            if (fichero.isDirectory()) {
//                System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
//
//                File[] archivos = fichero.listFiles();
//
//                if (archivos == null || archivos.length == 0) {
//                    System.out.println("El directorio está vacío o no se pudo leer.");
//                } else {
//                    System.out.println("Longitud: " + archivos.length);
//                    String ficheroEsc = "F:\\workspace\\programacion\\UD7\\Ex07recuperacion\\logResumen.txt";
//                    int lineas = 0;
//                    try {
//                        // Abrimos el fichero texto.txt
//                        BufferedReader br = new BufferedReader(new FileReader("prueba.txt" + "pacientes.txt"));
//
//                        String linea;
//                        // Mientras haya líneas
//                        while ((linea = br.readLine()) != null) {
//                            // Contamos una línea
//                            lineas++;
//                        }
//                        br.close();
//                        // Mostramos resultados
//                        System.out.println("Numero de lineas: " + lineas);
//                    } catch (IOException e) {
//                        System.out.println("Error al leer el fichero");
//                    }
//
//                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc, true))) {
//                        for (File f : archivos) {
//                            String frase = fichero.getName() + " NUM_DE_LINEAS_DEL_FICHERO: " + lineas;
//                            bw.write(frase);
//                            bw.newLine();
//                            System.out.println(frase);
//                        }
//                    } catch (IOException ioe) {
//                        System.out.println("Error al escribir en el fichero");
//                    }
//                }
//            } else {
//                System.out.println("La ruta indicada no es un directorio.");
//            }
//        } else {
//            System.out.println("Fichero no encontrado");
//        }

        
        // ---- EJERCICIO 2 ----
        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        Utils.cargaPacientes(listaPacientes);
        Utils.cargaPruebas(listaPacientes);

        int opcion;
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Mostrar pacientes y su historial");
            System.out.println("2. Insertar paciente");
            System.out.println("3. Insertar prueba medica y asociarla al paciente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String lineaOpcion = System.console().readLine();
            try {
                opcion = Integer.parseInt(lineaOpcion);
            } catch (NumberFormatException nfe) {
                System.out.println("Por favor, introduce un número de opción válido.");
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    Utils.mostrarPacientes(listaPacientes);
                    break;
                case 2:
                    Utils.insertarPaciente(listaPacientes);
                    break;
                case 3:
                    Utils.insertarPruebaMedica(listaPacientes);
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
