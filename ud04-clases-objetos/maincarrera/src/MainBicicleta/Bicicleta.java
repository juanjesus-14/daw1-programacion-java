package MainBicicleta;

import java.util.Random;

public class Bicicleta {

    private String nombre;
    private int velocidadActual;
    private int velocidadMaxima;
    private int posicionActual;

    private Random numero = new Random();

    public Bicicleta(String nombre, int velocidadMaxima) {
        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
        this.posicionActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getPosicionX() {
        return posicionActual;
    }

    // iniciarCarrera: velocidad mínima de inicio = 5
    public void iniciarCarrera() {
        this.velocidadActual = 5;
    }

    // acelerar: suma aleatorio 1-5 sin pasar de velocidadMaxima
    public void acelerar() {
        int a = numero.nextInt(5) + 1; // 1..5
        velocidadActual += a;
        if (velocidadActual > velocidadMaxima) {
            velocidadActual = velocidadMaxima;
        }
    }

    // frenar: resta aleatorio 1-5 sin bajar de 0
    public void frenar() {
        int d = numero.nextInt(5) + 1;
        velocidadActual -= d;
        if (velocidadActual < 0) {
            velocidadActual = 0;
        }
    }

    // avanzar: posicionX += velocidadActual
    public void avanzar() {
        posicionActual += velocidadActual;
    }

    @Override
    public String toString() {
        return nombre + " (vel=" + velocidadActual + "/" + velocidadMaxima + " pos=" + posicionActual + ")";
    }
}
