/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio 5 – Gestión de productos
//        Crear un programa que permita:
//            1. Añadir productos con el formato:
//            2. id;nombre;precio
//            3. Guardarlos en productos.txt
//            4. Mostrar todos los productos almacenados
//           Ejemplo:
//             1;Teclado;25.99
//             2;Ratón;12.50
//         Ampliación:
//            - Mostrar el producto más caro (utilizar para ello LinkedList).
//            - Calcular el precio medio.
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    estadisticas();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    public static void añadirProducto() {
        try {
            System.out.print("ID: ");
            String id = System.console().readLine();
            System.out.print("Nombre: ");
            String nombre = System.console().readLine();
            System.out.print("Precio: ");
            String precio = System.console().readLine();

            FileWriter fw = new FileWriter("productos.txt", true);
            fw.write(id + ";" + nombre + ";" + precio + "\n");
            fw.close();

            System.out.println("Producto guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
        }
    }

    public static void mostrarProductos() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
            String linea;

            System.out.println("\n--- PRODUCTOS ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay productos guardados todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer los productos.");
        }
    }

    public static void estadisticas() {
        LinkedList<Double> precios = new LinkedList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                precios.add(Double.parseDouble(partes[2]));
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("No hay productos guardados todavía.");
            return;
        } catch (IOException e) {
            System.out.println("Error al leer los productos.");
            return;
        }

        if (precios.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        double max = 0;
        double suma = 0;
        for (double p : precios) {
            if (p > max) {
                max = p;
            }
            suma += p;
        }

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Producto más caro: " + max + "€");
        System.out.println("Precio medio: " + (suma / precios.size()) + "€");
    }
}
