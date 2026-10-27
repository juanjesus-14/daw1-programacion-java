
package main.examen1;

/**
 *
 * @author $(user)
 */
public class Modulo {

    private String codigo;
    private String nombre;
    private int horas;
    private Profesor profesor;

    public Modulo(String codigo, String nombre, int horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void asignarProfesor(Profesor profesor){
        this.profesor.setModulo(this.profesor.getModulo());
    }
    
    @Override
    public String toString() {
        return "-- Modulo-- " 
                + "\nCodigo: " + codigo 
                + "\nNombre: " + nombre 
                + "\nHoras: " + horas 
                //+ "\nProfesor: " + profesor
                ;
    }
    
    
    
}
