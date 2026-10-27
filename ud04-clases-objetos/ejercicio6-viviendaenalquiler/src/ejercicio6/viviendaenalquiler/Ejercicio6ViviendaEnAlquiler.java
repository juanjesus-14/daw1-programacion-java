/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6.viviendaenalquiler;

/**
 *
 * @author juand
 */
public class Ejercicio6ViviendaEnAlquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      EJERCICIO 6--ViviendaEnAlquiler--
//      Atributos: metros, numeroVentanas, numeroHabitaciones, direccion, metrosTerraza, tienePiscina, tieneGaraje, tipo (local, piso, chalet), precioAlquiler, disponible. 
//      Realizar el override de toString.
//      Crear la clase viviendaAlquiler y genera en el main varias vivientas en alquiler.
        Vivienda v1 = new Vivienda(100, 5, 3, "Una cualquiera", 20, true, true, "Piso", 900.0, true);
        System.out.println("Vivienda 1: " + v1);
        Vivienda v2 = new Vivienda(200, 4, 7, "Una cualquiera", 20, false, true, "Casa", 1400.0, true);
        System.out.println("Vivienda 2: " + v2);

    }

}
