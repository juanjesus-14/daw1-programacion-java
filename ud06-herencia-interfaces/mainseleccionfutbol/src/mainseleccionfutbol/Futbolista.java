package mainseleccionfutbol;

import java.util.Date;

/**
 *
 * @author $(user)
 */
public class Futbolista extends SeleccionFutbol {

    private int dorsal;
    private Posicion posicion;
    private Estadisticas estadisticas;

    //clase anidada
    public class Estadisticas {

        private int goles;
        private int faltas;
        private int partidosJugados;
        private int tarjetasAmarillas;
        private int tarjetasRojas;

        // Constructor vacío
        public Estadisticas() {
        }

        // Constructor con parámetros
        public Estadisticas(int goles, int faltas, int partidosJugados,
                int tarjetasAmarillas, int tarjetasRojas) {
            this.goles = goles;
            this.faltas = faltas;
            this.partidosJugados = partidosJugados;
            this.tarjetasAmarillas = tarjetasAmarillas;
            this.tarjetasRojas = tarjetasRojas;
        }

        // Getters y setters
        public int getGoles() {
            return goles;
        }

        public void setGoles(int goles) {
            this.goles = goles;
        }

        public int getFaltas() {
            return faltas;
        }

        public void setFaltas(int faltas) {
            this.faltas = faltas;
        }

        public int getPartidosJugados() {
            return partidosJugados;
        }

        public void setPartidosJugados(int partidosJugados) {
            this.partidosJugados = partidosJugados;
        }

        public int getTarjetasAmarillas() {
            return tarjetasAmarillas;
        }

        public void setTarjetasAmarillas(int tarjetasAmarillas) {
            this.tarjetasAmarillas = tarjetasAmarillas;
        }

        public int getTarjetasRojas() {
            return tarjetasRojas;
        }

        public void setTarjetasRojas(int tarjetasRojas) {
            this.tarjetasRojas = tarjetasRojas;
        }

        @Override
        public String toString() {
            return "\nGoles: " + goles
                    + "\nFaltas: " + faltas
                    + "\nPartidos Jugados: " + partidosJugados
                    + "\nTarjetas Amarillas: " + tarjetasAmarillas
                    + "\nTarjetas Rojas: " + tarjetasRojas;
        }

        public void mostrarEstadisticas() {
            System.out.println("   Goles: " + goles);
            System.out.println("   Faltas: " + faltas);
            System.out.println("   Partidos jugados: " + partidosJugados);
            System.out.println("   Tarjetas amarillas: " + tarjetasAmarillas);
            System.out.println("   Tarjetas rojas: " + tarjetasRojas);
        }

        public void actualizaDatos(int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
            this.faltas += faltas;
            this.goles += goles;
            this.partidosJugados += partidosJugados;
            this.tarjetasAmarillas += tarjetasAmarillas;
            this.tarjetasRojas += tarjetasRojas;
        }
    }

    //constructores
    public Futbolista(int dorsal, Posicion posicion, int id, String Nombre, String Apellidos, Date FechaNacimiento,
            int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
        super(id, Nombre, Apellidos, FechaNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;

        Estadisticas estad = new Estadisticas(goles, faltas, partidosJugados, tarjetasAmarillas, tarjetasRojas);
        this.estadisticas = estad;
    }

    public Futbolista(int dorsal, Posicion posicion, int ID, String Nombre, String Apellidos, Date fechaNacimiento) {
        super(ID, Nombre, Apellidos, fechaNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.estadisticas = new Estadisticas(0, 0, 0, 0, 0);
    }

    //getter y setter
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    // metodo
//    public void altaEstadisticas(int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
//        Estadisticas estad = new Estadisticas(goles, faltas, partidosJugados, tarjetasAmarillas, tarjetasRojas);
//        this.estadisticas = estad;
//    }
//opcion 1
    public void actualizaEstadisticas(int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
        estadisticas.faltas += faltas;
        estadisticas.goles += goles;
        estadisticas.partidosJugados += partidosJugados;
        estadisticas.tarjetasAmarillas += tarjetasAmarillas;
        estadisticas.tarjetasRojas += tarjetasRojas;
    }

//opcion 2
    public void actualizaEstadistica2(int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
        this.estadisticas.setGoles(this.estadisticas.getGoles() + goles);
        this.estadisticas.setFaltas(this.estadisticas.getFaltas() + faltas);
        this.estadisticas.setPartidosJugados(this.estadisticas.getPartidosJugados() + partidosJugados);
        this.estadisticas.setTarjetasAmarillas(this.estadisticas.getTarjetasAmarillas() + tarjetasAmarillas);
        this.estadisticas.setTarjetasRojas(this.estadisticas.getTarjetasRojas() + tarjetasRojas);
    }

//opcion 3
    public void actualizaEstadisticas3(int goles, int faltas, int partidosJugados, int tarjetasAmarillas, int tarjetasRojas) {
        estadisticas.actualizaDatos(goles, faltas, partidosJugados, tarjetasAmarillas, tarjetasRojas);
    }

    @Override
    public int getTipoPersona() {
        return 1;
    }

    @Override
    public String Concentrarse() {
        return this.Nombre + "(" + posicion + ") entra en la concentracion.";
    }

    @Override
    public String Viajar() {
        return this.Nombre + "(" + posicion + ") viaja para iniciar la concentracion.";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + "\nNombre: " + this.Nombre
                + "\nEdad: " + this.calculaEdad()
                + "\ndorsal: " + dorsal
                + ",\nposicion: " + posicion
                + "\nestadisticas: " + estadisticas;
    }
}
