package main;

import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Departamento {

    // ATRIBUTOS
    private String codDepto;
    private String nombreDepto;

    private ArrayList<Empleado> empleados;

    // CONSTRUCTOR
    public Departamento(String codDepto, String nombreDepto) {

        this.codDepto = codDepto;
        this.nombreDepto = nombreDepto;

        empleados = new ArrayList<>();

    }

    // AÑADIR EMPLEADO
    public void addEmpleado(Empleado emp) {

        empleados.add(emp);

        // ASIGNAR DEPARTAMENTO
        emp.setDepto(this);

    }

    // MOSTRAR EMPLEADOS
    public void listarEmpleados() {

        for (Empleado e : empleados) {

            System.out.println(
                    e.getNombreCompleto());

        }

    }

    // GETTERS
    public String getCodDepto() {
        return codDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    
// MOSTRAR EMPLEADOS
public void mostrarEmpleados() {

    // RECORRER ARRAYLIST
    for (Empleado e : empleados) {

        System.out.println(e);
    }
}



    // TOSTRING
    @Override
    public String toString() {

        return codDepto + " - "
                + nombreDepto;

    }

}
