/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examencompletoprueba;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class ExamenCompletoPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---- EJERCICIO 1: log de ficheros/directorios ----
        //opcion1
//        System.out.print("Introduce la ruta: ");
//        String ruta = System.console().readLine();
//
//        File directorio = new File(ruta);
//
//        if (!directorio.exists() || !directorio.isDirectory()) {
//            System.out.println("La ruta no existe o no es un directorio.");
//        } else {
//            File[] archivos = directorio.listFiles();
//
//            if (archivos == null || archivos.length == 0) {
//                System.out.println("El directorio está vacío.");
//            } else {
//                try (BufferedWriter bw = new BufferedWriter(new FileWriter("logMensual.txt", true))) {
//
//                    for (File f : archivos) {
//                        String linea = (f.isDirectory() ? "D" : "F") + ";" + f.getName() + ";" + f.getAbsolutePath();
//                        bw.write(linea);
//                        bw.newLine();
//                        System.out.println(linea);
//                    }
//                    System.out.println("Log generado correctamente.");
//
//                } catch (IOException ioe) {
//                    System.out.println("Error al escribir el log: " + ioe.getMessage());
//                }
//            }
//        }

        //opcion2
        System.out.println("Ejercicio 1");
        System.out.println("Dime la ruta del fichero");
        String ruta = System.console().readLine();
        File fichero = new File(ruta);

        if (fichero.exists()) {
            if (fichero.isDirectory()) {
                System.out.println("\nContenido de la ruta: " + fichero.getAbsolutePath());

                File[] archivos = fichero.listFiles();

                if (archivos == null || archivos.length == 0) {
                    System.out.println("El directorio está vacío o no se pudo leer.");
                } else {
                    System.out.println("Longitud: " + archivos.length);
                    String ficheroEsc = "D:\\workspace\\programacion\\UD7\\RECUPERACION\\ExamenFacilPrueba\\logMensual.txt";

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEsc, true))) {
                        for (File f : archivos) {
                            String frase = (f.isDirectory() ? "D" : "F") + ";" + f.getName() + ";" + f.getAbsolutePath();
                            bw.write(frase);
                            bw.newLine();
                            System.out.println(frase);
                        }
                    } catch (IOException ioe) {
                        System.out.println("Error al escribir en el fichero");
                    }
                }
            } else {
                System.out.println("La ruta indicada no es un directorio.");
            }
        } else {
            System.out.println("Fichero no encontrado");
        }
        
        // ---- EJERCICIO 2: gestión de clientes y cuentas ----
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        Utils.cargaClientes(listaClientes);
        Utils.cargaCuentas(listaClientes);

        int opcion;
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Mostrar clientes y sus cuentas");
            System.out.println("2. Insertar cliente");
            System.out.println("3. Insertar cuenta");
            System.out.println("4. Modificar saldo de una cuenta");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Eliminar cuenta");
            System.out.println("7. Eliminar cliente y sus cuentas asociadas");
            System.out.println("8. Modificar datos de un cliente");
            System.out.println("9. Transferencia entre cuentas");
            System.out.println("10. Listar cuentas de un cliente");
            System.out.println("11. Saldo total de un cliente");
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
                    Utils.mostrarClientes(listaClientes);
                    break;
                case 2:
                    Utils.insertarCliente(listaClientes);
                    break;
                case 3:
                    Utils.insertarCuenta(listaClientes);
                    break;
                case 4:
                    Utils.modificarSaldoCuenta(listaClientes);
                    break;
                case 5:
                    Utils.eliminarCliente(listaClientes);
                    break;
                case 6:
                    Utils.eliminarCuenta(listaClientes);
                    break;
                case 7:
                    Utils.eliminarClienteConCuentas(listaClientes);
                    break;
                case 8:
                    Utils.modificarDatosCliente(listaClientes);
                    break;
                case 9:
                    Utils.transferenciaEntreCuentas(listaClientes);
                    break;
                case 10:
                    Utils.listarCuentasDeCliente(listaClientes);
                    break;
                case 11:
                    Utils.saldoTotalCliente(listaClientes);
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
