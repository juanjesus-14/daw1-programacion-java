package maingeometria;

/**
 *
 * @author $(user)
 */
public interface Geometria {
    
    public double pi = 3.14159;
    
    // por defecto cualquier metodo que defina en un interface es public abstract
    // public abstract double perimetro();  equivalente a  double perimetro();
    
    double perimetro();
    public abstract double area();
    
    default void SoyGeometrico(){
        System.out.println("Estoy en geometria");
    }
}