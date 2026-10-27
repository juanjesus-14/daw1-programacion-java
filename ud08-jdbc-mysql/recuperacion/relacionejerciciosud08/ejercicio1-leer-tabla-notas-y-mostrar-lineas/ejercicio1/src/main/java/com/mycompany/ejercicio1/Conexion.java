/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

/**
 *
 * @author juand
 */
import java.sql.*;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/1rodaw";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "CAMBIA_ESTA_PASSWORD";

    public static Connection creaConexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
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
