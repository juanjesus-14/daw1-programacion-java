package mainfile;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MainFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File fichero = new File("F:\\workspace\\programacion\\UD7");

        if (fichero.exists()) {
            try {
                System.out.println("Nombre: " + fichero.getName());
                System.out.println("Ruta absoluta: " + fichero.getAbsolutePath() + " -- " + fichero.getCanonicalPath());
                System.out.println("¿Es fichero ?: " + fichero.isFile());
                System.out.println("¿Es directorio?: " + fichero.isDirectory());
                System.out.println("Tamanyo(bytes): " + fichero.length());
                System.out.println("Total space: " + ((fichero.getTotalSpace() / 1024) / 1024) + " -- FreeSpace: " + ((fichero.getFreeSpace() / 1024) / 1024) + " -- UsableSpace: " + ((fichero.getUsableSpace() / 1024) / 1024));
                System.out.println("----------------------------------------------------------------------");
            } catch (IOException ex) {
                System.out.println("Illi nos ha dado eror: " + ex.getMessage());
            }
        } else {
            System.out.println("La ruta no existe");
        }

        // opcion 1
//        if (fichero.isDirectory()) {
//            //Listamos todos los ficheros directorios que hay en la ruta
//            System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
//            File[] archivos = fichero.listFiles();
//            System.out.println("Longitud: " + archivos.length);
//            if (archivos != null) {
//                for (File f : archivos) {
//                    System.out.println((f.isDirectory() ? "[DIR]" : "[FICH]") + f.getName());
//                }
//            }
//        }
        // opcion 2
//        if (fichero.isDirectory()) {
//            //Listamos todos los ficheros directorios que hay en la ruta
//            System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
//            File[] archivos = fichero.listFiles();
//            System.out.println("Longitud: " + archivos.length);
//            if (archivos != null) {
//                for (int i = 0; i < archivos.length; i++) {
//                    System.out.println((archivos[i].isDirectory() ? "[DIR]" : "[FICH]") + archivos[i].getName());
//                }
//            }
//        }
        // opcion 3
//        String[] archivos2 = fichero.list();
//        for (int i = 0; i < archivos2.length; i++) {
//            System.out.println(archivos2[i]);
//        }
        // opcion 4
        String[] archivos3 = fichero.list();
        for (String a : archivos3) {
            System.out.println(((a.indexOf(".") > 0) ? "[FICH] " : "[DIR] ") + a);
        }

        // Escritura en fichero
        String ficheroEsc = "F:\\workspace\\programacion\\UD7\\NuevoFich.txt";
        Scanner sc = new Scanner(System.in);
        try {
            String frase = "";
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc));
            // FileWriter si no existe el fichero lo crea, y si existe lo abre.
            // BufferedWriter nos mejora el rendimiento y facilita la escritura en el fichero
            do {
                // Pedimos los datos 
                System.out.println("introduce la siguiente frase: ");
                frase = sc.nextLine();

                if (!frase.equalsIgnoreCase("fin")) {
                    bw.write(frase);
                    bw.newLine();
                }
            } while (!frase.equalsIgnoreCase("fin"));
            bw.close();

        } catch (IOException ioe) {
            System.out.println("Error al escribir en el fichero");
        }

        // Jugamos solicitando una ruta del fichero a crear. Vamos a utilizar ahora PrintWriter
        try {
            // Solicitamos ruta del fichero
            System.out.println("Dime la ruta absoluta para crear el fichero: ");
            String ruta = sc.nextLine();


            // Creamos el PrintWriter
            PrintWriter pw = new PrintWriter(ruta);
            String frase = "";
            // Leemos linea a linea y escribimos en el fichero
            while (true) {
                // Pedimos los datos 
                System.out.println("introduce la siguiente frase: ");
                frase = sc.nextLine();

                if (!frase.equalsIgnoreCase("fin")) {
                    pw.println(frase);
                } else {
                    break;
                }
            }
            // cerramos
            pw.close();
            System.out.println("Fichero generado correctamente.");

        } catch (FileNotFoundException fnfe) {
            System.out.println("illo, revisa la ruta que te has equivocado.");
        }

    }
}
