package main.examen1;

/**
 *
 * @author $(user)
 */
public class Persona {

    protected String DNI;
    protected String nombre;
    protected String apellidos;
    protected String email;

    public Persona(String DNI, String nombre, String apellidos, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombreCompleto(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return nombre + apellidos;
    }

    @Override
    public String toString() {
        return "-- Persona --"
                + "\nDNI: " + DNI
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nEmail: " + email;
    }

}
