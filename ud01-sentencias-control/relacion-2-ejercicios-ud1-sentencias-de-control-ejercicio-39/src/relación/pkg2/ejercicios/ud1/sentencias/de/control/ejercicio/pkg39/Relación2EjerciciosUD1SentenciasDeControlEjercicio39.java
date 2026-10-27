package relación.pkg2.ejercicios.ud1.sentencias.de.control.ejercicio.pkg39;

/**
 *
 * @author DAW
 */
public class Relación2EjerciciosUD1SentenciasDeControlEjercicio39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int primerNumero;
        int segundoNumero;
        int tercerNumero;
        
        System.out.println("Escribe el primer numero: ");
        primerNumero = Integer.parseInt(System.console().readLine());
        System.out.println("Escribe el segundo numero: ");
        segundoNumero = Integer.parseInt(System.console().readLine());
        System.out.println("Escribe el tercer numero: ");
        tercerNumero = Integer.parseInt(System.console().readLine());  
        
        if (primerNumero > segundoNumero && primerNumero > tercerNumero) {
            System.out.println(primerNumero +  segundoNumero + tercerNumero);
        } else if (primerNumero < segundoNumero && primerNumero < tercerNumero) {
            System.out.println(segundoNumero + primerNumero + tercerNumero);
        } else {
            System.out.println(tercerNumero + segundoNumero + primerNumero);
        }
    }
    
}
