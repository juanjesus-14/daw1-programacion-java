package main.examen1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author $(user)
 */
public class Matricula {

    private int id;
    private String fechaMatricula;
    private Alumno alumno;
    private Grado grado;
    private ArrayList<Modulo> ModuloMatricula;

    public Matricula(int id, String fechaMatricula, Alumno alumno, Grado grado) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.alumno = alumno;
        this.grado = grado;

        this.ModuloMatricula = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public ArrayList<Modulo> getModuloMatricula() {
        return ModuloMatricula;
    }

    public void setModuloMatricula(ArrayList<Modulo> ModuloMatricula) {
        this.ModuloMatricula = ModuloMatricula;
    }

    public void anadirModulos(Modulo moduloMatricula) {
        this.ModuloMatricula.add(moduloMatricula);
    }

    public void eliminarModulos(Modulo moduloMatricula) {
        int idElim = obtenNumeroEntero("Numero de horasque tiene para eliminar: ");
        boolean eliminado = false;

        for (int i = 0; i < ModuloMatricula.size(); i++) {
            if (ModuloMatricula.get(i).getHoras() == idElim ) {
                ModuloMatricula.remove(i);
                eliminado = true;
                System.out.println("Empleado eliminado.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No existe ese codEmpleado.");
        }
//        this.ModuloMatricula.remove(moduloMatricula);
//        for (int i = 0; i < this.ModuloMatricula.size(); i++) {
//            if (this.ModuloMatricula.get(i).getNombre().equals(moduloMatricula)) {
//                ModuloMatricula.remove(this.ModuloMatricula.get(i));
//            }
//        }
    }

    @Override
    public String toString() {
        return "-- Matricula --"
                + "\nid: " + id
                + "\nFecha Matricula: " + fechaMatricula
                + "\nAlumno: " + alumno
                + "\nGrado: " + grado
                + "\nModulo: " + ModuloMatricula;
    }

    public static int obtenNumeroEntero(String mensaje) {
        int numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

    public static double obtenNumeroDouble(String mensaje) {
        double numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

}
