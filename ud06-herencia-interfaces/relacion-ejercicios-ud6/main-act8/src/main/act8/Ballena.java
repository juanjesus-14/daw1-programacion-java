/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
public class Ballena extends AnimalAcuatico {

    public Ballena(String nombre, int edad) {
        super(nombre, edad, "salada");
    }

    @Override
    public void comer() {
        System.out.println("La ballena se alimenta de krill");
    }

    @Override
    public void dormir() {
        System.out.println("La ballena duerme parcialmente mientras nada");
    }

    @Override
    public void nadar() {
        System.out.println("La ballena nada majestuosamente");
    }
}

