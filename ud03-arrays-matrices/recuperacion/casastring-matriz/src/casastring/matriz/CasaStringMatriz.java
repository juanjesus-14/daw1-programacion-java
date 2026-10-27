/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casastring.matriz;

/**
 *
 * @author juand
 */
public class CasaStringMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ==========================
        // MATRIZ DE ALUMNOS
        // ==========================
        String[][] alumnos = {
            {"Juan", "DAW1", "APROBADO"},
            {"Ana", "DAW1", "SUSPENSO"},
            {"Pedro", "DAW2", "APROBADO"},
            {"Lucia", "DAW1", "SUSPENSO"},
            {"Sergio", "DAW2", "APROBADO"}
        };

        // ==========================
        // MOSTRAR MATRIZ
        // ==========================
        System.out.println("----- LISTADO DE ALUMNOS -----");
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < alumnos[0].length; j++) {
                System.out.print(alumnos[i][j] + "\t");
            }
            System.out.println();
        }

        // ==========================
        // BUSCAR ALUMNO
        // ==========================
        System.out.println("\nNombre a buscar:");
        String buscar = System.console().readLine();
        boolean encontrado = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (buscar.equalsIgnoreCase(alumnos[i][0])) {
                encontrado = true;
                System.out.println("\nAlumno encontrado:");
                System.out.println("Nombre: " + alumnos[i][0]);
                System.out.println("Curso: " + alumnos[i][1]);
                System.out.println("Edad: " + alumnos[i][2]);
            }
        }
        if (!encontrado) {
            System.out.println("Alumno no encontrado.");
        }

        // ==========================
        // CONTAR ALUMNOS DAW1
        // ==========================
        int contDAW1 = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i][1].equalsIgnoreCase("DAW1")) {
                contDAW1++;
            }
        }
        System.out.println("\nAlumnos DAW1: " + contDAW1);

        // ==========================
        // ALUMNO MÁS MAYOR
        // ==========================
        int edadMayor = Integer.parseInt(alumnos[0][2]);
        String nombreMayor = alumnos[0][0];
        for (int i = 0; i < alumnos.length; i++) {
            int edad = Integer.parseInt(alumnos[i][2]);
            if (edad > edadMayor) {
                edadMayor = edad;
                nombreMayor = alumnos[i][0];
            }
        }
        System.out.println("\nAlumno mayor:");
        System.out.println(nombreMayor + " (" + edadMayor + " años)");

        // ==========================
        // MEDIA DE EDADES
        // ==========================
        int sumaEdades = 0;
        for (int i = 0; i < alumnos.length; i++) {
            sumaEdades += Integer.parseInt(alumnos[i][2]);
        }
        double media = (double) sumaEdades / alumnos.length;
        System.out.printf("\nMedia edades: %.2f\n", media);

        // ==========================
        // ORDENAR ALFABÉTICAMENTE
        // ==========================
        for (int i = 0; i < alumnos.length - 1; i++) {
            for (int j = i + 1; j < alumnos.length; j++) {
                if (alumnos[i][0].compareToIgnoreCase(alumnos[j][0]) > 0) {
                    String[] aux = alumnos[i];
                    alumnos[i] = alumnos[j];
                    alumnos[j] = aux;
                }
            }
        }

        // ==========================
        // MOSTRAR ORDENADOS
        // ==========================
        System.out.println("\n----- ORDENADOS -----");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i][0] + " - " + alumnos[i][1] + " - " + alumnos[i][2]);
        }

        // ==========================
        // MOSTRAR NOMBRES AL REVÉS
        // ==========================
        System.out.println("\n----- NOMBRES AL REVÉS -----");
        for (int i = 0; i < alumnos.length; i++) {
            String nombre = alumnos[i][0];
            for (int j = nombre.length() - 1; j >= 0; j--) {
                System.out.print(nombre.charAt(j));
            }
            System.out.println();
        }
    }
}
