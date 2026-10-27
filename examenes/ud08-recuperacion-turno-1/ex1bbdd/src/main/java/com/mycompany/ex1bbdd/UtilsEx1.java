/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ex1bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilsEx1 {

    // ─────────────────────────────────────────────
    // CARGA DE DATOS
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Empleado> listaEmpleados) {

        String resultado = "Reporte de la carga realizada\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            // 1) Cargar empleados
            ResultSet rs = st.executeQuery("select * from empleados");
            while (rs.next()) {
                int id = rs.getInt("numeroEmpleado");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String dniPareja = rs.getString("dniPareja");

                Empleado emp = new Empleado(id, dni, nombre, apellidos, email);
                if (dniPareja != null) {
                    emp.setDniPareja(dniPareja);
                }
                listaEmpleados.add(emp);
                resultado += "Empleado cargado: " + dni + "\n";
            }
            rs.close();

            // 2) Cargar parejas y asociarlas
            rs = st.executeQuery("select * from parejas");
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                for (int i = 0; i < listaEmpleados.size(); i++) {
                    if (dni.equalsIgnoreCase(listaEmpleados.get(i).getPareja().getDni())) {
                        listaEmpleados.get(i).asignaPareja(nombre, apellidos);
                        resultado += "Pareja asociada: " + dni + "\n";
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

    // ─────────────────────────────────────────────
    // LISTAR
    // ─────────────────────────────────────────────
    public static void listar(ArrayList<Empleado> listaEmpleados) {
        System.out.println("\n========== EMPLEADOS ==========\n");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("--------------------------------");
            System.out.println(listaEmpleados.get(i));
            System.out.println("--------------------------------\n");
        }
    }

    // ─────────────────────────────────────────────
    // INSERTAR EMPLEADO
    // ─────────────────────────────────────────────
    //Con Si o No la garantia
    public static boolean insertaEmp(ArrayList<Empleado> listaEmpleados) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.creaConexion();

            // Obtener el siguiente numeroEmpleado
            String sql = "select max(numeroEmpleado) as numeroEmpleado from empleados";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int numeroEmpleado = 1;
            while (rs.next()) {
                numeroEmpleado = rs.getInt("numeroEmpleado") + 1;
                System.out.println("Numero de empleado asignado: " + numeroEmpleado);
            }

            // Pedir DNI
            System.out.println("Dime el dni del empleado: ");
            String dni = sc.nextLine();

            // Comprobar si ya existe
            sql = "select dni from empleados where dni='" + dni + "'";
            ResultSet rs2 = st.executeQuery(sql);

            if (rs2.next()) {
                System.out.println("Ya existe un empleado con dni " + dni);
            } else {
                // Pedir datos
                System.out.println("Dime el nombre del empleado: ");
                String nombre = sc.nextLine();
                System.out.println("Dime los apellidos del empleado: ");
                String apellidos = sc.nextLine();
                System.out.println("Dime el correo del empleado: ");
                String email = sc.nextLine();

                // INSERT
                sql = "Insert into empleados(numeroEmpleado, dni, nombre, apellidos, email) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, numeroEmpleado);
                ps.setString(2, dni);
                ps.setString(3, nombre);
                ps.setString(4, apellidos);
                ps.setString(5, email);
                ps.executeUpdate();

                System.out.println("Empleado añadido correctamente.");

                Empleado eTemp = new Empleado(numeroEmpleado, dni, nombre, apellidos, email);

                // Preguntar si quiere pareja
                System.out.println("Desea asociarle una pareja?(s/n)");
                String opcion = System.console().readLine().toLowerCase();

                if (opcion.equals("s")) {
                    System.out.println("Dime el dni de la pareja: ");
                    String dniPareja = sc.nextLine();

                    // Comprobar si la pareja ya existe
                    sql = "select dni from parejas where dni='" + dniPareja + "'";
                    rs = st.executeQuery(sql);

                    if (rs.next()) {
                        System.out.println("Ya existe una pareja con dni " + dniPareja);
                    } else {
                        System.out.println("Dime el nombre de la pareja: ");
                        String nombreP = sc.nextLine();
                        System.out.println("Dime los apellidos de la pareja: ");
                        String apellidosP = sc.nextLine();

                        // INSERT pareja
                        sql = "Insert into parejas(dni, nombre, apellidos) values(?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, dniPareja);
                        ps.setString(2, nombreP);
                        ps.setString(3, apellidosP);
                        ps.executeUpdate();

                        // UPDATE empleado con dniPareja
                        sql = "update empleados set dniPareja='" + dniPareja + "' where dni='" + dni + "'";
                        ps = con.prepareStatement(sql);
                        ps.executeUpdate();

                        // Asignar en memoria
                        eTemp.setDniPareja(dniPareja);
                        eTemp.asignaPareja(nombreP, apellidosP);
                    }
                }
                // Añadir al ArrayList
                listaEmpleados.add(eTemp);
            }
            con.close();

        } catch (SQLException sqle) {
            correcto = false;
        }
        //sc.close();
        return correcto;
    }

    //Con 0 o 1 la garantia
    public static boolean insertaEmp2(ArrayList<Empleado> listaEmpleados) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.creaConexion();

            // Obtener el siguiente numeroEmpleado
            String sql = "select max(numeroEmpleado) as numeroEmpleado from empleados";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int numeroEmpleado = 1;
            while (rs.next()) {
                numeroEmpleado = rs.getInt("numeroEmpleado") + 1;
                System.out.println("Numero de empleado asignado: " + numeroEmpleado);
            }

            // Pedir DNI
            System.out.println("Dime el dni del empleado: ");
            String dni = sc.nextLine();

            // Comprobar si ya existe
            sql = "select dni from empleados where dni='" + dni + "'";
            ResultSet rs2 = st.executeQuery(sql);

            if (rs2.next()) {
                System.out.println("Ya existe un empleado con dni " + dni);
            } else {
                System.out.println("Dime el nombre del empleado: ");
                String nombre = sc.nextLine();
                System.out.println("Dime los apellidos del empleado: ");
                String apellidos = sc.nextLine();
                System.out.println("Dime el correo del empleado: ");
                String email = sc.nextLine();

                // INSERT empleado
                sql = "Insert into empleados(numeroEmpleado, dni, nombre, apellidos, email) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, numeroEmpleado);
                ps.setString(2, dni);
                ps.setString(3, nombre);
                ps.setString(4, apellidos);
                ps.setString(5, email);
                ps.executeUpdate();

                System.out.println("Empleado añadido correctamente.");

                Empleado eTemp = new Empleado(numeroEmpleado, dni, nombre, apellidos, email);

                // Preguntar si quiere pareja con 0 y 1
                int tienePareja = -1;
                String op = "-1";
                do {
                    System.out.println("Desea asociarle una pareja? (1=Si / 0=No): ");
                    op = sc.nextLine();
                    switch (op) {
                        case "1":
                            tienePareja = 1;
                            break;
                        case "0":
                            tienePareja = 0;
                            break;
                        default:
                            op = "-1";
                            System.out.println("Opción incorrecta, escribe 1 o 0.");
                    }
                } while (op.equals("-1"));

                if (tienePareja == 1) {
                    System.out.println("Dime el dni de la pareja: ");
                    String dniPareja = sc.nextLine();

                    // Comprobar si la pareja ya existe
                    sql = "select dni from parejas where dni='" + dniPareja + "'";
                    rs = st.executeQuery(sql);

                    if (rs.next()) {
                        System.out.println("Ya existe una pareja con dni " + dniPareja);
                    } else {
                        System.out.println("Dime el nombre de la pareja: ");
                        String nombreP = sc.nextLine();
                        System.out.println("Dime los apellidos de la pareja: ");
                        String apellidosP = sc.nextLine();

                        // INSERT pareja
                        sql = "Insert into parejas(dni, nombre, apellidos) values(?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, dniPareja);
                        ps.setString(2, nombreP);
                        ps.setString(3, apellidosP);
                        ps.executeUpdate();

                        // UPDATE empleado con dniPareja
                        sql = "update empleados set dniPareja='" + dniPareja + "' where dni='" + dni + "'";
                        ps = con.prepareStatement(sql);
                        ps.executeUpdate();

                        // Asignar en memoria
                        eTemp.setDniPareja(dniPareja);
                        eTemp.asignaPareja(nombreP, apellidosP);
                    }
                }
                // Añadir al ArrayList
                listaEmpleados.add(eTemp);
            }
            con.close();

        } catch (SQLException sqle) {
            correcto = false;
        }
        return correcto;
    }

    // ─────────────────────────────────────────────
    // INSERTAR PAREJA A EMPLEADO EXISTENTE
    // ─────────────────────────────────────────────
    public static boolean insertaPar(ArrayList<Empleado> listaEmpleados) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.creaConexion();
            Statement st = con.createStatement();

            // Pedir DNI del empleado
            System.out.println("A qué empleado le quieres asociar una pareja?");
            String dniEmp = System.console().readLine();

            // Comprobar que existe
            String sql = "select dni from empleados where dni='" + dniEmp + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Dime el dni de la pareja: ");
                String dni = sc.nextLine();

                // Comprobar que no existe ya
                sql = "select dni from parejas where dni='" + dni + "'";
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    System.out.println("Ya existe una pareja con dni " + dni);
                } else {
                    System.out.println("Dime el nombre de la pareja: ");
                    String nombre = sc.nextLine();
                    System.out.println("Dime los apellidos de la pareja: ");
                    String apellidos = sc.nextLine();

                    // INSERT pareja
                    sql = "Insert into parejas(dni, nombre, apellidos) values(?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, dni);
                    ps.setString(2, nombre);
                    ps.setString(3, apellidos);
                    ps.executeUpdate();

                    // UPDATE empleado
                    sql = "update empleados set dniPareja='" + dni + "' where dni='" + dniEmp + "'";
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();

                    // Actualizar ArrayList en memoria
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        if (listaEmpleados.get(i).getDni().equalsIgnoreCase(dniEmp)) {
                            listaEmpleados.get(i).setDniPareja(dni);
                            listaEmpleados.get(i).asignaPareja(nombre, apellidos);
                        }
                    }
                }
            } else {
                System.out.println("El empleado con dni " + dniEmp + " no consta en la base de datos");
            }
            con.close();

        } catch (SQLException sqle) {
            correcto = false;
        }
        //sc.close();
        return correcto;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES
    // ─────────────────────────────────────────────
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
