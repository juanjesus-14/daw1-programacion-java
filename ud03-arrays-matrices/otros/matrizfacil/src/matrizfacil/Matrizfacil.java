package matrizfacil;

/**
 *
 * @author DAW
 */
public class Matrizfacil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Ejercicio que solicita por pantalla el número de filas y el número de columnas de una matriz,... crea la matriz y la 
// rellena con números aleatorios y a posteriori la pinta. Deben ser números que van de 0 a 99 y en el caso de que 
// vayamos a pintar números del 0 al 9 le pone un 0 delante.

        //Usar bien:
        //int valorEntero = (int)(Math.floor(Math.random()*(M-N+1)+N));  // Valor entre N y M, ambos incluidos.
        //o bien usando la clase java.util.Random (import java.util.Random;)
        //Random r = new Random(); // r.nextInt(max - min + 1) + min;
        //int valorDado = r.nextInt(10)+1;  // Entre 0 y 10 excluido, más 1, es decir, del 1 al 10 ambos incluidos.
        
        int[][] matriz;
        int filas;
        int columnas;

        // Pedir filas
        do {
            System.out.println("Dime el número de filas:");
            filas = rangoCorrecto(System.console().readLine(), 1, 20);
        } while (filas == -1);

        // Pedir columnas
        do {
            System.out.println("Dime el número de columnas:");
            columnas = rangoCorrecto(System.console().readLine(), 1, 20);
        } while (columnas == -1);

        // Crear matriz
        matriz = new int[filas][columnas];

        // Rellenar matriz con números aleatorios
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 100);
            }
        }

        // Mostrar matriz
        System.out.println("\nMATRIZ:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] < 10) {
                    System.out.print("0" + matriz[i][j] + " ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Función para validar números dentro de un rango
    public static int rangoCorrecto(String texto, int min, int max) {
        int numero;
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto.");
            return -1;
        }
        if (numero < min || numero > max) {
            System.out.println("Valor fuera de rango.");
            return -1;
        }
        return numero;
    }
}
