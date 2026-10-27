package mainbicicleta;

import utilidades.Utilities;

/**
 *
 * @author DAW
 */
public class MainBicicleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Bicicleta bici1 = new Bicicleta(1,1,1);
        Bicicleta bici2 = new Bicicleta(1,1,1);
        Bicicleta bici3 = new Bicicleta(1,1,1);
        Bicicleta bici4 = new Bicicleta(1,1,1);
        
        bici1.acelerar();
        bici2.acelerar();
        bici3.acelerar();
        bici4.acelerar();
        System.out.println("Piñon actual: " + bici1.getPinonActual());
        bici1.cambiarPinon("+");
        System.out.println("Piñon actual: " + bici1.getPinonActual());
        System.out.println("Plato actual: " + bici1.getPlatoActual());
        bici1.cambiarPlato("+");
        System.out.println("Plato actual: " + bici1.getPlatoActual());
        
        // Mostrar estado actual de velocidad de cada bici.
        System.out.println("La velocidad de bici1 es: " + bici1.getVelocidadActual());
        System.out.println("La velocidad de bici2 es: " + bici2.getVelocidadActual());
        System.out.println("La velocidad de bici3 es: " + bici3.getVelocidadActual());
        System.out.println("La velocidad de bici4 es: " + bici4.getVelocidadActual());
    }
}
