/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencompletoprueba;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Utils {

    // ---------- BÚSQUEDAS AUXILIARES ----------
    public static Cliente buscaCliente(ArrayList<Cliente> listaClientes, String dni) {
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    public static Cuenta buscaCuenta(ArrayList<Cliente> listaClientes, String numeroCuenta) {
        for (Cliente c : listaClientes) {
            for (Cuenta cu : c.getListaCuentas()) {
                if (cu.getNumeroCuenta().equals(numeroCuenta)) {
                    return cu;
                }
            }
        }
        return null;
    }

    // ---------- CARGA ----------
    // Formato clientes.txt: dni;nombre;apellidos;email;telefono
    public static void cargaClientes(ArrayList<Cliente> listaClientes) {
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
                    listaClientes.add(c);
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
    public static void cargaCuentas(ArrayList<Cliente> listaClientes) {
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

                    Cliente cliente = buscaCliente(listaClientes, dniCliente);
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

    // ---------- MOSTRAR ----------
    public static void mostrarClientes(ArrayList<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes cargados.");
            return;
        }
        for (Cliente c : listaClientes) {
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

    // ---------- INSERTAR ----------
    public static void insertarCliente(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI: ");
        String dni = System.console().readLine();

        if (buscaCliente(listaClientes, dni) != null) {
            System.out.println("Ya existe un cliente con ese DNI. No se ha insertado.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = System.console().readLine();
        System.out.print("Apellidos: ");
        String apellidos = System.console().readLine();
        System.out.print("Email: ");
        String email = System.console().readLine();
        System.out.print("Teléfono: ");
        String telefono = System.console().readLine();

        Cliente c = new Cliente(dni, nombre, apellidos, email, telefono);
        listaClientes.add(c);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            bw.write(dni + ";" + nombre + ";" + apellidos + ";" + email + ";" + telefono);
            bw.newLine();
            System.out.println("Cliente insertado correctamente.");
        } catch (IOException ioe) {
            System.out.println("Error al escribir en clientes.txt");
        }
    }

    public static void insertarCuenta(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente titular: ");
        String dniCliente = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dniCliente);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dniCliente);
            return;
        }

        System.out.print("Número de cuenta: ");
        String numeroCuenta = System.console().readLine();

        if (buscaCuenta(listaClientes, numeroCuenta) != null) {
            System.out.println("Ya existe una cuenta con ese número. No se ha insertado.");
            return;
        }

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
    public static void modificarSaldoCuenta(ArrayList<Cliente> listaClientes) {
        System.out.print("Número de cuenta: ");
        String numeroCuenta = System.console().readLine();

        Cuenta cu = buscaCuenta(listaClientes, numeroCuenta);
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

        reescribeCuentas(listaClientes);
        System.out.println("Saldo actualizado correctamente. Nuevo saldo: " + cu.getSaldo());
    }

    // ---------- MODIFICAR DATOS DE UN CLIENTE (nueva opción 8) ----------
    public static void modificarDatosCliente(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente a modificar: ");
        String dni = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        System.out.println("¿Qué dato quieres modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellidos");
        System.out.println("3. Email");
        System.out.println("4. Teléfono");
        System.out.print("Opción: ");

        int opcion;
        try {
            opcion = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Opción incorrecta.");
            return;
        }

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre: ");
                cliente.setNombre(System.console().readLine());
                break;
            case 2:
                System.out.print("Nuevos apellidos: ");
                cliente.setApellidos(System.console().readLine());
                break;
            case 3:
                System.out.print("Nuevo email: ");
                cliente.setEmail(System.console().readLine());
                break;
            case 4:
                System.out.print("Nuevo teléfono: ");
                cliente.setTelefono(System.console().readLine());
                break;
            default:
                System.out.println("Opción no válida. No se ha modificado nada.");
                return;
        }

        reescribeClientes(listaClientes);
        System.out.println("Datos del cliente actualizados correctamente.");
    }

    // ---------- ELIMINAR ----------
    public static void eliminarCliente(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente a eliminar: ");
        String dni = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        if (!cliente.getListaCuentas().isEmpty()) {
            System.out.println("No se puede eliminar: el cliente tiene cuentas abiertas.");
            return;
        }

        listaClientes.remove(cliente);
        reescribeClientes(listaClientes);
        System.out.println("Cliente eliminado correctamente.");
    }

    public static void eliminarCuenta(ArrayList<Cliente> listaClientes) {
        System.out.print("Número de cuenta a eliminar: ");
        String numeroCuenta = System.console().readLine();

        Cuenta cu = buscaCuenta(listaClientes, numeroCuenta);
        if (cu == null) {
            System.out.println("No existe ninguna cuenta con número: " + numeroCuenta);
            return;
        }

        Cliente titular = cu.getTitular();
        titular.cerrarCuenta(cu);

        reescribeCuentas(listaClientes);
        System.out.println("Cuenta eliminada correctamente.");
    }

    public static void eliminarClienteConCuentas(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente a eliminar: ");
        String dni = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        listaClientes.remove(cliente);

        reescribeClientes(listaClientes);
        reescribeCuentas(listaClientes);
        System.out.println("Cliente y sus cuentas eliminados correctamente.");
    }

    // ---------- TRANSFERENCIA ENTRE CUENTAS (nueva opción 9) ----------
    public static void transferenciaEntreCuentas(ArrayList<Cliente> listaClientes) {
        System.out.print("Número de cuenta de origen: ");
        String numeroOrigen = System.console().readLine();
        System.out.print("Número de cuenta de destino: ");
        String numeroDestino = System.console().readLine();

        if (numeroOrigen.equals(numeroDestino)) {
            System.out.println("La cuenta de origen y destino no pueden ser la misma.");
            return;
        }

        Cuenta origen = buscaCuenta(listaClientes, numeroOrigen);
        if (origen == null) {
            System.out.println("No existe ninguna cuenta con número: " + numeroOrigen);
            return;
        }

        Cuenta destino = buscaCuenta(listaClientes, numeroDestino);
        if (destino == null) {
            System.out.println("No existe ninguna cuenta con número: " + numeroDestino);
            return;
        }

        System.out.print("Importe a transferir: ");
        double importe;
        try {
            importe = Double.parseDouble(System.console().readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Importe con formato incorrecto.");
            return;
        }

        if (importe <= 0) {
            System.out.println("El importe debe ser mayor que 0.");
            return;
        }
        if (importe > origen.getSaldo()) {
            System.out.println("Saldo insuficiente en la cuenta de origen.");
            return;
        }

        origen.setSaldo(origen.getSaldo() - importe);
        destino.setSaldo(destino.getSaldo() + importe);

        reescribeCuentas(listaClientes);
        System.out.println("Transferencia realizada correctamente.");
    }

    // ---------- LISTAR CUENTAS DE UN CLIENTE (nueva opción 10) ----------
    public static void listarCuentasDeCliente(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente: ");
        String dni = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        System.out.println("Cuentas de " + cliente.getNombre() + " " + cliente.getApellidos() + ":");
        if (cliente.getListaCuentas().isEmpty()) {
            System.out.println("  No tiene cuentas");
        } else {
            for (Cuenta cu : cliente.getListaCuentas()) {
                System.out.println("  " + cu);
            }
        }
    }

    // ---------- SALDO TOTAL DE UN CLIENTE (nueva opción 11) ----------
    public static void saldoTotalCliente(ArrayList<Cliente> listaClientes) {
        System.out.print("DNI del cliente: ");
        String dni = System.console().readLine();

        Cliente cliente = buscaCliente(listaClientes, dni);
        if (cliente == null) {
            System.out.println("No existe ningún cliente con DNI: " + dni);
            return;
        }

        double total = 0;
        for (Cuenta cu : cliente.getListaCuentas()) {
            total += cu.getSaldo();
        }

        System.out.println("Saldo total de " + cliente.getNombre() + " " + cliente.getApellidos() + ": " + total);
    }

    // ---------- REESCRITURA COMPLETA DE FICHEROS ----------
    private static void reescribeClientes(ArrayList<Cliente> listaClientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", false))) {
            for (Cliente c : listaClientes) {
                bw.write(c.getDni() + ";" + c.getNombre() + ";" + c.getApellidos() + ";"
                        + c.getEmail() + ";" + c.getTelefono());
                bw.newLine();
            }
        } catch (IOException ioe) {
            System.out.println("Error al reescribir clientes.txt");
        }
    }

    private static void reescribeCuentas(ArrayList<Cliente> listaClientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("cuentas.txt", false))) {
            for (Cliente c : listaClientes) {
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

}
