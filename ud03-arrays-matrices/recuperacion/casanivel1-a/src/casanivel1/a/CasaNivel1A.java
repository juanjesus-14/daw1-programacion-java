/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casanivel1.a;

/**
 *
 * @author juand
 */
public class CasaNivel1A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Array de 20 posiciones
        int[] numeros = new int[20];

        // ==========================
        // GENERAR NÚMEROS ALEATORIOS
        // ==========================
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100) + 1;
        }

        // ==========================
        // MOSTRAR TODOS LOS NÚMEROS
        // ==========================
        System.out.println("----- TODOS LOS NÚMEROS -----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("%02d ", numeros[i]);
        }

        // ==========================
        // ORDENAR ARRAY DE MENOR A MAYOR
        // ==========================
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    int aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        // Mostrar array ordenado
        System.out.println("\n\n----- ARRAY ORDENADO -----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("%02d ", numeros[i]);
        }

        System.out.println("\nMenor (ordenado): " + numeros[0]);
        System.out.println("Mayor (ordenado): " + numeros[numeros.length - 1]);

        // ==========================
        // VARIABLES AUXILIARES
        // ==========================
        int mayor = numeros[0];
        int menor = numeros[0];

        int posMayor = 0;
        int posMenor = 0;

        int suma = 0;

        int contPares = 0;
        int contImpares = 0;

        int sumaPares = 0;
        int sumaImpares = 0;

        // ==========================
        // RECORRIDO GENERAL
        // ==========================
        for (int i = 0; i < numeros.length; i++) {
            // Buscar mayor
            if (numeros[i] > mayor) {
                mayor = numeros[i];
                posMayor = i;
            }

            // Buscar menor
            if (numeros[i] < menor) {
                menor = numeros[i];
                posMenor = i;
            }

            // Acumular suma total
            suma += numeros[i];

            // Contar pares e impares
            if (numeros[i] % 2 == 0) {
                contPares++;
                sumaPares += numeros[i];
            } else {
                contImpares++;
                sumaImpares += numeros[i];
            }

        }

        // ==========================
        // MOSTRAR PARES
        // ==========================
        System.out.println("\n\n----- NÚMEROS PARES -----");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.printf("%02d ", numeros[i]);
            }
        }

        // ==========================
        // MOSTRAR IMPARES
        // ==========================
        System.out.println("\n\n----- NÚMEROS IMPARES -----");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.printf("%02d ", numeros[i]);
            }
        }

        // ==========================
        // MOSTRAR PRIMOS
        // ==========================
        System.out.println("\n\n----- NÚMEROS PRIMOS -----");
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                System.out.print(numeros[i] + " ");
            }
        }

        // ==========================
        // CALCULAR MEDIA
        // ==========================
        double media = (double) suma / numeros.length;

        // ==========================
        // MOSTRAR ESTADÍSTICAS
        // ==========================
        System.out.println("\n\n----- ESTADÍSTICAS -----");

        System.out.println("Mayor: " + mayor);
        System.out.println("Posición mayor: " + posMayor);

        System.out.println("Menor: " + menor);
        System.out.println("Posición menor: " + posMenor);

        System.out.printf("Media: %.2f\n", media);

        System.out.println("Cantidad pares: " + contPares);
        System.out.println("Cantidad impares: " + contImpares);

        System.out.println("Suma pares: " + sumaPares);
        System.out.println("Suma impares: " + sumaImpares);

        // ==========================
        // BUSCAR NÚMERO
        // ==========================
        System.out.println("\nNúmero a buscar:");
        int buscar = Integer.parseInt(System.console().readLine());
        boolean encontrado = false;
        int veces = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscar) {
                encontrado = true;
                veces++;
            }
        }
        if (encontrado) {
            System.out.println("El número existe.");
            System.out.println("Aparece " + veces + " veces.");
        } else {
            System.out.println("El número no existe.");
        }
    }

// Función que comprueba si un número es primo
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
}
