package mainseleccionfutbol;

import java.util.Date;

/**
 *
 * @author $(user)
 */
public class Entrenador extends SeleccionFutbol {

    private String idFederacion;

    //constructor
    public Entrenador(String idFederacion, int ID, String Nombre, String Apellidos, Date fechaNacimiento) {
        super(ID, Nombre, Apellidos, fechaNacimiento);
        this.idFederacion = idFederacion;
    }

    //getters y setters
    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    //metodos
    @Override
    public int getTipoPersona() {
        return 2;
    }

    @Override
    public String Concentrarse() {
        return this.Nombre + "(Entrenador ) entra en la concentracion.";
    }

    @Override
    public String Viajar() {
        return this.Nombre + "(Entrenador ) viaja para iniciar la concentracion.";
    }

    public void dirigirPartido() {
        System.out.println(this.Nombre + " designa como formacion 4-3-3 " + this.idFederacion);
    }

    public void dirigirEntrenamiento() {
        System.out.println(this.Nombre + " dirige el entreamiento de la seleccion " + this.idFederacion);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + "\nNombre: " + this.Nombre
                + "\nEdad: " + this.calculaEdad()
                + "\nID Federacion: " + idFederacion;
    }

}
