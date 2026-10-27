package mainescriturafichero;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Utils {

    public static int EscribeFichero(String ruta, String linea) {

        int error = 0;

        try {

            // Escritura en el fichero
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
            // true es para añadir información, si no toma por defecto el valor false que elimina
            // true es para que no nos elimine el texto, no lo copia completo
            // FileWriter si no existe el fichero lo crea, y si existe lo abre.

            bw.write(linea);
            bw.newLine();

            // cerrar el fichero
            bw.close();

        } catch (IOException ioe) {
            error = -1;
        }
        return error;
    }

    public static int corrigeFichero(String ruta, String linea) {

        int error = 0;
        String resultado = "";
        try {

            // Escritura en el fichero
            String[] palabra = linea.split(",");
            for (int i = 0; i < palabra.length; i++) {
                if (i == (palabra.length - 1)) {
                    resultado += palabra[i];
                } else {

                    resultado += palabra[i] + ", ";
                }

            }
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
            
            // true es para añadir información, si no toma por defecto el valor false que elimina
            // true es para que no nos elimine el texto, no lo copia completo
            // FileWriter si no existe el fichero lo crea, y si existe lo abre.

            bw.write(resultado);
            bw.newLine();


            // cerrar el fichero
            bw.close();

        } catch (IOException ioe) {
            error = -1;
        }
        return error;
    }
}
