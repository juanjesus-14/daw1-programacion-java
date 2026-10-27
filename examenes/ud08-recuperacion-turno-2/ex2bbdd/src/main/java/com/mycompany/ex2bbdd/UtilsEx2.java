/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex2bbdd;

import java.sql.*;
import java.util.*;

public class UtilsEx2 {

    // ─────────────────────────────────────────────
    // LISTAR
    // ─────────────────────────────────────────────
    public static void listaOrdenador(ArrayList<Ordenador> listaOrdenador) {
        for (int i = 0; i < listaOrdenador.size(); i++) {
            System.out.println(listaOrdenador.get(i).toString());
        }
    }

    // ─────────────────────────────────────────────
    // CARGA DE DATOS
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Ordenador> listaOrdenador) {
        String resultado = "Reporte de la carga de ordenador:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from equipos");

            while (rs.next()) {
                String numSerie = rs.getString("numSerie");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                String formato = rs.getString("formato");
                String ram = rs.getString("ram");
                String procesador = rs.getString("procesador");
                String hdd = rs.getString("hdd");
                boolean tieneGarantia = rs.getBoolean("tieneGarantia");

                Ordenador ordTemp = new Ordenador(
                        numSerie, fabricante, modelo,
                        formato, ram, procesador, hdd, tieneGarantia);

                // Si tiene garantía, buscarla con PreparedStatement SEPARADO
                // No podemos usar 'st' aquí porque rs todavía está abierto
                if (tieneGarantia) {
                    PreparedStatement psGar = cn.prepareStatement(
                            "select * from garantia where numSerie = ?");
                    psGar.setString(1, numSerie);
                    ResultSet rsGar = psGar.executeQuery();

                    if (rsGar.next()) {
                        String fechaFin = rsGar.getString("fechaFin");
                        Double importeAnual = rsGar.getDouble("importeAnual");
                        ordTemp.setGarantia(new Garantia(numSerie, fechaFin, importeAnual));
                    }
                    rsGar.close();
                    psGar.close();
                }

                listaOrdenador.add(ordTemp);
                resultado += "Se ha añadido el ordenador: " + numSerie
                        + (tieneGarantia ? " con garantía asociada." : ". No dispone de garantía.")
                        + "\n";
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // INSERTAR ORDENADOR
    // ─────────────────────────────────────────────
    //Con 0 o 1 la garantia
    public static String insertarOrdenador(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Dime el número de serie del ordenador: ");
        String numSerie = sc.nextLine();
        System.out.println("Dime el fabricante del ordenador: ");
        String fabricante = sc.nextLine();
        System.out.println("Dime el modelo del ordenador: ");
        String modelo = sc.nextLine();
        System.out.println("Dime el formato del ordenador: ");
        String formato = sc.nextLine();
        System.out.println("Dime la RAM del ordenador: ");
        String ram = sc.nextLine();
        System.out.println("Dime el procesador del ordenador: ");
        String procesador = sc.nextLine();
        System.out.println("Dime el hdd del ordenador: ");
        String hdd = sc.nextLine();
        System.out.println("Dime si tiene garantia con 0 o 1: ");
        String tieneGarantia = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            String sql = "INSERT INTO equipos(numSerie, fabricante, modelo, formato, ram, procesador, hdd, tieneGarantia) VALUES (?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, numSerie);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, formato);
            ps.setString(5, ram);
            ps.setString(6, procesador);
            ps.setString(7, hdd);
            ps.setString(8, tieneGarantia);

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Se ha insertado correctamente el ordenador: " + numSerie;
            } else {
                resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    //Con Si o No la garantia
    public static String insertarOrdenador2(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        // Pedimos todos los datos antes de abrir la conexión
        System.out.println("Dime el número de serie del ordenador: ");
        String numSerie = sc.nextLine();
        System.out.println("Dime el fabricante del ordenador: ");
        String fabricante = sc.nextLine();
        System.out.println("Dime el modelo del ordenador: ");
        String modelo = sc.nextLine();
        System.out.println("Dime el formato del ordenador: ");
        String formato = sc.nextLine();
        System.out.println("Dime la RAM del ordenador: ");
        String ram = sc.nextLine();
        System.out.println("Dime el procesador del ordenador: ");
        String procesador = sc.nextLine();
        System.out.println("Dime el hdd del ordenador: ");
        String hdd = sc.nextLine();

        // Validación S/N para garantía
        int tieneGarantiaInt = -1;
        String op = "-1";
        do {
            System.out.println("¿Tiene garantia? (S/N): ");
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
                    System.out.println("Opción incorrecta, escribe S o N.");
            }
        } while (op.equals("-1"));

        try {
            cn = Conexion.creaConexion();

            String sql = "INSERT INTO equipos(numSerie, fabricante, modelo, formato, ram, procesador, hdd, tieneGarantia) VALUES (?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, numSerie);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, formato);
            ps.setString(5, ram);
            ps.setString(6, procesador);
            ps.setString(7, hdd);
            ps.setInt(8, tieneGarantiaInt);  // int, no String

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Se ha insertado correctamente el ordenador: " + numSerie;
            } else {
                resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // INSERTAR GARANTÍA
    // ─────────────────────────────────────────────
    public static String insertarGarantia(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Dime el número de serie del ordenador al que asocias la garantía: ");
            String numSerie = sc.nextLine();

            // Comprobar que existe el ordenador
            psBuscar = cn.prepareStatement("SELECT * FROM equipos WHERE numSerie = ?");
            psBuscar.setString(1, numSerie);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Ordenador encontrado.");

                System.out.println("Dime la fecha en la que acaba la garantía: ");
                String fechaFin = sc.nextLine();
                System.out.println("Dime el importe anual: ");
                String importeAnual = sc.nextLine();

                // INSERT en garantia
                psInsert = cn.prepareStatement("INSERT INTO garantia(numSerie, fechaFin, importeAnual) VALUES (?,?,?)");
                psInsert.setString(1, numSerie);
                psInsert.setString(2, fechaFin);
                psInsert.setString(3, importeAnual);
                int resultInsert = psInsert.executeUpdate();

                if (resultInsert > 0) {
                    // UPDATE en equipos — marcar tieneGarantia = 1
                    psUpdate = cn.prepareStatement("UPDATE equipos SET tieneGarantia = 1 WHERE numSerie = ?");
                    psUpdate.setString(1, numSerie);
                    int resultUpdate = psUpdate.executeUpdate();

                    if (resultUpdate > 0) {
                        resultado = "Garantía insertada y asociada correctamente";
                    } else {
                        resultado = "No se pudo asociar la garantía";
                    }
                } else {
                    resultado = "No se pudo insertar la garantía";
                }
            } else {
                resultado = "No existe el ordenador con número de serie: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL";
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error general";
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
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES
    // ─────────────────────────────────────────────
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
