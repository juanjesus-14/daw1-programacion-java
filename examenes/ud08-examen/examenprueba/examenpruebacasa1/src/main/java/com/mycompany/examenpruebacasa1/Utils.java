/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpruebacasa1;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Utils {

    public static int obtenNumeroEntero(String num) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(num);
                } else {
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de numero incorrecto");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

    public static boolean cargaDatos(
            ArrayList<Alumno> listaAlumno) {

        try {

            Connection cn
                    = Conexion.creaConexion();

            Statement st
                    = cn.createStatement();

            ResultSet rs
                    = st.executeQuery(
                            "SELECT * FROM alumnos");

            while (rs.next()) {

                Alumno a
                        = new Alumno(
                                rs.getInt("expediente"),
                                rs.getString("dni"),
                                rs.getString("nombre"));

                listaAlumno.add(a);
            }

            return true;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());

            return false;
        }
    }

    public static void listaAlumnos(
            ArrayList<Alumno> listaAlumno) {

        for (Alumno a : listaAlumno) {

            System.out.println(a);
        }
    }

}
