
package main.examen2;

/**
 *
 * @author $(user)
 */
public abstract class Empleado {

    protected String nombre;
    protected int fechaContratacion;
    protected int codEmpleado;
    protected int sueldo;
    
    public abstract int obtenSueldoActual();

    public Empleado(String nombre, int fechaContratacion, int codEmpleado, int sueldo) {
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
        this.codEmpleado = codEmpleado;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(int fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "-- Empleado --" 
                + "\nNombre: " + nombre 
                + "\nFechaContratacion: " + fechaContratacion 
                + "\nCodEmpleado: " + codEmpleado 
                + "\nSueldo: " + sueldo;
    }
    
    
    
}
