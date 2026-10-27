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

public class UtilsEj1 {

    // Lee todas las filas de NOTAS y las muestra por pantalla
    // Devuelve el total de líneas leídas
    public static int listarNotas() {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        int totalLineas = 0;

        try {
            cn = Conexion.creaConexion();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM NOTAS");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String asignatura = rs.getString("asignatura");
                Double nota = rs.getDouble("nota");

                System.out.println("Alumna/o: " + nombre);
                System.out.println(asignatura + ": " + nota);

                totalLineas++; // contamos cada fila
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // Cerramos ResultSet y Statement antes de la conexión
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return totalLineas;
    }
}
