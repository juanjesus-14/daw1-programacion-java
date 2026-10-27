package relación.pkg2.ejercicios.ud1.sentencias.de.control.ejercicio.pkg29;

/**
 *
 * @author DAW
 */
public class Relación2EjerciciosUD1SentenciasDeControlEjercicio29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int hora;
        System.out.println("Escribe la hora del dia: ");
        hora = Integer.parseInt(System.console().readLine());

        if (hora > 6 && hora < 12) {
            System.out.println("Es por la mañana");
        } else if (hora >= 12 && hora < 19) {
            System.out.println("Es por la tarde");
        } else {
            System.out.println("Es por la noche");
        }

    }

}
