package main;

import java.io.*;

/**
 *
 * @author $(user)
 */
public class Utils {

    // CREAR LOG
    public static void crearLog(String ruta) {

        try {

            PrintWriter pw = new PrintWriter("logMensual.txt");

            File carpeta = new File(ruta);

            File[] lista = carpeta.listFiles();

            for (File f : lista) {

                // SI ES DIRECTORIO
                if (f.isDirectory()) {

                    pw.println("directorio;" + f.getName());

                }

                // SI ES FICHERO
                if (f.isFile()) {

                    pw.println("fichero;" + f.getName());

                }

            }

            pw.close();

            System.out.println("Log creado");

        } catch (FileNotFoundException e) {

            System.out.println("Error creando log");

        }

    }

}
