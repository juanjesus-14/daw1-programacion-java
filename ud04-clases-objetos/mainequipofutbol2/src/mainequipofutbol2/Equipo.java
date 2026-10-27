package mainequipofutbol2;

/**
 *
 * @author $(user)
 */
public class Equipo {

    private String NombreEquipo;
    private String NombreEstadio;
    private int Espectadores;
    private String Direccion;
    private String Ciudad;
    private String Division;
    private boolean Asciende;

    public Equipo(String NombreEquipo, String NombreEstadio, int Espectadores, String Direccion, String Ciudad, String Division, boolean Asciende) {
        this.NombreEquipo = NombreEquipo;
        this.NombreEstadio = NombreEstadio;
        this.Espectadores = Espectadores;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Division = Division;
        this.Asciende = Asciende;
    }

    public Equipo() {

    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }

    public String getNombreEstadio() {
        return NombreEstadio;
    }

    public void setNombreEstadio(String NombreEstadio) {
        this.NombreEstadio = NombreEstadio;
    }

    public int getEspectadores() {
        return Espectadores;
    }

    public void setEspectadores(int Espectadores) {
        this.Espectadores = Espectadores;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String Division) {
        this.Division = Division;
    }

    public boolean isAsciende() {
        return Asciende;
    }

    public void setAsciende(boolean Asciende) {
        this.Asciende = Asciende;
    }

    @Override
    public String toString() {
        return "\n--- Equipo ---"
                + "\nNombre: " + NombreEquipo
                + "\nEstadio: " + NombreEstadio
                + "\nEspectadores: " + Espectadores
                + "\nDireccion: " + Direccion
                + "\nCiudad: " + Ciudad
                + "\nDivision: " + Division
                + "\nAsciende: " + (Asciende ? "Si" : "No");
    }

}
