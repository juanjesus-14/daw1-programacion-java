/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daw
 */
public class Conexion {

    // URL del servidor MySQL
    private static final String url = "jdbc:mysql://localhost:3307/";
    // Nombre de la base de datos
    private static final String schema = "1rodaw";
    // Usuario de MySQL
    private static final String user = "root";
    // Contraseña del usuario
    private static final String pwd = "CAMBIA_ESTA_PASSWORD";

    // Método que crea y devuelve una conexión
    public static Connection creaConexion() {
        // Variable donde se almacenará la conexión
        Connection cn = null;
        try {
            // Crea la conexión con MySQL
            // URL completa:
            // jdbc:mysql://localhost:3307/1rodaw
            cn = DriverManager.getConnection(url + schema, user, pwd);

        } catch (SQLException sqle) {
            // Captura errores SQL
            sqle.printStackTrace();
        } catch (Exception e) {
            // Captura cualquier otro error
            e.printStackTrace();
        }
        // Devuelve la conexión creada
        return cn;
    }

    // Método para cerrar la conexión
    public static Connection cierraConexion() {
        // Variable de conexión
        Connection cn = null;
        try {
            // Cierra la conexión con la BD
            cn.close();
        } catch (SQLException sqle) {
            // Error al cerrar la conexión
            sqle.printStackTrace();
        } catch (Exception e) {
            // Error general
            e.printStackTrace();
        }
        // Devuelve la conexión
        return cn;
    }
}
