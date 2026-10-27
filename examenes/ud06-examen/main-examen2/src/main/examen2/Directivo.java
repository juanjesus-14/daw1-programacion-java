package main.examen2;

/**
 *
 * @author $(user)
 */
public class Directivo extends Empleado {

    private int bonoExperiencia;

    public Directivo(int bonoExperiencia, String nombre, int fechaContratacion, int codEmpleado, int sueldo) {
        super(nombre, fechaContratacion, codEmpleado, sueldo);
        this.bonoExperiencia = bonoExperiencia;
    }

    public int getBonoExperiencia() {
        return bonoExperiencia;
    }

    public void setBonoExperiencia(int bonoExperiencia) {
        this.bonoExperiencia = bonoExperiencia;
    }

    @Override
    public int obtenSueldoActual() {
        return (this.sueldo + (this.bonoExperiencia * this.fechaContratacion));
    }

    @Override
    public String toString() {
        return "Soy " + nombre + ", Directivo de la empresa, mi sueldo actual es: " + sueldo;

    }

}
