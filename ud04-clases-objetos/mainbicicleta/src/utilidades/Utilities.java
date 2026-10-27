package utilidades;

/**
 *
 * @author $(user)
 */
public class Utilities {

    // -------------------------------
    //      OPERACIONES BÁSICAS
    // -------------------------------
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Error: división entre 0.");
            return Double.NaN;
        }
        return a / b;
    }

}
