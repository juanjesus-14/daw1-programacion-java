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
 * Clase Banco: gestiona un array de tamaño fijo de Cuentas.
 */
public class Banco {

    private Cuenta[] cuentas;
    private int numCuentasActual; // cuántas posiciones del array están ocupadas

    public Banco(int capacidad) {
        cuentas = new Cuenta[capacidad];
        numCuentasActual = 0;
    }

    /**
     * Da de alta una cuenta en la primera posición libre.
     * Comprueba antes que el array no esté lleno.
     */
    public boolean altaCuenta(Cuenta c) {
        if (numCuentasActual < cuentas.length) {
            cuentas[numCuentasActual] = c;
            numCuentasActual++;
            return true;
        }
        return false; // array lleno
    }

    /**
     * Busca una cuenta por su número recorriendo SOLO las posiciones
     * ocupadas (hasta numCuentasActual, no hasta cuentas.length,
     * para no toparse con huecos null).
     */
    public Cuenta buscarCuenta(int numCuenta) {
        for (int i = 0; i < numCuentasActual; i++) {
            if (cuentas[i].getNumCuenta() == numCuenta) {
                return cuentas[i];
            }
        }
        return null;
    }

    public boolean ingresar(int numCuenta, double importe) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null) {
            return c.ingresar(importe);
        }
        return false;
    }

    public boolean retirar(int numCuenta, double importe) {
        Cuenta c = buscarCuenta(numCuenta);
        if (c != null) {
            return c.retirar(importe);
        }
        return false;
    }

    public void listarCuentas() {
        for (int i = 0; i < numCuentasActual; i++) {
            System.out.println(cuentas[i]);
        }
    }

    public double saldoTotalBanco() {
        double total = 0;
        for (int i = 0; i < numCuentasActual; i++) {
            total = total + cuentas[i].getSaldo();
        }
        return total;
    }
}
