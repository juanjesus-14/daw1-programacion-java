package main.examen2;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainExamen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Empleado> empleado = new ArrayList<>();

        String opcion1;
        boolean terminar1 = false;

        do {
            System.out.println("\n-- Menú Empresa --");
            System.out.println("1. Alta Empleados");
            System.out.println("2. Baja Empleados");
            System.out.println("3. Lista Empleados");
            System.out.println("Escribe 0 para salir");

            opcion1 = System.console().readLine();

            if (opcion1.equals("0")) {
                terminar1 = true;
            } else {
                switch (Integer.parseInt(opcion1)) {
                    case 1:
                        String opcion2;
                        boolean terminar2 = false;

                        do {
                            System.out.println("\n-- Alta Empleados --");
                            System.out.println("1. Alta Directivo");
                            System.out.println("2. Alta Operario");
                            System.out.println("3. Alta Oficial");
                            System.out.println("4. Alta Tecnico");
                            System.out.println("Escribe 0 para salir");

                            opcion2 = System.console().readLine();

                            if (opcion2.equals("0")) {
                                terminar2 = true;
                            } else {
                                switch (Integer.parseInt(opcion2)) {
                                    case 1:
                                        empleado.add(creaDirectivo());
                                        break;
                                    case 2:
                                        empleado.add(creaOperario());
                                        break;
                                    case 3:
                                        empleado.add(creaOficial());
                                        break;
                                    case 4:
                                        empleado.add(creaTecnico());
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta.");
                                }

                            }

                        } while (!terminar2);
                        break;

                    case 2:
                        int idElim = obtenNumeroEntero("Codigo para eliminar: ");
                        boolean eliminado = false;

                        for (int i = 0; i < empleado.size(); i++) {
                            if (empleado.get(i).getCodEmpleado() == idElim) {
                                empleado.remove(i);
                                eliminado = true;
                                System.out.println("Empleado eliminado.");
                                break;
                            }
                        }

                        if (!eliminado) {
                            System.out.println("No existe ese codEmpleado.");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Lista Empleados ---");
                        for (Empleado a : empleado) {
                            System.out.println(a);
                            System.out.println("------------------");
                        }
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }

            }

        } while (!terminar1);

        System.out.println("Saliendo del Menu...");

    }
// Directivo(int bonoExperiencia, String nombre, int fechaContratacion, String codEmpleado, int sueldo)

    public static Directivo creaDirectivo() {
        int bonoExperiencia = obtenNumeroEntero("Bono Experiencia: ");
        String nombre = System.console().readLine("Nombre: ");
        int fechaContratacion = obtenNumeroEntero("Fecha Contratacion: ");
        int codEmpleado = obtenNumeroEntero("Codigo Empleado: ");
        int sueldo = obtenNumeroEntero("Sueldo: ");
        return new Directivo(bonoExperiencia, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    // Operario(int gratificacion, String nombre, int fechaContratacion, String codEmpleado, int sueldo)
    public static Operario creaOperario() {
        int gratificacion = obtenNumeroEntero("Gratificacion: ");
        String nombre = System.console().readLine("Nombre: ");
        int fechaContratacion = obtenNumeroEntero("Fecha Contratacion: ");
        int codEmpleado = obtenNumeroEntero("Codigo Empleado: ");
        int sueldo = obtenNumeroEntero("Sueldo: ");
        return new Operario(gratificacion, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    // Oficial(int gratificacion, String nombre, int fechaContratacion, String codEmpleado, int sueldo)
    public static Oficial creaOficial() {
        int gratificacion = obtenNumeroEntero("Gratificacion: ");
        String nombre = System.console().readLine("Nombre: ");
        int fechaContratacion = obtenNumeroEntero("Fecha Contratacion: ");
        int codEmpleado = obtenNumeroEntero("Codigo Empleado: ");
        int sueldo = obtenNumeroEntero("Sueldo: ");
        return new Oficial(gratificacion, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    // Tecnico(int gratificacion, String nombre, int fechaContratacion, String codEmpleado, int sueldo)
    public static Tecnico creaTecnico() {
        int gratificacion = obtenNumeroEntero("Gratificacion: ");
        String nombre = System.console().readLine("Nombre: ");
        int fechaContratacion = obtenNumeroEntero("Fecha Contratacion: ");
        int codEmpleado = obtenNumeroEntero("Codigo Empleado: ");
        int sueldo = obtenNumeroEntero("Sueldo: ");
        return new Tecnico(gratificacion, nombre, fechaContratacion, codEmpleado, sueldo);
    }

    public static int obtenNumeroEntero(String mensaje) {
        int numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

    public static double obtenNumeroDouble(String mensaje) {
        double numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }
}
