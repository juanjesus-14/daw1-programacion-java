package ex1;

/**
 *
 * @author daw
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//1. (1,5 puntos) Realiza un programa que rellene un array con 50 números aleatorios comprendidos entre 100 y 1000
//(ambos incluidos) y que muestre por pantalla únicamente los números que terminan en 7 de los introducidos en el
//array (es necesario recorrer el array).

        // Creamos un array de 50 posiciones para almacenar números enteros
        int[] numeros = new int[50];
        // Variable auxiliar para guardar el resultado del cálculo
        int resultado;
        // Valor máximo para generar números aleatorios
        int max = 1000;
        // Valor mínimo para generar números aleatorios
        int min = 100;
        // Mensaje informativo
        System.out.println("Terminan en 7:");
       
        // Recorremos todas las posiciones del array
        for (int i = 0; i < numeros.length; i++) {
            // Generamos un número aleatorio entre 100 y 1000 y lo guardamos en el array
            numeros[i] = (int) (Math.random() * (max - min + 1)) + min;
            // Copiamos el número generado en la variable resultado
            resultado = numeros[i];
            // Obtenemos la última cifra del número usando el operador módulo
            resultado = resultado % 10;
            // Comprobamos si la última cifra es un 7
            if (resultado == 7) {
                // Si termina en 7, mostramos el número por pantalla
                System.out.println(numeros[i]);
            }
        }
    }
}
