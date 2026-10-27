/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casa1.pkg2;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Casa12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE PRODUCTOS =====");
            System.out.println("1. Añadir producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Mostrar producto con más stock");
            System.out.println("0. Salir");

            opcion = rangoCorrecto(System.console().readLine(), 0, 5);

            switch (opcion) {
                case 1:
                    añadirProducto(nombres, stock);
                    break;
                case 2:
                    venderProducto(nombres, stock);
                    break;
                case 3:
                    reponerProducto(nombres, stock);
                    break;
                case 4:
                    mostrarInventario(nombres, stock);
                    break;
                case 5:
                    productoMasStock(nombres, stock);
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
    }

    // Añadir producto
    public static void añadirProducto(ArrayList<String> nombres,
            ArrayList<Integer> stock) {

        System.out.println("Nombre del producto:");
        String nombre = System.console().readLine();

        System.out.println("Stock inicial:");
        int unidades = Integer.parseInt(System.console().readLine());

        nombres.add(nombre);
        stock.add(unidades);

        System.out.println("Producto añadido.");
    }

    // Vender producto
    public static void venderProducto(ArrayList<String> nombres,
            ArrayList<Integer> stock) {

        System.out.println("Producto a vender:");
        String nombre = System.console().readLine();

        boolean encontrado = false;

        for (int i = 0; i < nombres.size(); i++) {
            if (nombre.equalsIgnoreCase(nombres.get(i))) {
                encontrado = true;
                if (stock.get(i) > 0) {
                    stock.set(i, stock.get(i) - 1);
                    System.out.println("Venta realizada.");
                } else {
                    System.out.println("No hay stock.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    // Reponer producto
    public static void reponerProducto(ArrayList<String> nombres,
            ArrayList<Integer> stock) {

        System.out.println("Producto a reponer:");
        String nombre = System.console().readLine();

        boolean encontrado = false;

        for (int i = 0; i < nombres.size(); i++) {
            if (nombre.equalsIgnoreCase(nombres.get(i))) {
                encontrado = true;
                System.out.println("Cantidad a añadir:");
                int cantidad = Integer.parseInt(System.console().readLine());
                stock.set(i, stock.get(i) + cantidad);
                System.out.println("Stock actualizado.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    // Mostrar inventario
    public static void mostrarInventario(ArrayList<String> nombres,
            ArrayList<Integer> stock) {

        if (nombres.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        System.out.println("\n----- INVENTARIO -----");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println((i + 1) + ". " + nombres.get(i) + " | Stock: " + stock.get(i));
        }

    }

    // Producto con más stock
    public static void productoMasStock(ArrayList<String> nombres,
            ArrayList<Integer> stock) {

        if (nombres.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }

        int posMax = 0;

        for (int i = 1; i < stock.size(); i++) {
            if (stock.get(i) > stock.get(posMax)) {
                posMax = i;
            }
        }

        System.out.println("Producto con más stock:");
        System.out.println(nombres.get(posMax) + " -> " + stock.get(posMax) + " unidades");
    }

    // Control de errores
    public static int rangoCorrecto(String texto, int min, int max) {

        int numero;

        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto.");
            return -1;
        }
        if (numero < min || numero > max) {
            System.out.println("Valor fuera de rango.");
            return -1;
        }
        return numero;
    }
}
