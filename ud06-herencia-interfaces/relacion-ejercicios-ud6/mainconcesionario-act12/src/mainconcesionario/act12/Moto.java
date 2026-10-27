/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainconcesionario.act12;

/**
 *
 * @author juand
 */
public class Moto extends Vahiculo {

    private int cilindrada;

    public Moto(int cilindrada, String marca, String modelo, int anio, Combustible tipoCombustible) {
        super(marca, modelo, anio, tipoCombustible);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("MOTO -> Marca: " + marca
                + ", Modelo: " + modelo
                + ", Año: " + anio
                + ", Combustible: " + tipoCombustible
                + ", Cilindrada: " + cilindrada + "cc");
    }

}
