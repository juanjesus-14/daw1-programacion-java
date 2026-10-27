/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainempleado.act4;

/**
 *
 * @author juand
 */
public class Empleado {

    private String nombre;

    // constructor
    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "\n Empleado: " + nombre;
    }

}
