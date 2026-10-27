/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8.equipobaloncesto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Ejercicio8EquipoBaloncesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      EJERCICIO 8—Equipo Baloncesto.
//      Crear las clases (con los atributos que consideres oportunos): Equipo, Jugador, Cancha, Ranking.
//      Debes tener en cuenta que 1 equipo se compone de X jugadores y de 1 cancha.
      
Scanner sc = new Scanner(System.in);
        ArrayList<Equipo> equipos = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("1) Añadir equipo 2) Añadir jugador a equipo 3) Asignar cancha 4) Listar equipos 0) Salir");
            int opt = Integer.parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Nombre equipo: ");
                    equipos.add(new Equipo(sc.nextLine()));
                    break;
                case 2:
                    System.out.print("Equipo (index): ");
                    int idx = Integer.parseInt(sc.nextLine());
                    if (idx >= 0 && idx < equipos.size()) {
                        System.out.print("Nombre jugador: ");
                        String nombre = sc.nextLine();
                        System.out.print("Dorsal: ");
                        int dorsal = Integer.parseInt(sc.nextLine());
                        System.out.print("Posición: ");
                        String pos = sc.nextLine();
                        equipos.get(idx).agregarJugador(new Jugador(nombre, dorsal, pos));
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Equipo (index): ");
                    idx = Integer.parseInt(sc.nextLine());
                    if (idx >= 0 && idx < equipos.size()) {
                        System.out.print("Nombre cancha: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ciudad: ");
                        String ciudad = sc.nextLine();
                        System.out.print("Capacidad: ");
                        int cap = Integer.parseInt(sc.nextLine());
                        equipos.get(idx).setCancha(new Cancha(nombre, ciudad, cap));
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    for (int i = 0; i < equipos.size(); i++) {
                        System.out.println(i + ") " + equipos.get(i));
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
