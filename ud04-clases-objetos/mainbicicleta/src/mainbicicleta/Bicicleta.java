package mainbicicleta;

import java.util.Random;

/**
 *
 * @author $(user)
 */
public class Bicicleta {
    // Creamos nuestro objeto bicicleta

    // Atributos (que definen el estado del objeto)
    private int velocidadActual;
    private int platoActual;
    private int pinonActual;

    // Constructor
    public Bicicleta(int velocidadActual, int platoActual, int pinonActual) {
        this.velocidadActual = velocidadActual;
        this.platoActual = platoActual;
        this.pinonActual = pinonActual;
    }

    // Métodos get - devuelven al main el valor actual del objeto del atributo 
    // oportuno referenciado en el método get
    public int getVelocidadActual() {
        return this.velocidadActual;
    }

    public int getPlatoActual() {
        return this.platoActual;
    }

    public int getPinonActual() {
        return this.pinonActual;
    }

    // Métodos set - establecen el valor del atributo del objeto
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public void setpPlatoActual(int platoActual) {
        this.platoActual = platoActual;
    }

    public void setPinonActual(int pinonActual) {
        this.pinonActual = pinonActual;
    }

    // Métodos - Cambiamos el comportamiento
    public void acelerar() {
        Random aleatorio = new Random();

        this.velocidadActual = this.velocidadActual + aleatorio.nextInt(10) + 1;
    }

    public void frenar() {
        Random aleatorio = new Random();

        this.velocidadActual = this.velocidadActual - (aleatorio.nextInt(10) + 1);
    }

    //Asignará un plato hasta un límite de 3 y un mínimo de 1
    //en caso de no estar en ese rango devuelvo false
    public boolean cambiarPlato(int plato) {
        if (plato < 1 || plato > 3) {
            return false;
        } else {
            this.platoActual = plato;
            return true;
        }
    }

    //Asignará un plato hasta un límite de 12 y un mínimo de 1
    //en caso de no estar en ese rango devuelvo false
    public boolean cambiarPinon(int pinon) {
        if (pinon < 1 || pinon > 12) {
            return false;
        } else {
            this.pinonActual = pinon;
            return true;
        }
    }

    //accion = "+" subirá un plato hasta un límite de 3
    //accion = "-" bajará un plato hasta un límite de 1
    public void cambiarPlato(String accion) {
        if (accion.equals("+")) {
            if (platoActual < 3) {
                platoActual++;
            } else {
                System.out.println("Ya no puedes subir mas de plato");
            }
        } else if (accion.equals("-")) {
            if (platoActual > 1) {
                platoActual--;
            } else {
                System.out.println("Ya no puedes bajar mas de plato");
            }
        }
    }

    //accion = "+" subirá un piñon hasta un límite de 12
    //accion = "-" bajará un piñon hasta un límite de 1
    public void cambiarPinon(String accion) {
        if (accion.equals("+")) {
            if (pinonActual < 12) {
                pinonActual++;
            } else {
                System.out.println("Ya no puedes subir mas de piñon");
            }
        } else if (accion.equals("-")) {
            if (pinonActual > 1) {
                pinonActual--;
            } else {
                System.out.println("Ya no puedes bajar mas de piñon");
            }
        }
    }
}
