package ex07recuperacion;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Utils {

    // ---------- BÚSQUEDAS AUXILIARES ----------
    public static Paciente buscaPaciente(ArrayList<Paciente> listaPacientes, String numSegSocial) {
        for (Paciente p : listaPacientes) {
            if (p.getNumSegSocial().equals(numSegSocial)) {
                return p;
            }
        }
        return null;
    }

    public static PruebaMedica buscaPruebaMedica(ArrayList<Paciente> listaPacientes, String codigo) {
        for (Paciente p : listaPacientes) {
            for (PruebaMedica pm : p.historial()) {
                if (pm.getCodigo().equals(codigo)) {
                    return pm;
                }
            }
        }
        return null;
    }

    // ---------- CARGA ----------
    // Formato pacientes.txt: dniPaciente;nombre;apellidos;email;genero;fechaNacimiento;direccion;telefono;numSegSocial
    public static void cargaPacientes(ArrayList<Paciente> listaPacientes) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
            String linea1;

            while ((linea1 = br.readLine()) != null) {
                String[] datos = linea1.split(";");
//                System.out.println(datos);
//                System.out.println(datos.length);

                if (datos.length == 9) {
                    String dni = datos[0];
                    String nombre = datos[1];
                    String apellidos = datos[2];
                    String email = datos[3];
                    String genero = datos[4];

                    LocalDate fechaNacimiento;
                    try {
                        fechaNacimiento = LocalDate.parse(datos[5]);
                    } catch (Exception e) {
                        System.out.println("Fecha incorrecta en línea: " + linea1);
                        continue;
                    }

                    String direccion = datos[6];
                    String telefono = datos[7];
                    String numSegSocial = datos[8];

                    Paciente paciente = new Paciente(dni, nombre, apellidos, email, genero, fechaNacimiento, direccion, telefono, numSegSocial);
                    listaPacientes.add(paciente);
                } else {
                    System.out.println("Línea con formato incorrecto1: " + linea1);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero clientes.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer clientes.txt");
        }
    }

    // Formato prueba.txt: numSegSocial;codigo;fechaPrueba;descripPrueba;resultadoPrueba
    public static void cargaPruebas(ArrayList<Paciente> listaPacientes) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("pruebas.txt"));
            String linea2;

            while ((linea2 = br.readLine()) != null) {
                String[] datos = linea2.split(";");

                if (datos.length == 5) {
                    String numSegSocial = datos[0];
                    String codigo = datos[1];
                    LocalDate fechaPrueba;
                    try {
                        fechaPrueba = LocalDate.parse(datos[2]);
                    } catch (Exception e) {
                        System.out.println("Fecha incorrecta en línea: " + linea2);
                        continue;
                    }
                    String descripPrueba = datos[3];
                    String resultadoPrueba = datos[4];

                    PruebaMedica prueba = new PruebaMedica(numSegSocial, codigo, fechaPrueba, descripPrueba, resultadoPrueba);

                    Paciente paciente = buscaPaciente(listaPacientes, numSegSocial);
                    if (paciente != null) {
                        paciente.asignaPrueba(prueba);
                        prueba.asignaPaciente(paciente);
                    } else {
                        System.out.println("No se encontró paciente con numSegSocial: " + numSegSocial);
                    }
                } else {
                    System.out.println("Línea con formato incorrecto2: " + linea2);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero pruebas.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer pruebas.txt");
        }
    }

    // ---------- MOSTRAR ----------
    public static void mostrarPacientes(ArrayList<Paciente> listaPacientes) {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay clientes cargados.");
            return;
        }
        for (Paciente p : listaPacientes) {
            System.out.println(p);
            if (p.historial().isEmpty()) {
                System.out.println("    No dispone de historial");
            } else {
                for (PruebaMedica pm : p.historial()) {
                    System.out.println("    " + pm);
                }
            }
        }
    }

    // ---------- INSERTAR ----------
    public static void insertarPaciente(ArrayList<Paciente> listaPacientes) {
        System.out.print("DNI: ");
        String dni = System.console().readLine();

        if (buscaPaciente(listaPacientes, dni) != null) {
            System.out.println("Ya existe un cliente con ese DNI. No se ha insertado.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Apellidos: ");
        String apellidos = System.console().readLine();
        System.out.print("Email: ");
        String email = System.console().readLine();
        System.out.print("Genero: ");
        String genero = System.console().readLine();

        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaTexto = System.console().readLine();
        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaTexto);
        } catch (Exception e) {
            System.out.println("Fecha con formato incorrecto. No se ha insertado la cuenta.");
            return;
        }

        System.out.print("Direccion: ");
        String direccion = System.console().readLine();
        System.out.print("Teléfono: ");
        String telefono = System.console().readLine();
        System.out.print("Numero Seguridad Social: ");
        String numSegSocial = System.console().readLine();

        Paciente p = new Paciente(dni, nombre, apellidos, email, genero, fechaNacimiento, direccion, telefono, numSegSocial);
        listaPacientes.add(p);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pacientes.txt", true))) {
            bw.write(dni + ";" + nombre + ";" + apellidos + ";" + email + ";" + genero + ";" + fechaNacimiento + ";" + direccion + ";" + telefono + ";" + numSegSocial);
            bw.newLine();
            System.out.println("Paciente insertado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en pacientes.txt");
        }
    }

    public static void insertarPruebaMedica(ArrayList<Paciente> listaPacientes) {
        System.out.print("DNI del paciente: ");
        String dniCliente = System.console().readLine();

        Paciente cliente = buscaPaciente(listaPacientes, dniCliente);
        if (cliente == null) {
            System.out.println("No existe ningún paciente con DNI: " + dniCliente);
            return;
        }

        System.out.print("Codigo de prueba: ");
        String codigo = System.console().readLine();

        if (buscaPruebaMedica(listaPacientes, codigo) != null) {
            System.out.println("Ya existe una prueba con ese codigo. No se ha insertado.");
            return;
        }

        System.out.print("Numero Seguridad Social: ");
        String numSegSocial = System.console().readLine();

        System.out.print("Fecha de prueba (yyyy-MM-dd): ");
        String fechaTexto = System.console().readLine();
        LocalDate fechaPrueba;
        try {
            fechaPrueba = LocalDate.parse(fechaTexto);
        } catch (Exception e) {
            System.out.println("Fecha con formato incorrecto. No se ha insertado la cuenta.");
            return;
        }

        System.out.print("Descripcion de la prueba: ");
        String descripPrueba = System.console().readLine();
        System.out.print("Resultado de prueba (Si esta pendiente escribe N/A ): ");
        String resultadoPrueba = System.console().readLine();

        PruebaMedica pm = new PruebaMedica(numSegSocial, codigo, fechaPrueba, descripPrueba, resultadoPrueba);
        cliente.abrirPrueba(pm);
        pm.asignaPaciente(cliente);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pruebas.txt", true))) {
            bw.write(numSegSocial + ";" + codigo + ";" + fechaPrueba + ";" + descripPrueba + ";" + resultadoPrueba);
            bw.newLine();
            System.out.println("Prueba insertada correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en prueba.txt");
        }
    }

}
