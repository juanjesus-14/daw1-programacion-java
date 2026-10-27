package mainordenador.pkg3.pkg5;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainOrdenador35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 2º Evolución de este ejercicio,... vamos a incluir un atributo IDInventario y vamos a jugar con la 
        // eliminación del artículo,... verificación de que el ID de inventario existe,...

        int opcion = 0;
        int idinventario = 0;

        ArrayList<Ordenador35> lista = new ArrayList<>();

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
            boolean encontrado = false;

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
                    idinventario++;

                    Ordenador35 oTemp = new Ordenador35(marca, modelo, RAM, procesador, precio, portatil, idinventario);
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
                    for (int i = 0; i < lista.size(); i++) {
                        if (numOrdenador == lista.get(i).getIdInventario()) {
                            System.out.println("Dime la RAM que amplias:");
                            RAM = Integer.parseInt(System.console().readLine());
                            lista.get(i).ampliarRAM(RAM);
                        } else if ((i == lista.size() - 1) && (numOrdenador != lista.get(i).getIdInventario())) {
                            System.out.println("No existe ese IdInventario.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qué número de ordenador quieres modificar el precio: ");
                    numOrdenador = Integer.parseInt(System.console().readLine());
                    encontrado = false;
                    for (int i = 0; i < lista.size(); i++) {
                        if (numOrdenador == lista.get(i).getIdInventario()) {
                            System.out.println("Dime el precio nuevo: ");
                            precio = Double.parseDouble(System.console().readLine());
                            lista.get(numOrdenador - 1).setPrecio(precio);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No existe ese IdInventario.");
                    }
                    break;
                case 5:
                    System.out.println("Qué número de ordenador quieres eleminar: ");
                    numOrdenador = Integer.parseInt(System.console().readLine());
                    for (int i = 0; i < lista.size(); i++) {
                        if (numOrdenador == lista.get(i).getIdInventario()) {
                            lista.remove(i);
                        } else if ((i == lista.size() - 1) && (numOrdenador != lista.get(i).getIdInventario())) {
                            System.out.println("No existe ese IdInventario.");
                        }
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
