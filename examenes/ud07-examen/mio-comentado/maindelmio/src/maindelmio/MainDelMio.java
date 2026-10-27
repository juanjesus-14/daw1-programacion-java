/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maindelmio;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class MainDelMio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        //(2,5 puntos) Solicita por consola la ubicación de los ficheros origen del presente ejercicio y a continuación
//        //genera un log resumen de todos los ficheros y directorios existentes en dicha ubicación. Para ello el formato
//        //esperado es: directorio/fichero;nombre_fichero
//        
//        System.out.println("--Ejercicio 1--");
//        System.out.println("Dime la ruta del fichero");
//
//        // Leemos la ruta escrita por teclado
//        String ruta = System.console().readLine();
//
//        // Creamos objeto File con la ruta
//        File fichero = new File(ruta);
//
//        // Comprobamos que exista
//        if (fichero.exists()) {
//
//            // Comprobamos que sea un directorio/carpeta
//            if (fichero.isDirectory()) {
//
//                // Mostramos la ruta absoluta
//                System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());
//
//                // Ruta del fichero log
//                String ficheroEsc = "F:\\workspace\\programacion\\UD7\\EXAMEN\\mio(comentado)\\logMensual.txt";
//
//                try {
//
//                    // Guardamos todos los archivos y carpetas
//                    // existentes dentro de la ruta
//                    File[] archivos = fichero.listFiles();
//
//                    // Mostramos cantidad de elementos
//                    System.out.println("Longitud: " + archivos.length);
//
//                    // Recorremos todos los archivos/carpetas
//                    for (File f : archivos) {
//
//                        // Creamos frase:
//                        // directorio/fichero;nombre
//                        String frase = (f.isDirectory() ? "directorio" : "fichero") + ";" + f.getName();
//
//                        // Creamos BufferedWriter para escribir
//                        // en el fichero log
//                        // El TRUE es MUY IMPORTANTE:
//                        // añade contenido sin borrar el anterior
//                        BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc, true));
//
//                        // Escribimos línea
//                        bw.write(frase);
//
//                        // Salto de línea
//                        bw.newLine();
//
//                        // Cerramos fichero
//                        bw.close();
//                    }
//
//                } catch (IOException ioe) {
//
//                    // Error de escritura
//                    System.out.println("Error al escribir en el fichero");
//                }
//
//            }
//
//        } else {
//
//            // Si la ruta no existe
//            System.out.println("Fichero no encontrado");
//        }

        // Inicio ejercicio 2
//b) (7,5 puntos) Realiza la lectura oportuna de empleados. Debes definir las clases según el diseño UML facilitado.
//   i) Lectura de departamentosMes-Año.txt y presentación de la información en consola.
//      (1 punto) Control de errores adecuado (try/catch, existe ruta,…).
//Nota: el no trabajar con los tipos de datos definidos en el UML (LocalDate,…) resta puntuación.
//Nota2: ese 3-26 del nombre del fichero viene del Mes-Año que debemos incorporar en la ejecución oportuna que se realiza (mensualmente estos valores cambiarán).
//Formato: codDepto;nombreDepto;numEmpleado;dni;nombre;apellidos;email;fechaContratacion
        System.out.println("\n------Inicio de Ejercicio 2------");

// Variable para guardar cada línea del fichero
        String linea = "";

// Contador de líneas leídas
        int contLinea = 0;

// ArrayList donde almacenaremos todos los departamentos
        ArrayList<Departamento> listaDeptos = new ArrayList<>();

// Ruta del fichero:
// departamentosMes-Año.txt
// Ejemplo: departamentos5-26.txt
        //String ruta2 = "D:\\workspace\\programacion\\UD7\\examenSara\\mio\\empleados3-26.txt";
        String ruta2 = "F:\\workspace\\programacion\\UD7\\EXAMEN\\mio(comentado)\\empleados" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear() + ".txt";

        try {

            // Apertura del fichero para lectura
            BufferedReader br = new BufferedReader(new FileReader(ruta2));

            // Leemos primera línea
            linea = br.readLine();

            System.out.println("Datos del fichero:");

            // Mientras haya líneas en el fichero
            while (linea != null) {

                // Mostrar línea leída
                System.out.println(linea);

                // Método que:
                // - crea departamentos
                // - crea empleados
                // - relaciona empleados con departamentos
                Utils.creaDepYEmp(linea, listaDeptos, contLinea);

                // Leer siguiente línea
                linea = br.readLine();

                // Incrementar contador
                contLinea++;
            }

            // Cerramos fichero
            br.close();

        } catch (FileNotFoundException fnfe) {

            // Error si el fichero no existe
            System.out.println("Fichero no encontrado");

        } catch (IOException ioe) {

            // Error de lectura
            System.out.println("Error de lectura");

        } catch (Exception e) {

            // Cualquier otro error inesperado
            System.out.println("Error inesperado");
        }

// Mostrar organigrama
        System.out.println("\n--Organigrama--");

// Recorremos departamentos
        for (Departamento d : listaDeptos) {

            // Mostramos información del departamento
            System.out.println(d);
        }

// Mostrar empleados por departamento
        System.out.println("\n--Empleados por departamento--");

// Recorremos departamentos
        for (int i = 0; i < listaDeptos.size(); i++) {

            // Mostrar empleados de cada departamento
            listaDeptos.get(i).listarEmpleados();
        }
    }
}
