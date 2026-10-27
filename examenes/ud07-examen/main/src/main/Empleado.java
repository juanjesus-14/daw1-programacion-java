package main;

import java.time.LocalDate;

/**
 *
 * @author $(user)
 */
public class Empleado extends Persona {

    // ATRIBUTOS
    private int numEmpleado;
    private LocalDate fechaContratacion;
    private Departamento depto;

    // CONSTRUCTOR
    public Empleado(int numEmpleado, String dni, String nombre, String apellidos, String email, LocalDate fechaContratacion) {

        // LLAMADA AL CONSTRUCTOR PADRE
        super(dni, nombre, apellidos, email);

        this.numEmpleado = numEmpleado;
        this.fechaContratacion = fechaContratacion;

    }

    // GETTERS
    public int getNumEmpleado() {
        return numEmpleado;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public Departamento getDepto() {
        return depto;
    }

    // SETTERS
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public void setFechaContratacion(
            LocalDate fechaContratacion) {

        this.fechaContratacion = fechaContratacion;

    }

    public void setDepto(Departamento depto) {

        this.depto = depto;

    }

    // TOSTRING
    @Override
    public String toString() {

        return numEmpleado + " - "
                + getNombreCompleto()
                + " - " + fechaContratacion;

    }

}
