/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.act8;

/**
 *
 * @author juand
 */
    public abstract class AnimalAcuatico extends Animal {

    private String tipoAgua; // dulce o salada

    public AnimalAcuatico(String nombre, int edad, String tipoAgua) {
        super(nombre, edad);
        this.tipoAgua = tipoAgua;
    }

    public String getTipoAgua() {
        return tipoAgua;
    }

    public abstract void nadar();
}