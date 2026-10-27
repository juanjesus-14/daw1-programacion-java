/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2;

import java.sql.*;

/**
 *
 * @author juand
 */
public class UtilsEj2 {
    // Lee todos los alumnos y para cada uno busca sus calificaciones
    // Devuelve el total de líneas leídas

    public static int listarAlumnos() {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement psC = null;
        ResultSet rsC = null;
        int totalLineas = 0;

        try {
            cn = Conexion.creaConexion();
            st = cn.createStatement();

            // 1) Traemos todos los alumnos
            rs = st.executeQuery("SELECT * FROM Alumnos");

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                System.out.println("\nAlumna/o: " + nombre + " " + apellidos);
                totalLineas++;

                // 2) Para cada alumno buscamos sus calificaciones
                psC = cn.prepareStatement(
                        "SELECT * FROM Calificaciones WHERE idAlumno = ?");
                psC.setInt(1, idAlumno);
                rsC = psC.executeQuery();

                while (rsC.next()) {
                    String asignatura = rsC.getString("asignatura");
                    Double nota = rsC.getDouble("nota");
                    System.out.println("   " + asignatura + ": " + nota);
                    totalLineas++;
                }
                rsC.close();
                psC.close();
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
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
