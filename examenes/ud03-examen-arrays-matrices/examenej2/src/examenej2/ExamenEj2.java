package examenej2;

/**
 *
 * @author DAW
 */
public class ExamenEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] numeros = new int[10];
        int minRand = 10;
        int maxRand = 999;
        int random;
        int menor = 0;
        int mayor = 0;
        double media = 0;
        System.out.print("Numeros generados: ");

        for (int i = 0; i < 10; i++) {
            random = (int) (Math.random() * (maxRand - minRand + 1)) + minRand;
            numeros[i] = random;

            media += numeros[i];
            if (i == 0) {
                menor = numeros[i];
                mayor = numeros[i];
            } else {
                if (numeros[i] < menor) {
                    menor = numeros[i];
                }
                if (numeros[i] > mayor) {
                    mayor = numeros[i];
                }
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("%03d ", numeros[i]);
        }
        System.out.println("\n\nMayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.printf("Media: %.2f", (media / 10));
        System.out.println("");
    }
}
