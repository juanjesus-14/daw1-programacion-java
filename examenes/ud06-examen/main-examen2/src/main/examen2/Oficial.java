
package main.examen2;

/**
 *
 * @author $(user)
 */
public class Oficial extends Operario {

    public Oficial(int gratificacion, String nombre, int fechaContratacion, int codEmpleado, int sueldo) {
        super(gratificacion, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    @Override
    public String toString() {
        return "Soy el Oficial " + nombre + " con el codigo " + codEmpleado;
    }

   
}
