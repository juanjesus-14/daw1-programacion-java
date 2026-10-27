package main.examen1;

import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class Profesor extends Persona {

    private String especialidad;
    private ArrayList<Modulo> Modulo = new ArrayList<>();

    public Profesor(String especialidad, String DNI, String nombre, String apellidos, String email) {
        super(DNI, nombre, apellidos, email);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Modulo> getModulo() {
        return Modulo;
    }

    public void setModulo(ArrayList<Modulo> modulo) {
        this.Modulo = modulo;
    }
    
    public void asignarModulo(Modulo modulo){
        this.Modulo.add(modulo);
    }

    @Override
    public String toString() {
        return "-- Profesor --" 
                + "\nEspecialidad: " + especialidad 
                //+ "\nModulo: " + Modulo
                ;
    }

    
}
