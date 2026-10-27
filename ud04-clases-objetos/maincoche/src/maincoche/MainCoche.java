package maincoche;

/**
 *
 * @author DAW
 */
public class MainCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Opción1
        Coche c1 = new Coche("Ferrari-Testarosa", "rojo", 180, "R20");

        System.out.println(c1.toString());
        
        c1.arrancar();
        c1.girarRuedas();
        
        System.out.println("\n");
        // Opción 2
        Motor motor = new Motor(150);
        Rueda[] ruedas = {new Rueda("R19"), new Rueda("R19"),
            new Rueda("R19"), new Rueda("R19")};

        Coche c2 = new Coche("Ferrari-F-40", "rojo", motor, ruedas);

        System.out.println(c2.toString());
        
        c2.arrancar();
        c2.girarRuedas();
        System.out.println("Estado motor: " + c1.toStringMotor());

    }

}
