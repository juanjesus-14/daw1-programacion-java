package ejer3;

import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ejer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        System.out.print("Sistemas Infotmaticos: ");
        int SistemasInformáticos = sc.nextInt();
        System.out.print("Base de datos: ");
        int BaseDeDatos = sc.nextInt();
        System.out.print("Programación: ");
        int Programación = sc.nextInt();
        System.out.print("Lenguajes de marcas y sistema de gestión de información: ");
        int LenguajeDeMArcas = sc.nextInt();
        System.out.print("Itinerario personal para la empleabilidad I: ");
        int IPE = sc.nextInt();
        System.out.print("Digitalización: ");
        int Digitalización = sc.nextInt();
        System.out.print("Sostenibilidad: ");
        int Sostenibilidad = sc.nextInt();
        System.out.println("");

        double media = (SistemasInformáticos + BaseDeDatos + Programación + LenguajeDeMArcas + IPE + Digitalización + Sostenibilidad) / 7;
        System.out.println("Nota media: " + media);

        sc.close();
    }
}
