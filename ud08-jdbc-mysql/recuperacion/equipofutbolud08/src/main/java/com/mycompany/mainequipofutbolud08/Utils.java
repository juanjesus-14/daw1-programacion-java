package com.mycompany.mainequipofutbolud08;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Utils {

    // ─────────────────────────────────────────────
    // LEER FICHERO → LinkedList
    // Lee el fichero línea a línea, crea objetos Jugador
    // y los añade a la lista en memoria
    // ─────────────────────────────────────────────
    public static String leerFichero(LinkedList<Jugador> lista, String rutaFichero) {

        String resultado = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String linea;

            while ((linea = br.readLine()) != null) {
                // Cada línea tiene formato: id;nombre;posicion;dorsal;edad
                String[] datos = linea.split(";");

                Jugador j = new Jugador(
                        Integer.parseInt(datos[0].trim()), // id
                        datos[1].trim(),                   // nombre
                        datos[2].trim(),                   // posicion
                        Integer.parseInt(datos[3].trim()), // dorsal
                        Integer.parseInt(datos[4].trim())  // edad
                );
                lista.add(j);
            }
            br.close();
            resultado = "Fichero leído correctamente. Jugadores cargados: " + lista.size();

        } catch (FileNotFoundException e) {
            resultado = "Error: no se encontró el fichero: " + rutaFichero;
        } catch (IOException e) {
            resultado = "Error al leer el fichero.";
            e.printStackTrace();
        } catch (NumberFormatException e) {
            resultado = "Error: formato incorrecto en el fichero.";
            e.printStackTrace();
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // INSERTAR FICHERO EN BBDD
    // Recorre el LinkedList y mete cada jugador en la BBDD
    // Comprueba que no existe ya el id antes de insertar
    // ─────────────────────────────────────────────
    public static String insertarFicheroEnBBDD(LinkedList<Jugador> lista) {

        String     resultado  = "";
        Connection cn         = null;
        int        insertados = 0;
        int        omitidos   = 0;

        try {
            cn = Conexion.creaConexion();

            for (Jugador j : lista) {

                // Comprobamos que no existe ya ese id en la BBDD
                PreparedStatement psBusca = cn.prepareStatement(
                        "SELECT id FROM jugadores WHERE id = ?");
                psBusca.setInt(1, j.getId());
                ResultSet rs = psBusca.executeQuery();

                if (rs.next()) {
                    // Ya existe, lo omitimos
                    omitidos++;
                } else {
                    // No existe, lo insertamos — 5 columnas → 5 signos ?
                    PreparedStatement ps = cn.prepareStatement(
                        "INSERT INTO jugadores(id, nombre, posicion, dorsal, edad) "
                      + "VALUES (?,?,?,?,?)");
                    ps.setInt   (1, j.getId());
                    ps.setString(2, j.getNombre());
                    ps.setString(3, j.getPosicion());
                    ps.setInt   (4, j.getDorsal());
                    ps.setInt   (5, j.getEdad());
                    ps.executeUpdate();
                    ps.close();
                    insertados++;
                }
                rs.close();
                psBusca.close();
            }

            resultado = "Proceso completado. Insertados: " + insertados
                      + " | Ya existían: " + omitidos;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar desde fichero.";
        } finally {
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // LISTAR — muestra todos los jugadores de la BBDD
    // ─────────────────────────────────────────────
    public static void listarJugadores() {

        Connection cn = null;
        Statement  st = null;
        ResultSet  rs = null;

        try {
            cn = Conexion.creaConexion();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM jugadores");

            System.out.println("\n===== JUGADORES =====");
            while (rs.next()) {
                System.out.println("----------------------------------------");
                System.out.println("ID: "       + rs.getInt("id"));
                System.out.println("Nombre: "   + rs.getString("nombre"));
                System.out.println("Posición: " + rs.getString("posicion"));
                System.out.println("Dorsal: "   + rs.getInt("dorsal"));
                System.out.println("Edad: "     + rs.getInt("edad"));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
    }

    // ─────────────────────────────────────────────
    // ALTA — inserta un nuevo jugador pedido por teclado
    // Comprueba que no existe ya ese id (integridad)
    // ─────────────────────────────────────────────
    public static String altaJugador(Scanner sc, LinkedList<Jugador> lista) {

        String            resultado = "";
        Connection        cn        = null;
        PreparedStatement ps        = null;

        System.out.println("ID: ");
        int id = obtenNumeroEntero(sc.nextLine());
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Posición: ");
        String posicion = sc.nextLine();
        System.out.println("Dorsal: ");
        int dorsal = obtenNumeroEntero(sc.nextLine());
        System.out.println("Edad: ");
        int edad = obtenNumeroEntero(sc.nextLine());

        try {
            cn = Conexion.creaConexion();

            // Comprobamos que no existe ese id
            PreparedStatement psBusca = cn.prepareStatement(
                    "SELECT id FROM jugadores WHERE id = ?");
            psBusca.setInt(1, id);
            ResultSet rs = psBusca.executeQuery();

            if (rs.next()) {
                rs.close();
                psBusca.close();
                return "Ya existe un jugador con ID: " + id;
            }
            rs.close();
            psBusca.close();

            // 5 columnas → 5 signos ?
            ps = cn.prepareStatement(
                "INSERT INTO jugadores(id, nombre, posicion, dorsal, edad) "
              + "VALUES (?,?,?,?,?)");
            ps.setInt   (1, id);
            ps.setString(2, nombre);
            ps.setString(3, posicion);
            ps.setInt   (4, dorsal);
            ps.setInt   (5, edad);

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Jugador insertado correctamente: " + nombre;
                // Añadimos también al LinkedList en memoria
                lista.add(new Jugador(id, nombre, posicion, dorsal, edad));
            } else {
                resultado = "No se pudo insertar el jugador.";
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar jugador.";
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // BAJA — elimina un jugador por id
    // Lo elimina de la BBDD y del LinkedList en memoria
    // ─────────────────────────────────────────────
    public static String bajaJugador(Scanner sc, LinkedList<Jugador> lista) {

        String            resultado = "";
        Connection        cn        = null;
        PreparedStatement ps        = null;

        System.out.println("ID del jugador a eliminar: ");
        int id = obtenNumeroEntero(sc.nextLine());

        try {
            cn = Conexion.creaConexion();

            // Comprobamos que existe antes de borrar
            PreparedStatement psBusca = cn.prepareStatement(
                    "SELECT id FROM jugadores WHERE id = ?");
            psBusca.setInt(1, id);
            ResultSet rs = psBusca.executeQuery();

            if (!rs.next()) {
                rs.close();
                psBusca.close();
                return "No existe jugador con ID: " + id;
            }
            rs.close();
            psBusca.close();

            // DELETE
            ps = cn.prepareStatement(
                "DELETE FROM jugadores WHERE id = ?");
            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Jugador eliminado correctamente.";
                // Eliminamos también del LinkedList en memoria
                // removeIf evita ConcurrentModificationException
                lista.removeIf(j -> j.getId() == id);
            } else {
                resultado = "No se pudo eliminar el jugador.";
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al eliminar jugador.";
        } finally {
            try {
                if (ps != null) ps.close();
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
                    ok     = true;
                    numero = Integer.parseInt(new Scanner(System.in).nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                ok = false;
            }
        } while (!ok);
        return numero;
    }
}
