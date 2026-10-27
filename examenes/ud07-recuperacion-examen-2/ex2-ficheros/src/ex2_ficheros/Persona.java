/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2_ficheros;

/**
 *
 * @author juand
 */
import java.util.ArrayList;

public class Persona {

    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;
    private ArrayList<Mascota> listaMascotas;

    public Persona(String dni, String nombre, String apellidos, String email, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaMascotas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public boolean asignaMascota(Mascota mascota) {
        this.listaMascotas.add(mascota);
        return true;
    }

    public void listarMascotas() {
        for (int i = 0; i < listaMascotas.size(); i++) {
            System.out.println("  <Mascota " + (i + 1) + "> " + listaMascotas.get(i));
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
}
