package ejercicio7.viviendaenalquiler.agencia;

/**
 *
 * @author $(user)
 */
public class Vivienda {

    private int metros;
    private int numeroVentanas;
    private int numeroHabitaciones;
    private String direccion;
    private int metrosTerraza;
    private boolean tienePiscina;
    private boolean tieneGaraje;
    private String tipo;
    private double precioAlquiler;
    private boolean disponible;

    public Vivienda(int metros, int numeroVentanas, int numeroHabitaciones, String direccion, int metrosTerraza, boolean tienePiscina, boolean tieneGaraje, String tipo, double precioAlquiler, boolean disponible) {
        this.metros = metros;
        this.numeroVentanas = numeroVentanas;
        this.numeroHabitaciones = numeroHabitaciones;
        this.direccion = direccion;
        this.metrosTerraza = metrosTerraza;
        this.tienePiscina = tienePiscina;
        this.tieneGaraje = tieneGaraje;
        this.tipo = tipo;
        this.precioAlquiler = precioAlquiler;
        this.disponible = disponible;
    }

    public Vivienda() {
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public int getNumeroVentanas() {
        return numeroVentanas;
    }

    public void setNumeroVentanas(int numeroVentanas) {
        this.numeroVentanas = numeroVentanas;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMetrosTerraza() {
        return metrosTerraza;
    }

    public void setMetrosTerraza(int metrosTerraza) {
        this.metrosTerraza = metrosTerraza;
    }

    public boolean isTienePiscina() {
        return tienePiscina;
    }

    public void setTienePiscina(boolean tienePiscina) {
        this.tienePiscina = tienePiscina;
    }

    public boolean isTieneGaraje() {
        return tieneGaraje;
    }

    public void setTieneGaraje(boolean tieneGaraje) {
        this.tieneGaraje = tieneGaraje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\n Metros=" + metros
                + "\n NumeroVentanas=" + numeroVentanas
                + "\n NumeroHabitaciones=" + numeroHabitaciones
                + "\n Direccion=" + direccion
                + "\n MetrosTerraza=" + metrosTerraza
                + "\n TienePiscina=" + (tienePiscina ? "Si" : "No")
                + "\n TieneGaraje=" + (tieneGaraje ? "Si" : "No")
                + "\n Tipo=" + tipo
                + "\n PrecioAlquiler=" + precioAlquiler
                + "\n Disponible=" + (disponible ? "Si" : "No");
    }

}
