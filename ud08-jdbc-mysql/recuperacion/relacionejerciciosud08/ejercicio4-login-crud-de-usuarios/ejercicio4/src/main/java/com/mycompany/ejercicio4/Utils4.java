/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio4;

/**
 *
 * @author juand
 */
import java.sql.*;
import java.util.Scanner;

public class Utils4 {

    // ─────────────────────────────────────────────
    // LOGIN — devuelve tipo ('admin'/'normal')
    // o null si las credenciales son incorrectas
    // ─────────────────────────────────────────────
    public static String login(String username, String password) {

        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tipo = null;

        try {
            cn = Conexion.creaConexion();

            // Buscamos con username Y password a la vez
            ps = cn.prepareStatement(
                    "SELECT tipo FROM Usuarios WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                tipo = rs.getString("tipo"); // 'admin' o 'normal'
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return tipo; // null = acceso denegado
    }

    // ─────────────────────────────────────────────
    // VER todos los usuarios
    // ─────────────────────────────────────────────
    public static void verUsuarios() {

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM Usuarios");

            System.out.println("\n===== USUARIOS =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idUsuario")
                        + " | User: " + rs.getString("username")
                        + " | Tipo: " + rs.getString("tipo"));
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
    }

    // ─────────────────────────────────────────────
    // CREAR usuario
    // Comprueba que el username no existe ya
    // ─────────────────────────────────────────────
    public static String crearUsuario(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Nuevo username: ");
        String username = sc.nextLine();
        System.out.println("Contraseña: ");
        String password = sc.nextLine();
        String tipo = pedirTipo(sc);

        try {
            cn = Conexion.creaConexion();

            // Comprobamos que no existe ese username
            if (existeUsuario(username, cn)) {
                return "Ya existe un usuario con ese nombre: " + username;
            }

            // 3 columnas → 3 signos ?
            ps = cn.prepareStatement(
                    "INSERT INTO Usuarios(username, password, tipo) VALUES (?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, tipo);

            int result = ps.executeUpdate();
            resultado = result > 0
                    ? "Usuario creado correctamente."
                    : "No se pudo crear el usuario.";

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al crear usuario.";
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
    // MODIFICAR usuario — cambia password y tipo
    // ─────────────────────────────────────────────
    public static String modificarUsuario(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Username a modificar: ");
        String username = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            if (!existeUsuario(username, cn)) {
                return "No existe usuario con nombre: " + username;
            }

            System.out.println("Nueva contraseña: ");
            String newPassword = sc.nextLine();
            String nuevoTipo = pedirTipo(sc);

            // UPDATE — 2 campos + WHERE
            ps = cn.prepareStatement(
                    "UPDATE Usuarios SET password = ?, tipo = ? WHERE username = ?");
            ps.setString(1, newPassword);
            ps.setString(2, nuevoTipo);
            ps.setString(3, username);

            int result = ps.executeUpdate();
            resultado = result > 0
                    ? "Usuario modificado correctamente."
                    : "No se pudo modificar el usuario.";

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al modificar usuario.";
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
    // ELIMINAR usuario
    // ─────────────────────────────────────────────
    public static String eliminarUsuario(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Username a eliminar: ");
        String username = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            if (!existeUsuario(username, cn)) {
                return "No existe usuario con nombre: " + username;
            }

            // DELETE
            ps = cn.prepareStatement(
                    "DELETE FROM Usuarios WHERE username = ?");
            ps.setString(1, username);

            int result = ps.executeUpdate();
            resultado = result > 0
                    ? "Usuario eliminado correctamente."
                    : "No se pudo eliminar el usuario.";

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al eliminar usuario.";
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
    // MENÚ USUARIO NORMAL
    // Llama a los métodos de abajo que están
    // copiados del ejercicio 3 en esta misma clase
    // ─────────────────────────────────────────────
    public static void menuUsuarioNormal(Scanner sc) {

        int opcion = -1;
        do {
            System.out.println("\n-- MENÚ USUARIO --");
            System.out.println("1.- Ver alumnos y calificaciones");
            System.out.println("2.- Insertar alumno");
            System.out.println("3.- Insertar calificación");
            System.out.println("0.- Salir");
            System.out.print("Opción: ");
            opcion = obtenNumeroEntero(sc.nextLine());

            switch (opcion) {
                case 1:
                    listarAlumnos();                          // mismo Utils, sin prefijo
                    break;
                case 2:
                    System.out.println(insertarAlumno(sc));   // mismo Utils, sin prefijo
                    break;
                case 3:
                    System.out.println(insertarCalificacion(sc)); // mismo Utils, sin prefijo
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
    }

    // ─────────────────────────────────────────────
    // MÉTODOS DEL EJERCICIO 3
    // Copiados aquí para no depender de otro proyecto
    // ─────────────────────────────────────────────
    // LISTAR alumnos con sus calificaciones
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
    }

    // INSERTAR alumno
    // Comprueba que no existe ya ese email
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

    // INSERTAR calificación a un alumno existente
    // Busca el alumno por email antes de insertar
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
    // AUXILIARES PRIVADOS
    // ─────────────────────────────────────────────
    // Comprueba si existe un username — recibe conexión ya abierta
    private static boolean existeUsuario(String username, Connection cn)
            throws SQLException {
        PreparedStatement ps = cn.prepareStatement(
                "SELECT username FROM Usuarios WHERE username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        boolean existe = rs.next();
        rs.close();
        ps.close();
        return existe;
    }

    // Pide y valida el tipo (admin/normal)
    private static String pedirTipo(Scanner sc) {
        String tipo = "";
        do {
            System.out.println("Tipo (admin/normal): ");
            tipo = sc.nextLine().toLowerCase();
            if (!tipo.equals("admin") && !tipo.equals("normal")) {
                System.out.println("Tipo incorrecto, escribe admin o normal.");
            }
        } while (!tipo.equals("admin") && !tipo.equals("normal"));
        return tipo;
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
