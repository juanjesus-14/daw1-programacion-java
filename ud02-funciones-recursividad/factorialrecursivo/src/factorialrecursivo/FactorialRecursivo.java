package factorialrecursivo;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class FactorialRecursivo {

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
            result = factorial(num);
        }
    }

    public static int factorial(int num) {
        // Recursividad lo importante es definir los casos base 
        if (num == 0 || num == 1) {
            return 1;
        } else {
            int result = num * factorial(num - 1);
            System.out.println(result);
            return result;
        }
    }
}
