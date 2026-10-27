/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco.cuenta.cliente.arrayfijo;

import java.util.Scanner;

/**
 *
 * @author juand
 */
public class BancoCuentaClienteArrayFijo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco(10);
        int opcion;

        do {
            System.out.println("\n1. Alta cliente+cuenta");
            System.out.println("2. Ingresar");
            System.out.println("3. Retirar");
            System.out.println("4. Listar cuentas");
            System.out.println("5. Saldo total del banco");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Utils.altaCuenta(sc, banco);
                    break;
                case 2:
                    Utils.ingresar(sc, banco);
                    break;
                case 3:
                    Utils.retirar(sc, banco);
                    break;
                case 4:
                    Utils.listarCuentas(banco);
                    break;
                case 5:
                    Utils.saldoTotal(banco);
                    break;
            }

        } while (opcion != 0);
    }
}
