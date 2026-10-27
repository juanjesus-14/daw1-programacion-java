/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5.alumno;

/**
 *
 * @author juand
 */
public class Ejercicio5Alumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      EJERCICIO 5--Alumno--
//      Atributos: Apellidos, estatura, edad, peso, notas
//      Implementa la clase Alumno y la Clase Nota (debe incorporar nombre_asignatura y calificación).

        Alumno alumno1 = new Alumno("García López", 1.75, 18, 70, 3);

        alumno1.ponerNota(0, new Nota("Matemáticas", 8.5));
        alumno1.ponerNota(1, new Nota("Lengua", 7.2));
        alumno1.ponerNota(2, new Nota("Historia", 9.0));

        System.out.println(alumno1);
    }
}
