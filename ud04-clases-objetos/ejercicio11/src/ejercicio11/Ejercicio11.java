/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio11;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      Ejercicio 11: 
//      El ejercicio anterior, pero facilitando un menú que permita almacenar múltiples libros y el obtener el libro que 
//      tiene más páginas implique recorrer la colección (ArrayList).

        ArrayList<Libro> biblioteca = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ LIBROS ===");
            System.out.println("1) Añadir libro");
            System.out.println("2) Listar libros");
            System.out.println("3) Mostrar libro con más páginas");
            System.out.println("4) Eliminar libro por ISBN");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = System.console().readLine();

            try {
                switch (opcion) {
                    case "1":
                        System.out.print("ISBN: ");
                        String isbn = System.console().readLine();

                        System.out.print("Título: ");
                        String titulo = System.console().readLine();

                        System.out.print("Autor: ");
                        String autor = System.console().readLine();

                        System.out.print("Número de páginas: ");
                        String paginasStr = System.console().readLine();
                        int paginas = Integer.parseInt(paginasStr);
                        if (paginas < 0) {
                            System.out.println("El número de páginas no puede ser negativo.");
                            break;
                        }

                        biblioteca.add(new Libro(isbn, titulo, autor, paginas));
                        System.out.println("Libro añadido.");
                        break;

                    case "2":
                        if (biblioteca.isEmpty()) {
                            System.out.println("No hay libros registrados.");
                        } else {
                            System.out.println("\nListado de libros:");
                            for (int i = 0; i < biblioteca.size(); i++) {
                                System.out.println("[" + i + "] " + biblioteca.get(i));
                            }
                        }
                        break;

                    case "3":
                        if (biblioteca.isEmpty()) {
                            System.out.println("La biblioteca está vacía.");
                        } else {
                            Libro mayor = biblioteca.get(0);
                            for (int i = 1; i < biblioteca.size(); i++) {
                                if (biblioteca.get(i).getNumPaginas() > mayor.getNumPaginas()) {
                                    mayor = biblioteca.get(i);
                                }
                            }
                            System.out.println("El libro con más páginas es:");
                            System.out.println(mayor);
                        }
                        break;

                    case "4":
                        if (biblioteca.isEmpty()) {
                            System.out.println("La biblioteca está vacía.");
                        } else {
                            System.out.print("Introduce el ISBN del libro a eliminar: ");
                            String isbnEliminar = System.console().readLine();
                            int indice = -1;
                            for (int i = 0; i < biblioteca.size(); i++) {
                                if (biblioteca.get(i).getIsbn().equalsIgnoreCase(isbnEliminar)) {
                                    indice = i;
                                    break;
                                }
                            }
                            if (indice != -1) {
                                System.out.println("Libro eliminado: " + biblioteca.get(indice).getTitulo());
                                biblioteca.remove(indice);
                            } else {
                                System.out.println("No se encontró libro con ese ISBN.");
                            }
                        }
                        break;

                    case "0":
                        salir = true;
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Entrada inválida: se esperaba un número. " + nfe.getMessage());
            } catch (Exception ex) {
                System.out.println("Error inesperado: " + ex.getMessage());
            }
        }
    }
}