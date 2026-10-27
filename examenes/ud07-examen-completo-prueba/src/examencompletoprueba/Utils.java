/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencompletoprueba;

import java.io.*;
import java.time.LocalDate;

public class Utils {

    // ---------- CARGA ----------
    // Formato clientes.txt: dni;nombre;apellidos;email;telefono
    public static void cargaClientes(Banco banco) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("clientes.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 5) {
                    String dni = datos[0];
                    String nombre = datos[1];
                    String apellidos = datos[2];
                    String email = datos[3];
                    String telefono = datos[4];

                    Cliente c = new Cliente(dni, nombre, apellidos, email, telefono);
                    banco.insertaCliente(c);
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero clientes.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer clientes.txt");
        }
    }

    // Formato cuentas.txt: numeroCuenta;tipo;saldo;fechaApertura;dniCliente
    public static void cargaCuentas(Banco banco) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cuentas.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 5) {
                    String numeroCuenta = datos[0];
                    String tipo = datos[1];
                    double saldo;
                    LocalDate fechaApertura;
                    try {
                        saldo = Double.parseDouble(datos[2]);
                        fechaApertura = LocalDate.parse(datos[3]);
                    } catch (Exception e) {
                        System.out.println("Saldo o fecha incorrectos en línea: " + linea);
                        continue;
                    }
                    String dniCliente = datos[4];

                    Cuenta cu = new Cuenta(numeroCuenta, tipo, saldo, fechaApertura);

                    Cliente cliente = banco.buscaCliente(dniCliente);
                    if (cliente != null) {
                        cliente.abrirCuenta(cu);
                        cu.asignaTitular(cliente);
                    } else {
                        System.out.println("No se encontró cliente con DNI: " + dniCliente);
                    }
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
            br.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero cuentas.txt no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer cuentas.txt");
        }
    }

    // ---------- BÚSQUEDA AUXILIAR ----------
    public static Cuenta buscaCuenta(Banco banco, String numeroCuenta) {
        for (Cliente c : banco.getListaClientes()) {
            for (Cuenta cu : c.getListaCuentas()) {
                if (cu.getNumeroCuenta().equals(numeroCuenta)) {
                    return cu;
                }
            }
        }
        return null;
    }

    // ---------- INSERTAR ----------
    public static void insertarCliente(Banco banco) {
        System.out.print("DNI: ");
        String dni = System.console().readLine();
        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Apellidos: ");
        String apellidos = System.console().readLine();
        System.out.print("Email: ");
        String email = System.console().readLine();
        System.out.print("Teléfono: ");
        String telefono = System.console().readLine();

        Cliente c = new Cliente(dni, nombre, apellidos, email, telefono);
        banco.insertaCliente(c);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            bw.write(dni + ";" + nombre + ";" + apellidos + ";" + email + ";" + telefono);
            bw.newLine();
            System.out.println("Cliente insertado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en clientes.txt");
        }
    }

    public static void insertarCuenta(Banco banco) {
        System.out.print("DNI del cliente titular: ");
        String dniCliente = System.console().readLine();

        Cliente cliente = banco.buscaCliente(dniCliente);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dniCliente);
            return;
        }

        System.out.print("Número de cuenta: ");
        String numeroCuenta = System.console().readLine();
        System.out.print("Tipo (AHORRO/CORRIENTE): ");
        String tipo = System.console().readLine();

        System.out.print("Saldo inicial: ");
        double saldo;
        try {
            saldo = Double.parseDouble(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Saldo con formato incorrecto. No se ha insertado la cuenta.");
            return;
        }

        System.out.print("Fecha de apertura (yyyy-MM-dd): ");
        String fechaTexto = System.console().readLine();
        LocalDate fechaApertura;
        try {
            fechaApertura = LocalDate.parse(fechaTexto);
        } catch (Exception e) {
            System.out.println("Fecha con formato incorrecto. No se ha insertado la cuenta.");
            return;
        }

        Cuenta cu = new Cuenta(numeroCuenta, tipo, saldo, fechaApertura);
        cliente.abrirCuenta(cu);
        cu.asignaTitular(cliente);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentas.txt", true))) {
            bw.write(numeroCuenta + ";" + tipo + ";" + saldo + ";" + fechaTexto + ";" + dniCliente);
            bw.newLine();
            System.out.println("Cuenta insertada correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en cuentas.txt");
        }
    }

    // ---------- MODIFICAR ----------
    public static void modificarSaldoCuenta(Banco banco) {
        System.out.print("Número de cuenta: ");
        String numeroCuenta = System.console().readLine();

        Cuenta cu = buscaCuenta(banco, numeroCuenta);
        if (cu == null) {
            System.out.println("No existe ninguna cuenta con número: " + numeroCuenta);
            return;
        }

        System.out.println("1. Ingreso");
        System.out.println("2. Reintegro");
        System.out.print("Opción: ");
        int opcion;
        try {
            opcion = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Opción incorrecta.");
            return;
        }

        System.out.print("Importe: ");
        double importe;
        try {
            importe = Double.parseDouble(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Importe con formato incorrecto.");
            return;
        }

        if (opcion == 1) {
            cu.setSaldo(cu.getSaldo() + importe);
        } else if (opcion == 2) {
            if (importe > cu.getSaldo()) {
                System.out.println("Saldo insuficiente para realizar el reintegro.");
                return;
            }
            cu.setSaldo(cu.getSaldo() - importe);
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        reescribeCuentas(banco);
        System.out.println("Saldo actualizado correctamente. Nuevo saldo: " + cu.getSaldo());
    }

    // ---------- ELIMINAR ----------
    public static void eliminarCliente(Banco banco) {
        System.out.print("DNI del cliente a eliminar: ");
        String dni = System.console().readLine();

        Cliente cliente = banco.buscaCliente(dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        if (!cliente.getListaCuentas().isEmpty()) {
            System.out.println("No se puede eliminar: el cliente tiene cuentas abiertas.");
            return;
        }

        banco.eliminaCliente(cliente);
        reescribeClientes(banco);
        System.out.println("Cliente eliminado correctamente.");
    }

    // ---------- REESCRITURA COMPLETA DE FICHEROS ----------
    private static void reescribeClientes(Banco banco) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", false))) {
            for (Cliente c : banco.getListaClientes()) {
                bw.write(c.getDni() + ";" + c.getNombre() + ";" + c.getApellidos() + ";"
                        + c.getEmail() + ";" + c.getTelefono());
                bw.newLine();
            }
        } catch (IOException ioe) {
            System.out.println("Error al reescribir clientes.txt");
        }
    }

    private static void reescribeCuentas(Banco banco) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentas.txt", false))) {
            for (Cliente c : banco.getListaClientes()) {
                for (Cuenta cu : c.getListaCuentas()) {
                    bw.write(cu.getNumeroCuenta() + ";" + cu.getTipo() + ";" + cu.getSaldo() + ";"
                            + cu.getFechaApertura() + ";" + c.getDni());
                    bw.newLine();
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error al reescribir cuentas.txt");
        }
    }

    // ---------- MOSTRAR ----------
    public static void mostrarClientes(Banco banco) {
        if (banco.getListaClientes().isEmpty()) {
            System.out.println("No hay clientes cargados.");
            return;
        }
        for (Cliente c : banco.getListaClientes()) {
            System.out.println(c);
            System.out.println("  Cuentas:");
            if (c.getListaCuentas().isEmpty()) {
                System.out.println("    No tiene cuentas");
            } else {
                for (Cuenta cu : c.getListaCuentas()) {
                    System.out.println("    " + cu);
                }
            }
        }
    }
}
