/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainanimal;

/**
 *
 * @author juand
 */
public class Caballo extends Animal {

    private String Raza;

    public Caballo() {
    }

    public Caballo(String Raza) {
        this.Raza = Raza;
    }

    public Caballo(String Raza, String Nombre, int Edad) {
        super(Nombre, Edad);
        this.Raza = Raza;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Caballo"
                + "\nRaza: " + Raza;
    }
}
