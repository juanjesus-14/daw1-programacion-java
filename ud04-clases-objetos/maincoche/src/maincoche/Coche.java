package maincoche;

/**
 *
 * @author $(user)
 */
public class Coche {

    private String modelo;
    private String color;
    private Motor motor;
    private Rueda[] ruedas;

    //Opcion 1
    public Coche(String modelo, String color, int potencia, String diametro) {
        this.modelo = modelo;
        this.color = color;

        Motor motor = new Motor(potencia);

        this.motor = motor;

        Rueda[] ruedas = {new Rueda(diametro), new Rueda(diametro),
            new Rueda(diametro), new Rueda(diametro)};

        this.ruedas = ruedas;
    }

    //Opcion 2
    public Coche(String modelo, String color, Motor motor, Rueda[] ruedas) {
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.ruedas = ruedas;
    }

    public void arrancar() {
        System.out.println("Arrancar motor!!");
        this.motor.encenderMotor();
    }

    public void apagar() {
        System.out.println("Parar motor!!");
        this.motor.apagarMotor();
    }

    public void girarRuedas() {
        System.out.println("El coche empieza a moverse, giramos ruedas: ");
        for (int i = 0; i < this.ruedas.length; i++) {
            System.out.print("Rueda" + (i + 1) + ". ");
            this.ruedas[i].girar();
        }

    }

    @Override
    public String toString() {
        return "Os presento mi coche!!!\nModelo: " + this.modelo + "\nColor: " + this.color + "\n" + this.motor.toString() + "\nRuedas(diametro): " + this.ruedas[0].getDiametro();

    }

    public String toStringMotor() {
        return this.motor.toString();
    }
}
