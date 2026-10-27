package maingeometria;

/**
 *
 * @author $(user)
 */
public class Circulo implements Geometria {

    private double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return (radio * radio * Geometria.pi);
    }

    @Override
    public double perimetro() {
        return (2 * pi * radio);
    }
}