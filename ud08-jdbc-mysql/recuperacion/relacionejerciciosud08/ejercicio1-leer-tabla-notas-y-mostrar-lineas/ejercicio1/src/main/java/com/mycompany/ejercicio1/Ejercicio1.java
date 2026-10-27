/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio1;

import java.sql.*;

/**
 *
 * @author juand
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // Listamos y recibimos el total de líneas leídas
        int total = UtilsEj1.listarNotas();

        System.out.println("\nTotal de líneas leídas: " + total);
    }
}
