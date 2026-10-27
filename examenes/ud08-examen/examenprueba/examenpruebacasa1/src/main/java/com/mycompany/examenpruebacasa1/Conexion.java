/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebacasa1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juand
 */
public class Conexion {

//    //Instituto
//    // URL del servidor MySQL
//    private static final String url = "jdbc:mysql://localhost:3307/";
//    // Nombre de la base de datos
//    private static final String schema = "1rodaw";
//    // Usuario de MySQL
//    private static final String user = "root";
//    // Contraseña de MySQL
//    private static final String pwd = "CAMBIA_ESTA_PASSWORD";
    //Casa
    // URL del servidor MySQL
    private static final String url = "jdbc:mysql://localhost:3306/";
    // Nombre de la base de datos
    private static final String schema = "1rodaw";
    // Usuario de MySQL
    private static final String user = "root";
    // Contraseña de MySQL
    private static final String pwd = "";

    // Método que crea y devuelve una conexión
    public static Connection creaConexion() {
        // Variable para almacenar la conexión
        Connection cn = null;
        try {
            // Conexión a la BD
            // URL final:
            // jdbc:mysql://localhost:3307/1rodaw
            cn = DriverManager.getConnection(url + schema, user, pwd);
        } catch (SQLException sqle) {
            //System.out.println("Error SQL");
            sqle.printStackTrace();

        } catch (Exception e) {
            System.out.println("Error general");
        }
        // Devuelve la conexión creada
        return cn;
    }

    // Método para cerrar la conexión
    public static Connection cierraConexion() {
        Connection cn = null;
        try {
            // Cierra la conexión
            cn.close();
        } catch (SQLException sqle) {
            System.out.println("Error al cerrar");
        } catch (Exception e) {
            System.out.println("Error general");
        }
        return cn;
    }
}
