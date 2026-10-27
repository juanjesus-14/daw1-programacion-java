/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author juand
 */
import java.sql.*;
import java.util.Scanner;

public class UtilsEj3 {

    // ─────────────────────────────────────────────
    // LISTAR alumnos con sus calificaciones
    // ─────────────────────────────────────────────
    public static void listarAlumnos() {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement psC = null;
        ResultSet rsC = null;

        try {
            cn = Conexion.creaConexion();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM Alumnos");

            System.out.println("\n===== ALUMNOS =====");
            while (rs.next()) {
                int id = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");

                System.out.println("\nAlumno: " + nombre + " " + apellidos
                        + " | Email: " + email);

                // Buscamos sus calificaciones
                psC = cn.prepareStatement(
                        "SELECT * FROM Calificaciones WHERE idAlumno = ?");
                psC.setInt(1, id);
                rsC = psC.executeQuery();

                boolean tieneNotas = false;
                while (rsC.next()) {
                    System.out.println("   " + rsC.getString("asignatura")
                            + ": " + rsC.getDouble("nota"));
                    tieneNotas = true;
                }
                if (!tieneNotas) {
                    System.out.println("   Sin calificaciones.");
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
    }

    // ─────────────────────────────────────────────
    // INSERTAR alumno
    // Comprueba que no existe ya ese email (integridad)
    // ─────────────────────────────────────────────
    public static String insertarAlumno(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            // Comprobamos que no existe ese email
            PreparedStatement psBusca = cn.prepareStatement(
                    "SELECT idAlumno FROM Alumnos WHERE email = ?");
            psBusca.setString(1, email);
            ResultSet rs = psBusca.executeQuery();

            if (rs.next()) {
                rs.close();
                psBusca.close();
                return "Ya existe un alumno con ese email: " + email;
            }
            rs.close();
            psBusca.close();

            // 3 columnas → 3 signos ?
            ps = cn.prepareStatement(
                    "INSERT INTO Alumnos(nombre, apellidos, email) VALUES (?,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, email);

            int result = ps.executeUpdate();
            resultado = result > 0
                    ? "Alumno insertado correctamente: " + nombre
                    : "No se pudo insertar el alumno.";

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar alumno.";
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
    // INSERTAR calificación a un alumno existente
    // Busca el alumno por email antes de insertar
    // ─────────────────────────────────────────────
    public static String insertarCalificacion(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement psInsert = null;

        System.out.println("Email del alumno: ");
        String email = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            // Buscamos el alumno por email para obtener su idAlumno
            PreparedStatement psBusca = cn.prepareStatement(
                    "SELECT idAlumno, nombre FROM Alumnos WHERE email = ?");
            psBusca.setString(1, email);
            ResultSet rs = psBusca.executeQuery();

            if (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String nombre = rs.getString("nombre");
                rs.close();
                psBusca.close();

                System.out.println("Alumno encontrado: " + nombre);
                System.out.println("Asignatura: ");
                String asignatura = sc.nextLine();
                System.out.println("Nota (0-10): ");
                Double nota = obtenNumeroDouble(sc.nextLine());

                // 3 columnas → 3 signos ?
                psInsert = cn.prepareStatement(
                        "INSERT INTO Calificaciones(idAlumno, asignatura, nota) VALUES (?,?,?)");
                psInsert.setInt(1, idAlumno);
                psInsert.setString(2, asignatura);
                psInsert.setDouble(3, nota);

                int result = psInsert.executeUpdate();
                resultado = result > 0
                        ? "Calificación insertada correctamente."
                        : "No se pudo insertar la calificación.";
            } else {
                resultado = "No existe alumno con email: " + email;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar calificación.";
        } finally {
            try {
                if (psInsert != null) {
                    psInsert.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES
    // ─────────────────────────────────────────────
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean ok = true;
        do {
            try {
                if (ok) {
                    numero = Integer.parseInt(opcion);
                } else {
                    ok = true;
                    numero = Integer.parseInt(new Scanner(System.in).nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto:");
                ok = false;
            }
        } while (!ok);
        return numero;
    }

    public static double obtenNumeroDouble(String opcion) {
        double numero = 0;
        boolean ok = true;
        do {
            try {
                if (ok) {
                    numero = Double.parseDouble(opcion);
                } else {
                    ok = true;
                    numero = Double.parseDouble(new Scanner(System.in).nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto:");
                ok = false;
            }
        } while (!ok);
        return numero;
    }
}
