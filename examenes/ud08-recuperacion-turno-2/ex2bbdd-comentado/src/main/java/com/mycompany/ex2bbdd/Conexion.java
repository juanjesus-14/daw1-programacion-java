package com.mycompany.ex2bbdd;

import java.sql.*;

/**
 * Clase Conexion — igual que en el Examen 1, solo cambia el schema.
 * Centraliza la gestión de la conexión a MySQL.
 */
public class Conexion {

    // ─── DATOS DE CONEXIÓN ───────────────────────
    private static final String url    = "jdbc:mysql://localhost:3306/";
    private static final String schema = "turno2";   // ← nombre de la BBDD
    private static final String user   = "root";
    private static final String pwd    = "CAMBIA_ESTA_PASSWORD";

    /**
     * Crea y devuelve una conexión a la base de datos.
     * URL completa: "jdbc:mysql://localhost:3306/turno2"
     */
    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            // catch extra para cualquier otro error inesperado
            e.printStackTrace();
        }
        return cn;
    }

    /**
     * Cierra la conexión recibida por parámetro.
     * Comprueba null antes de cerrar para evitar NullPointerException.
     */
    public static void cierraConexion(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
