package mainseleccionfutbol;

import java.util.Date;

/**
 *
 * @author $(user)
 */
public class Masajista extends SeleccionFutbol {

    private String titulacion;
    private int aniosExperiencia;

    //constructor
    public Masajista(String titulacion, int aniosExperiencia, int ID, String Nombre, String Apellidos, Date fechaNacimiento) {
        super(ID, Nombre, Apellidos, fechaNacimiento);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    //getters y setters
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    //metodos
    @Override
    public int getTipoPersona() {
        return 3;
    }

    @Override
    public String Concentrarse() {
        return this.Nombre + "(Masajista) entra en la concentracion.";
    }

    @Override
    public String Viajar() {
        return this.Nombre + "(Masajista) viaja para iniciar la concentracion.";
    }

    public void darMasaje(String jugador) {
        System.out.println(Nombre + " realiza un masaje a " + jugador);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + "\nNombre: " + this.Nombre
                + "\nEdad: " + this.calculaEdad()
                + "\nTitulacion: " + this.titulacion
                + "\nAnios Experiencia: " + this.aniosExperiencia;
    }
}
