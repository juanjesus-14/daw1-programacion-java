/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
public class Gato extends AnimalTerrestre {

    public Gato(String nombre, int edad) {
        super(nombre, edad, 4);
    }

    @Override
    public void comer() {
        System.out.println("El gato come pienso");
    }

    @Override
    public void dormir() {
        System.out.println("El gato duerme muchas horas");
    }

    @Override
    public void desplazarse() {
        System.out.println("El gato camina sigilosamente");
    }
}