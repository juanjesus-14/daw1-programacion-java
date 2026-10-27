package saludos;
import java.util.Scanner;
        
/**
 *
 * @author DAW
 */
public class Saludos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String nombre;
        
        Scanner buffer = new Scanner(System.in);
        
        System.out.println("Escribe tu nombre: ");
        
        nombre = buffer.nextLine();
        
        System.out.println("Bienvenido " + nombre + ", encantado de saludarte");
    }
    
}
