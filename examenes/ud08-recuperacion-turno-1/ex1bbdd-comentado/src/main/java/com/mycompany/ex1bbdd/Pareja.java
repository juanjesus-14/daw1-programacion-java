package com.mycompany.ex1bbdd;

/**
 * Clase Pareja — representa la pareja de un empleado.
 * Es una clase independiente, NO hereda de nadie.
 * Un empleado puede tener una pareja o no tenerla.
 */
public class Pareja {

    // ─── ATRIBUTOS ───────────────────────────────
    // 'private' → solo accesibles desde dentro de esta clase
    // Se usan getters y setters para acceder desde fuera
    private String dni;
    private String nombre;
    private String apellidos;

    // ─── CONSTRUCTORES ───────────────────────────

    // Constructor vacío — necesario porque Empleado hace 'new Pareja()'
    // sin datos al principio. Se rellena luego con setters.
    public Pareja() {
    }

    // Constructor completo — se usa cuando ya tenemos todos los datos
    public Pareja(String dni, String nombre, String apellidos) {
        this.dni = dni;           // 'this.dni' = atributo de la clase
        this.nombre = nombre;     // 'nombre' sin this = parámetro recibido
        this.apellidos = apellidos;
    }

    // ─── GETTERS Y SETTERS ───────────────────────
    // Getters: devuelven el valor del atributo
    // Setters: asignan un nuevo valor al atributo

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

    // ─── TOSTRING ────────────────────────────────
    // Se llama automáticamente cuando hacemos System.out.println(pareja)
    // Devuelve un String con los datos de la pareja
    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + " " + apellidos;
    }
}
