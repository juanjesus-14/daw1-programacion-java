/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio2;

/**
 *
 * @author juand
 */
import java.sql.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        int total = UtilsEj2.listarAlumnos();

        System.out.println("\nTotal de líneas leídas: " + total);
    }
}
