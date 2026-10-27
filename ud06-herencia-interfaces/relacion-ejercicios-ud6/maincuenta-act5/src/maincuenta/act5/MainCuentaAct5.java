/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maincuenta.act5;

/**
 *
 * @author juand
 */
public class MainCuentaAct5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Cuenta de ahorros");

        System.out.print("Ingrese saldo inicial: $ ");
        float saldoInicial = Float.parseFloat(System.console().readLine());

        System.out.print("Ingrese tasa de interés: ");
        float tasa = Float.parseFloat(System.console().readLine());

        CuentaDeAhorros cuenta = new CuentaDeAhorros(saldoInicial, tasa);

        System.out.print("Ingresar cantidad a consignar: $");
        float consignar = Float.parseFloat(System.console().readLine());
        cuenta.consignar(consignar);

        System.out.print("Ingresar cantidad a retirar: $");
        float retirar = Float.parseFloat(System.console().readLine());
        cuenta.retirar(retirar);

        cuenta.extractoMensual();

        System.out.println("Saldo = $" + cuenta.saldo);
        System.out.println("Comisión mensual = $" + cuenta.comisionMensual);
        System.out.println("Número de transacciones = "
                + (cuenta.numeroConsignaciones + cuenta.numeroRetiros));
    }
}
