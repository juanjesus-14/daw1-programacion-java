package com.juanjesus.maininventarioit;

/**
 *
 * @author $(user)
 */
public abstract class Ordenador {
    protected int idInventario;
    protected String marca;
    protected String modelo;
    protected int ram;
    protected String procesador;
    protected double precio;

    // constructores
    public Ordenador() {
    }

    public Ordenador(int idInventario, String marca, String modelo, int ram, String procesador, double precio) {
        this.idInventario=idInventario;
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.procesador = procesador;
        this.precio = precio;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    //getter and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Ordenador{" + "ID="+ idInventario + "marca=" + marca + ", modelo=" + modelo + ", ram=" + ram + ", procesador=" + procesador + ", precio=" + precio + '}';
    }
    
    public String arrancandoEquipoOpcion1(){
        return "arrancando el ordenador";
    }
    
    // Metodos 
    public abstract String tipoOrdenador();
    public abstract String arrancandoEquipo();
    public abstract Double precioFinal();
    
}
