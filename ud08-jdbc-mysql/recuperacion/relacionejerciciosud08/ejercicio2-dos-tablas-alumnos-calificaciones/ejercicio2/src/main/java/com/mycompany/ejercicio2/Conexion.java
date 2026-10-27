/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2;

/**
 *
 * @author juand
 */
import java.sql.*;

public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String schema = "1rodaw";
    private static final String user = "root";
    private static final String pwd = "CAMBIA_ESTA_PASSWORD";

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
