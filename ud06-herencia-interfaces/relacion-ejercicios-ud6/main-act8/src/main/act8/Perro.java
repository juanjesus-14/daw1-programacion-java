/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
public class Perro extends AnimalTerrestre {

    public Perro(String nombre, int edad) {
        super(nombre, edad, 4);
    }

    @Override
    public void comer() {
        System.out.println("El perro come croquetas");
    }

    @Override
    public void dormir() {
        System.out.println("El perro duerme en su cama");
    }

    @Override
    public void desplazarse() {
        System.out.println("El perro corre por el parque");
    }
}