package examenej3;

/**
 *
 * @author DAW
 */
public class ExamenEj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Array que contiene todas las letras del abecedario
        String[] abecedario = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM",
            "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ",
            "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BK", "BL", "BM",
            "BN", "BO", "BP", "BQ", "BR", "BS", "BT", "BU", "BV", "BW", "BX", "BY", "BZ",
            "CA", "CB", "CC", "CD", "CE", "CF", "CG", "CH", "CI", "CJ", "CK", "CL", "CM",
            "CN", "CO", "CP", "CQ", "CR", "CS", "CT", "CU", "CV", "CW", "CX", "CY", "CZ"
        };

        int[] cantidadLet = new int[25 + 78];
        int filas;
        int columnas;
        String comp;

        int random;
        String letraOcurr;
        int contador = 0;
        int vuelta = 0;

        System.out.println("Introduce filas(4-10): ");
        do {
            comp = System.console().readLine();
            filas = rangoCorrecto(comp);
        } while (filas == -1);

        System.out.println("Introduce columnas(4-10): ");
        do {
            comp = System.console().readLine();
            columnas = rangoCorrecto(comp);
        } while (columnas == -1);

        String[][] matAbeced = new String[filas][columnas];
        System.out.println("Matriz generada:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                random = (int) (Math.random() * (25 + 78 - 0 + 1)) + 0;
                matAbeced[i][j] = abecedario[random];

                if (abecedario[random].length() != 2) {
                    System.out.print(" " + matAbeced[i][j] + " ");
                } else {
                    System.out.print(matAbeced[i][j] + " ");
                }
            }
            System.out.println("");
        }

        System.out.println("\nIntroduce elemento abuscar: ");
        letraOcurr = System.console().readLine().toUpperCase();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matAbeced[i][j].equals(letraOcurr)) {
                    contador++;
                }
            }
        }
        System.out.println("Ocurrencia de " + letraOcurr + ": " + contador);
        contador = 0;

        System.out.println("\nCONTEO DE OCURRENCIAS:");
        do {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matAbeced[i][j].equals(abecedario[vuelta])) {
                        contador++;
                    }
                    cantidadLet[vuelta] = contador;
                }
            }

            if (contador != 0) {
                System.out.println(abecedario[vuelta] + "--> " + cantidadLet[vuelta]);
            }
            contador = 0;

            vuelta++;
        } while (vuelta < 25 + 78);
    }

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
}
