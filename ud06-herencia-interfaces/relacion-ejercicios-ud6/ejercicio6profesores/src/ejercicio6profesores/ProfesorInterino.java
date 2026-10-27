package ejercicio6profesores;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ProfesorInterino extends Profesor {

    private LocalDate fechaComienzoInterinidad;

    public ProfesorInterino(String nombre, String apellidos, int edad, String idProfesor,LocalDate fechaComienzoInterinidad) {
        super(nombre, apellidos, edad, idProfesor);
        this.fechaComienzoInterinidad = fechaComienzoInterinidad;
    }

    public LocalDate getFechaComienzoInterinidad() {
        return fechaComienzoInterinidad;
    }

    // asi mismo la nomina
    @Override
    public float importeNomina() {
        long meses = ChronoUnit.MONTHS.between(fechaComienzoInterinidad, LocalDate.now());
        if (meses < 0) meses = 0;
        return 1200f + (float) (meses * 5); // base + plus por la antiguedad de interinao
    }

    @Override
    public String toString() {
        return super.toString() + " [Interino, inicio=" + fechaComienzoInterinidad + "]";
    }
}
