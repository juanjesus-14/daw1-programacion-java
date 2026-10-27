package MainBicicleta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCarrera {

    private static final int MAX_DISTANCIA = 400;

    private List<Bicicleta> participantes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new MainCarrera().menu();
    }

    private void menu() {
        while (true) {
            System.out.println("\n--- MENÚ CARRERA ---");
            System.out.println("1) Añadir participante");
            System.out.println("2) Listar participantes");
            System.out.println("3) Iniciar carrera");
            System.out.println("4) Salir");
            System.out.print("Elige opción: ");
            int opc = leerEntero();
            switch (opc) {
                case 1: altaParticipante(); break;
                case 2: listarParticipantes(); break;
                case 3: iniciarYCorrer(); break;
                case 4: System.out.println("Adiós."); return;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void altaParticipante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Error");
            return;
        }
        System.out.print("Velocidad máxima (10 - 35): ");
        int vmax = leerEntero();
        if (vmax < 10 || vmax > 35) {
            System.out.println("Debe ser entre 10 y 35.");
            return;
        }
        participantes.add(new Bicicleta(nombre, vmax));
        System.out.println("Añadido: " + nombre);
    }

    private void listarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes.");
            return;
        }
        System.out.println("Participantes:");
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println((i+1) + ") " + participantes.get(i));
        }
    }

    private void iniciarYCorrer() {
        if (participantes.isEmpty()) {
            System.out.println("Añade participantes antes de iniciar la carrera.");
            return;
        }

        for (Bicicleta b : participantes) b.iniciarCarrera();

        int n = participantes.size();
        char[][] pista = new char[n][MAX_DISTANCIA];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX_DISTANCIA; j++) pista[i][j] = ' ';
            pista[i][MAX_DISTANCIA - 1] = '|';
        }

        boolean terminado = false;
        int iter = 0;

        while (!terminado) {
            iter++;
            System.out.println("\n--- Iteración " + iter + " ---");

            for (Bicicleta b : participantes) {
                double r = Math.random();
                if (r < 0.45) b.acelerar();
                else if (r < 0.9) b.frenar();
                else { if (Math.random() < 0.5) b.acelerar(); else b.frenar(); }
                b.avanzar();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < MAX_DISTANCIA - 1; j++) pista[i][j] = ' ';
                pista[i][MAX_DISTANCIA - 1] = '|';
            }

            for (int i = 0; i < n; i++) {
                int pos = participantes.get(i).getPosicionX();
                if (pos >= MAX_DISTANCIA) {
                    try {
                        pista[i][MAX_DISTANCIA - 1] = '*'; 
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.err.println("Aviso: no se pudo marcar meta para corredor " + i);
                    }
                    for (int j = 0; j < MAX_DISTANCIA - 1; j++) pista[i][j] = '*';
                } else {
                    int limite = Math.min(pos, MAX_DISTANCIA - 1);
                    for (int j = 0; j < limite; j++) pista[i][j] = '*';
                    if (pos == MAX_DISTANCIA - 1) {
                        try { pista[i][MAX_DISTANCIA - 1] = '*'; }
                        catch (ArrayIndexOutOfBoundsException ex) { }
                    }
                }
            }

          
            int anchoBarra = 50; 
            for (int i = 0; i < n; i++) {
                Bicicleta b = participantes.get(i);
                int pos = b.getPosicionX();
                int llenado = (int) ((pos / (double) MAX_DISTANCIA) * anchoBarra);
                if (llenado < 0) llenado = 0;
                if (llenado > anchoBarra) llenado = anchoBarra;
                StringBuilder barra = new StringBuilder();
                for (int k = 0; k < llenado; k++) barra.append('*');
                for (int k = llenado; k < anchoBarra; k++) barra.append(' ');
                String meta = (pos >= MAX_DISTANCIA) ? " *META* " : "       ";
                System.out.printf("%2d %-12s |%s| %s pos=%d\n", i+1, b.getNombre(), barra.toString(), meta, pos);
            }

            int ganador = -1;
            int mejorPos = -1;
            for (int i = 0; i < n; i++) {
                int pos = participantes.get(i).getPosicionX();
                if (pos >= MAX_DISTANCIA && pos > mejorPos) {
                    mejorPos = pos;
                    ganador = i;
                }
            }

            if (ganador != -1) {
                System.out.println("\n--- CARRERA TERMINADA ---");
                System.out.println("Ganador: " + participantes.get(ganador).getNombre() + " con pos=" + participantes.get(ganador).getPosicionX());
                participantes.sort((a,b) -> Integer.compare(b.getPosicionX(), a.getPosicionX()));
                System.out.println("\nClasificación final:");
                for (int i = 0; i < participantes.size(); i++) {
                    System.out.printf("%d) %s pos=%d\n", i+1, participantes.get(i).getNombre(), participantes.get(i).getPosicionX());
                }
                terminado = true;
                break;
            }

            try {
                Thread.sleep(000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Hilo interrumpido.");
                return;
            }
        } 
    }

    private int leerEntero() {
        while (true) {
            try {
                String linea = sc.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (Exception ex) {
                System.out.print("Introduce un número válido: ");
            }
        }
    }
}
