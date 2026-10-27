/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainvivienda;

/**
 *
 * @author juand
 */
public class Vivienda {

    protected int metros;
    protected int numeroVentanas;
    protected int numeroHabitaciones;
    protected String direccion;
    protected int metrosTerraza;
    protected boolean tienePiscina;
    protected boolean tieneGaraje;
    protected boolean enAlquiler;
    protected boolean enVenta;

    public Vivienda() {
    }

    public Vivienda(int metros, int numeroVentanas, int numeroHabitaciones, String direccion, int metrosTerraza, boolean tienePiscina, boolean tieneGaraje, boolean enAlquiler, boolean enVenta) {
        this.metros = metros;
        this.numeroVentanas = numeroVentanas;
        this.numeroHabitaciones = numeroHabitaciones;
        this.direccion = direccion;
        this.metrosTerraza = metrosTerraza;
        this.tienePiscina = tienePiscina;
        this.tieneGaraje = tieneGaraje;
        this.enAlquiler = enAlquiler;
        this.enVenta = enVenta;
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

    public boolean isEnAlquiler() {
        return enAlquiler;
    }

    public void setEnAlquiler(boolean enAlquiler) {
        this.enAlquiler = enAlquiler;
    }

    public boolean isEnVenta() {
        return enVenta;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }

    @Override
    public String toString() {
        return "--- Vivienda ---"
                + "\nmetros=" + metros
                + "\nnumeroVentanas=" + numeroVentanas
                + "\nnumeroHabitaciones=" + numeroHabitaciones
                + "\ndireccion=" + direccion
                + "\nmetrosTerraza=" + metrosTerraza
                + "\ntienePiscina=" + tienePiscina
                + "\ntieneGaraje=" + tieneGaraje
                + "\nenAlquiler=" + enAlquiler
                + "\nenVenta=" + enVenta;
    }

}
