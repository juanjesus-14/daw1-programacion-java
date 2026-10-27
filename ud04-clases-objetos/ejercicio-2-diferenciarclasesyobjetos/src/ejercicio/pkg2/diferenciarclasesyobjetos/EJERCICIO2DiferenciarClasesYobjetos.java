/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg2.diferenciarclasesyobjetos;

/**
 *
 * @author juand
 */
public class EJERCICIO2DiferenciarClasesYobjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //        EJERCICIO 2--Diferenciar clases y objetos--
        //        Crear las clases:  Mineral y Persona. 
        //        Definir los atributos oportunos y crear en el main varios objetos de cada. 
        //        Realizar el override de toString en cada clase.
        
        // Objetos de tipo Mineral
        Mineral cuarzo = new Mineral("Cuarzo", "Transparente", 7.0, "Rocas ígneas");
        Mineral pirita = new Mineral("Pirita", "Dorado", 6.0, "Rocas sedimentarias");
        Mineral diamante = new Mineral("Diamante", "Incoloro", 10.0, "Yacimientos volcánicos");

        // Objetos de tipo Persona
        Persona ana = new Persona("Ana", 25, "España", 1.68);
        Persona miguel = new Persona("Miguel", 32, "México", 1.75);
        Persona laura = new Persona("Laura", 19, "Argentina", 1.60);

        // Mostrar objetos
        System.out.println(cuarzo);
        System.out.println(pirita);
        System.out.println(diamante);

        System.out.println(ana);
        System.out.println(miguel);
        System.out.println(laura);
    }
}