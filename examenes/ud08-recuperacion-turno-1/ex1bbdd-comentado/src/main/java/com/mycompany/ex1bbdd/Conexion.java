package com.mycompany.ex1bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion — centraliza toda la gestión de la conexión a MySQL.
 * 
 * Todos los métodos son 'static' → se llaman sin crear objeto:
 *   Conexion.creaConexion()
 *   Conexion.cierraConexion(cn)
 */
public class Conexion {

    // ─── DATOS DE CONEXIÓN ───────────────────────
    // 'private static final' → constantes de clase, no cambian nunca
    // Solo accesibles desde dentro de esta clase

    // Dirección del servidor MySQL (localhost = este mismo ordenador, puerto 3306)
    private static final String url = "jdbc:mysql://localhost:3306/";

    // Nombre de la base de datos a la que nos conectamos
    private static final String schema = "ex1bbdd";

    // Usuario y contraseña de MySQL
    private static final String user = "root";
    private static final String pwd = "CAMBIA_ESTA_PASSWORD";

    // ─── MÉTODOS ─────────────────────────────────

    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * La URL completa queda: "jdbc:mysql://localhost:3306/ex1bbdd"
     * Si algo falla, imprime el error y devuelve null.
     */
    public static Connection creaConexion() {
        Connection cn = null;  // empezamos con null por si falla el try
        try {
            // DriverManager.getConnection() es el método JDBC que abre la conexión
            // Recibe: URL completa, usuario, contraseña
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            // SQLException → error relacionado con la base de datos
            sqle.printStackTrace();  // muestra el error en consola
        }
        // Devuelve la conexión (o null si falló)
        return cn;
    }

    /**
     * Cierra la conexión recibida por parámetro.
     * 
     * IMPORTANTE: recibe la conexión como parámetro.
     * Así podemos cerrar CUALQUIER conexión que nos pasen.
     * Comprobamos que no sea null antes de cerrar para evitar NullPointerException.
     */
    public static void cierraConexion(Connection cn) {
        // Solo intentamos cerrar si la conexión existe
        if (cn != null) {
            try {
                cn.close();  // libera los recursos de la conexión
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
