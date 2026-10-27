/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Tienda {

    // Atributos
    private String cif;
    private String nombre;
    private ArrayList<Categoria> estructura;

    // Constructor completo
    public Tienda(String cif, String nombre) {

        this.cif = cif;
        this.nombre = nombre;

        // Inicializar ArrayList
        estructura = new ArrayList<>();
    }

    // Constructor vacío
    public Tienda() {

        estructura = new ArrayList<>();
    }

    // Getter cif
    public String getCif() {
        return cif;
    }

    // Setter cif
    public void setCif(String cif) {
        this.cif = cif;
    }

    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter estructura
    public ArrayList<Categoria> getEstructura() {
        return estructura;
    }

    // Setter estructura
    public void setEstructura(
            ArrayList<Categoria> estructura) {

        this.estructura = estructura;
    }

    // Añadir categoría
    public boolean asignaCategoria(Categoria c) {

        if (c != null) {

            estructura.add(c);

            return true;
        }

        return false;
    }

    // Mostrar categorías
    public void listaCategorias() {

        for (Categoria c : estructura) {

            System.out.println(c);
        }
    }

    // Mostrar información tienda
    @Override
    public String toString() {

        return "Tienda: " + nombre
                + "\nCIF: " + cif
                + "\nNúmero categorías: "
                + estructura.size();
    }

}
