package ex3;

import java.util.Random;

/**
 *
 * @author daw
 */
public class Ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//(1,5 puntos) Solicita al usuario el número entre 2 y 10 para el cual quieres obtener sus múltiplos y muestra los
//elementos que se han encontrado que son múltiplos del número introducido:

//(0,5 puntos) Genera una matriz de modo que cada elemento sea el doble del valor existente en cada posición de
//la matriz inicial y muéstrala.
//Control de errores: números en el rango de lo solicitado.
//Ejemplo:
//01 19 13
//45 04 25
//16 88 09
//Número introducido el 5.
//Salida: “Los múltiplos de 5 son: 45, 25”
//002 038 026
//090 008 050
//032 176 018

        // Matriz donde se almacenarán los números aleatorios
        int[][] matrizAleatorios;
        // Objeto para generar números aleatorios
        Random numAleatorio = new Random();

        // Número para buscar sus múltiplos
        int valor;
        // Variables para almacenar filas y columnas
        int tamFilas;
        int tamColum;

        // Pedir número de filas entre 2 y 10
        do {
            System.out.println("Introduce la cantidad de filas entre 2 y 10: ");
            tamFilas = Integer.parseInt(System.console().readLine());
            if ((tamFilas > 10) || (tamFilas < 2)) {
                System.out.println("Tiene que ser un numero entre 2 y 10");
            }
        } while ((tamFilas > 10) || (tamFilas < 2));

        // Pedir número de columnas entre 2 y 10
        do {
            System.out.println("Introduce la cantidad de columnas entre 2 y 10");
            tamColum = Integer.parseInt(System.console().readLine());
            if ((tamColum > 10) || (tamColum < 2)) {
                System.out.println("Tiene que ser un numero entre 2 y 10");
            }
        } while ((tamColum > 10) || (tamColum < 2));

        // Crear la matriz con las dimensiones indicadas
        matrizAleatorios = new int[tamFilas][tamColum];

        // Rellenar la matriz con números aleatorios entre 0 y 99
        for (int i = 0; i < tamFilas; i++) {
            for (int j = 0; j < tamColum; j++) {
                matrizAleatorios[i][j] = numAleatorio.nextInt(100);
                // Mostrar los números con dos cifras
                if (matrizAleatorios[i][j] < 10) {
                    System.out.print(" 0" + matrizAleatorios[i][j]);
                } else {
                    System.out.print(" " + matrizAleatorios[i][j]);
                }
            }
            // Salto de línea al terminar cada fila
            System.out.println("");
        }

        // Pedir el número del que se quieren obtener los múltiplos
        do {
            System.out.println("Introduce un valor entre 2 y 10 para sacar sus multiplos");
            valor = Integer.parseInt(System.console().readLine());
            if ((valor > 10) || (valor < 2)) {
                System.out.println("Tiene que ser un numero entre 2 y 10");
            }
        } while ((valor > 10) || (valor < 2));

        // Llamar a la función que busca los múltiplos
        calculaMultiplos(matrizAleatorios, tamFilas, tamColum, valor);

        // Mostrar la matriz con todos sus valores multiplicados por 2
        for (int i = 0; i < tamFilas; i++) {
            for (int j = 0; j < tamColum; j++) {
                // Si tiene tres cifras se muestra directamente
                if ((matrizAleatorios[i][j] * 2) > 99) {
                    System.out.print(" " + matrizAleatorios[i][j] * 2);
                    // Si tiene dos cifras se añade un cero delante
                } else if (((matrizAleatorios[i][j] * 2) < 100)  && ((matrizAleatorios[i][j] * 2) > 9)) {
                    System.out.print(" 0" + matrizAleatorios[i][j] * 2);
                    // Si tiene una cifra se añaden dos ceros delante
                } else {
                    System.out.print(" 00" + matrizAleatorios[i][j] * 2);
                }
            }
            // Salto de línea al terminar cada fila
            System.out.println("");
        }
    }

    // Función que busca todos los múltiplos del número introducido
    public static void calculaMultiplos(int[][] matrizAleatorios, int tamFilas, int tamColum, int valor) {
        // Variable donde se almacenarán los múltiplos encontrados
        String resultado = "";
        // Recorrer toda la matriz
        for (int i = 0; i < tamFilas; i++) {
            for (int j = 0; j < tamColum; j++) {
                // Evitar que el 0 aparezca como múltiplo
                if (matrizAleatorios[i][j] != 0) {
                    // Comprobar si el número es múltiplo
                    if ((matrizAleatorios[i][j] % valor) == 0) {
                        // Primer múltiplo encontrado
                        if (resultado.isBlank()) {
                            resultado = String.valueOf(matrizAleatorios[i][j]);
                        } else {
                            // Añadir el resto separados por comas
                            resultado = resultado + ", " + matrizAleatorios[i][j];
                        }
                    }
                }
            }
        }
        // Si no se han encontrado múltiplos
        if (resultado.isBlank()) {
            System.out.println("No hay multiplos de " + valor);
        } else {
            // Mostrar los múltiplos encontrados
            System.out.println("\nLos multiplos de " + valor + " son: " + resultado + "\n");
        }
    }
}
