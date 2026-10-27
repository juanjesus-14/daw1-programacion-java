/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listafunciones;

/**
 *
 * @author juand
 */
public class ListaFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // ==========================
        // PROBAR verificaArray()
        // ==========================
        System.out.println("PRUEBA verificaArray");

        String[] texto = {"12", "45", "78"};

        System.out.println(verificaArray(texto));

        // ==========================
        // PROBAR esPalindromo()
        // ==========================
        System.out.println("\nPRUEBA esPalindromo");

        String[] palindromo = {"1", "2", "3", "2", "1"};

        System.out.println(esPalindromo(palindromo));

        // ==========================
        // PROBAR calculaMedia()
        // ==========================
        System.out.println("\nPRUEBA calculaMedia");

        int[] notas = {5, 8, 7, 10, 6};

        System.out.println("Media: " + calculaMedia(notas));

        // ==========================
        // PROBAR esPrimo()
        // ==========================
        System.out.println("\nPRUEBA esPrimo");

        System.out.println("7 es primo: " + esPrimo(7));

        System.out.println("10 es primo: " + esPrimo(10));

        // ==========================
        // PROBAR calculaMultiplos()
        // ==========================
        System.out.println("\nPRUEBA calculaMultiplos");

        int[][] matriz = {
            {2, 4, 6},
            {8, 10, 12},
            {15, 20, 25}
        };

        calculaMultiplos(matriz, 3, 3, 5);

        // ==========================
        // PROBAR numRepetido()
        // ==========================
        System.out.println("\nPRUEBA numRepetido");

        int[][] matrizRepetidos = {
            {1, 2},
            {3, 4}
        };

        System.out.println("Existe el 3: "
                + numRepetido(matrizRepetidos, 3));

        System.out.println("Existe el 7: "
                + numRepetido(matrizRepetidos, 7));

        // ==========================
        // PROBAR rangoCorrecto(min,max)
        // ==========================
        System.out.println("\nPRUEBA rangoCorrecto(min,max)");

        System.out.println(rangoCorrecto("5", 0, 10));

        System.out.println(rangoCorrecto("15", 0, 10));

    }

    // Función que verifica que todas las posiciones del array son números
    public static boolean verificaArray(String[] numTexto) {
        try {
            for (int i = 0; i < numTexto.length; i++) {
                Integer.parseInt(numTexto[i]);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Función que comprueba si la secuencia es un palíndromo
    public static boolean esPalindromo(String[] numTexto) {
        int j = numTexto.length - 1;
        for (int i = 0; i < (numTexto.length / 2); i++) {
            if (!numTexto[j].equals(numTexto[i])) {
                return false;
            }
            j--;
        }
        return true;
    }

    //Función para mostrar los múltiplos de un número introducido por el usuario.
    public static void calculaMultiplos(int[][] matrizAleatorios, int tamFilas, int tamColum, int valor) {
        String resultado = "";
        for (int i = 0; i < tamFilas; i++) {
            for (int j = 0; j < tamColum; j++) {
                if (matrizAleatorios[i][j] != 0) {
                    if ((matrizAleatorios[i][j] % valor) == 0) {
                        if (resultado.isBlank()) {
                            resultado = String.valueOf(matrizAleatorios[i][j]);
                        } else {
                            resultado = resultado + ", " + matrizAleatorios[i][j];
                        }
                    }
                }
            }
        }
        if (resultado.isBlank()) {
            System.out.println("No hay multiplos de " + valor);
        } else {
            System.out.println("\nLos multiplos de " + valor + " son: " + resultado + "\n");
        }
    }

    // Función que comprueba que el dato introducido es un número entre 4 y 10
    public static int rangoCorrecto(String comp) {
        int numero;
        try {
            numero = Integer.parseInt(comp);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto.");
            return -1;
        }

        do {
            if ((numero > 3) && (numero < 11)) {
                return numero;
            } else {
                System.out.println("Debe ser un numero entre 4 y 10");
                numero = Integer.parseInt(System.console().readLine());
            }
        } while ((numero > 10) || (numero < 4));
        return numero;
    }

    //Funcion para calcular la media
    public static double calculaMedia(int[] notas) {
        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media = media + notas[i];
            System.out.println("Tu nota " + (i + 1) + " es : " + notas[i]);
        }
        return media / notas.length;
    }

    //Funcion para comprobar si un numero es primo o no
    public static boolean esPrimo(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Comprueba si un número ya existe en la matriz
    public static boolean numRepetido(int[][] matriz, int numAleatorio) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == numAleatorio) {
                    return true;
                }
            }
        }
        return false;
    }

    // Función que comprueba formato y rango
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
