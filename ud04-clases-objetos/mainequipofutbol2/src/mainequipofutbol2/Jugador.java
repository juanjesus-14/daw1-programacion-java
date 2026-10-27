package mainequipofutbol2;

/**
 *
 * @author $(user)
 */
public class Jugador {

    private String NombreJugador;
    private int Edad;
    private double Peso;
    private double Altura;
    private Estadisticas estadisticas;
    private int Goles;
    private int Faltas;
    private int PartidosJugados;
    private int TarjetasAmarillas;
    private int TarjetasRojas;

    public int getGoles() {
        return Goles;
    }

    public void setGoles(int Goles) {
        this.Goles = Goles;
    }

    public int getFaltas() {
        return Faltas;
    }

    public void setFaltas(int Faltas) {
        this.Faltas = Faltas;
    }

    public int getPartidosJugados() {
        return PartidosJugados;
    }

    public void setPartidosJugados(int PartidosJugados) {
        this.PartidosJugados = PartidosJugados;
    }

    public int getTarjetasAmarillas() {
        return TarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int TarjetasAmarillas) {
        this.TarjetasAmarillas = TarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return TarjetasRojas;
    }

    public void setTarjetasRojas(int TarjetasRojas) {
        this.TarjetasRojas = TarjetasRojas;
    }

    public Jugador(String NombreJugador, int Edad, double Peso, double Altura, int Goles, int Faltas, int PartidosJugados, int TarjetasAmarillas, int TarjetasRojas) {
        this.NombreJugador = NombreJugador;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Altura = Altura;

        Estadisticas estadisticas = new Estadisticas(Goles, Faltas, PartidosJugados, TarjetasAmarillas, TarjetasRojas);
        this.estadisticas = estadisticas;
    }

    public Jugador() {

    }

    public String getNombreJugador() {
        return NombreJugador;
    }

    public void setNombreJugador(String NombreJugador) {
        this.NombreJugador = NombreJugador;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "\n--- Menu Jugadores ---"
                + "\nNombreJugador: " + NombreJugador
                + "\nEdad: " + Edad
                + "\nPeso: " + Peso
                + "\nAltura:" + Altura
                + "\nestadisticas:" + estadisticas;

    }
}
