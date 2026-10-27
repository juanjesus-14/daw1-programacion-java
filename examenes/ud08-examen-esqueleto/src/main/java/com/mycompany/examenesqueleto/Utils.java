/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenesqueleto;

import java.sql.*;
import java.util.*;

/**
 *
 * @author juand
 */
public class Utils {

    // ─── LISTAR ───────────────────────────────────
    public static void listarJugadores(ArrayList<Jugador> lista) {
        // recorrer el ArrayList y hacer System.out.println de cada elemento
    }

    // ─── CARGA DE DATOS ───────────────────────────
    public static String cargaDatos(ArrayList<Jugador> lista) {
        String resultado = "Reporte de la carga:\n";
        Connection cn = null;
        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // 1) SELECT principal
            ResultSet rs = st.executeQuery("select * from jugadores");
            while (rs.next()) {
                // leer columnas con rs.getString(), rs.getInt(), rs.getBoolean()
                // crear objeto y añadir a lista
            }
            rs.close();

            // 2) SELECT secundario y asociar
            rs = st.executeQuery("select * from contratos");
            while (rs.next()) {
                // leer columnas
                // buscar en lista con for y equalsIgnoreCase()
                // asignar con asignaContrato()
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

    // ─── INSERTAR PRINCIPAL ───────────────────────
    public static boolean insertarJugador(ArrayList<Jugador> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // 1) Pedir dni y comprobar duplicado
            // ResultSet rs = st.executeQuery("select dni from jugadores where dni='" + dni + "'");
            // if (rs.next()) { return false; }
            // 2) Pedir resto de datos
            // 3) Validación S/N
            // int valor = -1; String op = "-1";
            // do { ... switch ... } while (op.equals("-1"));
            // 4) INSERT con PreparedStatement
            // ps = cn.prepareStatement("INSERT INTO jugadores(...) VALUES (?,?,...)");
            // ps.setString(1, ...); ps.setInt(2, ...); ps.executeUpdate();
            // 5) Crear objeto y añadir al ArrayList
            // lista.add(new Jugador(...));
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
    public static boolean insertarContrato(ArrayList<Jugador> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            cn = Conexion.creaConexion();

            // 1) Pedir dni y comprobar que existe
            // psBuscar = cn.prepareStatement("select dni from jugadores where dni = ?");
            // psBuscar.setString(1, dni); rs = psBuscar.executeQuery();
            // if (rs.next()) {
            //     // 2) Pedir datos del contrato
            //     // 3) LocalDate.parse() con try/catch
            //     // 4) INSERT en contratos
            //     // psInsert = cn.prepareStatement("INSERT INTO contratos(dni, fechaInicio, salarioAnual) VALUES (?,?,?)");
            //     // psInsert.setDate(2, Date.valueOf(fechaInicio));
            //     // 5) Actualizar ArrayList en memoria
            // }
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

    // ─── MODIFICAR ────────────────────────────────
    public static boolean modificarJugador(ArrayList<Jugador> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            cn = Conexion.creaConexion();

            // 1) Pedir dni y comprobar que existe
            // if (rs.next()) {
            //     // 2) Pedir nuevos datos
            //     // 3) UPDATE jugadores SET campo=?, campo=? WHERE dni=?
            //     //    IMPORTANTE: WHERE siempre al final
            //     // 4) Actualizar ArrayList con setters
            // }
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

    // ─── ELIMINAR ─────────────────────────────────
    public static boolean eliminarJugador(ArrayList<Jugador> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psDeleteSecundario = null;
        PreparedStatement psDeletePrincipal = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            cn = Conexion.creaConexion();

            // 1) Pedir dni y comprobar que existe
            // if (rs.next()) {
            //     // 2) Borrar primero tabla hija (clave foránea)
            //     // DELETE FROM contratos WHERE dni=?
            //     // 3) Borrar tabla padre
            //     // DELETE FROM jugadores WHERE dni=?
            //     // 4) Borrar del ArrayList
            //     // lista.remove(i); break;
            // }
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
                if (psDeleteSecundario != null) {
                    psDeleteSecundario.close();
                }
                if (psDeletePrincipal != null) {
                    psDeletePrincipal.close();
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
