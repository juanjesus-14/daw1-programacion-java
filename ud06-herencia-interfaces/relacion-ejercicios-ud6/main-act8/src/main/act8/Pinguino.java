/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
public class Pinguino extends AnimalAcuatico {

    public Pinguino(String nombre, int edad) {
        super(nombre, edad, "salada");
    }

    @Override
    public void comer() {
        System.out.println("El pingüino come pescado");
    }

    @Override
    public void dormir() {
        System.out.println("El pingüino duerme de pie");
    }

    @Override
    public void nadar() {
        System.out.println("El pingüino nada rápidamente");
    }
}
