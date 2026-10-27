package com.mycompany.mainequipofutbolud08;

import java.sql.*;

public class Conexion {

    // Mismo formato exacto que usa el profe
    private static final String url    = "jdbc:mysql://localhost:3306/";
    private static final String schema = "equipo_futbol";
    private static final String user   = "root";
    private static final String pwd    = "CAMBIA_ESTA_PASSWORD";

    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cn;
    }

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
