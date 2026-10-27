package com.juanjesus.maininventarioit;

/**
 *
 * @author $(user)
 */
public class PC extends Ordenador {

    private int potenciaFuente;
    private String tipoFormato;
    private boolean incluyeMonitor;

//Constructor
    public PC() {
    }

    public PC(int idInventario, int potenciaFuente, String tipoFormato, String marca, String modelo, int ram, String procesador, double precio, boolean incluyeMonitor) {
        super(idInventario, marca, modelo, ram, procesador, precio);
        this.potenciaFuente = potenciaFuente;
        this.tipoFormato = tipoFormato;
    }

    //getter y setter
    public int getPotenciaFuente() {
        return potenciaFuente;
    }

    public void setPotenciaFuente(int potenciaFuente) {
        this.potenciaFuente = potenciaFuente;
    }

    public String getTipoFormato() {
        return tipoFormato;
    }

    public void setTipoFormato(String tipoFormato) {
        this.tipoFormato = tipoFormato;
    }

    public boolean isIncluyeMonitor() {
        return incluyeMonitor;
    }

    public void setIncluyeMonitor(boolean incluyeMonitor) {
        this.incluyeMonitor = incluyeMonitor;
    }

    // Metodos 
    @Override
    public String arrancandoEquipoOpcion1() {
        return "arrancando el PC";
    }

    // Metodos 
    @Override
    public String tipoOrdenador() {
        return "Soy un ordenador. Formato: " + this.tipoFormato;
    }

    public void ampliaTipoFormato(String infoFormato) {
        this.tipoFormato = tipoFormato + ", " + infoFormato;
    }

    @Override
    public Double precioFinal() {
        double precioFinal = 0;
        precioFinal = (this.incluyeMonitor ? (this.precio + 125) : this.precio);
        return precioFinal;
    }

    @Override
    public String arrancandoEquipo() {
        return "arrancando el PC";
    }

    //Metodos
    @Override
    public String toString() {
        return "-- Portatil --"
                + "\nMarca= " + marca
                + "\nModelo= " + modelo
                + "\nRam= " + ram
                + "\nProcesador= " + procesador
                + "\nPrecio= " + precio
                + "\nPotencia Fuente= " + potenciaFuente
                + "\nTipo Formato= " + tipoFormato
                + "\nIncluye Monitor= " + (this.incluyeMonitor ? "Si" : "No");
    }

    //equals
    //incluyeMonitor fuese un String incluyeMonitor (con valor S/N)
//            return "-- Portatil --"
//                + "\nMarca= " + marca
//                + "\nModelo= " + modelo
//                + "\nRam= " + ram
//                + "\nProcesador= " + procesador
//                + "\nPrecio= " + precio
//                + "\nPotencia Fuente= " + potenciaFuente
//                + "\nTipo Formato= " + tipoFormato
//                +"\nIncluye Monitor= " + (this.incluyeMonitor.equals("S") ? "Si" : "No");
//    }
}
