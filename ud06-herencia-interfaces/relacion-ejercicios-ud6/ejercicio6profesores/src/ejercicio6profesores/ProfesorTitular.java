package ejercicio6profesores;

import java.time.*;

public class ProfesorTitular extends Profesor {

    public ProfesorTitular(String nombre, String apellidos, int edad, String idProfesor) {
        super(nombre, apellidos, edad, idProfesor);
    }

    @Override
    public float importeNomina() {
        return 2000f;
    }

    @Override
    public String toString() {
        return super.toString() + " [Titular]";
    }
}
