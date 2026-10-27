/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maincuenta.act5;

/**
 *
 * @author juand
 */
public class CuentaCorriente extends Cuenta {

    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo = saldo - cantidad;
        } else {
            sobregiro = sobregiro + (cantidad - saldo);
            saldo = 0;
        }
        numeroRetiros = numeroRetiros + 1;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad = cantidad - sobregiro;
                sobregiro = 0;
                saldo = saldo + cantidad;
            } else {
                sobregiro = sobregiro - cantidad;
            }
        } else {
            saldo = saldo + cantidad;
        }
        numeroConsignaciones = numeroConsignaciones + 1;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo = $" + saldo);
        System.out.println("Comisión mensual = $" + comisionMensual);
        System.out.println("Número de transacciones = "
                + (numeroConsignaciones + numeroRetiros));
        System.out.println("Sobregiro = $" + sobregiro);
    }
}
