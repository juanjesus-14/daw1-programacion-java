/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examencompletoprueba;

import java.io.*;

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
        System.out.print("Introduce la ruta: ");
        String ruta = System.console().readLine();

        File directorio = new File(ruta);

        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
        } else {
            File[] archivos = directorio.listFiles();

            if (archivos == null || archivos.length == 0) {
                System.out.println("El directorio está vacío.");
            } else {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("logMensual.txt", true))) {

                    for (File f : archivos) {
                        String linea = (f.isDirectory() ? "D" : "F") + ";" + f.getName() + ";" + f.getAbsolutePath();
                        bw.write(linea);
                        bw.newLine();
                        System.out.println(linea);
                    }
                    System.out.println("Log generado correctamente.");

                } catch (IOException ioe) {
                    System.out.println("Error al escribir el log: " + ioe.getMessage());
                }
            }
        }

        // ---- EJERCICIO 2: gestión del banco ----
        Banco banco = new Banco("B001", "Mi Banco");

        Utils.cargaClientes(banco);
        Utils.cargaCuentas(banco);

        int opcion;
        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Mostrar clientes y sus cuentas");
            System.out.println("2. Insertar cliente");
            System.out.println("3. Insertar cuenta");
            System.out.println("4. Modificar saldo de una cuenta");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    Utils.mostrarClientes(banco);
                    break;
                case 2:
                    Utils.insertarCliente(banco);
                    break;
                case 3:
                    Utils.insertarCuenta(banco);
                    break;
                case 4:
                    Utils.modificarSaldoCuenta(banco);
                    break;
                case 5:
                    Utils.eliminarCliente(banco);
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
