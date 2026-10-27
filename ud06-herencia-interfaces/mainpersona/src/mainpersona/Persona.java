package mainpersona;

/**
 *
 * @author $(user)
 */
public abstract class Persona {

    protected String nombre;
    protected String apellidos;
    protected String direccion;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona(String nombre, String apellidos, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public abstract String saludar();

    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nApellidos: " + apellidos;
    }

}
