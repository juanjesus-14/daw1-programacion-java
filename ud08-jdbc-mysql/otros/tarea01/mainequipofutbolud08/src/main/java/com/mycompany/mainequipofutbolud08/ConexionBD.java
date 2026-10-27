/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainequipofutbolud08;

import java.sql.*;

/**
 *
 * @author juand
 */
public class ConexionBD {
    
  public static Connection conectar() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/equipo_futbol",
                "root",
                ""
            );
            System.out.println("Conectado a la BD");
        } catch (SQLException e) {
            System.out.println("Error conexión BD");
        }

        return con;
    }
}