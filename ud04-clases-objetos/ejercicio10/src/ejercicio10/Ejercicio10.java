/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10;

/**
 *
 * @author juand
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//      Ejercicio10: Crear una clase Libro que contenga los siguientes atributos: ISBN, Titulo, Autor, Número de páginas
//      Crear sus respectivos métodos get y set correspondientes para cada atributo. Crear el método toString(), tal y 
//      como explica en los apuntes, para mostrar la información relativa al libro con el siguiente formato: «El libro con ISBN creado por el autor tiene páginas»
//      En el fichero main, crear 2 objetos Libro (los valores que se quieran) y mostrarlos por pantalla.
//      Por último, indicar cuál de los 2 tiene más páginas.
        
   Libro libro1 = new Libro("978-1234567890", "El Principito", "Antoine de Saint-Exupéry", 120);
        Libro libro2 = new Libro("978-9876543210", "1984", "George Orwell", 328);

        System.out.println(libro1);
        System.out.println(libro2);

        if (libro1.getNumPaginas() > libro2.getNumPaginas()) {
            System.out.println("El libro '" + libro1.getTitulo() + "' tiene más páginas.");
        } else if (libro2.getNumPaginas() > libro1.getNumPaginas()) {
            System.out.println("El libro '" + libro2.getTitulo() + "' tiene más páginas.");
        } else {
            System.out.println("Ambos libros tienen el mismo número de páginas.");
        }
    }
}