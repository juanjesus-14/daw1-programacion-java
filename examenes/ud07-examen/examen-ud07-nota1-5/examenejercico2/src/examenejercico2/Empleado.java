package examenejercico2;

import java.time.LocalDate;

/**
 *
 * @author $(user)
 */
public class Empleado extends Persona {

    private int numeroEmpleado;
    private LocalDate fechaContratacion;
    private Departamento depto;

    public Empleado(int numeroEmpleado, LocalDate fechaContratacion, Departamento depto, String dni, String nombre, String apellidos, String email) {
        super(dni, nombre, apellidos, email);
        this.numeroEmpleado = numeroEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.depto = depto;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public boolean asignarDepto(Departamento depto) {
        return false;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numeroEmpleado=" + numeroEmpleado + ", depto=" + depto + '}';
    }

}
