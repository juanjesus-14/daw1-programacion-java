
package main.examen2;

/**
 *
 * @author $(user)
 */
public class Tecnico extends Operario{

    public Tecnico(int gratificacion, String nombre, int fechaContratacion, int codEmpleado, int sueldo) {
        super(gratificacion, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    @Override
    public String toString() {
        return "Soy el Tecnico " + nombre + " con el codigo " + codEmpleado + " y mi sueldo es: " + sueldo;
    }

    
}
