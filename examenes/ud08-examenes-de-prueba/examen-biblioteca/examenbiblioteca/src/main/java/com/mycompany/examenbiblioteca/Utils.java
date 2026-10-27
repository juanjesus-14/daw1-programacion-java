/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenbiblioteca;

import java.sql.*;
import java.util.ArrayList;

import java.io.*;

public class Utils {

    // ─────────────────────────────────────────────
    // LISTAR libros del ArrayList
    // ─────────────────────────────────────────────
    public static void listaLibros(ArrayList<Libro> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    // ─────────────────────────────────────────────
    // CARGA DE DATOS
    // ─────────────────────────────────────────────
    public static String cargaDatos(ArrayList<Libro> lista) {
        String resultado = "Reporte de carga:\n";
        Connection cn = null;

        try {
            cn = Conexion.creaConexion();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM libros");
            while (rs.next()) {
                String codArticulo = rs.getString("codArticulo");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                String numPaginas = rs.getString("numPaginas");
                String idioma = rs.getString("idioma");
                boolean estaPrestado = rs.getBoolean("estaPrestado");

                Libro libTemp = new Libro(codArticulo, titulo, autor,
                        genero, numPaginas, idioma, estaPrestado);

                if (estaPrestado) {
                    PreparedStatement psP = cn.prepareStatement(
                            "SELECT * FROM prestamos WHERE codArticulo = ?");
                    psP.setString(1, codArticulo);
                    ResultSet rsP = psP.executeQuery();

                    if (rsP.next()) {
                        String fechaDevolucion = rsP.getString("fechaDevolucion");
                        double fianza = rsP.getDouble("fianza");
                        libTemp.setPrestamo(new Prestamo(codArticulo, fechaDevolucion, fianza));
                    }
                    rsP.close();
                    psP.close();
                }

                lista.add(libTemp);
                resultado += "Libro cargado: " + codArticulo + (estaPrestado ? " (con préstamo)" : " (sin préstamo)") + "\n";
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
    // INSERTAR nuevo libro
    // ─────────────────────────────────────────────
    public static String insertarLibro(BufferedReader br, ArrayList<Libro> lista) {
        String resultado = "";
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            System.out.println("Código de artículo: ");
            String codArticulo = br.readLine();
            System.out.println("Título: ");
            String titulo = br.readLine();
            System.out.println("Autor: ");
            String autor = br.readLine();
            System.out.println("Género: ");
            String genero = br.readLine();
            System.out.println("Número de páginas: ");
            String numPaginas = br.readLine();
            System.out.println("Idioma: ");
            String idioma = br.readLine();

            // Validación S/N para préstamo
            int estaPrestadoInt = -1;
            String op = "-1";
            do {
                System.out.println("¿Está prestado? (S/N): ");
                op = br.readLine().toUpperCase();
                switch (op) {
                    case "S":
                        estaPrestadoInt = 1;
                        break;
                    case "N":
                        estaPrestadoInt = 0;
                        break;
                    default:
                        op = "-1";
                        System.out.println("Opción incorrecta.");
                }
            } while (op.equals("-1"));

            cn = Conexion.creaConexion();

            // 7 columnas → 7 signos ?
            ps = cn.prepareStatement(
                    "INSERT INTO libros(codArticulo, titulo, autor, genero, numPaginas, idioma, estaPrestado) " + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, codArticulo);
            ps.setString(2, titulo);
            ps.setString(3, autor);
            ps.setString(4, genero);
            ps.setString(5, numPaginas);
            ps.setString(6, idioma);
            ps.setInt(7, estaPrestadoInt);

            int result = ps.executeUpdate();

            if (result > 0) {
                resultado = "Libro insertado correctamente: " + codArticulo;
                boolean estaPrestadoBool = (estaPrestadoInt == 1);
                Libro libTemp = new Libro(codArticulo, titulo, autor, genero, numPaginas, idioma, estaPrestadoBool);

                if (estaPrestadoInt == 1) {
                    Prestamo preTemp = insertarPrestamoParaLibro(br, codArticulo, cn);
                    if (preTemp != null) {
                        libTemp.setPrestamo(preTemp);
                    }
                }
                lista.add(libTemp);
            } else {
                resultado = "No se pudo insertar el libro: " + codArticulo;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar libro.";
        } catch (IOException e) {
            e.printStackTrace();
            resultado = "Error de lectura.";
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
    // INSERTAR préstamo a un libro YA EXISTENTE
    // ─────────────────────────────────────────────
    public static String insertarPrestamo(BufferedReader br, ArrayList<Libro> lista) {
        String resultado = "";
        Connection cn = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;

        try {
            cn = Conexion.creaConexion();

            System.out.println("Código del libro al que asociar el préstamo: ");
            String codArticulo = br.readLine();

            PreparedStatement psBusca = cn.prepareStatement("SELECT codArticulo FROM libros WHERE codArticulo = ?");
            psBusca.setString(1, codArticulo);
            ResultSet rs = psBusca.executeQuery();

            if (rs.next()) {
                rs.close();
                psBusca.close();
                System.out.println("Libro encontrado.");

                System.out.println("Fecha de devolución (YYYY-MM-DD): ");
                String fechaDevolucion = br.readLine();
                System.out.println("Fianza: ");
                double fianza = obtenNumeroDouble(br.readLine());

                // 3 columnas → 3 signos ?
                psInsert = cn.prepareStatement("INSERT INTO prestamos(codArticulo, fechaDevolucion, fianza) VALUES (?,?,?)");
                psInsert.setString(1, codArticulo);
                psInsert.setString(2, fechaDevolucion);
                psInsert.setDouble(3, fianza);

                int resInsert = psInsert.executeUpdate();

                if (resInsert > 0) {
                    psUpdate = cn.prepareStatement("UPDATE libros SET estaPrestado = 1 WHERE codArticulo = ?");
                    psUpdate.setString(1, codArticulo);
                    psUpdate.executeUpdate();

                    resultado = "Préstamo insertado y asociado correctamente.";

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getCodArticulo().equals(codArticulo)) {
                            lista.get(i).setEstaPrestado(true);
                            lista.get(i).setPrestamo(new Prestamo(codArticulo, fechaDevolucion, fianza));
                            break;
                        }
                    }
                } else {
                    resultado = "No se pudo insertar el préstamo.";
                }

            } else {
                resultado = "No existe libro con código: " + codArticulo;
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            resultado = "Error SQL al insertar préstamo.";
        } catch (IOException e) {
            e.printStackTrace();
            resultado = "Error de lectura.";
        } finally {
            try {
                if (psInsert != null) {
                    psInsert.close();
                }
                if (psUpdate != null) {
                    psUpdate.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // AUXILIAR — inserta préstamo usando conexión ya abierta
    // ─────────────────────────────────────────────
    private static Prestamo insertarPrestamoParaLibro(BufferedReader br, String codArticulo, Connection cn) {
        Prestamo preTemp = null;
        PreparedStatement ps = null;
        try {
            System.out.println("Fecha de devolución (YYYY-MM-DD): ");
            String fechaDevolucion = br.readLine();
            System.out.println("Fianza: ");
            double fianza = obtenNumeroDouble(br.readLine());

            ps = cn.prepareStatement("INSERT INTO prestamos(codArticulo, fechaDevolucion, fianza) VALUES (?,?,?)");
            ps.setString(1, codArticulo);
            ps.setString(2, fechaDevolucion);
            ps.setDouble(3, fianza);

            int res = ps.executeUpdate();
            if (res > 0) {
                preTemp = new Prestamo(codArticulo, fechaDevolucion, fianza);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return preTemp;
    }

    // ─────────────────────────────────────────────
    // UTILIDADES
    // ─────────────────────────────────────────────
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean ok = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                if (ok) {
                    numero = Integer.parseInt(opcion);
                } else {
                    ok = true;
                    numero = Integer.parseInt(br.readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                ok = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!ok);
        return numero;
    }

    public static double obtenNumeroDouble(String opcion) {
        double numero = 0;
        boolean ok = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                if (ok) {
                    numero = Double.parseDouble(opcion);
                } else {
                    ok = true;
                    numero = Double.parseDouble(br.readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Número incorrecto, introduce un valor válido:");
                ok = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!ok);
        return numero;
    }
}
