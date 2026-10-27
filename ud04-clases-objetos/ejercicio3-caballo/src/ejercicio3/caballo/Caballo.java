/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.caballo;

/**
 *
 * @author juand
 */
public class Caballo {

    private String raza;
    private String color;
    private double peso;
    private int edad;
    private boolean[] herraduras = new boolean[4];

    public Caballo() {
    }

    public Caballo(String raza, String color, double peso, int edad) {
        this.raza = raza;
        this.color = color;
        this.peso = peso;
        this.edad = edad;
        for (int i = 0; i < 4; i++) {
            herraduras[i] = false;
        }
    }

    public void come(String alimento) {
        System.out.println(raza + " come " + alimento);
    }

    public void camina() {
        System.out.println(raza + " está caminando.");
    }

    public void relincha() {
        System.out.println(raza + " relincha: ¡hiiii!");
    }

    public void daCoz() {
        System.out.println(raza + " da una coz.");
    }

    public void ponerHerradura(int posicion) {
        if (posicion < 0 || posicion > 3) {
            System.out.println("Posición inválida (0..3).");
            return;
        }
        herraduras[posicion] = true;
        System.out.println("Herradura puesta en pata " + posicion);
    }

    @Override
    public String toString() {
        int cont = 0;
        for (boolean h : herraduras) {
            if (h) {
                cont++;
            }
        }
        return "Caballo{"
                + "raza='" + raza + '\''
                + ", color='" + color + '\''
                + ", peso=" + peso
                + ", edad=" + edad
                + ", herradurasPuestas=" + cont
                + '}';
    }
}
