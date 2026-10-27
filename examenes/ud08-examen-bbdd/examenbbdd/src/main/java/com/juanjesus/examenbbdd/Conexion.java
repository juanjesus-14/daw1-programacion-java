
package com.juanjesus.examenbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author $(user)
 */
public class Conexion {

  private static final String url = "jdbc:mysql://localhost:3307/";
    private static final String schema = "1rodaw";
    private static final String user = "root";
    private static final String pwd = "CAMBIA_ESTA_PASSWORD";

    // Crea y devuelve la conexión — devuelve null si falla
    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cn;
    }

    // Cierra la conexión — recibe cn como parámetro para no llamar .close() sobre null
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