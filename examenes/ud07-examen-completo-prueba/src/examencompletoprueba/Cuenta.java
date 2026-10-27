/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencompletoprueba;

//Cuenta
import java.time.LocalDate;

//-----------------------------------------------------
//- numeroCuenta : String
//- tipo : String          (AHORRO / CORRIENTE)
//- saldo : double
//- fechaApertura : LocalDate
//- titular : Cliente
//-----------------------------------------------------
//+ Cuenta(numeroCuenta: String, tipo: String, saldo: double, fechaApertura: LocalDate)
//+ asignaTitular(cliente: Cliente) : boolean
//+ toString() : String
//+ getters y setters
public class Cuenta {

    private String numeroCuenta;
    private String tipo;
    private double saldo;
    private LocalDate fechaApertura;
    private Cliente titular;

    public Cuenta(String numeroCuenta, String tipo, Double saldo, LocalDate fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.titular = null;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public boolean asignaTitular(Cliente cliente) {
        this.titular = cliente;
        return true;
    }

@Override
public String toString() {
    return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
}

}
