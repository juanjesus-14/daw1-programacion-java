package mainclientescuentas;

/**
 *
 * @author $(user)
 */
public class Cuenta {

    private String numCuenta;
    private String nombreBanco;

    public Cuenta(String numCuenta, String nombreBanco) {
        this.numCuenta = numCuenta;
        this.nombreBanco = nombreBanco;
    }

    public Cuenta() {
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    @Override
    public String toString() {
        return "Cuenta{" +  ", numCuenta=" + numCuenta + ", nombreBanco=" + nombreBanco + '}';
    }

}
