/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examencompleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Utils {

    public static String cargaDatos(ArrayList<Jugador> listaJugadores) {
        String resultado = "Reporte de la carga realizada\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // 1) Cargar empleados
            ResultSet rs = st.executeQuery("select * from jugadores");
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String nacionalidad = rs.getString("nacionalidad");
                int dorsal = rs.getInt("dorsal");
                String posicion = rs.getString("posicion");
                Boolean disponible = rs.getBoolean("disponible");

                Jugador jug = new Jugador(dni, nombre, apellidos, nacionalidad, dorsal, posicion, disponible);

                listaJugadores.add(jug);
                resultado += "Jugadores cargado: " + dni + "\n";
            }
            rs.close();

            // 2) Cargar contratos y asociarlos
            rs = st.executeQuery("select * from contratos");
            while (rs.next()) {
                String dniContrato = rs.getString("dni");
                LocalDate fechaInicio = rs.getDate("fechaInicio").toLocalDate();
                double salarioAnual = rs.getDouble("salarioAnual");

                for (int i = 0; i < listaJugadores.size(); i++) {
                    if (dniContrato.equalsIgnoreCase(listaJugadores.get(i).getDni())) {
                        listaJugadores.get(i).asignaContrato(dniContrato, fechaInicio, salarioAnual);
                        resultado += "Contrato asociada: " + dniContrato + "\n";
                    }
                }
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    public static void listarJugadores(ArrayList<Jugador> listaJugadores) {
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i).toString());
        }
    }

    public static boolean insertarJugador(Scanner sc, ArrayList<Jugador> listaJugadores) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime el dni del jugador: ");
            String dni = sc.nextLine();

            // Comprobar si ya existe
            ResultSet rs = st.executeQuery("select dni from jugadores where dni='" + dni + "'");
            if (rs.next()) {
                System.out.println("Ya existe un jugador con el dni: " + dni);
                return false;
            }
            rs.close();

            System.out.println("Dime el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Dime el apellido: ");
            String apellidos = sc.nextLine();
            System.out.println("Dime la nacionalidad: ");
            String nacionalidad = sc.nextLine();
            System.out.println("Dime el dorsal: ");
            int dorsal = Utils.obtenNumeroEntero(sc.nextLine());
            System.out.println("Dime la posicion: ");
            String posicion = sc.nextLine();

            // Validación S/N para garantía
            int estaDisponible = -1;
            String op = "-1";
            do {
                System.out.println("¿Está disponible? (S/N): ");
                op = sc.nextLine().toUpperCase();
                switch (op) {
                    case "S":
                        estaDisponible = 1;
                        break;
                    case "N":
                        estaDisponible = 0;
                        break;
                    default:
                        op = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (op.equals("-1"));

            // INSERT en electrodomesticos
            ps = cn.prepareStatement("INSERT INTO jugadores(dni,  nombre, apellidos, nacionalidad, dorsal, posicion, disponible) " + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, nacionalidad);
            ps.setInt(5, dorsal);
            ps.setString(6, posicion);
            ps.setInt(7, estaDisponible);
            ps.executeUpdate();

            System.out.println("Jugador insertado correctamente.");

            // Crear objeto en memoria
            boolean disponibleBool = (estaDisponible == 1);
            Jugador jTemp = new Jugador(dni, nombre, apellidos, nacionalidad, dorsal, posicion, disponibleBool);

            // Preguntar si quiere añadir compra ahora
            String opContrato = "-1";
            do {
                System.out.println("¿Desea añadir un contrato? (S/N): ");
                opContrato = sc.nextLine().toUpperCase();
                switch (opContrato) {
                    case "S":
                        break;
                    case "N":
                        break;
                    default:
                        opContrato = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (opContrato.equals("-1"));

            if (opContrato.equals("S")) {
                System.out.println("Dime la fecha de inicio (YYYY-MM-DD): ");
                String fecha = sc.nextLine();
                // Convertir String a LocalDate
                //LocalDate fechaCompra = LocalDate.parse(fechaStr);
                LocalDate fechaInicio = null;
                try {
                    fechaInicio = LocalDate.parse(fecha);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el salario: ");
                String salario = sc.nextLine();
                double salarioAnual = Double.parseDouble(salario);

                // INSERT en compras
                // Date.valueOf() convierte LocalDate a java.sql.Date para la BBDD
                PreparedStatement psCompra = cn.prepareStatement("INSERT INTO contratos(dni,  fechaInicio,  salarioAnual) VALUES (?,?,?)");
                psCompra.setString(1, dni);
                psCompra.setDate(2, java.sql.Date.valueOf(fechaInicio));
                psCompra.setDouble(3, salarioAnual);
                psCompra.executeUpdate();
                psCompra.close();

                Contrato cTemp = new Contrato(dni, fechaInicio, salarioAnual);
                jTemp.asignaContrato(cTemp);
            }

            listaJugadores.add(jTemp);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    public static boolean insertarContrato(Scanner sc, ArrayList<Jugador> listaJugadores) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("dni del jugador al que quieres añadir contrato: ");
            String dni = sc.nextLine();

            // Comprobar que existe
            psBuscar = cn.prepareStatement("select dni from jugadores where dni = ?");
            psBuscar.setString(1, dni);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Jugador encontrado.");

                System.out.println("Dime la fecha de inicio (YYYY-MM-DD): ");
                String fecha = sc.nextLine();
                // Convertir String a LocalDate
                //LocalDate fechaCompra = LocalDate.parse(fechaStr);
                LocalDate fechaInicio = null;
                try {
                    fechaInicio = LocalDate.parse(fecha);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el salario: ");
                String salario = sc.nextLine();
                double salarioAnual = Double.parseDouble(salario);

                // INSERT en compras
                psInsert = cn.prepareStatement("INSERT INTO contratos(dni,  fechaInicio,  salarioAnual) VALUES (?,?,?)");
                psInsert.setString(1, dni);
                psInsert.setDate(2, java.sql.Date.valueOf(fechaInicio)); // LocalDate → java.sql.Date
                psInsert.setDouble(3, salarioAnual);
                int result = psInsert.executeUpdate();

                if (result > 0) {
                    System.out.println("Contrato insertado correctamente.");

                    // Actualizar ArrayList en memoria
                    Contrato contratoTemp = new Contrato(dni, fechaInicio, salarioAnual);
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (listaJugadores.get(i).getDni().equals(dni)) {
                            listaJugadores.get(i).asignaContrato(contratoTemp);
                            break;
                        }
                    }
                } else {
                    System.out.println("No se pudo insertar el contrato.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe jugador con dni: " + dni);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psBuscar != null) {
                    psBuscar.close();
                }
                if (psInsert != null) {
                    psInsert.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;

    }

    public static boolean modificarJugador(ArrayList<Jugador> listaJugadores) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            cn = Conexion.creaConexion();

            System.out.println("DNI del jugador que quieres modificar: ");
            String dni = sc.nextLine();

            // Comprobar que existe
            psBuscar = cn.prepareStatement(
                    "select dni from jugadores where dni = ?");
            psBuscar.setString(1, dni);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Jugador encontrado.");

                // Pedir nuevos datos
                System.out.println("Nuevo dorsal: ");
                int dorsal = Utils.obtenNumeroEntero(sc.nextLine());
                System.out.println("Nueva posicion: ");
                String posicion = sc.nextLine();

                // UPDATE en BBDD
                // IMPORTANTE: el WHERE siempre al final
                psUpdate = cn.prepareStatement(
                        "UPDATE jugadores SET dorsal=?, posicion=? WHERE dni=?");
                psUpdate.setInt(1, dorsal);
                psUpdate.setString(2, posicion);
                psUpdate.setString(3, dni);  // ← condición WHERE al final
                int result = psUpdate.executeUpdate();

                if (result > 0) {
                    System.out.println("Jugador modificado correctamente.");

                    // Actualizar también el ArrayList en memoria
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (listaJugadores.get(i).getDni().equals(dni)) {
                            listaJugadores.get(i).setDorsal(dorsal);
                            listaJugadores.get(i).setPosicion(posicion);
                            break;
                        }
                    }
                } else {
                    System.out.println("No se pudo modificar el jugador.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe jugador con DNI: " + dni);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psBuscar != null) {
                    psBuscar.close();
                }
                if (psUpdate != null) {
                    psUpdate.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    public static boolean eliminarJugador(ArrayList<Jugador> listaJugadores) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psDeleteContrato = null;
        PreparedStatement psDeleteJugador = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            cn = Conexion.creaConexion();

            System.out.println("DNI del jugador que quieres eliminar: ");
            String dni = sc.nextLine();

            // Comprobar que existe
            psBuscar = cn.prepareStatement(
                    "select dni from jugadores where dni = ?");
            psBuscar.setString(1, dni);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Jugador encontrado.");

                // PASO 1: Borrar primero el contrato (si tiene)
                // Obligatorio por la clave foránea — no se puede borrar el jugador
                // si tiene registros en contratos que apuntan a él
                psDeleteContrato = cn.prepareStatement(
                        "DELETE FROM contratos WHERE dni=?");
                psDeleteContrato.setString(1, dni);
                psDeleteContrato.executeUpdate(); // no comprobamos result — puede no tener contrato

                // PASO 2: Borrar el jugador
                psDeleteJugador = cn.prepareStatement(
                        "DELETE FROM jugadores WHERE dni=?");
                psDeleteJugador.setString(1, dni);
                int result = psDeleteJugador.executeUpdate();

                if (result > 0) {
                    System.out.println("Jugador eliminado correctamente.");

                    // PASO 3: Borrar también del ArrayList en memoria
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (listaJugadores.get(i).getDni().equals(dni)) {
                            listaJugadores.remove(i);
                            break; // salir tras borrar — evita problemas con el índice
                        }
                    }
                } else {
                    System.out.println("No se pudo eliminar el jugador.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe jugador con DNI: " + dni);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psBuscar != null) {
                    psBuscar.close();
                }
                if (psDeleteContrato != null) {
                    psDeleteContrato.close();
                }
                if (psDeleteJugador != null) {
                    psDeleteJugador.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES
    // ─────────────────────────────────────────────
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(opcion);
                } else {
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de numero incorrecto");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }
}
