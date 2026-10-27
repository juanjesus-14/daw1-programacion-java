package mainequipofutbol;

/**
 *
 * @author $(user)
 */
public class Jugador {

    private int id;
    private String nombre;
    private String posicion;
    private int dorsal;
    private int edad;

    public Jugador(int id, String nombre, String posicion, int dorsal, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getEdad() {
        return edad;
    }

@Override
public String toString() {
    return "----------------------------------------" +
           "\nID: " + id +
           "\nNombre: " + nombre +
           "\nPosición: " + posicion +
           "\nDorsal: " + dorsal +
           "\nEdad: " + edad ;
}
}
