/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainempleados.act6;

/**
 *
 * @author juand
 */
public class Comercial extends Empleados {

    private double comision;

    public Comercial(String nombre, int edad, double salario, double comision) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public boolean plus() {
        if (edad > 30 && comision > 200) {
            salario = salario + PLUS;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Comisión: " + comision;
    }
}
