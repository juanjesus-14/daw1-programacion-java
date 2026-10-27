package main.examen1;

/**
 *
 * @author DAW
 */
public class MainExamen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //  Profesor(String especialidad, String DNI, String nombre, String apellidos, String email)
        Profesor profesor = new Profesor("profe", "23354326L", "Pedro", "Diaz", "fff@gmail.com");

        // Alumno(int numeroExpediente, String DNI, String nombre, String apellidos, String email)
        Alumno alumno = new Alumno(1, "23354326h", "Dani", "Diaz", "ggg@gmail.com");

        // Grado(String codigo, String nombre, String cursoAcademico, int nivel, String grupo)
        Grado grado = new Grado("1", "Dani", "primero", 1, "g");

        // Matricula(int id, String fechaMatricula, Alumno alumno, Grado grado)
        Matricula matricula = new Matricula(1, "2026", alumno, grado);

        // Modulo(String codigo, String nombre, int horas)
        Modulo modulo = new Modulo("1345f", "programacion", 20);
        
        matricula.anadirModulos(modulo);
        alumno.setMatricula(matricula);
        //profesor.asignarModulo(modulo);
        
       // System.out.println(matricula);
            System.out.println(alumno);
    }
    
}
