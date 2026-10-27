package examenejercico2;

import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Departamento {

    private String codDepto;
    private String nombreDepto;
    private ArrayList<Empleado> empleados;

    public Departamento(String codDepto, String nombreDepto, ArrayList<Empleado> empleados) {
        this.codDepto = codDepto;
        this.nombreDepto = nombreDepto;
        this.empleados = empleados;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean asignaEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        return true;
    }

    public boolean eliminarEmpleado(Empleado empleado) {
        String idElim = System.console().readLine("DNI: ");
        boolean eliminado = false;

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(idElim)) {
                empleados.remove(i);
                eliminado = true;
                System.out.println("Empleado eliminado.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No existe ese DNI.");
        }
        return eliminado;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codDepto=" + codDepto + ", nombreDepto=" + nombreDepto + ", empleados=" + empleados + '}';
    }
}
