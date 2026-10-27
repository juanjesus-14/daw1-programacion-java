package mainpersona;

/**
 *
 * @author $(user)
 */
public class Profesor extends Persona {

    private String departamento;

    public Profesor(String departamento, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.departamento = departamento;
    }

    public Profesor(String departamento, String nombre, String apellidos, String direccion) {
        super(nombre, apellidos, direccion);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String saludar() {
       // return "(Profesor) Hola: " + this.nombre + " " + this.apellidos;
        return this.getClass().getSimpleName() + " -- Hola: " + this.nombre + " " + this.apellidos;
    }

    @Override
    public String toString() {
        return "\nProfesor"
                + super.toString()
                + "\nDepartamento: " + departamento;
    }

}
