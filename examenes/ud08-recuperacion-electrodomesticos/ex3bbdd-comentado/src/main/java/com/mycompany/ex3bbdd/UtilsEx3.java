package com.mycompany.ex3bbdd;

import java.time.LocalDate;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

/**
 * Clase UtilsEx3 — contiene toda la lógica de la aplicación.
 *
 * Métodos:
 *   - listar()                    → muestra el ArrayList por pantalla
 *   - cargaDatos()                → SELECT electrodomesticos + SELECT compras → llena ArrayList
 *   - insertarElectrodomestico()  → INSERT electrodomestico + INSERT compra opcional
 *   - insertarCompra()            → INSERT compra a electrodomestico ya existente
 *   - obtenNumeroEntero()         → lee entero con validación
 *
 * DIFERENCIAS respecto a los exámenes anteriores:
 * - Usamos LocalDate para las fechas (en lugar de String)
 * - LocalDate.parse() convierte String → LocalDate
 * - Date.valueOf() convierte LocalDate → java.sql.Date para PreparedStatement
 * - insertarCompra() actualiza el ArrayList en memoria (más completo que Examen 2)
 */
public class UtilsEx3 {

    // ═══════════════════════════════════════════════════════════
    // LISTAR
    // ═══════════════════════════════════════════════════════════
    public static void listar(ArrayList<Electrodomestico> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Electrodomestico> lista) {

        String resultado = "Reporte de la carga:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // SELECT principal — todos los electrodomésticos
            ResultSet rs = st.executeQuery("select * from electrodomesticos");

            while (rs.next()) {
                // Leemos cada columna por su nombre en la BBDD
                String codProducto     = rs.getString("codProducto");
                String fabricante      = rs.getString("fabricante");
                String modelo          = rs.getString("modelo");
                String tipo            = rs.getString("tipo");
                String caracteristicas = rs.getString("caracteristicas");
                String consumo         = rs.getString("consumo");
                // getBoolean() → convierte TINYINT(1) de MySQL a boolean Java
                boolean tieneGarantia  = rs.getBoolean("tieneGarantia");

                // Crear electrodoméstico sin compra (datosCompra = null por ahora)
                Electrodomestico eTemp = new Electrodomestico(
                        fabricante, modelo, codProducto,
                        tipo, caracteristicas, consumo, tieneGarantia);

                // ── PUNTO CLAVE: consulta dentro de otra consulta ────
                // Usamos PreparedStatement SEPARADO para no cerrar 'rs'
                // (misma razón que en el Examen 2 con la garantía)
                // DIFERENCIA con Examen 2: aquí buscamos compra SIEMPRE
                // (no solo si tieneGarantia=true) porque puede tener compra
                // independientemente de si tiene garantía o no
                PreparedStatement psCompra = cn.prepareStatement(
                        "select * from compras where codProducto = ?");
                psCompra.setString(1, codProducto);
                ResultSet rsCompra = psCompra.executeQuery();

                if (rsCompra.next()) {
                    // rs.getDate() devuelve java.sql.Date
                    // .toLocalDate() lo convierte a LocalDate de Java
                    LocalDate fechaCompra = rsCompra.getDate("fechaCompra").toLocalDate();
                    Double importe = rsCompra.getDouble("importe");

                    // Crear objeto Compra y asignarlo al electrodoméstico
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                    eTemp.setDatosCompra(compraTemp);
                }
                // Siempre cerrar los recursos secundarios
                rsCompra.close();
                psCompra.close();

                lista.add(eTemp);
                resultado += "Electrodomestico cargado: " + codProducto + "\n";
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // finally garantiza que la conexión siempre se cierra
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR ELECTRODOMÉSTICO (con compra opcional)
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarElectrodomestico(Scanner sc, ArrayList<Electrodomestico> lista) {

        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime el código del producto: ");
            String codProducto = sc.nextLine();

            // ── Comprobar si ya existe ───────────────────────────
            // Statement con SQL concatenado (forma simple)
            ResultSet rs = st.executeQuery(
                    "select codProducto from electrodomesticos where codProducto='" + codProducto + "'");
            if (rs.next()) {
                System.out.println("Ya existe un electrodoméstico con código: " + codProducto);
                return false;  // salimos sin insertar
            }
            rs.close();

            // ── Pedir resto de datos ─────────────────────────────
            System.out.println("Dime el fabricante: ");
            String fabricante = sc.nextLine();
            System.out.println("Dime el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Dime el tipo (lavadora, lavavajillas, nevera): ");
            String tipo = sc.nextLine();
            System.out.println("Dime las características: ");
            String caracteristicas = sc.nextLine();
            System.out.println("Dime el consumo: ");
            String consumo = sc.nextLine();

            // ── Validación S/N para garantía ─────────────────────
            int tieneGarantiaInt = -1;
            String op = "-1";
            do {
                System.out.println("¿Tiene garantía? (S/N): ");
                op = sc.nextLine().toUpperCase(); // toUpperCase acepta 's' y 'S'
                switch (op) {
                    case "S": tieneGarantiaInt = 1; break;
                    case "N": tieneGarantiaInt = 0; break;
                    default:
                        op = "-1"; // resetear para repetir el do-while
                        System.out.println("Opción incorrecta.");
                }
            } while (op.equals("-1")); // equals() para Strings, NUNCA ==

            // ── INSERT en electrodomesticos ──────────────────────
            // 7 columnas → 7 signos ? (índices del 1 al 7)
            ps = cn.prepareStatement(
                    "INSERT INTO electrodomesticos(codProducto, fabricante, modelo, tipo, caracteristicas, consumo, tieneGarantia) "
                    + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, codProducto);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, tipo);
            ps.setString(5, caracteristicas);
            ps.setString(6, consumo);
            ps.setInt(7, tieneGarantiaInt);  // setInt porque es 0 o 1
            ps.executeUpdate();

            System.out.println("Electrodoméstico insertado correctamente.");

            // Crear objeto en memoria
            boolean tieneGarantiaBool = (tieneGarantiaInt == 1); // convertir int a boolean
            Electrodomestico eTemp = new Electrodomestico(
                    fabricante, modelo, codProducto,
                    tipo, caracteristicas, consumo, tieneGarantiaBool);

            // ── Preguntar si quiere añadir compra ahora ──────────
            String opCompra = "-1";
            do {
                System.out.println("¿Desea añadir una compra? (S/N): ");
                opCompra = sc.nextLine().toUpperCase();
                switch (opCompra) {
                    case "S": break;
                    case "N": break;
                    default:
                        opCompra = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (opCompra.equals("-1"));

            if (opCompra.equals("S")) {
                System.out.println("Dime la fecha de compra (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();

                // ── Conversión String → LocalDate con validación ─
                // LocalDate.parse() lanza excepción si la fecha no es válida
                // por ejemplo "5555-55-55" (mes 55 no existe)
                LocalDate fechaCompra = null;
                try {
                    fechaCompra = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el importe: ");
                String importeStr = sc.nextLine();
                double importe = Double.parseDouble(importeStr);

                // ── INSERT en compras ─────────────────────────────
                PreparedStatement psCompra = cn.prepareStatement(
                        "INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
                psCompra.setString(1, codProducto);
                // Date.valueOf() convierte LocalDate → java.sql.Date para MySQL
                psCompra.setDate(2, Date.valueOf(fechaCompra));
                psCompra.setDouble(3, importe);
                psCompra.executeUpdate();
                psCompra.close();

                // Asignar la compra al objeto en memoria
                Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                eTemp.setDatosCompra(compraTemp);
            }

            // Añadir al ArrayList (con o sin compra)
            lista.add(eTemp);

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
    // INSERTAR COMPRA A ELECTRODOMÉSTICO YA EXISTENTE
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarCompra(Scanner sc, ArrayList<Electrodomestico> lista) {

        boolean correcto = true;
        Connection cn = null;
        // Declaramos fuera del try para cerrarlos en finally
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Código del electrodoméstico al que asociar la compra: ");
            String codProducto = sc.nextLine();

            // ── PASO 1: Comprobar que existe el electrodoméstico ─
            psBuscar = cn.prepareStatement(
                    "select codProducto from electrodomesticos where codProducto = ?");
            psBuscar.setString(1, codProducto);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Electrodoméstico encontrado.");

                System.out.println("Dime la fecha de compra (YYYY-MM-DD): ");
                String fechaStr = sc.nextLine();

                // Conversión String → LocalDate con validación
                LocalDate fechaCompra = null;
                try {
                    fechaCompra = LocalDate.parse(fechaStr);
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, usa formato YYYY-MM-DD");
                    return false;
                }

                System.out.println("Dime el importe: ");
                String importeStr = sc.nextLine();
                double importe = Double.parseDouble(importeStr);

                // ── PASO 2: INSERT en compras ─────────────────────
                psInsert = cn.prepareStatement(
                        "INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
                psInsert.setString(1, codProducto);
                psInsert.setDate(2, Date.valueOf(fechaCompra)); // LocalDate → java.sql.Date
                psInsert.setDouble(3, importe);
                int result = psInsert.executeUpdate();

                if (result > 0) {
                    System.out.println("Compra insertada correctamente.");

                    // ── PASO 3: Actualizar ArrayList en memoria ───
                    // Buscamos el electrodoméstico en la lista y le asignamos la compra
                    // DIFERENCIA con Examen 2: aquí sí actualizamos el ArrayList
                    // (en Examen 2 insertarGarantia no actualizaba la lista)
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getCodProducto().equals(codProducto)) {
                            lista.get(i).setDatosCompra(compraTemp);
                            break; // ya encontramos el que buscábamos, salimos
                        }
                    }
                } else {
                    System.out.println("No se pudo insertar la compra.");
                    correcto = false;
                }

            } else {
                // El electrodoméstico no existe
                System.out.println("No existe electrodoméstico con código: " + codProducto);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            // Cerrar todos los recursos en orden
            try {
                if (rs != null)       rs.close();
                if (psBuscar != null) psBuscar.close();
                if (psInsert != null) psInsert.close();
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
                    // Primer intento: convertir el String recibido por parámetro
                    numero = Integer.parseInt(num);
                } else {
                    // Intentos siguientes: pedir nuevo valor
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
