package ex07recuperacion;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Paciente extends Persona {

    private String numSegSocial;
    private ArrayList<PruebaMedica> historial;

    public Paciente(String dni, String nombre, String apellidos, String email, String genero, LocalDate fechaNacimiento, String direccion, String telefono, String numSegSocial) {
        super(dni, nombre, apellidos, email, genero, fechaNacimiento, direccion, telefono);
        this.numSegSocial = numSegSocial;
        this.historial = new ArrayList<>();
    }

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public void setNumSegSocial(String numSegSocial) {
        this.numSegSocial = numSegSocial;
    }

    public ArrayList<PruebaMedica> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<PruebaMedica> historial) {
        this.historial = historial;
    }

    public void asignaPrueba(PruebaMedica prueba) {
        this.historial.add(prueba);
    }

    public void asignaPrueba(String codigo, LocalDate fechaPrueba, String descripPrueba) {

    }

    public ArrayList<PruebaMedica> historial() {
        return historial;
    }

    public void setListaCuentas(ArrayList<PruebaMedica> historial) {
        this.historial = historial;
    }

    public boolean abrirPrueba(PruebaMedica p) {
        this.historial.add(p);
        return true;
    }

    @Override
    public String toString() {
        return super.toString()
                + " - numSegSocial=" + numSegSocial + "\n-- Historial --";
    }

}
