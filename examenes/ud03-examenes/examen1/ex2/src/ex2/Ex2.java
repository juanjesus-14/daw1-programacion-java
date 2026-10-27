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
//2. (2,5 puntos) Realiza un programa solicite por consola un String en el que dispondremos de números separados
//por “;” y nos debe indicar a continuación si el número introducido es un palíndromo.

//Un palíndromo es una palabra, número, frase o secuencia de caracteres que se lee igual de izquierda a
//derecha que de derecha a izquierda, ignorando espacios, signos de puntuación y mayúsculas.
        //Introduce la cadena:  2;4;3;4;2            //Introduce la cadena:  2;4;4;2             //Introduce la cadena:  2;5;3;4;2
        //Se trata de un palíndromo.                     //Se trata de un palíndromo.                    //No es un palíndromo.
//(0,5 puntos) Control de errores: todas las posiciones deben ser números. Recomendación: realizar mediante
//función (public static boolean verificaArray(int[] números)).
    
        // Variable donde se almacenará la cadena introducida por el usuario
        String cadena;
        // Array de String donde se guardarán los números separados por ";"
        String[] numTexto;

        // Solicitar la cadena al usuario
        System.out.println("Introduce una serie de numeros separados por ;");
        // Leer la cadena introducida
        cadena = System.console().readLine();

        // Comprobar que la cadena contiene el carácter ";"
        if (cadena.contains(";")) {
            // Dividir la cadena en varias posiciones del array
            numTexto = cadena.split(";");
            // Comprobar que todas las posiciones contienen números
            if (!verificaArray(numTexto)) {
                // Mostrar mensaje de error
                System.out.println("Error: todos los valores deben ser numeros");
                // Finalizar el programa
                return;
            }

            // Mostrar la secuencia introducida
            System.out.print("La secuencia ");

            // Recorrer el array y mostrar todos sus elementos
            for (int i = 0; i < numTexto.length; i++) {
                System.out.print(numTexto[i] + " ");
            }

            // Comprobar si la secuencia es un palíndromo
            if (esPalindromo(numTexto)) {
                System.out.println("se trata de un palindromo");
            } else {
                System.out.println("no se trata de un palindromo");
            }
        }
    }

    // Función que verifica que todas las posiciones del array son números
    public static boolean verificaArray(String[] numTexto) {
        try {
            // Recorrer todas las posiciones del array
            for (int i = 0; i < numTexto.length; i++) {
                // Intentar convertir cada posición a entero
                Integer.parseInt(numTexto[i]);
            }
            // Si no hay errores, devolver true
            return true;
        } catch (NumberFormatException e) {
            // Si alguna posición no es numérica, devolver false
            return false;
        }
    }

    // Función que comprueba si la secuencia es un palíndromo
    public static boolean esPalindromo(String[] numTexto) {
        // Variable que apunta a la última posición del array
        int j = numTexto.length - 1;
        // Recorrer únicamente hasta la mitad del array
        for (int i = 0; i < (numTexto.length / 2); i++) {
            // Comparar los elementos de los extremos
            if (!numTexto[j].equals(numTexto[i])) {
                // Si son distintos, no es un palíndromo
                return false;
            }
            // Mover la posición final hacia atrás
            j--;
        }
        // Si todas las comparaciones coinciden, es un palíndromo
        return true;
    }
}
