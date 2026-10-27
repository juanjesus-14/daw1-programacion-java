package ejarraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author DAW
 */
public class EjArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // ArrayList crece y decrece de forma dinámica
        //        Opciones
        //        Operaciones básicas con ArrayList
        //        Acción Método		Ejemplo Descripción
        //        Añadir elemento	     add()	                 numeros.add(5);          Inserta un nuevo elemento al final 
        //        Obtener elemento	      get()	                  numeros.get(0);          Devuelve el elemento de la posición indicada 
        //        Cambiar valor                    set()                       numeros.set(0, 10);    Modifica el valor en una posición
        //        Eliminar elemento	      remove()	numeros.remove(2);    Borra el elemento en el índice 2
        //        Tamaño de la lista             size()	                  numeros.size();            Devuelve el número de elementos 
        //        Vaciar lista                         clear()     	numeros.clear();           Elimina todos los elementos
        //        Comprobar si está vacía    isEmpty()	numeros.isEmpty();      Devuelve true si no hay elementos 
        // Crear ArrayList dinámico
        ArrayList<Integer> numeros = new ArrayList<>();

        int opcion = 2;

        // Menú
        do {
            System.out.println("\nPulse 1 para añadir número y 0 para salir.");
            opcion = Integer.parseInt(System.console().readLine());
            if (opcion == 1) {
                System.out.println("Introduce un nuevo número:");
                int num = Integer.parseInt(System.console().readLine());
                numeros.add(num);
            } else if (opcion != 0) {
                System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);

        // Comprobar si está vacío
        if (numeros.isEmpty()) {
            System.out.println("La estructura está vacía.");
        } else {
            int max = numeros.get(0);
            int min = numeros.get(0);

            System.out.println("\nDisponemos de " + numeros.size() + " elementos.");

            // =====================================================
            // OPCIÓN 1 - FOREACH
            // =====================================================
            System.out.println("\nRecorrido con foreach:");

//            for (int numero : numeros) {
//
//                System.out.print(numero + " ");
//
//                if (numero > max) {
//                    max = numero;
//                }
//
//                if (numero < min) {
//                    min = numero;
//                }
//            }
            // =====================================================
            // OPCIÓN 2 - FOR CON ÍNDICES
            // =====================================================
            System.out.println("\nRecorrido con índices:");

//            for (int i = 0; i < numeros.size(); i++) {
//
//                System.out.print(numeros.get(i) + " ");
//
//                if (numeros.get(i) > max) {
//                    max = numeros.get(i);
//                }
//
//                if (numeros.get(i) < min) {
//                    min = numeros.get(i);
//                }
//            }
            // =====================================================
            // OPCIÓN 3 - ITERATOR
            // =====================================================
            System.out.println("\nRecorrido con Iterator:");
            Iterator<Integer> it = numeros.iterator();
            while (it.hasNext()) {
                int numero = it.next();
                System.out.print(numero + " ");
                if (numero > max) {
                    max = numero;
                }
                if (numero < min) {
                    min = numero;
                }
            }

            // Mostrar resultados
            System.out.println("\n\nMáximo: " + max);
            System.out.println("Mínimo: " + min);
        }
    }
}
