package com.juanjesus.maininventarioit;

/**
 *
 * @author $(user)
 */
public class Portatil extends Ordenador {

    private double peso;
    private int autonomiaBateria; // horas
    private boolean garantia;

    // constructores
    public Portatil() {
    }

    public Portatil(int idInventario, double peso, int autonomiaBateria, String marca, String modelo, int ram, String procesador, double precio, boolean garantia) {
        super(idInventario, marca, modelo, ram, procesador, precio);
        this.peso = peso;
        this.autonomiaBateria = autonomiaBateria;
        this.garantia = garantia;
    }

    // Getters y setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAutonomiaBateria() {
        return autonomiaBateria;
    }

    public void setAutonomiaBateria(int autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    // Metodos
    //como modificamos un atributo que heredamos de la clase padre
    //opcion 1. - Usemos diferectamente el atributo heredado
    public void ampliarRam(
            int ramQueAmplio) {
        this.ram = this.ram + ramQueAmplio;
    }

    //opcion 2. - Recomendada porque al usar setter o metodos de la clae padre 
    //estoy utilizando correctamente la encapsulacion
    public void establecerRam(int ramQueInstalo) {
        this.setRam(ramQueInstalo);
    }

    //opcion 3. - Utiliamos directamente la llamda super para acceder al padre.
    public void establecerRam2(int ramQueInstalo) {
        super.ram = ramQueInstalo;
    }

    // Metodos 
    @Override
    public String arrancandoEquipoOpcion1() {
        return "arrancando el portatil";
    }

    // Metodos 
    @Override
    public String tipoOrdenador() {
        return "Soy un portatil. Marca: " + this.marca + ", modelo: " + this.modelo;
    }

    @Override
    public String arrancandoEquipo() {
        return "arrancando el PC";
    }

    @Override
    public Double precioFinal() {
        //Vamos a incrementar el precio de objeto en 50€ si tiene garantia
//        Double precioFinal = 0;
//        if (this.garantia == true) {
//            precioFinal = this.precio + 50;
//        } else {
//            precioFinal = this.precio;
//        }
//        return precioFinal;
//    }
        double precioFinal = 0;
        precioFinal = (this.garantia ? (this.precio + 50) : this.precio);
        return precioFinal;
    }

    @Override
    public String toString() {
        return "-- Portatil --"
                + "\nMarca=" + marca
                + "\nModelo=" + modelo
                + "\nRam=" + ram
                + "\nProcesador=" + procesador
                + "\nPrecio= " + precio
                + "\nPeso= " + peso
                + "\nAutonomiaBateria= " + autonomiaBateria
                + "\nGarantia= " + (garantia ? "Si" : "No");
    }

}
