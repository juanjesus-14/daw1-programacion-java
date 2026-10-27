package com.juanjesus.examenbbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author $(user)
 */
public class Utils {

    // ─────────────────────────────────────────────
    // LISTAR
    // ─────────────────────────────────────────────
    public static void listarCoches(ArrayList<Coche> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("--------------------------------");
            System.out.println(lista.get(i));
            System.out.println("--------------------------------\n");
        }
    }

    // ─────────────────────────────────────────────
    // CARGA DE DATOS
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Coche> lista) {

        String resultado = "Reporte de la carga realizada\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // 1) Cargar empleados
            ResultSet rs = st.executeQuery("select * from coche");
            while (rs.next()) {
                String bastidor = rs.getString("bastidor");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                String numSerieMotor = rs.getString("numSerieMotor");

                Coche cTemp = new Coche(bastidor, marca, modelo, color, numSerieMotor);

                if (numSerieMotor != null) {
                    cTemp.setnumSerieMotor(numSerieMotor);
                }
                lista.add(cTemp);
                resultado += "Coche cargado: " + bastidor + "\n";
            }
            rs.close();

            // 2) Cargar parejas y asociarlas
            rs = st.executeQuery("select * from motor");
            while (rs.next()) {
                String numSerie = rs.getString("numSerie");
                String potencia = rs.getString("potencia");
                String cilindrada = rs.getString("cilindrada");

                for (int i = 0; i < lista.size(); i++) {
                    if (numSerie.equalsIgnoreCase(lista.get(i).getNumSerieMotor())) {
                        lista.get(i).asignaMotor(numSerie, potencia, cilindrada);
                        resultado += "Motor asociado: " + numSerie + "\n";
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

    // ─── INSERTAR PRINCIPAL ───────────────────────
    public static boolean insertarCoche(Scanner sc, ArrayList<Coche> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            System.out.println("Dime el bastidor del coche: ");
            String bastidor = sc.nextLine();

            ResultSet rs = st.executeQuery("select bastidor from coche where bastidor='" + bastidor + "'");
            if (rs.next()) {
                System.out.println("Ya existe un coche con bastidor: " + bastidor);
                return false;  // salimos sin insertar
            }
            rs.close();

            // ── Pedir resto de datos ─────────────────────────────
            System.out.println("Dime la marca: ");
            String marca = sc.nextLine();
            System.out.println("Dime el modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Dime el color: ");
            String color = sc.nextLine();
            System.out.println("Dime el numSerieMotor: ");
            String numSerieMotor = null;

            ps = cn.prepareStatement("INSERT INTO coche( bastidor, marca, modelo, color, numSerieMotor) " + "VALUES (?,?,?,?,?)");
            ps.setString(1, bastidor);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, color);
            ps.setString(5, numSerieMotor);
            ps.executeUpdate();

            System.out.println("Coche insertado correctamente.");

            Coche cTemp = new Coche(bastidor, marca, modelo, color, numSerieMotor);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
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
        return correcto;
    }

//  ─── INSERTAR SECUNDARIO ──────────────────────
    public static boolean insertarMotor(Scanner sc, ArrayList<Coche> lista) {
        boolean correcto = true;
        Connection cn = null;
        PreparedStatement psBuscar = null;
        PreparedStatement psInsert = null;
        ResultSet rs = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Bastidor del coche al que asociar el motor: ");
            String bastidor = sc.nextLine();

            // Comprobar que existe
            psBuscar = cn.prepareStatement("select bastidor from coche where bastidor = ?");
            psBuscar.setString(1, bastidor);
            rs = psBuscar.executeQuery();

            if (rs.next()) {
                System.out.println("Coche encontrado.");

                System.out.println("Dime el numero de serie: ");
                String numSerie = sc.nextLine();

                System.out.println("Dime la potencia: ");
                String potencia = sc.nextLine();

                System.out.println("Dime la cilindrada: ");
                String cilindrada = sc.nextLine();

                // INSERT en compras
                psInsert = cn.prepareStatement("INSERT INTO motor(numSerie, potencia, cilindrada) VALUES (?,?,?)");
                psInsert.setString(1, numSerie);
                psInsert.setString(2, potencia);
                psInsert.setString(3, cilindrada);
                int result = psInsert.executeUpdate();

                if (result > 0) {
                    System.out.println("Motor insertada correctamente.");

                    // Actualizar ArrayList en memoria
                    Motor motorTemp = new Motor(numSerie, potencia, cilindrada);
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getBastidor().equals(bastidor)) {
                            lista.get(i).setMotor(motorTemp);
                            break;
                        }
                    }
                } else {
                    System.out.println("No se pudo insertar el motor.");
                    correcto = false;
                }
            } else {
                System.out.println("No existe el coche con bastidor: " + bastidor);
                correcto = false;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return correcto;
    }

    // ─── UTILIDADES ───────────────────────────────
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(opcion);
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
