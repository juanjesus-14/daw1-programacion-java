package main;

import java.io.*;
import java.time.LocalDate;

/**
 *
 * @author DAW
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // CREAR EMPRESA
        Empresa empresa = new Empresa("MiEmpresa");

        // CREAR LOG
        Utils.crearLog("F:\\workspace\\programacion\\UD7\\EXAMEN\\Main");

        try {

            /*
            =====================================
            ESCRIBIR NUEVA LINEA DESDE TERMINAL
            =====================================
             */
            // LEER TECLADO
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            // ABRIR TXT EN MODO AÑADIR
            FileWriter fw = new FileWriter("empleados5-26.txt", true);

            PrintWriter pw = new PrintWriter(fw);

            System.out.println("Introduce nuevo empleado:");

            System.out.println("Formato:");

            System.out.println("D03;Ventas;5;11111111A;Juan;Diaz;juan@gmail.com;2025-01-10");

            // GUARDAR LINEA
            String nuevaLinea = teclado.readLine();

            // ESCRIBIR EN EL TXT
            pw.println(nuevaLinea);

            // CERRAR
            pw.close();
            fw.close();

            System.out.println("Linea añadida");

            /*
            =====================================
            LEER FICHERO
            =====================================
             */
            BufferedReader br = new BufferedReader(new FileReader("empleados5-26.txt"));

            String linea;

            System.out.println("\n--- DATOS DEL FICHERO ---");

            // LEER LINEAS
            while ((linea = br.readLine()) != null) {

                // MOSTRAR LINEA
                System.out.println(linea);

                // SPLIT
                String[] datos = linea.split(";");

                // GUARDAR DATOS
                String codDepto = datos[0];

                String nombreDepto = datos[1];

                int numEmpleado = Integer.parseInt(datos[2]);

                String dni = datos[3];

                String nombre = datos[4];

                String apellidos = datos[5];

                String email = datos[6];

                // LOCALDATE
                LocalDate fecha = LocalDate.parse(datos[7].trim());

                // CREAR EMPLEADO
                Empleado emp = new Empleado(numEmpleado, dni, nombre, apellidos, email, fecha);

                // BUSCAR DEPARTAMENTO
                Departamento d = empresa.buscarDepartamento(codDepto);

                // SI NO EXISTE
                if (d == null) {

                    d = new Departamento(codDepto, nombreDepto);

                    empresa.addDepartamento(d);

                }

                // AÑADIR EMPLEADO
                d.addEmpleado(emp);

            }

            // CERRAR
            br.close();

            /*
            =====================================
            MOSTRAR ORGANIGRAMA
            =====================================
             */
            empresa.mostrarOrganigrama();

            /*
            =====================================
            EMPLEADOS POR DEPARTAMENTO
            =====================================
             */
            System.out.println("\n--- EMPLEADOS POR DEPARTAMENTO ---");

            // DEPARTAMENTO D01
            Departamento d1 = empresa.buscarDepartamento("D01");

            if (d1 != null) {

                System.out.println("\nDepartamento: " + d1.getNombreDepto());

                d1.mostrarEmpleados();

            }

            // DEPARTAMENTO D02
            Departamento d2 = empresa.buscarDepartamento("D02");

            if (d2 != null) {

                System.out.println("\nDepartamento: " + d2.getNombreDepto());

                d2.mostrarEmpleados();

            }

        } catch (IOException e) {

            System.out.println("Error leyendo fichero");

        }

    }

}
