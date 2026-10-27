/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.cuenta.cliente.arrayfijo;

/**
 *
 * @author juand
 */
/**
 * Clase Cuenta: representa una cuenta bancaria con saldo
 * y un cliente como titular.
 */
public class Cuenta {

    private int numCuenta;
    private double saldo;
    private Cliente titular;

    public Cuenta(int numCuenta, double saldo, Cliente titular) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    /**
     * Ingresa dinero: solo si el importe es positivo.
     */
    public boolean ingresar(double importe) {
        if (importe > 0) {
            saldo = saldo + importe;
            return true;
        }
        return false;
    }

    /**
     * Retira dinero: importe positivo Y saldo suficiente.
     */
    public boolean retirar(double importe) {
        if (importe > 0 && saldo >= importe) {
            saldo = saldo - importe;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", saldo=" + saldo
                + ", titular=" + titular.getNombre() + " " + titular.getApellidos() + '}';
    }
}
