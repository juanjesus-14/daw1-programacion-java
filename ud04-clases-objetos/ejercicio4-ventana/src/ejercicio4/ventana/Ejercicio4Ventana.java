/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4.ventana;

/**
 *
 * @author juand
 */
public class Ejercicio4Ventana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      --EJERCICIO 4--Ventana--
//      Atributos: color, tamaño, titulo, nomAplicacion.
//      Metodos o Acciones: Cierra, Minimiza, Aumenta, Abre, Alinear, Redimensiona.

        Ventana v1 = new Ventana("Azul", "800x600", "Documento1", "Editor de Texto");

        v1.abre();
        v1.minimiza();
        v1.aumenta();
        v1.redimensiona("1280x720");
        v1.alinear("centro");
        v1.cierra();

        System.out.println(v1);
    }
}
