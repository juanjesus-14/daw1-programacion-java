package com.juanjesus.exmanud08;

import java.sql.*;

/**
 *
 * @author $(user)
 */
public class Conexion {

    // Datos de conexión a la base de datos
    private static final String url = "jdbc:mysql://localhost:3307/";
    private static final String schema = "1rodaw";
    private static final String user = "root";
    private static final String pwd = "CAMBIA_ESTA_PASSWORD";

    // Crea y devuelve una conexión a la BBDD
    // Devuelve null si falla
    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    // Cierra la conexión que se le pasa por parámetro
    // IMPORTANTE: recibe la conexión como parámetro, no la crea dentro
    public static void cierraConexion(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
