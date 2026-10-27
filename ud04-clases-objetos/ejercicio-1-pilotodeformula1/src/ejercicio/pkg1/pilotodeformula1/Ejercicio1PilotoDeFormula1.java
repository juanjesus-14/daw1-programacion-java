/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.pkg1.pilotodeformula1;

/**
 *
 * @author juand
 */
public class Ejercicio1PilotoDeFormula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//Ejercicio 1. PilotoDeFormula1--
//Atributos: nombre, apellidos, escuderia, peso, altura, nacionalidad, edad, debut, ranking, numeroPuntos. 
//Realizar el override de toString.
//Objetos a crear en el Main: fernandoAlonso, sebastianVettel, lewisHamilton, carlosSainzJr.
        PilotoDeFormula1 fernando = new PilotoDeFormula1("Fernando","Alonso","Aston Martin",68.0,1.71,"España",44,2001,5,150);
        PilotoDeFormula1 sebastian = new PilotoDeFormula1("Sebastian","Vettel","Aston Martin",72.0,1.75,"Alemania",38,2007,20,45);
        PilotoDeFormula1 lewis = new PilotoDeFormula1("Lewis","Hamilton","Mercedes",70.0,1.74,"Reino Unido",40,2007,1,300);
        PilotoDeFormula1 carlos = new PilotoDeFormula1("Carlos","Sainz Jr","Ferrari",68.5,1.78,"España",30,2015,10,98);

        System.out.println(fernando);
        System.out.println(sebastian);
        System.out.println(lewis);
        System.out.println(carlos);
    }
}