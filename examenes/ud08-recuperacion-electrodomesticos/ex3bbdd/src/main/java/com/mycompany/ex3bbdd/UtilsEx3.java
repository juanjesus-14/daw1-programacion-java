/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex3bbdd;

import java.time.LocalDate;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

public class UtilsEx3 {

    // ═══════════════════════════════════════════════════════════
    // LISTAR
    // ═══════════════════════════════════════════════════════════
    public static void listar(ArrayList<Electrodomestico> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Electrodomestico> lista) {

        String resultado = "Reporte de la carga:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from electrodomesticos");

            while (rs.next()) {
                String codProducto = rs.getString("codProducto");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                String tipo = rs.getString("tipo");
                String caracteristicas = rs.getString("caracteristicas");
                String consumo = rs.getString("consumo");
                boolean tieneGarantia = rs.getBoolean("tieneGarantia");

                Electrodomestico eTemp = new Electrodomestico(
                        fabricante, modelo, codProducto,
                        tipo, caracteristicas, consumo, tieneGarantia);

                // Buscar compra asociada con PreparedStatement SEPARADO
                // No podemos usar 'st' aquí porque 'rs' sigue abierto
                PreparedStatement psCompra = cn.prepareStatement("select * from compras where codProducto = ?");
                psCompra.setString(1, codProducto);
                ResultSet rsCompra = psCompra.executeQuery();

                if (rsCompra.next()) {
                    // rs.getDate() devuelve java.sql.Date → .toLocalDate() lo convierte a LocalDate
                    LocalDate fechaCompra = rsCompra.getDate("fechaCompra").toLocalDate();
                    Double importe = rsCompra.getDouble("importe");
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                    eTemp.setDatosCompra(compraTemp);
                }
                rsCompra.close();
                psCompra.close();

                lista.add(eTemp);
                resultado += "Electrodomestico cargado: " + codProducto + "\n";
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

    // ═══════════════════════════════════════════════════════════
    // INSERTAR ELECTRODOMÉSTICO (con compra opcional)
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarElectrodomestico(Scanner sc, ArrayList<Electrodomestico> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime el código del producto: ");
            String codProducto = sc.nextLine();

            // Comprobar si ya existe
            ResultSet rs = st.executeQuery("select codProducto from electrodomesticos where codProducto='" + codProducto + "'");
            if (rs.next()) {
                System.out.println("Ya existe un electrodoméstico con código: " + codProducto);
                return false;
            }
            rs.close();

            System.out.println("Dime el fabricante: ");
            String fabricante = sc.nextLine();
            System.out.println("Dime el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Dime el tipo (lavadora, lavavajillas, nevera): ");
            String tipo = sc.nextLine();
            System.out.println("Dime las características: ");
            String caracteristicas = sc.nextLine();
            System.out.println("Dime el consumo: ");
            String consumo = sc.nextLine();

            // Validación S/N para garantía
            int tieneGarantiaInt = -1;
            String op = "-1";
            do {
                System.out.println("¿Tiene garantía? (S/N): ");
                op = sc.nextLine().toUpperCase();
                switch (op) {
                    case "S":
                        tieneGarantiaInt = 1;
                        break;
                    case "N":
                        tieneGarantiaInt = 0;
                        break;
                    default:
                        op = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (op.equals("-1"));

            // INSERT en electrodomesticos
            ps = cn.prepareStatement("INSERT INTO electrodomesticos(codProducto, fabricante, modelo, tipo, caracteristicas, consumo, tieneGarantia) " + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, codProducto);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, tipo);
            ps.setString(5, caracteristicas);
            ps.setString(6, consumo);
            ps.setInt(7, tieneGarantiaInt);
            ps.executeUpdate();

            System.out.println("Electrodoméstico insertado correctamente.");

            boolean tieneGarantiaBool = (tieneGarantiaInt == 1);
            Electrodomestico eTemp = new Electrodomestico(fabricante, modelo, codProducto, tipo, caracteristicas, consumo, tieneGarantiaBool);

            // Preguntar si quiere añadir compra ahora
            String opCompra = "-1";
            do {
                System.out.println("¿Desea añadir una compra? (S/N): ");
                opCompra = sc.nextLine().toUpperCase();
                switch (opCompra) {
                    case "S":
                        break;
                    case "N":
                        break;
                    default:
                        opCompra = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (opCompra.equals("-1"));

            if (opCompra.equals("S")) {
                System.out.println("Dime la fecha de compra (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();
                // Convertir String a LocalDate
                //LocalDate fechaCompra = LocalDate.parse(fechaStr);
                LocalDate fechaCompra = null;
                try {
                    fechaCompra = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el importe: ");
                String importeStr = sc.nextLine();
                double importe = Double.parseDouble(importeStr);

                // INSERT en compras
                // Date.valueOf() convierte LocalDate a java.sql.Date para la BBDD
                PreparedStatement psCompra = cn.prepareStatement("INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
                psCompra.setString(1, codProducto);
                psCompra.setDate(2, Date.valueOf(fechaCompra));
                psCompra.setDouble(3, importe);
                psCompra.executeUpdate();
                psCompra.close();

                Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                eTemp.setDatosCompra(compraTemp);
            }

            lista.add(eTemp);

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

    // ═══════════════════════════════════════════════════════════
    // INSERTAR COMPRA A ELECTRODOMÉSTICO EXISTENTE
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarCompra(Scanner sc, ArrayList<Electrodomestico> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Código del electrodoméstico al que asociar la compra: ");
            String codProducto = sc.nextLine();

            // Comprobar que existe
            psBuscar = cn.prepareStatement("select codProducto from electrodomesticos where codProducto = ?");
            psBuscar.setString(1, codProducto);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Electrodoméstico encontrado.");

                System.out.println("Dime la fecha de compra (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();
                //LocalDate fechaCompra = LocalDate.parse(fechaStr);
                LocalDate fechaCompra = null;
                try {
                    fechaCompra = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el importe: ");
                String importeStr = sc.nextLine();
                double importe = Double.parseDouble(importeStr);

                // INSERT en compras
                psInsert = cn.prepareStatement("INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
                psInsert.setString(1, codProducto);
                psInsert.setDate(2, Date.valueOf(fechaCompra)); // LocalDate → java.sql.Date
                psInsert.setDouble(3, importe);
                int result = psInsert.executeUpdate();

                if (result > 0) {
                    System.out.println("Compra insertada correctamente.");

                    // Actualizar ArrayList en memoria
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getCodProducto().equals(codProducto)) {
                            lista.get(i).setDatosCompra(compraTemp);
                            break;
                        }
                    }
                } else {
                    System.out.println("No se pudo insertar la compra.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe electrodoméstico con código: " + codProducto);
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

    // ═══════════════════════════════════════════════════════════
    // UTILIDADES
    // ═══════════════════════════════════════════════════════════
    public static int obtenNumeroEntero(String num) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(num);
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
