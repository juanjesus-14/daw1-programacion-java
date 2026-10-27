package main;

/**
 *
 * @author $(user)
 */
public class Persona {

    // ATRIBUTOS
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;

    // CONSTRUCTOR
    public Persona(String dni, String nombre, String apellidos, String email) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;

    }

    // GETTERS
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    // SETTERS
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // MÉTODO NOMBRE COMPLETO
    public String getNombreCompleto() {

        return nombre + " " + apellidos;

    }

    // TOSTRING
    @Override
    public String toString() {

        return dni + " - " + nombre + " "
                + apellidos + " - " + email;

    }

}
