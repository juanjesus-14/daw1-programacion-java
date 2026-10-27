package mainequipofutbol2;

/**
 *
 * @author $(user)
 */
public class Estadisticas {

    private int Goles;
    private int Faltas;
    private int PartidosJugados;
    private int TarjetasAmarillas;
    private int TarjetasRojas;

    public Estadisticas(int Goles, int Faltas, int PartidosJugados, int TarjetasAmarillas, int TarjetasRojas) {
        this.Goles = Goles;
        this.Faltas = Faltas;
        this.PartidosJugados = PartidosJugados;
        this.TarjetasAmarillas = TarjetasAmarillas;
        this.TarjetasRojas = TarjetasRojas;
    }
    
    public Estadisticas(){
        
    }

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
    
        @Override
    public String toString() {
        return "Estadisticas: "
                + "\n     Goles: " + Goles 
                + "\n     Faltas: " + Faltas 
                + "\n     PartidosJugados: " + PartidosJugados 
                + "\n     TarjetasAmarillas: " + TarjetasAmarillas 
                + "\n     TarjetasRojas: " + TarjetasRojas;
    }
    
}
