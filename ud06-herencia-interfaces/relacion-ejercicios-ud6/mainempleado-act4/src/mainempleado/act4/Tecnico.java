/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainempleado.act4;

/**
 *
 * @author juand
 */
public class Tecnico extends Operario {

    public Tecnico() {
        super();
    }

    public Tecnico(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return super.toString() + " -> Tecnico";
    }
}
