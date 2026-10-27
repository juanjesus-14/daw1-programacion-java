package aleatoriosymultiplos;

/**
 *
 * @author DAW
 */
public class AleatoriosYMultiplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Realiza un programa que rellene un array con 20 números aleatorios comprendidos entre 1 y 100
        //(ambos incluidos) y que los muestre por pantalla. A continuación, el programa deberá mostrar por
        //separado los múltiplos de 2, de 3 y de 5.

        // Crear array de 20 posiciones
        int[] numeros = new int[20];

        int min = 1;
        int max = 100;

        // Rellenar array con aleatorios
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        // Mostrar números generados
        System.out.println("Números generados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println();

        // Mostrar múltiplos
        calculaMultiplos(numeros, 2);
        calculaMultiplos(numeros, 3);
        calculaMultiplos(numeros, 5);
        calculaMultiplos(numeros, 7);
    }

    // Función que muestra los múltiplos de un valor
    public static void calculaMultiplos(int[] numeros, int valor) {
        String resultado = "";
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % valor == 0) {
                if (resultado.isEmpty()) {
                    resultado = String.valueOf(numeros[i]);
                } else {
                    resultado = resultado + ", " + numeros[i];
                }
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("No hay múltiplos de " + valor);
        } else {
            System.out.println("Múltiplos de " + valor + ": " + resultado);
        }
    }
}
