/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainconcesionario.act12;

/**
 *
 * @author juand
 */
public class Auto extends Vahiculo {

    private int cantidadPuertas;

    public Auto(int cantidadPuertas, String marca, String modelo, int anio, Combustible tipoCombustible) {
        super(marca, modelo, anio, tipoCombustible);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("AUTO -> Marca: " + marca
                + ", Modelo: " + modelo
                + ", Año: " + anio
                + ", Combustible: " + tipoCombustible
                + ", Puertas: " + cantidadPuertas);
    }

}
