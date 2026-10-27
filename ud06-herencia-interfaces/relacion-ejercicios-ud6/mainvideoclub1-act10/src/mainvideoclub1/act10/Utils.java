package mainvideoclub1.act10;

/**
 *
 * @author $(user)
 */
public class Utils {

    public static int obtenNumeroEntero(String mensaje) {
        int numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

    public static double obtenNumeroDouble(String mensaje) {
        double numero = -1;
        do {
            System.out.print(mensaje);
            try {
                numero = Double.parseDouble(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

}
