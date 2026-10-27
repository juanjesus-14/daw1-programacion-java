package com.mycompany.ex3bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion — igual que en los Exámenes 1 y 2.
 * Solo cambia el schema: aquí es "1rodaw".
 */
public class Conexion {

    // ─── DATOS DE CONEXIÓN ───────────────────────
    private static final String url    = "jdbc:mysql://localhost:3306/";
    private static final String schema = "1rodaw";   // ← nombre de la BBDD
    private static final String user   = "root";
    private static final String pwd    = "CAMBIA_ESTA_PASSWORD";

    /**
     * Crea y devuelve una conexión a la base de datos.
     * URL completa: "jdbc:mysql://localhost:3306/1rodaw"
     */
    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cn;
    }

    /**
     * Cierra la conexión recibida por parámetro.
     * Comprueba null antes de cerrar para evitar NullPointerException.
     */
    public static void cierraConexion(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
