/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio4;

/**
 *
 * @author juand
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ── FORMULARIO DE LOGIN ──
        System.out.println("=== INICIO DE SESIÓN ===");
        System.out.println("Usuario: ");
        String username = sc.nextLine();
        System.out.println("Contraseña: ");
        String password = sc.nextLine();

        // login devuelve "admin", "normal" o null
        String tipo = Utils4.login(username, password);

        if (tipo == null) {
            // Credenciales incorrectas → acceso denegado
            System.out.println("Acceso denegado.");

        } else if (tipo.equals("admin")) {
            // Es admin → menú CRUD completo
            System.out.println("Bienvenido administrador, " + username);
            int opcion = -1;
            do {
                mostrarMenuAdmin();
                opcion = Utils4.obtenNumeroEntero(sc.nextLine());
                switch (opcion) {
                    case 1:
                        Utils4.verUsuarios();
                        break;
                    case 2:
                        System.out.println(Utils4.crearUsuario(sc));
                        break;
                    case 3:
                        System.out.println(Utils4.modificarUsuario(sc));
                        break;
                    case 4:
                        System.out.println(Utils4.eliminarUsuario(sc));
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
            } while (opcion != 0);

        } else {
            // Es usuario normal → menú de la aplicación
            System.out.println("Bienvenido, " + username);
            Utils4.menuUsuarioNormal(sc);
        }

        sc.close();
    }

    public static void mostrarMenuAdmin() {
        System.out.println("\n-- MENÚ ADMIN --");
        System.out.println("1.- Ver todos los usuarios");
        System.out.println("2.- Crear nuevo usuario");
        System.out.println("3.- Modificar usuario");
        System.out.println("4.- Eliminar usuario");
        System.out.println("0.- Salir");
        System.out.print("Opción: ");
    }
}
