package com.juanjesus.examenbbdd;

/**
 *
 * @author $(user)
 */
public class Coche extends Vehiculo {

    private String bastidor;
    private Motor motor; // null si no tiene revision registrada
    private String numSerieMotor;

    public Coche(String bastidor, String marca, String modelo, String color, String numSerieMotor) {
        super(marca, modelo, color);
        this.bastidor = bastidor;
        this.numSerieMotor = numSerieMotor;
        this.motor = new Motor();
    }

    public Coche() {
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getNumSerieMotor() {
        return numSerieMotor;
    }

    public void setNumSerieMotor(String numSerieMotor) {
        this.numSerieMotor = numSerieMotor;
    }

    public void setMotor(Motor m) {
        this.motor = m;
    }

    //Métodos
    public boolean asignaMotor(String numSerie, String potencia, String cilindrada) {
        boolean asignado = false;
        this.motor.setNumSerie(numSerie);
        this.motor.setPotencia(potencia);
        this.motor.setCilindrada(cilindrada);
        asignado = true;
        return asignado;
    }

    public void setnumSerieMotor(String numSerie) {
        if (!numSerie.isEmpty()) {
            this.motor.setNumSerie(numSerie);
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBastidor: " + bastidor
                + (this.numSerieMotor == null ? "\n - No tiene motor." : "\n" + motor);
    }

}
