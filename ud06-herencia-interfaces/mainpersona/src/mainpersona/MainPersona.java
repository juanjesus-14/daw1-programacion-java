package mainpersona;

import java.util.*;

/**
 *
 * @author DAW
 */
public class MainPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//opcion 1
        TreeSet<Persona> personas = new TreeSet<>(
                Comparator.comparing((Persona p) -> p.getClass().getSimpleName())
                        .thenComparing(Persona::getNombre)
                        .thenComparing(Persona::getApellidos)
        );

//opcion 2 ponerlo del reves
//        TreeSet<Persona> personas = new TreeSet<>(
//                Comparator.comparing((Persona p) -> p.nombre)
//                .thenComparing(Persona::getNombre)
//                .reversed()
//        );

        // Añadir personas
        Alumno a1 = new Alumno("Daw", "Lucas", "Martin");
        Alumno a2 = new Alumno("ASIR", "Pablo", "Carrillo");
        Alumno a3 = new Alumno("SMR", "Juanma", "Gitano");
        Profesor p1 = new Profesor("Informatica", "Carmen", "Macias");
        Profesor p2 = new Profesor("Informatica", "Jose", "Cabeza");
        Bedel b1 = new Bedel("IES Salduba", false, "Antonio", "Nono");

        personas.add(a1);
        personas.add(a2);
        personas.add(a3);
        personas.add(p1);
        personas.add(p2);
        personas.add(b1);

        // Mostramos el TreeSet
        System.out.println("-- Listado de personas --");
        for (Persona p : personas) {
            System.out.println(p);
        }
        
        //Polimorfismo -- llamar al metodo mediante polimorfismo
        System.out.println("Saludamos a las personas!!!");
        for(Persona p : personas){
            System.out.println(p.saludar());
        }
    }
}
