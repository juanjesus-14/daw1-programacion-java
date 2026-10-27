package examenejercico2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExamenEjercico2 {

    public static void main(String[] args) {
        ArrayList<Departamento> departamentos = new ArrayList<>();

        // 1. Leer fichero y mostrar datos en bruto
        System.out.println("Datos del fichero:");
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\workspace\\programacion\\UD7\\RECUPERACION\\Examen1\\Examen1-ej2\\departamentosMes-3-26.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // muestra la línea en bruto

                String[] datos = linea.split(";");
                String codDepto = datos[0];
                String nombreDepto = datos[1];
                int numeroEmpleado = Integer.parseInt(datos[2]);
                String dni = datos[3];
                String nombre = datos[4];
                String apellidos = datos[5];
                String email = datos[6];
                LocalDate fechaCont = LocalDate.parse(datos[7]);

                // Buscar si el departamento ya existe
                Departamento depto = null;
                for (Departamento d : departamentos) {
                    if (d.getCodDepto().equals(codDepto)) {
                        depto = d;
                        break;
                    }
                }
                // Si no existe, crearlo
                if (depto == null) {
                    depto = new Departamento(codDepto, nombreDepto, new ArrayList<>());
                    departamentos.add(depto);
                }

                // Crear empleado y asignarlo al departamento
                Empleado emp = new Empleado(numeroEmpleado, fechaCont, depto, dni, nombre, apellidos, email);
                depto.asignaEmpleado(emp);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        System.out.println("-------------------------------------------------------------------");

        // 2. Organigrama
        System.out.println("-- Organigrama --");
        for (Departamento d : departamentos) {
            System.out.println("Departamento: " + d.getNombreDepto()
                    + " | Código: " + d.getCodDepto()
                    + " | Número empleados: " + d.getEmpleados().size());
        }

        System.out.println();

        // 3. Empleados por departamento
        System.out.println("--Empleados por departamento--");
        for (Departamento d : departamentos) {
            System.out.println("\nDepartamento: " + d.getNombreDepto());
            for (Empleado emp : d.getEmpleados()) {
                System.out.println(emp.getNombre() + " " + emp.getApellidos());
            }
        }
    }
}
