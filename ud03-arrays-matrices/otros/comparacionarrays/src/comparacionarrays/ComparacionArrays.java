package comparacionarrays;

import java.util.Arrays;

/**
 *
 * @author DAW
 */
public class ComparacionArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array1;
        int[] array2 = {5, 6, 7, 6, 7, 8};
        System.out.println("Longitud: " + array2.length);
        String[] array3 = {"BD", "LLMM", "Programacion", "SI", "Entornos", "IP"};
        int[] array4 = {5, 6, 7, 6, 7, 8};
        array1 = array4;

        System.out.println(array1 == array4);
        System.out.println(array2 == array4);
        System.out.println(array1.equals(array4));

        System.out.println(Arrays.equals(array2, array4));

        System.out.println("Son iguales¿?" + comparaArrays(array2, array4));

    }

  public static boolean comparaArrays(int[] array1, int[] array2) {

        if (array1.length != array2.length) {
            return false;
        }


        // Opción try catch
        boolean comparacion = true;
        try {
            for (int i = 0; i <= array1.length; i++) {
                if (array2[i] == array2[i]) {
                    System.out.println("Las notas son iguales");
                } else {
                    comparacion = false;
                    System.out.println("No son la misma nota");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return comparacion;
    }
}
