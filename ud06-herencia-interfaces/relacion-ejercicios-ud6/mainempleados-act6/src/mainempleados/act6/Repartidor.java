/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainempleados.act6;

/**
 *
 * @author juand
 */
public class Repartidor extends Empleados {

    private String zona;

    public Repartidor(String nombre, int edad, double salario, String zona) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public boolean plus() {
        if (edad < 25 && zona.equalsIgnoreCase("zona 3")) {
            salario = salario + PLUS;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Zona: " + zona;
    }
}
