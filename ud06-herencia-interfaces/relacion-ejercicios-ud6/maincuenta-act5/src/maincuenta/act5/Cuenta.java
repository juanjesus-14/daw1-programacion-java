/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maincuenta.act5;

/**
 *
 * @author juand
 */
public class Cuenta {

    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    // constructor
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    // getters y setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public void setNumeroConsignaciones(int numeroConsignaciones) {
        this.numeroConsignaciones = numeroConsignaciones;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros = numeroRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    // metodos
    public void consignar(float cantidad) {
        saldo = saldo + cantidad;
        numeroConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo = saldo - cantidad;
            numeroRetiros++;
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (saldo * tasaAnual) / 12;
        saldo = saldo + interesMensual;
    }

    public void extractoMensual() {
        saldo = saldo - comisionMensual;
        calcularInteresMensual();
    }

    public void imprimir() {
        System.out.println("Saldo = $" + saldo);
        System.out.println("Consignaciones = " + numeroConsignaciones);
        System.out.println("Retiros = " + numeroRetiros);
        System.out.println("Tasa anual = " + tasaAnual);
        System.out.println("Comisión mensual = $" + comisionMensual);
    }

}
