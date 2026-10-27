package ejercicio13;

/**
 *
 * @author $(user)
 */
public class Cuenta {

    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }

    public Cuenta(Cuenta otraCuenta) {
        this.nombreCliente = otraCuenta.nombreCliente;
        this.numeroCuenta = otraCuenta.numeroCuenta;
        this.tipoInteres = otraCuenta.tipoInteres;
        this.saldo = otraCuenta.saldo;
    }
    
        public Cuenta(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = "0183-1234-56-00000" + String.valueOf((int)(Math.random()*99999)+10000);
        this.tipoInteres = Math.random() + 0.5;
        this.saldo = 0;
    }

    public Cuenta() {

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double dineroAIngresar) {
        this.saldo = this.saldo + dineroAIngresar;
    }

    public boolean reintegro(double dineroARetirar) {
        if (this.saldo < dineroARetirar) {
            return false;
        } else {
            this.saldo = this.saldo - dineroARetirar;
        }
        return true;
    }

    public boolean transferencia(Cuenta destino, double importe) {
        if (this.saldo >= importe) {
            this.saldo = this.saldo - importe;
            destino.ingreso(importe);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta {"
                + "\nNum cuenta=" + numeroCuenta
                + "\nCliente=" + nombreCliente
                + "\nTipo interes=" + String.format("%.2f", tipoInteres) + "%" 
                + "\nSaldo=" + saldo + "}";
    }
}
