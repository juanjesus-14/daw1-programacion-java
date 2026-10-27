/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
public abstract class AnimalTerrestre extends Animal {

    private int numeroPatas;

    public AnimalTerrestre(String nombre, int edad, int numeroPatas) {
        super(nombre, edad);
        this.numeroPatas = numeroPatas;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public abstract void desplazarse();
}
