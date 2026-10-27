/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebavehiculococherevision;

import java.sql.Connection;
import java.sql.Date;
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

    // ─── LISTAR ───────────────────────────────────
    public static void listarCoches(ArrayList<Coche> lista) {
        // recorrer el ArrayList y hacer System.out.println de cada elemento
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    // ─── CARGA DE DATOS ───────────────────────────
    public static String cargaDatos(ArrayList<Coche> lista) {
        String resultado = "Reporte de la carga:\n";
        Connection cn = null;
        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // SELECT principal — todos los electrodomésticos
            ResultSet rs = st.executeQuery("select * from coches");

            while (rs.next()) {
                // Leemos cada columna por su nombre en la BBDD
                String matricula = rs.getString("matricula");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                int km = rs.getInt("km");
                boolean tieneRevision = rs.getBoolean("tieneRevision");

                // Crear coche sin revision (datosRevision = null por ahora)
                Coche cTemp = new Coche(matricula, marca, modelo, color, km, tieneRevision);

                // ── PUNTO CLAVE: consulta dentro de otra consulta ────
                PreparedStatement psRevision = cn.prepareStatement("select * from revisiones where matricula = ?");

                psRevision.setString(1, matricula);
                ResultSet rsRevision = psRevision.executeQuery();

                if (rsRevision.next()) {
                    // rs.getDate() devuelve java.sql.Date
                    // .toLocalDate() lo convierte a LocalDate de Java
                    LocalDate fechaRevision = rsRevision.getDate("fechaRevision").toLocalDate();
                    Double coste = rsRevision.getDouble("coste");

                    // Crear objeto Revision y asignarlo al coche
                    Revision rTemp = new Revision(matricula, fechaRevision, coste);
                    cTemp.setRevision(rTemp);
                }
                // Siempre cerrar los recursos secundarios
                rsRevision.close();
                psRevision.close();

                lista.add(cTemp);
                resultado += "Coche cargado: " + matricula + "\n";
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // finally garantiza que la conexión siempre se cierra
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─── INSERTAR PRINCIPAL ───────────────────────
    public static boolean insertarCoche(Scanner sc, ArrayList<Coche> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime la matricula del coche: ");
            String matricula = sc.nextLine();

            // ── Comprobar si ya existe ───────────────────────────
            // Statement con SQL concatenado (forma simple)
            ResultSet rs = st.executeQuery(
                    "select matricula from coches where matricula='" + matricula + "'");
            if (rs.next()) {
                System.out.println("Ya existe un coche con matricula: " + matricula);
                return false;  // salimos sin insertar
            }
            rs.close();

            // ── Pedir resto de datos ─────────────────────────────
            System.out.println("Dime la marca: ");
            String marca = sc.nextLine();
            System.out.println("Dime el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Dime el color: ");
            String color = sc.nextLine();
            System.out.println("Dime los km: ");
            int km = Utils.obtenNumeroEntero(sc.nextLine());
            System.out.println("¿Tiene revision? (S/N): ");
            // Validación S/N para tieneRevision
            int tieneRevisionInt = -1;
            String op = "-1";
            do {
                op = sc.nextLine().toUpperCase();
                switch (op) {
                    case "S":
                        tieneRevisionInt = 1;
                        break;
                    case "N":
                        tieneRevisionInt = 0;
                        break;
                    default:
                        op = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (op.equals("-1"));

// Convertir int a boolean para el objeto Java
            boolean tieneRevisionBool = (tieneRevisionInt == 1);

            // ── INSERT en electrodomesticos ──────────────────────
            // 7 columnas → 7 signos ? (índices del 1 al 7)
            ps = cn.prepareStatement(
                    "INSERT INTO coches( matricula, marca, modelo, color, km, tieneRevision) " + "VALUES (?,?,?,?,?,?)");
            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, color);
            ps.setInt(5, km);
            ps.setInt(6, tieneRevisionInt);
            ps.executeUpdate();

            System.out.println("Coche insertado correctamente.");

            Coche cTemp = new Coche(matricula, marca, modelo, color, km, tieneRevisionBool);

            // ── Preguntar si quiere añadir revision ahora ──────────
            String opRevision = "-1";
            do {
                System.out.println("¿Desea añadir una revision? (S/N): ");
                opRevision = sc.nextLine().toUpperCase();
                switch (opRevision) {
                    case "S":
                        break;
                    case "N":
                        break;
                    default:
                        opRevision = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (opRevision.equals("-1"));

            if (opRevision.equals("S")) {
                System.out.println("Dime la fecha de compra (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();

                // ── Conversión String → LocalDate con validación ─
                // LocalDate.parse() lanza excepción si la fecha no es válida
                // por ejemplo "5555-55-55" (mes 55 no existe)
                LocalDate fechaRevision = null;
                try {
                    fechaRevision = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el importe: ");
                String costeStr = sc.nextLine();
                double coste = Double.parseDouble(costeStr);

                // ── INSERT en compras ─────────────────────────────
                PreparedStatement psCompra = cn.prepareStatement(
                        "INSERT INTO revisiones(matricula, fechaRevision, coste) VALUES (?,?,?)");
                psCompra.setString(1, matricula);
                // Date.valueOf() convierte LocalDate → java.sql.Date para MySQL
                psCompra.setDate(2, Date.valueOf(fechaRevision));
                psCompra.setDouble(3, coste);
                psCompra.executeUpdate();
                psCompra.close();

                // Asignar la compra al objeto en memoria
                Revision revisionTemp = new Revision(matricula, fechaRevision, coste);
                cTemp.setRevision(revisionTemp);
            }

            // Añadir al ArrayList (con o sin compra)
            lista.add(cTemp);

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

    // ─── INSERTAR SECUNDARIO ──────────────────────
    public static boolean insertarRevision(Scanner sc, ArrayList<Coche> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Matricula del coche al que asociar la revision: ");
            String matricula = sc.nextLine();

            // PASO 1: Comprobar que existe el coche
            psBuscar = cn.prepareStatement(
                    "select matricula from coches where matricula = ?");
            psBuscar.setString(1, matricula);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Coche encontrado.");

                System.out.println("Dime la fecha de revision (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();

                // Conversión String → LocalDate con validación
                LocalDate fechaRevision = null;
                try {
                    fechaRevision = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el coste: ");
                double coste = Double.parseDouble(sc.nextLine());

                // PASO 2: INSERT en revisiones
                psInsert = cn.prepareStatement(
                        "INSERT INTO revisiones(matricula, fechaRevision, coste) VALUES (?,?,?)");
                psInsert.setString(1, matricula);
                psInsert.setDate(2, Date.valueOf(fechaRevision)); // LocalDate → java.sql.Date
                psInsert.setDouble(3, coste);
                int result = psInsert.executeUpdate();

                if (result > 0) {
                    // PASO 3: UPDATE en coches — marcar tieneRevision = 1
                    // Sin esto la próxima carga no sabrá que tiene revision
                    psUpdate = cn.prepareStatement(
                            "UPDATE coches SET tieneRevision = 1 WHERE matricula = ?");
                    psUpdate.setString(1, matricula);
                    psUpdate.executeUpdate();

                    System.out.println("Revision insertada correctamente.");

                    // PASO 4: Actualizar ArrayList en memoria
                    Revision revisionTemp = new Revision(matricula, fechaRevision, coste);
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getMatricula().equals(matricula)) {
                            lista.get(i).setRevision(revisionTemp);
                            lista.get(i).setTieneRevision(true); // actualizar también el boolean
                            break;
                        }
                    }
                } else {
                    System.out.println("No se pudo insertar la revision.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe coche con matricula: " + matricula);
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

    // ─── UTILIDADES ───────────────────────────────
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
