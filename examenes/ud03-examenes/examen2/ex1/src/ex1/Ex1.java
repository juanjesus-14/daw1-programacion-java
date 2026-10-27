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

        // Array que contiene todas las letras del abecedario
        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        // Array donde se almacenarán las 10 letras aleatorias
        String[] letras = new String[10];

        // Variables para generar números aleatorios
        int random;
        int max = 25;
        int min = 0;

        // Rellenar el array de letras aleatorias
        for (int i = 0; i < letras.length; i++) {
            // Generar una posición aleatoria entre 0 y 25
            random = (int) (Math.random() * (max - min + 1)) + min;
            // Guardar la letra correspondiente en el nuevo array
            letras[i] = abecedario[random];
        }

        // Mostrar el contenido del array
        for (int i = 0; i < letras.length; i++) {
            // Mostrar coma después de cada letra excepto la última
            if (i < letras.length - 1) {
                System.out.print(letras[i] + ", ");
            } else {
                System.out.print(letras[i]);
            }
        }
        
        //-----------------------------------------------   
        System.out.println("\n");
        //Forma rapida
        String[] abecedario1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int random1;
        int max1 = 25;
        int min1 = 0;
        for (int i = 0; i < 10; i++) {
            random1 = (int) (Math.random() * (max1 - min1 + 1)) + min1;
            System.out.print(abecedario1[random1]);
            if (i < 9) {
                System.out.print(", ");
            }
        }
        //--------------------------------------------------
    }
}
