package mainpersona;

/**
 *
 * @author $(user)
 */
public class Bedel extends Persona {

    private String centroTrabaja;
    private boolean turnoTarde;

    public Bedel(String centroTrabaja, boolean turnoTarde, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.centroTrabaja = centroTrabaja;
        this.turnoTarde = turnoTarde;
    }

    public Bedel(String centroTrabaja, boolean turnoTarde, String nombre, String apellidos, String direccion) {
        super(nombre, apellidos, direccion);
        this.centroTrabaja = centroTrabaja;
        this.turnoTarde = turnoTarde;
    }

    public String getCentroTrabaja() {
        return centroTrabaja;
    }

    public void setCentroTrabaja(String centroTrabaja) {
        this.centroTrabaja = centroTrabaja;
    }

    public boolean isTurnoTarde() {
        return turnoTarde;
    }

    public void setTurnoTarde(boolean turnoTarde) {
        this.turnoTarde = turnoTarde;
    }

    @Override
    public String saludar() {
        return this.getClass().getSimpleName() + " -- Hola: " + this.nombre + " " + this.apellidos;
    }

    @Override
    public String toString() {
        return "\nBedel"
                + super.toString()
                + "\ncentroTrabaja: " + centroTrabaja
                //opcion1 
                + ", turnoTarde: " + (turnoTarde ? "No" : "Si");
        //opcion2
//              +", turnoTarde=" + (!turnoTarde ? "Si" : "No");
        //opcion3
//            +", turnoTarde=" + (turnoTarde ? "Tarde" : "Mañana");
    }
}
