/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4.ventana;

/**
 *
 * @author juand
 */
public class Ventana {

    private String color;
    private String tamano;
    private String titulo;
    private String nomAplicacion;
    private boolean abierta;
    private boolean minimizada;

    public Ventana(String color, String tamano, String titulo, String nomAplicacion) {
        this.color = color;
        this.tamano = tamano;
        this.titulo = titulo;
        this.nomAplicacion = nomAplicacion;
        this.abierta = false;
        this.minimizada = false;
    }

    public void abre() {
        abierta = true;
        minimizada = false;
        System.out.println("La ventana '" + titulo + "' se ha abierto.");
    }

    public void cierra() {
        abierta = false;
        minimizada = false;
        System.out.println("La ventana '" + titulo + "' se ha cerrado.");
    }

    public void minimiza() {
        if (abierta) {
            minimizada = true;
            System.out.println("La ventana '" + titulo + "' está minimizada.");
        } else {
            System.out.println("No se puede minimizar una ventana cerrada.");
        }
    }

    public void aumenta() {
        if (abierta) {
            System.out.println("La ventana '" + titulo + "' ha sido maximizada.");
        } else {
            System.out.println("No se puede maximizar una ventana cerrada.");
        }
    }

    public void alinear(String tipo) {
        System.out.println("La ventana '" + titulo + "' se alinea a: " + tipo + ".");
    }

    public void redimensiona(String nuevoTamano) {
        this.tamano = nuevoTamano;
        System.out.println("La ventana '" + titulo + "' ha cambiado a tamaño: " + nuevoTamano + ".");
    }

    @Override
    public String toString() {
        return "Ventana {"
                + "color='" + color + '\''
                + ", tamaño='" + tamano + '\''
                + ", titulo='" + titulo + '\''
                + ", nomAplicacion='" + nomAplicacion + '\''
                + ", abierta=" + abierta
                + ", minimizada=" + minimizada
                + '}';
    }
}
