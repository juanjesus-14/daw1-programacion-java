package maintienda;

/**
 *
 * @author $(user)
 */
public class Mascota {

    private String nombre;
    private int edad;
    private String raza;
    private Persona per;

    public Mascota(String dni, String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.per = per;
    }

    public Mascota(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
        public boolean asignaPersona(Persona per) {
        this.per = per;
        return true;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + '}';
    }

}
