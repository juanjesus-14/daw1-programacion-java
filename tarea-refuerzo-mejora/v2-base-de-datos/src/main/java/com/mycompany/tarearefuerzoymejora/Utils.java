/*
 * Autor: Juan Jesús
 * Fecha: Junio 2026
 */
package com.mycompany.tarearefuerzoymejora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    // ═══════════════════════════════════════════════════════════
    // LISTAR
    // ═══════════════════════════════════════════════════════════
    public static void listar(ArrayList<Persona> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Persona> lista) {
        String resultado = "Reporte de la carga:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // ── PASO 1: Cargar personas ──────────────────────────
            ResultSet rs = st.executeQuery("select * from personas");
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");

                Persona pTemp = new Persona(dni, nombre, apellidos, email, telefono, direccion);
                lista.add(pTemp);
                resultado += "Persona cargada: " + dni + "\n";
            }
            rs.close();

            // ── PASO 2: Cargar mascotas y asociarlas ─────────────
            rs = st.executeQuery("select * from mascotas");
            while (rs.next()) {
                String dniPersona = rs.getString("dniPersona");
                String nombreMascota = rs.getString("nombreMascota");
                int edad = rs.getInt("edad");
                String raza = rs.getString("raza");

                Mascota mTemp = new Mascota(dniPersona, nombreMascota, edad, raza);

                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getDni().equalsIgnoreCase(dniPersona)) {
                        lista.get(i).asignaMascota(mTemp);
                        resultado += "Mascota asociada: " + nombreMascota + " a " + dniPersona + "\n";
                    }
                }
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR PERSONA
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarPersona(Scanner sc, ArrayList<Persona> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime el DNI de la persona: ");
            String dni = sc.nextLine();

            ResultSet rs = st.executeQuery("select dni from personas where dni='" + dni + "'");
            if (rs.next()) {
                System.out.println("Ya existe una persona con DNI: " + dni);
                return false;
            }
            rs.close();

            System.out.println("Dime el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Dime los apellidos: ");
            String apellidos = sc.nextLine();
            System.out.println("Dime el email: ");
            String email = sc.nextLine();
            System.out.println("Dime el teléfono: ");
            String telefono = sc.nextLine();
            System.out.println("Dime la dirección: ");
            String direccion = sc.nextLine();

            ps = cn.prepareStatement(
                "INSERT INTO personas(dni, nombre, apellidos, email, telefono, direccion) VALUES (?,?,?,?,?,?)"
            );
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, email);
            ps.setString(5, telefono);
            ps.setString(6, direccion);
            ps.executeUpdate();

            System.out.println("Persona insertada correctamente.");

            Persona pTemp = new Persona(dni, nombre, apellidos, email, telefono, direccion);
            lista.add(pTemp);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR MASCOTA
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarMascota(Scanner sc, ArrayList<Persona> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("DNI de la persona a la que asociar la mascota: ");
            String dniPersona = System.console().readLine();

            String sql = "select dni from personas where dni='" + dniPersona + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Persona encontrada.");

                System.out.println("Dime el nombre de la mascota: ");
                String nombreMascota = sc.nextLine();
                System.out.println("Dime la edad de la mascota: ");
                int edad = Utils.obtenNumeroEntero(sc.nextLine());
                System.out.println("Dime la raza de la mascota: ");
                String raza = sc.nextLine();

                sql = "INSERT INTO mascotas(dniPersona, nombreMascota, edad, raza) VALUES (?,?,?,?)";
                ps = cn.prepareStatement(sql);
                ps.setString(1, dniPersona);
                ps.setString(2, nombreMascota);
                ps.setInt(3, edad);
                ps.setString(4, raza);
                ps.executeUpdate();

                System.out.println("Mascota insertada correctamente.");

                Mascota mTemp = new Mascota(dniPersona, nombreMascota, edad, raza);
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getDni().equalsIgnoreCase(dniPersona)) {
                        lista.get(i).asignaMascota(mTemp);
                        break;
                    }
                }

            } else {
                System.out.println("No existe persona con DNI: " + dniPersona);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // MODIFICAR PERSONA
    // ═══════════════════════════════════════════════════════════
    public static boolean modificarPersona(Scanner sc, ArrayList<Persona> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("DNI de la persona a modificar: ");
            String dni = sc.nextLine();

            ResultSet rs = st.executeQuery("select dni from personas where dni='" + dni + "'");
            if (!rs.next()) {
                System.out.println("No existe persona con DNI: " + dni);
                return false;
            }
            rs.close();

            Persona aModificar = null;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDni().equalsIgnoreCase(dni)) {
                    aModificar = lista.get(i);
                    break;
                }
            }

            System.out.println("Datos actuales: " + aModificar);
            System.out.println("(Pulsa ENTER para dejar el valor sin cambios)");

            System.out.println("Nuevo nombre [" + aModificar.getNombre() + "]: ");
            String nombre = sc.nextLine();
            if (!nombre.isEmpty()) aModificar.setNombre(nombre);

            System.out.println("Nuevos apellidos [" + aModificar.getApellidos() + "]: ");
            String apellidos = sc.nextLine();
            if (!apellidos.isEmpty()) aModificar.setApellidos(apellidos);

            System.out.println("Nuevo email [" + aModificar.getEmail() + "]: ");
            String email = sc.nextLine();
            if (!email.isEmpty()) aModificar.setEmail(email);

            System.out.println("Nuevo teléfono [" + aModificar.getTelefono() + "]: ");
            String telefono = sc.nextLine();
            if (!telefono.isEmpty()) aModificar.setTelefono(telefono);

            System.out.println("Nueva dirección [" + aModificar.getDireccion() + "]: ");
            String direccion = sc.nextLine();
            if (!direccion.isEmpty()) aModificar.setDireccion(direccion);

            ps = cn.prepareStatement(
                "UPDATE personas SET nombre=?, apellidos=?, email=?, telefono=?, direccion=? WHERE dni=?"
            );
            ps.setString(1, aModificar.getNombre());
            ps.setString(2, aModificar.getApellidos());
            ps.setString(3, aModificar.getEmail());
            ps.setString(4, aModificar.getTelefono());
            ps.setString(5, aModificar.getDireccion());
            ps.setString(6, dni);
            ps.executeUpdate();

            System.out.println("Persona modificada correctamente.");
            // El objeto en el ArrayList ya está actualizado (modificamos el mismo objeto)

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // ELIMINAR MASCOTA
    // ═══════════════════════════════════════════════════════════
    public static boolean eliminarMascota(Scanner sc, ArrayList<Persona> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("DNI de la persona propietaria: ");
            String dniPersona = sc.nextLine();

            Persona propietario = null;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDni().equalsIgnoreCase(dniPersona)) {
                    propietario = lista.get(i);
                    break;
                }
            }

            if (propietario == null) {
                System.out.println("No existe persona con DNI: " + dniPersona);
                return false;
            }

            if (propietario.getMascotas().isEmpty()) {
                System.out.println(propietario.getNombre() + " no tiene mascotas.");
                return false;
            }

            System.out.println("Mascotas de " + propietario.getNombre() + ":");
            for (int i = 0; i < propietario.getMascotas().size(); i++) {
                System.out.println("  " + (i + 1) + ". " + propietario.getMascotas().get(i).getNombre());
            }

            System.out.println("Nombre de la mascota a eliminar: ");
            String nombreMascota = sc.nextLine();

            Mascota aEliminar = null;
            for (int i = 0; i < propietario.getMascotas().size(); i++) {
                if (propietario.getMascotas().get(i).getNombre().equalsIgnoreCase(nombreMascota)) {
                    aEliminar = propietario.getMascotas().get(i);
                    break;
                }
            }

            if (aEliminar == null) {
                System.out.println("No se encontró esa mascota.");
                return false;
            }

            ps = cn.prepareStatement("DELETE FROM mascotas WHERE dniPersona=? AND nombreMascota=?");
            ps.setString(1, dniPersona);
            ps.setString(2, aEliminar.getNombre());
            ps.executeUpdate();

            System.out.println("Mascota eliminada correctamente.");

            propietario.getMascotas().remove(aEliminar);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // ELIMINAR PERSONA (primero mascotas por FK, luego persona)
    // ═══════════════════════════════════════════════════════════
    public static boolean eliminarPersona(Scanner sc, ArrayList<Persona> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("DNI de la persona a eliminar: ");
            String dni = sc.nextLine();

            ResultSet rs = st.executeQuery("select dni from personas where dni='" + dni + "'");
            if (!rs.next()) {
                System.out.println("No existe persona con DNI: " + dni);
                return false;
            }
            rs.close();

            System.out.println("¿Seguro que deseas eliminarla junto con sus mascotas? (S/N): ");
            String confirm = System.console().readLine().toUpperCase();
            if (!confirm.equals("S")) {
                System.out.println("Operación cancelada.");
                return false;
            }

            // PRIMERO eliminar mascotas (clave foránea)
            ps = cn.prepareStatement("DELETE FROM mascotas WHERE dniPersona=?");
            ps.setString(1, dni);
            ps.executeUpdate();
            ps.close();

            // LUEGO eliminar persona
            ps = cn.prepareStatement("DELETE FROM personas WHERE dni=?");
            ps.setString(1, dni);
            ps.executeUpdate();

            System.out.println("Persona y sus mascotas eliminadas correctamente.");

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDni().equalsIgnoreCase(dni)) {
                    lista.remove(i);
                    break;
                }
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // UTILIDAD — lee un número entero con validación
    // ═══════════════════════════════════════════════════════════
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
}
