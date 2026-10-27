/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainanimal;

/**
 *
 * @author juand
 */
public class Perro extends Animal {

    private String Raza;

    public Perro() {
    }

    public Perro(String Raza) {
        this.Raza = Raza;
    }

    public Perro(String Raza, String Nombre, int Edad) {
        super(Nombre, Edad);
        this.Raza = Raza;
    }

@Override
public String toString() {
return super.toString()
+ "\nTipo: Perro"
+ "\nRaza: " + Raza;
}
}
