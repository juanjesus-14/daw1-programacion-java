/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mainequipofutbolud08;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author juand
 */
public class MainEquipoFutbolUD08 {

    public static void main(String[] args) {

        LinkedList<Jugador> lista = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // LEER FICHERO
        try {
            BufferedReader br = new BufferedReader(new FileReader("equiposFutbol.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                lista.add(new Jugador(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4])
                ));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error fichero");
        }

        // CONEXIÓN BD
        Connection con = ConexionBD.conectar();

        // MENU
        do {
            System.out.println("\n1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Listado");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    sc.nextLine();

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Posicion: ");
                    String posicion = sc.nextLine();

                    System.out.print("Dorsal: ");
                    int dorsal = sc.nextInt();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    try {
                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO jugadores VALUES (?, ?, ?, ?, ?)"
                        );

                        ps.setInt(1, id);
                        ps.setString(2, nombre);
                        ps.setString(3, posicion);
                        ps.setInt(4, dorsal);
                        ps.setInt(5, edad);

                        ps.executeUpdate();

                        System.out.println("Insertado");

                    } catch (SQLException e) {
                        System.out.println("Error");
                    }
                    break;

                case 2:
                    System.out.print("ID a borrar: ");
                    int idBorrar = sc.nextInt();

                    try {
                        PreparedStatement ps = con.prepareStatement(
                                "DELETE FROM jugadores WHERE id = ?"
                        );

                        ps.setInt(1, idBorrar);
                        ps.executeUpdate();

                        System.out.println("Borrado");

                    } catch (SQLException e) {
                        System.out.println("Error");
                    }
                    break;

                case 3:
                    try {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM jugadores");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " "
                                    + rs.getString("nombre") + " "
                                    + rs.getString("posicion")
                            );
                        }

                    } catch (SQLException e) {
                        System.out.println("Error");
                    }
                    break;
            }

        } while (opcion != 0);
    }
}
