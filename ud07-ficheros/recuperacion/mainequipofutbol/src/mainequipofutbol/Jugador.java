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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "----------------------------------------" +
               "\nID: " + id +
               "\nNombre: " + nombre +
               "\nPosición: " + posicion +
               "\nDorsal: " + dorsal +
               "\nEdad: " + edad;
    }

    // Para guardar en fichero con el mismo formato
    public String toFichero() {
        return id + ";" + nombre + ";" + posicion + ";" + dorsal + ";" + edad;
    }
}