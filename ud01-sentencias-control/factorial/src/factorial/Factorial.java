package factorial;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int num = 0;
        int result = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero: ");
        num = sc.nextInt();

        if (num > 0) {
            //incremento
            for (int i = 1; i <= num; i++) {
                result = result * i;
                System.out.println(result);
            }
            result = 1;
             //decremento
            for (int i = num; i > 1; i--) {
                result = result * i;
                System.out.println(result);
            }
        }
        
    }

}
