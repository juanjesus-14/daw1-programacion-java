package com.juanjesus.examenbbdd;

/**
 *
 * @author $(user)
 */
public class Motor {

    private String numSerie ;
    private String potencia;
    private String cilindrada;

    public Motor(String numSerie, String potencia, String cilindrada) {
        this.numSerie = numSerie;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
    }

    public Motor() {
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Motor: " + "numSerie=" + numSerie + ", potencia=" + potencia + ", cilindrada=" + cilindrada ;
    }    
}
