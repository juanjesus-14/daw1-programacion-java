/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfacil;

import java.sql.*;
import java.util.ArrayList;

import java.io.*;

public class Utils {

    // ─────────────────────────────────────────────
    // LISTAR alumnos del ArrayList
    // ─────────────────────────────────────────────
    public static void listaAlumnos(ArrayList<Alumno> lista) {
        // lista.get(i) imprime el objeto — NUNCA imprimir lista directamente
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    // ─────────────────────────────────────────────
    // CARGA DE DATOS
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Alumno> lista) {
        String resultado = "Reporte de carga:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // SELECT para traer todos los alumnos
            ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
            while (rs.next()) {
                // Leemos cada campo de la fila
                int numAlumno = rs.getInt("numAlumno");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String curso = rs.getString("curso");

                // Creamos el objeto y lo añadimos al ArrayList
                // NUNCA añadir null al ArrayList
                Alumno alumTemp = new Alumno(numAlumno, dni, nombre, apellidos, curso);
                lista.add(alumTemp);
                resultado += "Alumno cargado: " + dni + "\n";
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // Cerramos siempre en el finally con null-check
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // INSERTAR nuevo alumno
    // ─────────────────────────────────────────────
    public static String insertarAlumno(BufferedReader br, ArrayList<Alumno> lista) {
        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            // Pedimos datos al usuario con BufferedReader
            System.out.println("DNI: ");
            String dni = br.readLine();
            System.out.println("Nombre: ");
            String nombre = br.readLine();
            System.out.println("Apellidos: ");
            String apellidos = br.readLine();
            System.out.println("Curso: ");
            String curso = br.readLine();

            cn = Conexion.creaConexion();

            // 4 columnas → 4 signos ? (numAlumno es AUTO_INCREMENT, no lo insertamos)
            // Statement.RETURN_GENERATED_KEYS avisa a MySQL de que vamos a pedir el id generado
            ps = cn.prepareStatement(
                    "INSERT INTO alumnos(dni, nombre, apellidos, curso) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            // Los índices empiezan en 1, mismo orden que el SQL
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, curso);

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Alumno insertado correctamente: " + dni;

                // Obtenemos el numAlumno que MySQL generó automáticamente
                ResultSet rsKeys = ps.getGeneratedKeys();
                int numAlumno = 0;
                if (rsKeys.next()) {
                    numAlumno = rsKeys.getInt(1); // columna 1 = el id generado
                }
                rsKeys.close();

                // Creamos el objeto con el numAlumno real de la BD
                Alumno alumTemp = new Alumno(numAlumno, dni, nombre, apellidos, curso);
                lista.add(alumTemp);
            } else {
                resultado = "No se pudo insertar el alumno: " + dni;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar alumno.";
        } catch (IOException e) {
            e.printStackTrace();
            resultado = "Error de lectura.";
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES — lectura segura de números
    // ─────────────────────────────────────────────
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean ok = true;
        // BufferedReader propio para el bucle de validación
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                if (ok) {
                    // Primera vez intenta parsear el parámetro recibido
                    numero = Integer.parseInt(opcion);
                } else {
                    // Si falló, pide otro número
                    ok = true;
                    numero = Integer.parseInt(br.readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                ok = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!ok);
        return numero;
    }
}
