/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencompletoprueba;

//Cliente
import java.util.ArrayList;

//-----------------------------------------------------
//- dni : String
//- nombre : String
//- apellidos : String
//- email : String
//- telefono : String
//- cuentas : ArrayList<Cuenta>
//-----------------------------------------------------
//+ Cliente(dni: String, nombre: String, apellidos: String, email: String, telefono: String)
//+ abrirCuenta(cuenta: Cuenta) : boolean
//+ cerrarCuenta(cuenta: Cuenta) : boolean
//+ listarCuentas() : void
//+ toString() : String
//+ getters y setters
public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private ArrayList<Cuenta> listaCuentas;

    public Cliente(String dni, String nombre, String apellidos, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.listaCuentas = new ArrayList<>();
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

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public boolean abrirCuenta(Cuenta c) {
        this.listaCuentas.add(c);
        return true;
    }

    public boolean cerrarCuenta(Cuenta c) {
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            if (c.getNumeroCuenta().equals(listaCuentas.get(i).getNumeroCuenta())) {
                this.listaCuentas.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + ", listaCuentas=" + listaCuentas + '}';
    }

}
