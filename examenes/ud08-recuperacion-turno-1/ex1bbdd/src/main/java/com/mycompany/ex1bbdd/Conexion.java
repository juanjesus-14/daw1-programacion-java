/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juand
 */
public class Conexion {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String schema = "ex1bbdd";
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
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
