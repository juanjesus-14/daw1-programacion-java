/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainempleados.act6;

/**
 *
 * @author juand
 */
public abstract class Empleados {

    protected String nombre;
    protected int edad;
    protected double salario;

    public double PLUS = 300;

    public Empleados(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método abstracto
    public abstract boolean plus();

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + ", Edad: " + edad
                + ", Salario: " + salario;
    }
}
