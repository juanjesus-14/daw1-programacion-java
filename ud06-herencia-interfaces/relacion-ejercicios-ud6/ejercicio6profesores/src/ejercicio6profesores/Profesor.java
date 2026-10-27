package ejercicio6profesores;

import java.time.*;

public abstract class Profesor extends Persona {

    protected String idProfesor;

    public Profesor(String nombre, String apellidos, int edad, String idProfesor) {
        super(nombre, apellidos, edad);
        this.idProfesor = idProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    // este va a ser el metodo abstracto que implementan Titular e Interino de los profes
    public abstract float importeNomina();

    @Override
    public String toString() {
        return "Profesor{id='" + idProfesor + "', " + super.toString() + "}";
    }
}
