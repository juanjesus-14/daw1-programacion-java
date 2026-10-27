package relación.pkg2.ejercicios.ud1.sentencias.de.control.ejercicio.pkg31;

/**
 *
 * @author DAW
 */
public class Relación2EjerciciosUD1SentenciasDeControlEjercicio31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int precioHora = 10;
        int precioHoraExtra = 15;
        int numeroHoras;        
        int numeroHorasExtras;

        System.out.println("Escribe el numero de horas: ");
        numeroHoras = Integer.parseInt(System.console().readLine());
        System.out.println("Escribe el numero de horas extra: ");
        numeroHorasExtras = Integer.parseInt(System.console().readLine());
        
        System.out.println("El sueldo total es: " + ((numeroHoras*precioHora) + (numeroHorasExtras*precioHoraExtra)));
    }
    
}
