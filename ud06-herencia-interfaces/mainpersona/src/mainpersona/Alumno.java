package mainpersona;

/**
 *
 * @author $(user)
 */
public class Alumno extends Persona {

    private String cicloMatriculado;

    public Alumno(String cicloMatriculado, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.cicloMatriculado = cicloMatriculado;
    }

    public Alumno(String cicloMatriculado, String nombre, String apellidos, String direccion) {
        super(nombre, apellidos, direccion);
        this.cicloMatriculado = cicloMatriculado;
    }

    public String getCicloMatriculado() {
        return cicloMatriculado;
    }

    public void setCicloMatriculado(String cicloMatriculado) {
        this.cicloMatriculado = cicloMatriculado;
    }

    @Override
    public String saludar() {
        return this.getClass().getSimpleName() + " -- Hola: " + this.nombre + " " + this.apellidos;
    }

    @Override
    public String toString() {
        return "\nAlumno"
                + super.toString()
                + "\nCicloMatriculado: " + cicloMatriculado;
    }

}
