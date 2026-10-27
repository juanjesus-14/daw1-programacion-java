package mainescriturafichero;

import java.io.*;
import java.util.Scanner;

public class MainEscrituraFichero {

    public static void main(String[] args) {
// Solicitar una ruta de un fichero y vamos a escribir por pantalla todo lo que tiene el fichero.        
        String logError = "";
        String ruta = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la ruta completa del fichero de entrada: ");

        try {
            ruta = sc.nextLine();

            // Apertura del fichero para lectura
            BufferedReader br = new BufferedReader(new FileReader(ruta));

            // que pasa con este new BufferedReader
            // si el fichero no existe tenemos nuestroFileNotFoundException
            // si no tengo permisos genera un IOException
            // empezmaos a leer
            String linea;

            //leemos lineas del fichero;
            linea = br.readLine(); // lee txto es solo Read es para int

            while (linea != null) {
                System.out.println(linea); // directamente pasamos a consola
                
                
                //GENERO LA COPIA DEL FICHERO
                
//                Utils.EscribeFichero(".\\CopiaFichero.txt", linea);
                
                Utils.corrigeFichero(".\\CorregidoFichero.txt", linea);
                
                linea = br.readLine(); // para que lo vuelva a leer
                // Para leer añado el .\nombre.txt
            }

            //Cerramos el manejador del fichero
            br.close(); // tiene que ir aqui en este caso y no en l finally 
            
        } catch (FileNotFoundException fnfe) {// error de encuentro del fichero
            logError = "Fichero no encontrado";

        } catch (IOException ioe) { // esto es para el error de escribir o leed
            logError = "Error de lectura";

        } catch (Exception e) {
            logError = "illo esto no ha funcionado";

        } finally {
            sc.close();

            //Escribir un fichero de log o en BBDD la variable logError.
        }

    }
}

//// Escritura en fichero
//        String ficheroEsc = "D:\\workspace\\Programacion\\UD7\\NuevoFich.txt";
//        Scanner sc = new Scanner(System.in);
//        try{
//            String frase = "";
//            // Escritura en el fichero
//            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc));
//            // FileWriter si no existe el fichero lo crea, y si existe lo abre.
//            // BufferedWriter nos mejor el rendimiento y facilita la escritura en el fichero.
//            do {
//                // Pedimos los datos
//                System.out.print("Introduce la siguiente frase: ");
//                frase = sc.nextLine();
//                
//                if (!frase.equalsIgnoreCase("fin")){
//                    bw.write(frase);
//                    bw.newLine();
//                }       
//            } while (!frase.equalsIgnoreCase("fin"));
//            
//            // cerrar el fichero
//            bw.close();           
//        } catch (IOException ioe){
//            System.out.println("Error al escribir en el fichero");
//        }