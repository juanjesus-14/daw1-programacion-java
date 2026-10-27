
package maingeometria;

/**
 *
 * @author $(user)
 */
public class Triangulo implements Geometria{
    private double base, altura; // Triangulo rectangulo

    public Triangulo() {
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

@Override
    public double area() {
        return (this.base * this.altura)/2;
    }

    @Override
    public double perimetro() {
        return 1;
    }
}
