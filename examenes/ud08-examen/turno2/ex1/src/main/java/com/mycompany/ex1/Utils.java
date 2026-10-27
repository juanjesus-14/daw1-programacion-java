/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Utils {

    public static void listaOrdenador(ArrayList<Ordenador> listaOrdenador) {
        // Recorre el ArrayList de ordenadores
        for (int i = 0; i < listaOrdenador.size(); i++) {
            // Muestra cada ordenador por pantalla
            System.out.println(listaOrdenador.get(i).toString());
        }
    }

    // Método que carga los ordenadores desde la base de datos y los almacena en un ArrayList
    public static String cargaDatos(ArrayList<Ordenador> listaOrdenador) {

        // Variable donde se guardará el informe de la carga
        String resultado = "Reporte de la carga de ordenador:\n";

        // Objetos necesarios para trabajar con la BD
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        // Consulta SQL para obtener todos los equipos
        String sql = "select * from Equipos";

        try {

            // Crear conexión con la base de datos
            cn = Conexion.creaConexion();
            // Crear Statement para ejecutar consultas SQL
            st = cn.createStatement();
            // Ejecutar la consulta SELECT
            rs = st.executeQuery(sql);

            // Recorrer todos los registros obtenidos
            while (rs.next()) {
                // Obtener los datos de cada columna
                String numSerie = rs.getString("numSerie");
                String fabricante = rs.getString("fabricante");
                String modelo = rs.getString("modelo");
                String formato = rs.getString("formato");
                String procesador = rs.getString("ram");
                String ram = rs.getString("procesador");
                String hdd = rs.getString("hdd");

                // Indica si el ordenador tiene garantía
                Boolean tieneGarantia = rs.getBoolean("tieneGarantia");
                Garantia garantia;

                // Generar mensaje informativo
                if (tieneGarantia == false) {
                    resultado
                            += "Se ha añadido el ordenador con número de serie: "
                            + numSerie
                            + ". No dispone de garantía.\n";
                } else {
                    resultado
                            += "Se ha añadido el ordenador con número de serie: "
                            + numSerie
                            + " con garantía asociada.\n";
                }

                // Variable temporal para almacenar el ordenador
                Ordenador ordTemp = null;

                // Si no tiene garantía se crea directamente
                if (tieneGarantia == false) {
                    ordTemp
                            = new Ordenador(numSerie, fabricante, modelo, formato, procesador, ram, hdd);
                } else {
                    // Si tiene garantía se crea el ordenador
                    // y se le asocia la garantía correspondiente
                    ordTemp = creaOrdenador(
                            numSerie, fabricante, modelo, formato, procesador, ram, hdd, tieneGarantia, cn);
                }
                // Añadir el ordenador al ArrayList
                listaOrdenador.add(ordTemp);
            }
            // Cerrar ResultSet y Statement
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            // Captura errores SQL
            sqle.printStackTrace();
        } catch (Exception e) {
            // Captura errores generales
            e.printStackTrace();

        } finally {
            // Cerrar conexión si existe
            if (cn != null) {
                Conexion.cierraConexion();
            }
        }
        // Devuelve el informe de carga
        return resultado;
    }

    // Método que crea un objeto Ordenador y le asigna su garantía si existe
    public static Ordenador creaOrdenador(String numSerie, String fabricante, String modelo, String formato, String ram, String procesador, String hdd, Boolean tieneGarantia, Connection cn) {

        // Crear objeto Ordenador con los datos recibidos
        Ordenador ordTemp = new Ordenador(numSerie, fabricante, modelo, formato, procesador, ram, hdd);

        try {
            // Crear Statement para ejecutar consultas SQL
            Statement st = cn.createStatement();
            // Buscar la garantía asociada al número de serie
            ResultSet rs = st.executeQuery("select * from garantia where numSerie='" + numSerie + "'");

            // Si existe una garantía asociada
            if (rs.next()) {

                // Obtener los datos de la garantía
                String fechaFin = rs.getString("fechaFin");
                Double importeAnual = rs.getDouble("importeAnual");
                // Crear objeto Garantía
                Garantia garantiaTemp = new Garantia(numSerie, fechaFin, importeAnual);
                // Asociar la garantía al ordenador
                ordTemp.setGarantia(garantiaTemp);
            }
        } catch (SQLException sqle) {
            // Captura errores SQL
            sqle.printStackTrace();
        } catch (Exception e) {
            // Captura errores generales
            e.printStackTrace();
        }
        // Devuelve el ordenador completo
        return ordTemp;
    }

    // Método que inserta un nuevo ordenador en la base de datos
    public static String insertarOrdenador(Scanner sc) {

        // Variable para guardar el resultado de la operación
        String resultado = "";

        // Objetos para trabajar con la BD
        Connection cn = null;
        PreparedStatement ps = null;

        // Solicitar datos del ordenador por teclado
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

        System.out.println("Dime si tiene garantia del ordenador con 0 o 1: ");
        String tieneGarantia = sc.nextLine();

        try {
            // Crear conexión con la base de datos
            cn = Conexion.creaConexion();
            // Consulta SQL para insertar un nuevo ordenador
            String sql = "INSERT INTO equipos(numSerie, fabricante, modelo, formato, ram, procesador, hdd, tieneGarantia) VALUES (?,?,?,?,?,?,?,?)";
            // Preparar la sentencia SQL
            ps = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            ps.setString(1, numSerie);
            ps.setString(2, fabricante);
            ps.setString(3, modelo);
            ps.setString(4, formato);
            ps.setString(5, ram);
            ps.setString(6, procesador);
            ps.setString(7, hdd);
            ps.setString(8, tieneGarantia);

            // Ejecutar INSERT
            int result = ps.executeUpdate();

            // Comprobar si se ha insertado correctamente
            if (result > 0) {
                resultado = "Se ha insertado correctamente el ordenador con número de serie: " + numSerie;
            } else {
                resultado = "No se ha insertado correctamente el ordenador con número de serie: " + numSerie;
            }
        } catch (SQLException sqle) {
            // Captura errores SQL
            sqle.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador con número de serie: " + numSerie;
        } catch (Exception e) {
            // Captura errores generales
            e.printStackTrace();
            resultado = "No se ha insertado correctamente el ordenador con número de serie: " + numSerie;
        } finally {
            try {
                // Cerrar PreparedStatement
                if (ps != null) {
                    ps.close();
                }
                // Cerrar conexión
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Devuelve el resultado de la operación
        return resultado;
    }

// Método que inserta una garantía y la asocia a un ordenador
    public static String insertarGarantia(Scanner sc) {

        // Variable que almacena el resultado final
        String resultado = "";

        // Conexión con la base de datos
        Connection cn = null;

        // PreparedStatement para las distintas consultas
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;

        // ResultSet para almacenar los resultados del SELECT
        ResultSet rs = null;

        try {
            // Crear conexión con MySQL
            cn = Conexion.creaConexion();

            // Pedir el número de serie del ordenador
            System.out.println("Dime el número de serie del ordenador, al que le asocias una garantía: ");

            String numSerie = sc.nextLine();

            // Consulta para comprobar si existe el ordenador
            String sqlBuscar = "SELECT * FROM equipos WHERE numSerie = ?";

            // Preparar consulta
            psBuscar = cn.prepareStatement(sqlBuscar);

            // Asignar parámetro
            psBuscar.setString(1, numSerie);

            // Ejecutar SELECT
            rs = psBuscar.executeQuery();

            // Si el ordenador existe
            if (rs.next()) {

                System.out.println("Ordenador encontrado");

                // Pedir los datos de la garantía
                System.out.println("Dime de nuevo el número de serie: ");
                numSerie = sc.nextLine();

                System.out.println("Dime la fecha en la que acaba la garantía: ");
                String fechaFin = sc.nextLine();

                System.out.println("Dime el importe anual: ");
                String importeAnual = sc.nextLine();

                // Consulta INSERT para la garantía
                String sqlInsert = "INSERT INTO garantia(numSerie, fechaFin, importeAnual) VALUES (?,?,?)";

                // Preparar INSERT
                psInsert = cn.prepareStatement(sqlInsert);

                // Asignar parámetros
                psInsert.setString(1, numSerie);
                psInsert.setString(2, fechaFin);
                psInsert.setString(3, importeAnual);

                // Ejecutar INSERT
                int resultInsert = psInsert.executeUpdate();

                // Si la garantía se insertó correctamente
                if (resultInsert > 0) {

                    // Actualizar el ordenador indicando
                    // que ya tiene garantía
                    String sqlUpdate = "UPDATE equipos SET tieneGarantia = 1 WHERE numSerie = ?";

                    // Preparar UPDATE
                    psUpdate = cn.prepareStatement(sqlUpdate);

                    // Asignar parámetro
                    psUpdate.setString(1, numSerie);

                    // Ejecutar UPDATE
                    int resultUpdate = psUpdate.executeUpdate();

// Comprobar si se actualizó correctamente
                    if (resultUpdate > 0) {
                        resultado = "Garantía insertada y asociada correctamente";
                    } else {
                        resultado = "No se pudo asociar la garantía";
                    }
                } else {
                    resultado = "No se pudo insertar la garantía";
                }
            } else {
                // El ordenador no existe
                resultado = "No existe el ordenador con número de serie: " + numSerie;
            }
        } catch (SQLException sqle) {
            // Error SQL
            sqle.printStackTrace();
            resultado = "Error SQL";
        } catch (Exception e) {
            // Error general
            e.printStackTrace();
            resultado = "Error general";

        } finally {
            try {
                // Cerrar ResultSet
                if (rs != null) {
                    rs.close();
                }
                // Cerrar PreparedStatement de búsqueda
                if (psBuscar != null) {
                    psBuscar.close();
                }
                // Cerrar PreparedStatement de inserción
                if (psInsert != null) {
                    psInsert.close();
                }
                // Cerrar PreparedStatement de actualización
                if (psUpdate != null) {
                    psUpdate.close();
                }
                // Cerrar conexión
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Devuelve el resultado de la operación
        return resultado;
    }

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
