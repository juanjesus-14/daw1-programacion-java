package main;

import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Empresa {

    // ATRIBUTOS
    private String nombre;

    private ArrayList<Departamento> departamentos;

    // CONSTRUCTOR
    public Empresa(String nombre) {

        this.nombre = nombre;

        departamentos = new ArrayList<>();

    }

    // AÑADIR DEPARTAMENTO
    public void addDepartamento(Departamento d) {

        departamentos.add(d);

    }

    // BUSCAR DEPARTAMENTO
    public Departamento buscarDepartamento(String codigo) {

        for (Departamento d : departamentos) {

            if (d.getCodDepto().equalsIgnoreCase(codigo)) {

                return d;

            }

        }

        return null;

    }

    // MOSTRAR ORGANIGRAMA
    public void mostrarOrganigrama() {

        System.out.println("\n--- ORGANIGRAMA ---");

        for (Departamento d : departamentos) {

            System.out.println("\nDepartamento: " + d.getNombreDepto());

            System.out.println("Código: " + d.getCodDepto());

            System.out.println("Número empleados: " + d.getEmpleados().size());

        }

    }

}
