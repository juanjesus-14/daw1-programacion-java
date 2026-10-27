/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casa3;

/**
 *
 * @author juand
 */
public class Casa3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];

        // Rellenar matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = (int) (Math.random() * 1000);
            }
        }

        // Mostrar matriz
        System.out.println("MATRIZ:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%03d\t", matriz[i][j]);
                                            //%d → número entero.
                                            //2 → ocupa mínimo 2 posiciones.
                                            //0 → rellena con ceros a la izquierda.
            }
            System.out.println();
        }
    }
}
