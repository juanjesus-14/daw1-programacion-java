package maintienda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class MainTienda {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("------------------------Ejercicio 1------------------------");
        System.out.println("Dime la ruta del fichero");

        String ruta = System.console().readLine();
        File fichero = new File(ruta);

        if (fichero.exists()) {
            if (fichero.isDirectory()) {
                System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
                String ficheroEsc = "F:\\workspace\\programacion\\UD7\\EXAMEN\\MainTienda\\archivos\\logMensual.txt";
                try {
                    File[] archivos = fichero.listFiles();
                    System.out.println("Longitud: " + archivos.length);
                    for (File f : archivos) {
                        String frase = (f.isDirectory() ? "D" : "F") + " ; " + f.getName() + " ; " + f.getAbsolutePath();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc, true));

                        bw.write(frase);
                        bw.newLine();
                        bw.close();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error al escribir en el fichero");
                }
            }
        } else {
            System.out.println("Fichero no encontrado");
        }

        System.out.println("\n------------------------Ejercicio 2------------------------");

        int opcion;
        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Mostrar personas");
            System.out.println("2. Insertar personas");
            System.out.println("3. Insertar mascotas");
            System.out.println("4. Mostrar personas.txt");
            System.out.println("5. Mostrar mascotas.txt");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                case 1:
                    mostrarPersonasMascotas("personas.txt");
                    break;
                case 2:
                    guardar("personas.txt");
                    break;
                case 3:
                    guardar("mascotas.txt");
                    break;
                case 4:
                    mostrar("personas.txt");
                    break;
                case 5:
                    mostrar("mascotas.txt");
                    break;
            }
        } while (opcion != 0); // salir cuando el usuario elija 0
    }

    public static void guardar(String fichero) {

        try {
            FileWriter fw = new FileWriter(fichero, true);
            System.out.println("Introduce los datos separados por ;");
            String datos = sc.nextLine();
            fw.write(datos + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar datos");
        }
    }

    public static void mostrar(String fichero) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer fichero");
        }
    }

    public static void mostrarPersonasMascotas(String fichero) {

        String linea = "";
        int contLinea = 0;
        ArrayList<Persona> listaPersona = new ArrayList<>();

        String ruta2 = "F:\\workspace\\programacion\\UD7\\EXAMEN\\MainTienda\\personas.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta2));
            linea = br.readLine();

            System.out.println("-----------------");
            System.out.println("Persona");

            while (linea != null) {
                System.out.println(linea);

                ListadoTiendaVeterinaria.creaPeryMas(linea, listaPersona, contLinea);

                linea = br.readLine();
                contLinea++;
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ioe) {
            System.out.println("Error de lectura");
        } catch (Exception e) {

            // Cualquier otro error inesperado
            System.out.println("Error inesperado");
        }

        for (Persona d : listaPersona) {
            System.out.println(d);
            System.out.println("\n--Mascotas--");
            for (int i = 0; i < listaPersona.size(); i++) {
                listaPersona.get(i).listarMascotas();
            }
        }
    }
}
