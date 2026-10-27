/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.cuenta.cliente.arrayfijo;

/**
 *
 * @author juand
 */
import java.util.Scanner;

public class Utils {

    public static void altaCuenta(Scanner sc, Banco banco) {
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Apellidos: ");
        String apellidos = sc.next();
        System.out.print("Número de cuenta: ");
        int numCuenta = sc.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        Cliente cliente = new Cliente(dni, nombre, apellidos);
        Cuenta cuenta = new Cuenta(numCuenta, saldoInicial, cliente);

        if (banco.altaCuenta(cuenta)) {
            System.out.println("Cuenta creada correctamente.");
        } else {
            System.out.println("No se pudo crear: banco lleno.");
        }
    }

    public static void ingresar(Scanner sc, Banco banco) {
        System.out.print("Número de cuenta: ");
        int numCuenta = sc.nextInt();
        System.out.print("Importe a ingresar: ");
        double importe = sc.nextDouble();

        if (banco.ingresar(numCuenta, importe)) {
            System.out.println("Ingreso realizado.");
        } else {
            System.out.println("No se pudo ingresar (cuenta no existe o importe inválido).");
        }
    }

    public static void retirar(Scanner sc, Banco banco) {
        System.out.print("Número de cuenta: ");
        int numCuenta = sc.nextInt();
        System.out.print("Importe a retirar: ");
        double importe = sc.nextDouble();

        if (banco.retirar(numCuenta, importe)) {
            System.out.println("Retirada realizada.");
        } else {
            System.out.println("No se pudo retirar (cuenta no existe, importe inválido o saldo insuficiente).");
        }
    }

    public static void listarCuentas(Banco banco) {
        banco.listarCuentas();
    }

    public static void saldoTotal(Banco banco) {
        System.out.println("Saldo total del banco: " + banco.saldoTotalBanco());
    }
}
