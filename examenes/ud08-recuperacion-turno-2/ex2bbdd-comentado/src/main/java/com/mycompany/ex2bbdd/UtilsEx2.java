package com.mycompany.ex2bbdd;

import java.sql.*;
import java.util.*;

/**
 * Clase UtilsEx2 — contiene toda la lógica de la aplicación.
 *
 * Métodos:
 *   - listaOrdenador()      → muestra el ArrayList por pantalla
 *   - cargaDatos()          → SELECT equipos + SELECT garantia → llena el ArrayList
 *   - insertarOrdenador()   → pide datos con 0/1, INSERT en equipos
 *   - insertarOrdenador2()  → pide datos con S/N, INSERT en equipos
 *   - insertarGarantia()    → busca ordenador, INSERT en garantia + UPDATE en equipos
 *   - obtenNumeroEntero()   → lee entero con validación
 */
public class UtilsEx2 {

    // ═══════════════════════════════════════════════════════════
    // LISTAR — muestra todos los ordenadores del ArrayList
    // ═══════════════════════════════════════════════════════════
    public static void listaOrdenador(ArrayList<Ordenador> listaOrdenador) {
        for (int i = 0; i < listaOrdenador.size(); i++) {
            // toString() de Ordenador se llama automáticamente
            System.out.println(listaOrdenador.get(i).toString());
        }
    }

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Ordenador> listaOrdenador) {
        String resultado = "Reporte de la carga de ordenador:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();

            // Statement para el SELECT principal
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from equipos");

            while (rs.next()) {
                // Leemos cada columna por su nombre en la BBDD
                String numSerie       = rs.getString("numSerie");
                String fabricante     = rs.getString("fabricante");
                String modelo         = rs.getString("modelo");
                String formato        = rs.getString("formato");
                String ram            = rs.getString("ram");
                String procesador     = rs.getString("procesador");
                String hdd            = rs.getString("hdd");
                // getBoolean() → convierte TINYINT(1) de MySQL a boolean Java
                boolean tieneGarantia = rs.getBoolean("tieneGarantia");

                // Crear el ordenador con los datos leídos (garantia queda null)
                Ordenador ordTemp = new Ordenador(
                        numSerie, fabricante, modelo,
                        formato, ram, procesador, hdd, tieneGarantia);

                // ── PUNTO CLAVE: consulta dentro de otra consulta ────
                // NO podemos usar 'st' aquí porque 'rs' sigue abierto
                // Usar st.executeQuery() dentro del while cerraría rs → error
                // Solución: usar un PreparedStatement SEPARADO con su propio objeto
                if (tieneGarantia) {
                    PreparedStatement psGar = cn.prepareStatement(
                            "select * from garantia where numSerie = ?");
                    psGar.setString(1, numSerie);
                    ResultSet rsGar = psGar.executeQuery();

                    if (rsGar.next()) {
                        String fechaFin      = rsGar.getString("fechaFin");
                        Double importeAnual  = rsGar.getDouble("importeAnual");
                        // Crear objeto Garantia y asignarlo al ordenador
                        ordTemp.setGarantia(new Garantia(numSerie, fechaFin, importeAnual));
                    }
                    // Cerrar siempre el ResultSet y PreparedStatement secundarios
                    rsGar.close();
                    psGar.close();
                }

                listaOrdenador.add(ordTemp);
                resultado += "Se ha añadido el ordenador: " + numSerie
                        + (tieneGarantia ? " con garantía asociada." : ". No dispone de garantía.")
                        + "\n";
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally garantiza que la conexión siempre se cierra
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR ORDENADOR — versión con 0 o 1 para garantía
    // ═══════════════════════════════════════════════════════════
    public static String insertarOrdenador(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        // Pedimos todos los datos ANTES de abrir la conexión
        System.out.println("Dime el número de serie del ordenador: ");
        String numSerie = sc.nextLine();
        System.out.println("Dime el fabricante del ordenador: ");
        String fabricante = sc.nextLine();
        System.out.println("Dime el modelo del ordenador: ");
        String modelo = sc.nextLine();
        System.out.println("Dime el formato del ordenador: ");
        String formato = sc.nextLine();
        System.out.println("Dime la RAM del ordenador: ");
        String ram = sc.nextLine();
        System.out.println("Dime el procesador del ordenador: ");
        String procesador = sc.nextLine();
        System.out.println("Dime el hdd del ordenador: ");
        String hdd = sc.nextLine();
        // El usuario escribe "1" o "0" directamente como String
        System.out.println("Dime si tiene garantia con 0 o 1: ");
        String tieneGarantia = sc.nextLine();

        try {
            cn = Conexion.creaConexion();

            // 8 columnas → 8 signos ?  (índices del 1 al 8)
            String sql = "INSERT INTO equipos(numSerie, fabricante, modelo, formato, ram, procesador, hdd, tieneGarantia) VALUES (?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, numSerie);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, formato);
            ps.setString(5, ram);
            ps.setString(6, procesador);
            ps.setString(7, hdd);
            ps.setString(8, tieneGarantia); // String "0" o "1" → MySQL lo convierte a TINYINT

            // executeUpdate() → para INSERT/UPDATE/DELETE, devuelve filas afectadas
            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Se ha insertado correctamente el ordenador: " + numSerie;
            } else {
                resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR ORDENADOR — versión con S/N para garantía
    // Usa do-while para validar la entrada
    // ═══════════════════════════════════════════════════════════
    public static String insertarOrdenador2(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        System.out.println("Dime el número de serie del ordenador: ");
        String numSerie = sc.nextLine();
        System.out.println("Dime el fabricante del ordenador: ");
        String fabricante = sc.nextLine();
        System.out.println("Dime el modelo del ordenador: ");
        String modelo = sc.nextLine();
        System.out.println("Dime el formato del ordenador: ");
        String formato = sc.nextLine();
        System.out.println("Dime la RAM del ordenador: ");
        String ram = sc.nextLine();
        System.out.println("Dime el procesador del ordenador: ");
        String procesador = sc.nextLine();
        System.out.println("Dime el hdd del ordenador: ");
        String hdd = sc.nextLine();

        // ── Patrón do-while para validar S/N ────────────────────
        // tieneGarantiaInt guardará 1 (sí) o 0 (no)
        // op empieza en "-1" para que el do-while entre siempre la primera vez
        int tieneGarantiaInt = -1;
        String op = "-1";
        do {
            System.out.println("¿Tiene garantia? (S/N): ");
            op = sc.nextLine().toUpperCase(); // toUpperCase → acepta 's' y 'S'
            switch (op) {
                case "S":
                    tieneGarantiaInt = 1;
                    break;
                case "N":
                    tieneGarantiaInt = 0;
                    break;
                default:
                    // Reseteamos op a "-1" para que el do-while repita
                    op = "-1";
                    System.out.println("Opción incorrecta, escribe S o N.");
            }
        } while (op.equals("-1")); // equals() para Strings, NUNCA ==

        try {
            cn = Conexion.creaConexion();

            String sql = "INSERT INTO equipos(numSerie, fabricante, modelo, formato, ram, procesador, hdd, tieneGarantia) VALUES (?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, numSerie);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, formato);
            ps.setString(5, ram);
            ps.setString(6, procesador);
            ps.setString(7, hdd);
            ps.setInt(8, tieneGarantiaInt); // setInt porque es un int (1 o 0), no String

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Se ha insertado correctamente el ordenador: " + numSerie;
            } else {
                resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador: " + numSerie;
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR GARANTÍA — INSERT en garantia + UPDATE en equipos
    // ═══════════════════════════════════════════════════════════
    public static String insertarGarantia(Scanner sc) {

        String resultado = "";
        Connection cn = null;
        // Declaramos todos los PreparedStatements fuera del try
        // para poder cerrarlos en el finally
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Dime el número de serie del ordenador al que asocias la garantía: ");
            String numSerie = sc.nextLine();

            // ── PASO 1: Comprobar que existe el ordenador ────────────
            psBuscar = cn.prepareStatement("SELECT * FROM equipos WHERE numSerie = ?");
            psBuscar.setString(1, numSerie);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                // El ordenador existe → pedimos datos de la garantía
                System.out.println("Ordenador encontrado.");

                System.out.println("Dime la fecha en la que acaba la garantía: ");
                String fechaFin = sc.nextLine(); // formato esperado: YYYY-MM-DD

                System.out.println("Dime el importe anual: ");
                String importeAnual = sc.nextLine();

                // ── PASO 2: INSERT en la tabla garantia ──────────────
                psInsert = cn.prepareStatement(
                        "INSERT INTO garantia(numSerie, fechaFin, importeAnual) VALUES (?,?,?)");
                psInsert.setString(1, numSerie);
                psInsert.setString(2, fechaFin);
                psInsert.setString(3, importeAnual); // MySQL convierte el String a DECIMAL

                int resultInsert = psInsert.executeUpdate();

                if (resultInsert > 0) {
                    // ── PASO 3: UPDATE en equipos ────────────────────
                    // Marcamos tieneGarantia = 1 para que la próxima carga
                    // sepa que tiene que buscar su garantía en la tabla garantia
                    psUpdate = cn.prepareStatement(
                            "UPDATE equipos SET tieneGarantia = 1 WHERE numSerie = ?");
                    psUpdate.setString(1, numSerie);
                    int resultUpdate = psUpdate.executeUpdate();

                    if (resultUpdate > 0) {
                        resultado = "Garantía insertada y asociada correctamente";
                    } else {
                        resultado = "No se pudo asociar la garantía";
                    }
                } else {
                    resultado = "No se pudo insertar la garantía";
                }

            } else {
                // El ordenador no existe en la BBDD
                resultado = "No existe el ordenador con número de serie: " + numSerie;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL";
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error general";
        } finally {
            // Cerramos TODOS los recursos en orden inverso al que se abrieron
            // ResultSet → PreparedStatements → Connection
            try {
                if (rs != null)       rs.close();
                if (psBuscar != null) psBuscar.close();
                if (psInsert != null) psInsert.close();
                if (psUpdate != null) psUpdate.close();
                if (cn != null)       cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
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
                    // Intentos siguientes: pedir nuevo valor por consola
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                // El String no era un número válido
                System.out.println("Formato de numero incorrecto");
                correcto = false; // fuerza otra vuelta del do-while
            }
        } while (!correcto);
        return numero;
    }
}
