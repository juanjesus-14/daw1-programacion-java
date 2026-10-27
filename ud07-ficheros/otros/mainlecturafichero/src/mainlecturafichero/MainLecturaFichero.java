package mainlecturafichero;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MainLecturaFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Solicitar una ruta de un fichero y vamos a escribir por pantalla todo lo que tiene el fichero.

        String logError = "";
        String ruta = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la ruta completa del fichero de entrada: ");

        try {
            ruta = sc.nextLine();

            // Apertura del fichero para lectura
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            // si el fichero nno existe tenemos nuestro FileNotFoundException 
            // si no tengo permisos genera un IOException

            String linea;

            // leemos lineas del fichero;
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                
                // Genero la copia del fichero
                Utils.escribeFichero(".\\CopiaFichero.txt", linea);
                
                linea = br.readLine();
            }
            
            // Cerramos el manejador del fichero
            br.close();

        } catch (FileNotFoundException fnfe) {
            logError = "Fichero no encontrado";
        } catch (IOException ioe) {
            logError = "Error de lectura";
        } catch (Exception e) {
            logError = "illooooo esto no esta funcionando";
        } finally {
            sc.close();

            // Escribir en fichero de log o en BBDD la variable logError.
        }

    }

}
