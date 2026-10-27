package com.juanjesus.exmanud08;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author $(user)
 */
public class Utils {

    // ─────────────────────────────────────────────
    // LISTAR electrodomésticos del ArrayList
    // ─────────────────────────────────────────────
    public static void listaElectrodomestico(ArrayList<Electrodomestico> lista) {
        for (Electrodomestico e : lista) {
            // IMPORTANTE: e (el objeto), NO lista (imprimiría el ArrayList entero)
            System.out.println(e);
        }
    }

    // ─────────────────────────────────────────────
    // CARGA DE DATOS desde la BBDD al ArrayList
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Electrodomestico> lista) {
        String resultado = "Productos cargados:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // Traemos todos los electrodomésticos
            ResultSet rs = st.executeQuery("SELECT * FROM electrodomesticos");

            while (rs.next()) {
                // Leemos cada campo de la fila
                String codProducto = rs.getString("codProducto");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                String tipo = rs.getString("tipo");
                String caracteristicas = rs.getString("caracteristicas");
                String consumo = rs.getString("consumo");
                boolean tieneGarantia = rs.getBoolean("tieneGarantia");

                // Creamos el electrodoméstico base (sin compra todavía)
                Electrodomestico elecTemp = new Electrodomestico(
                        fabricante, modelo, codProducto,
                        tipo, caracteristicas, consumo, tieneGarantia);

                // Buscamos si tiene compra asociada en la tabla compras
                PreparedStatement psCompra = cn.prepareStatement(
                        "SELECT * FROM compras WHERE codProducto = ?");
                psCompra.setString(1, codProducto);
                ResultSet rsCompra = psCompra.executeQuery();

                if (rsCompra.next()) {
                    // Si existe compra, creamos el objeto y lo asignamos
                    String fechaCompra = rsCompra.getString("fechaCompra");
                    Double importe = rsCompra.getDouble("importe");
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);
                    elecTemp.setDatosCompra(compraTemp);
                }
                rsCompra.close();
                psCompra.close();

                // Añadimos el electrodoméstico (con o sin compra) al ArrayList
                lista.add(elecTemp);

                // Acumulamos texto de resultado usando ternaria
                resultado += elecTemp.toString();
            }

            rs.close();
            st.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerramos la conexión siempre
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // INSERTAR nuevo electrodoméstico
    // Recibe también el ArrayList para añadirlo en memoria
    // ─────────────────────────────────────────────
    public static String insertarElectrodomestico(Scanner sc,
            ArrayList<Electrodomestico> lista) {
        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        // Pedimos datos al usuario
        System.out.println("Fabricante: ");
        String fabricante = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Código de producto: ");
        String codProducto = sc.nextLine();
        System.out.println("Tipo: ");
        String tipo = sc.nextLine();
        System.out.println("Características: ");
        String caracteristicas = sc.nextLine();
        System.out.println("Consumo: ");
        String consumo = sc.nextLine();

        // Pedimos garantía con validación S/N
        int tieneGarantiaInt = -1;
        String op = "-1";
        do {
            System.out.println("¿Tiene garantía? (S/N): ");
            op = sc.nextLine().toUpperCase();
            switch (op) {
                case "S":
                    tieneGarantiaInt = 1;
                    break;
                case "N":
                    tieneGarantiaInt = 0;
                    break;
                default:
                    // Volvemos op a "-1" para que el do-while repita
                    // IMPORTANTE: usar equals() para comparar Strings, no ==
                    op = "-1";
                    System.out.println("Opción incorrecta, escribe S o N.");
            }
        } while (op.equals("-1")); // ← equals(), nunca == con Strings

        try {
            cn = Conexion.creaConexion();

            // SQL con 7 parámetros (? ) — uno por cada columna del INSERT
            String sql = "INSERT INTO electrodomesticos "
                    + "(fabricante, modelo, codProducto, tipo, caracteristicas, consumo, tieneGarantia) "
                    + "VALUES (?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);

            // Los índices empiezan en 1 y deben coincidir con el orden del SQL
            ps.setString(1, fabricante);
            ps.setString(2, modelo);
            ps.setString(3, codProducto);
            ps.setString(4, tipo);
            ps.setString(5, caracteristicas);
            ps.setString(6, consumo);
            ps.setInt(7, tieneGarantiaInt); // tieneGarantia es INT en la BBDD

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Electrodoméstico insertado correctamente: " + codProducto;

                // Creamos el objeto en memoria con tieneGarantia como boolean
                boolean tieneGarantiaBool = (tieneGarantiaInt == 1);
                Electrodomestico eTemp = new Electrodomestico(
                        fabricante, modelo, codProducto,
                        tipo, caracteristicas, consumo, tieneGarantiaBool);

                // Preguntamos si también tiene fecha de compra
                int tieneFechaCompra = -1;
                op = "-1";
                do {
                    System.out.println("¿Tiene fecha de compra? (S/N): ");
                    op = sc.nextLine().toUpperCase();
                    switch (op) {
                        case "S":
                            tieneFechaCompra = 1;
                            break;
                        case "N":
                            tieneFechaCompra = 0;
                            break;
                        default:
                            op = "-1";
                            System.out.println("Opción incorrecta.");
                    }
                } while (op.equals("-1"));

                if (tieneFechaCompra == 1) {
                    // Insertamos la compra en la BBDD y obtenemos el objeto
                    Compra compraTemp = insertarCompraParaElectrodomestico(sc, codProducto, cn);
                    if (compraTemp != null) {
                        eTemp.setDatosCompra(compraTemp); // asignamos la compra al objeto
                    }
                }

                // Añadimos al ArrayList en memoria
                lista.add(eTemp);

            } else {
                resultado = "No se pudo insertar el electrodoméstico: " + codProducto;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar: " + codProducto;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error general al insertar: " + codProducto;
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
    // INSERTAR compra para un electrodoméstico ya existente
    // Recibe el ArrayList para actualizar el objeto en memoria
    // ─────────────────────────────────────────────
    public static String insertarCompras(Scanner sc,
            ArrayList<Electrodomestico> lista) {
        String resultado = "";
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Código del electrodoméstico al que asociar la compra: ");
            String codProducto = sc.nextLine();

            // Comprobamos que existe en la BBDD
            psBuscar = cn.prepareStatement(
                    "SELECT * FROM electrodomesticos WHERE codProducto = ?");
            psBuscar.setString(1, codProducto);
            ResultSet rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Electrodoméstico encontrado.");

                // Pedimos los datos de la compra
                System.out.println("Fecha de compra (YYYY-MM-DD): ");
                String fechaCompra = sc.nextLine();
                System.out.println("Importe: ");
                Double importe = obtenNumeroDouble(sc.nextLine());

                // Insertamos la compra en la BBDD
                psInsert = cn.prepareStatement(
                        "INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
                psInsert.setString(1, codProducto);
                psInsert.setString(2, fechaCompra);
                psInsert.setDouble(3, importe);   // importe es DOUBLE en la BBDD

                int resultInsert = psInsert.executeUpdate();

                if (resultInsert > 0) {
                    resultado = "Compra insertada correctamente para: " + codProducto;

                    // Creamos el objeto Compra
                    Compra compraTemp = new Compra(codProducto, fechaCompra, importe);

                    // Buscamos el electrodoméstico en el ArrayList y le asignamos la compra
                    for (Electrodomestico e : lista) {
                        if (e.getCodProducto().equals(codProducto)) {
                            e.setDatosCompra(compraTemp);
                            break; // ya lo encontramos, salimos del bucle
                        }
                    }
                } else {
                    resultado = "No se pudo insertar la compra.";
                }

            } else {
                resultado = "No existe electrodoméstico con código: " + codProducto;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL en insertarCompras.";
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error general en insertarCompras.";
        } finally {
            try {
                if (psBuscar != null) {
                    psBuscar.close();
                }
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
    // Método auxiliar — inserta compra usando una conexión ya abierta
    // Se usa desde insertarElectrodomestico para no abrir otra conexión
    // Devuelve el objeto Compra si todo va bien, null si falla
    // ─────────────────────────────────────────────
    private static Compra insertarCompraParaElectrodomestico(Scanner sc,
            String codProducto,
            Connection cn) {
        Compra compraTemp = null;
        PreparedStatement ps = null;
        try {
            System.out.println("Fecha de compra (YYYY-MM-DD): ");
            String fechaCompra = sc.nextLine();
            System.out.println("Importe: ");
            Double importe = obtenNumeroDouble(sc.nextLine());

            ps = cn.prepareStatement(
                    "INSERT INTO compras(codProducto, fechaCompra, importe) VALUES (?,?,?)");
            ps.setString(1, codProducto);
            ps.setString(2, fechaCompra);
            ps.setDouble(3, importe);

            int result = ps.executeUpdate();
            if (result > 0) {
                compraTemp = new Compra(codProducto, fechaCompra, importe);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return compraTemp; // null si falló, objeto Compra si fue bien
    }

    // ─────────────────────────────────────────────
    // UTILIDADES — lectura segura de números
    // ─────────────────────────────────────────────
    // Lee un double validado desde consola
    public static double obtenNumeroDouble(String opcion) {
        double numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Double.parseDouble(opcion);
                } else {
                    correcto = true;
                    numero = Double.parseDouble(sc_readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

    // Lee un entero validado desde consola
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(opcion);
                } else {
                    correcto = true;
                    numero = Integer.parseInt(sc_readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

    // Auxiliar para leer línea desde consola (evita depender de System.console())
    private static String sc_readLine() {
        return new Scanner(System.in).nextLine();
    }
}
