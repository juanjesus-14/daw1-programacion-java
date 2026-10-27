/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3.caballo;

/**
 *
 * @author juand
 */
public class Ejercicio3Caballo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      EJERCICIO 3--Caballo--
//      Atributo: Raza, Color, Peso, Edad, Herraduras (array de 4 posiciones).
//      Métodos a diseñar: Come, Camina, Relincha, daCoz, ponerHerradura.

         Caballo galgo = new Caballo("Andaluz", "Alazán", 450.0, 7);
         
        galgo.come("heno");
        galgo.camina();
        galgo.ponerHerradura(0);
        galgo.ponerHerradura(1);
        galgo.relincha();
        
        System.out.println(galgo);
    }
}