package mainseleccionfutbol;

import java.time.*;
import java.util.Date;

/**
 *
 * @author $(user)
 */
public abstract class SeleccionFutbol {

    protected int ID;
    protected String Nombre;
    protected String Apellidos;
    //protected int Edad;
    protected Date fechaNacimiento;

    //constructor
    public SeleccionFutbol(int ID, String Nombre, String Apellidos, Date fechaNacimiento) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    //getter y setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //Metodos
    public abstract String Concentrarse();

    public abstract String Viajar();
    
    public abstract int getTipoPersona();

    //Metodo calcular la edad
    public int calculaEdad() {
//opcion 1 --> no es la mejor solucion ni la mas exacta
//        Date hoy = new Date();
//        return hoy.getYear() - this.getFechaNacimiento().getYear();

//opcion 2 --> convertimos de date a localdate
        LocalDate fechaNac = this.fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
                //fecha actual en localdate
                LocalDate hoy = LocalDate.now();
                return Period.between(fechaNac, hoy).getYears();
    }
    //tostring

    @Override
    public String toString() {
        return (ID + 1) + "\nNombre: " + Nombre
                + "\nApellidos:" + Apellidos
                + "\nFecha Nacimiento: " + fechaNacimiento;
    }

}
