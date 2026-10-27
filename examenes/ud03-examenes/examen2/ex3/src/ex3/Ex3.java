package ex3;

/**
 *
 * @author daw
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// 3. (5 puntos) Pida al usuario el número de filas y columnas de una matriz (entre 4 y 10) para cada dimensión). Se
//requiere control de errores mediante rango válido (0,5 puntos) y mediante try/catch (0,5 puntos).

//(0,5 puntos) Rellene la matriz con letras aleatorias del abecedario y preséntala en consola manteniendo un
//espacio de separación entre letra.

//(1 puntos) Solicita al usuario una letra e indica el número de ocurrencias de la misma:

//(2,5 puntos) Realiza un conteo de las ocurrencias de cada una de las letras del abecedario. Para ello, por
//ejemplo, puedes utilizar el array abecedario y otro array de la misma dimensión para cumplimentar el conteo de
//ocurrencias. Opción B – alcance menor (1 punto) no te apoyas en este 2º array y realizas el conteo de cada letra
//de forma individual y lo presentas directamente en consola.

        // Array que contiene todas las letras del abecedario
        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // Array donde se almacenará el número de apariciones
        // de cada letra del abecedario
        int[] cantidadLet = new int[26];
        // Variables para almacenar filas y columnas
        int filas;
        int columnas;
        // Variable auxiliar para leer datos por teclado
        String comp;
        // Variable para generar posiciones aleatorias
        int random;
        // Letra que introducirá el usuario para buscar ocurrencias
        String letraOcurr;
        // Contador de apariciones
        int contador = 0;
        // Variable para recorrer el abecedario completo
        int vuelta = 0;

        // Solicitar el número de filas
        System.out.println("Cuantas filas quieres que tenga?");
        do {
            // Leer dato introducido
            comp = System.console().readLine();
            // Validar formato y rango
            filas = rangoCorrecto(comp);
        } while (filas == -1);

        // Solicitar el número de columnas
        System.out.println("Cuantas columnas quieres que tenga?");
        do {
            // Leer dato introducido
            comp = System.console().readLine();
            // Validar formato y rango
            columnas = rangoCorrecto(comp);
        } while (columnas == -1);

        // Crear la matriz con las dimensiones indicadas
        String[][] matAbeced = new String[filas][columnas];
        System.out.println("Matriz generada:");
        // Recorrer las filas de la matriz
        for (int i = 0; i < filas; i++) {
            // Recorrer las columnas de la matriz
            for (int j = 0; j < columnas; j++) {
                // Generar una posición aleatoria entre 0 y 25
                random = (int) (Math.random() * (25 - 0 + 1)) + 0;
                // Guardar una letra aleatoria en la matriz
                matAbeced[i][j] = abecedario[random];
                // Mostrar la letra generada
                System.out.print(matAbeced[i][j] + " ");
            }
            // Salto de línea al terminar cada fila
            System.out.println("");
        }

        // Solicitar una letra para contar ocurrencias
        System.out.println("Introduce la letra para contar ocurrencias");
        // Convertir la letra introducida a mayúscula
        letraOcurr = System.console().readLine().toUpperCase();
        // Recorrer toda la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Comprobar si la letra coincide
                if (matAbeced[i][j].equals(letraOcurr)) {
                    // Incrementar el contador
                    contador++;
                }
            }
        }

        // Mostrar resultado
        System.out.println("La letra " + letraOcurr + " aparece " + contador + " veces.");
        // Reiniciar contador
        contador = 0;
        System.out.println("\nConteo total del abecedario:");
        // Recorrer todas las letras del abecedario
        do {
            // Recorrer toda la matriz
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    // Comprobar si la letra de la matriz coincide
                    // con la letra actual del abecedario
                    if (matAbeced[i][j].equals(abecedario[vuelta])) {
                        // Incrementar contador
                        contador++;
                    }
                    // Guardar las ocurrencias encontradas
                    cantidadLet[vuelta] = contador;
                }
            }

            // Reiniciar contador para la siguiente letra
            contador = 0;
            // Mostrar ocurrencias de la letra actual
            System.out.println(abecedario[vuelta] + ": " + cantidadLet[vuelta]);
            // Pasar a la siguiente letra
            vuelta++;
        } while (vuelta < 26);
    }

    // Función que comprueba que el dato introducido
    // es un número entre 4 y 10
    public static int rangoCorrecto(String comp) {
        int numero;
        try {
            // Convertir el texto a entero
            numero = Integer.parseInt(comp);
        } catch (NumberFormatException e) {
            // Error si no es un número válido
            System.out.println("Formato de número incorrecto.");
            return -1;
        }

        do {
            // Comprobar que está entre 4 y 10
            if ((numero > 3) && (numero < 11)) {
                return numero;
            } else {
                System.out.println("Debe ser un numero entre 4 y 10");
                numero = Integer.parseInt(System.console().readLine());
            }
        } while ((numero > 10) || (numero < 4));
        return numero;
    }
}
