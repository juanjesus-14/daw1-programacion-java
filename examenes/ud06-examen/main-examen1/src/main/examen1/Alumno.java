package main.examen1;

/**
 *
 * @author $(user)
 */
public class Alumno extends Persona {

    private int numeroExpediente;
    private Matricula matricula;

    public Alumno(int numeroExpediente, String DNI, String nombre, String apellidos, String email) {
        super(DNI, nombre, apellidos, email);
        this.numeroExpediente = numeroExpediente;
    }

    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "-- Alumno --"
                + "\nNumero Expediente: " + numeroExpediente
                //+ "\nMatricula: " + matricula
                ;
    }

}
