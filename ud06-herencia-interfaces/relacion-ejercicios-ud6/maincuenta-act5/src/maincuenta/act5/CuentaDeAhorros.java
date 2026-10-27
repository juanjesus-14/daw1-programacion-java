/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maincuenta.act5;

/**
 *
 * @author juand
 */
public class CuentaDeAhorros extends Cuenta {

    private boolean activa;

    public CuentaDeAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa == true) {
            super.consignar(cantidad);
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa == true) {
            super.retirar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual = (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo = $" + saldo);
        System.out.println("Comisión mensual = $" + comisionMensual);
        System.out.println("Número de transacciones = "
                + (numeroConsignaciones + numeroRetiros));
    }
}
