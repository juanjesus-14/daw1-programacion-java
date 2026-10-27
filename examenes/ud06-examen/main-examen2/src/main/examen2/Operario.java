package main.examen2;

/**
 *
 * @author $(user)
 */
public class Operario extends Empleado {

    private int gratificacion;

    public Operario(int gratificacion, String nombre, int fechaContratacion, int codEmpleado, int sueldo) {
        super(nombre, fechaContratacion, codEmpleado, sueldo);
        this.gratificacion = gratificacion;
    }

    public int getGratificacion() {
        return gratificacion;
    }

    public void setGratificación(int gratificacion) {
        this.gratificacion = gratificacion;
    }

    @Override
    public int obtenSueldoActual() {
        return (this.sueldo + this.gratificacion);
    }

    @Override
    public String toString() {
        return "Soy el Operario " + nombre + " con el codigo " + codEmpleado;

    }

}
