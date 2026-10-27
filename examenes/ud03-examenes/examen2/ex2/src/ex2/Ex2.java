package ex2;

/**
 *
 * @author daw
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//2. (3 puntos) Programa que genere un array de 10 números aleatorios entre 1 y 20 y que se muestre por pantalla
//(manteniendo 2 dígitos por posición), después deberá mostrarte el mayor, menor y la media.

//Salida esperada:
//Números generados: 03,17,09,20,11,04,15,08,19,02
//Mayor: 20
//Menor: 2
//Media: 10.80

        // Array donde se almacenarán los números aleatorios
        int[] numeros = new int[10];
        // Valor mínimo para generar aleatorios
        int minRand = 1;
        // Valor máximo para generar aleatorios
        int maxRand = 20;
        // Variable donde se almacenará el número aleatorio generado
        int random;
        // Variables para guardar el menor y el mayor número
        int menor = 0;
        int mayor = 0;
        // Variable para calcular la media
        double media = 0;
        System.out.print("Numeros generados: ");

        // Recorrer las 10 posiciones del array
        for (int i = 0; i < 10; i++) {
            // Generar un número aleatorio entre 1 y 20
            random = (int) (Math.random() * (maxRand - minRand + 1)) + minRand;
            // Guardar el número en el array
            numeros[i] = random;

            // Mostrar siempre dos cifras
            if (numeros[i] < 10) {
                System.out.print("0" + numeros[i]);
            } else {
                System.out.print(numeros[i]);
            }

            // Mostrar coma excepto en el último elemento
            if (i < 9) {
                System.out.print(", ");
            } else {
                System.out.println("");
            }
            
            // Acumular los números para calcular la media
            media += numeros[i];
            // Primera posición del array
            if (i == 0) {
                menor = numeros[i];
                mayor = numeros[i];
            } else {
                // Comprobar si es el menor número encontrado
                if (numeros[i] < menor) {
                    menor = numeros[i];
                }
                // Comprobar si es el mayor número encontrado
                if (numeros[i] > mayor) {
                    mayor = numeros[i];
                }
            }
        }
        // Mostrar el mayor número
        System.out.println("Mayor: " + mayor);
        // Mostrar el menor número
        System.out.println("Menor: " + menor);
        // Mostrar la media con dos decimales
        System.out.printf("Media: %.2f", (media / 10));
        System.out.println("");
    }
}
