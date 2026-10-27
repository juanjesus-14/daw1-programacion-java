package arraylist.aleatoriosymedia;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class ArrayListAleatoriosYmedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        double resultado = 0;
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numeros.add((int) (Math.random() * (100 - 0 + 1) + 0));  
            System.out.print(numeros.get(i) + " ");
            resultado = resultado + numeros.get(i);
        }
        System.out.printf("\nLa media es: %.2f ", (resultado / 10));
    }

}
