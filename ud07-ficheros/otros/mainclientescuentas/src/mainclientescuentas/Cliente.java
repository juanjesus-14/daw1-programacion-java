package mainclientescuentas;

/**
 *
 * @author $(user)
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private Cuenta cuenta;

    public Cliente(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cuenta = new Cuenta();
    }

    public Cliente(String dni, String nombre, String apellidos, Cuenta cuenta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cuenta = cuenta;
    }
    
        public Cliente(String dni, String nombre, String apellidos, String numCuenta, String nombreBanco ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cuenta = new Cuenta(numCuenta, nombreBanco);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
        public void setCuenta(String numCuenta, String nombreBanco) {
        this.cuenta.setNombreBanco(nombreBanco);
        this.cuenta.setNumCuenta(numCuenta);
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cuenta=" + cuenta + '}';
    }

}
