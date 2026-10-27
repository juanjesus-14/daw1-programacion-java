package mainordenador.pkg2.pkg5;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainOrdenador25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Clase Ordenador
        // Incluye atributos típicos: marca, modelo, RAM, procesador, precio y si es portátil o no.        
        //2 constructores 1 sin parametros y otro con todos los parametros

        int opcion = 0;
        ArrayList<Ordenador25> lista = new ArrayList<>();

        do {
            System.out.println("\n--- MENU ORDENADORES ---");
            System.out.println("1. Añadir ordenador.");
            System.out.println("2. Mostrar todos.");
            System.out.println("3. Modificar RAM.");
            System.out.println("4. Modificar precio.");
            System.out.println("5. Eliminar ordenador.");
            System.out.println("6. Salir");

            opcion = Integer.parseInt(System.console().readLine());

            String marca;
            String modelo;
            int RAM;
            String procesador;
            double precio;
            boolean portatil;
            int numOrdenador = -1;

            switch (opcion) {
                case 1:
                    System.out.println("Dime la marca: ");
                    marca = System.console().readLine();
                    System.out.println("Dime el modelo: ");
                    modelo = System.console().readLine();
                    System.out.println("Dime la RAM: ");
                    RAM = Integer.parseInt(System.console().readLine());
                    System.out.println("Dime el procesador: ");
                    procesador = System.console().readLine();
                    System.out.println("Dime el precio: ");
                    precio = Integer.parseInt(System.console().readLine());
                    System.out.println("Indica si, si es portatil: ");
                    portatil = System.console().readLine().toLowerCase().equals("si");

                    Ordenador25 oTemp = new Ordenador25(marca, modelo, RAM, procesador, precio, portatil);
                    lista.add(oTemp);
                    break;
                case 2:
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i).toString());
                    }
                    break;
                case 3:
                    System.out.println("Qué número de ordenador quieres ampliar: ");
                    numOrdenador = Integer.parseInt(System.console().readLine());
                    if (numOrdenador <= lista.size()) {
                        System.out.println("Dime la RAM que amplias:");
                        RAM = Integer.parseInt(System.console().readLine());
                        lista.get(numOrdenador - 1).ampliarRAM(RAM);
                    } else {
                        System.out.println("El número de ordenador seleccionado no existe.");
                    }
                    break;
                case 4:
                    System.out.println("Qué número de ordenador quieres modificar el precio: ");
                    numOrdenador = Integer.parseInt(System.console().readLine());
                    if (numOrdenador <= lista.size()) {
                        System.out.println("Dime el precio nuevo: ");
                        precio = Integer.parseInt(System.console().readLine());
                        lista.get(numOrdenador - 1).setPrecio(precio);
                    } else {
                        System.out.println("El número de ordenador seleccionado no existe.");
                    }
                    break;
                case 5:
                    System.out.println("Qué número de ordenador quieres eleminar: ");
                    numOrdenador = Integer.parseInt(System.console().readLine());
                    if (numOrdenador <= lista.size()) {
                        lista.remove(numOrdenador - 1);                       
                    } else {
                        System.out.println("El número de ordenador seleccionado no existe.");
                    }
                    break;
                case 6:
                    System.out.println("Gracias por utilizar nuestro servicio.");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 6);
    }
}
