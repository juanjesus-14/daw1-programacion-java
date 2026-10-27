/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12;

/**
 *
 * @author juand
 */
public class Modulo {

    private String id;
    private String nombre;

    public Modulo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toFile() {
        return id + ";" + nombre;
    }

    @Override
    public String toString() {
        return "Modulo{id=" + id + ", nombre=" + nombre + "}";
    }
}
