package mainequipofutbol2;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainEquipoFutbol2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Equipo e1 = new Equipo("Málaga CF", "Rosaleda", 30044, "P.º Martiricos, s/n", "Málaga", "Segunda división", false);
//        Equipo e2 = new Equipo("Real Betis", "Benito Villamarin", 60000, "Av. de la Palmera 1", "Sevilla", "Primera división", false);
//
//        System.out.println(e1);
//        System.out.println(e2);
//        Estadisticas e1 = new Estadisticas(4, 7, 1, 2, 5);
//
//        Jugador j1 = new Jugador(21, 70.5, 1.80, Estadisticas);
//        System.out.println(j1);

        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        int opcion = -1;
        do {
            System.out.println("----------Menu----------");
            System.out.println("1.- Añadir un equipo.");
            System.out.println("2.- Mostrar equipos.");
            System.out.println("3.- Dar de Alta un jugador.");
            System.out.println("4.- Dar de Baja un jugador.");
            System.out.println("5.- Mostrar jugadores.");
            System.out.println("6.- Salir.");

            opcion = Integer.parseInt(System.console().readLine());

            Equipo temp1;
            Jugador temp2;
            String nombre;

            switch (opcion) {
                case 1:
                    temp1 = new Equipo();

                    System.out.println("--- Menu Equipos ---");
                    System.out.println("Dime el nombre del equipo.");
                    temp1.setNombreEquipo(System.console().readLine());
                    System.out.println("Dime el nombre del estadio.");
                    temp1.setNombreEstadio(System.console().readLine());
                    temp1.setEspectadores(obtenNumeroEntero("Dime número de espectadores."));
                    System.out.println("Dime la direccion del estadio.");
                    temp1.setDireccion(System.console().readLine());
                    System.out.println("Dime la ciudad del equipo.");
                    temp1.setCiudad(System.console().readLine());
                    System.out.println("Dime la division en la ue se encuentra el equipo.");
                    temp1.setDivision(System.console().readLine());
                    System.out.println("Dime si el equipo asciende o no(S/N).");
                    temp1.setAsciende(System.console().readLine().toLowerCase().equals("s") ? true : false);
                    break;

                case 2:
                    System.out.println("Los equipos que tenemos actualmente son: \n");
                    System.out.println(listaEquipos);
                    break;

                case 3:
                    temp2 = new Jugador();
                    
                    System.out.println("--- Menu Jugadores ---");
                    System.out.println("Dime el nombre.");
                    temp2.setNombreJugador(System.console().readLine());
                    temp2.setEdad(obtenNumeroEntero("Dime la edad."));
                    temp2.setPeso(obtenNumeroEntero("Dime el peso."));
                    temp2.setAltura(obtenNumeroEntero("Dime la altura."));
                    System.out.println("Estadisticas:");
                    temp2.setGoles(obtenNumeroEntero("Dime los goles."));
                    temp2.setPartidosJugados(obtenNumeroEntero("Dime los partidos jugados."));
                    temp2.setTarjetasAmarillas(obtenNumeroEntero("Dime las tarjetas amarillas."));
                    temp2.setTarjetasRojas(obtenNumeroEntero("Dime las tarjetas rojas."));
                   
                    listaJugadores.add(temp2);
                    break;

                case 4:
                    System.out.println("Introduce el nombre para eliminar:");
                    nombre = System.console().readLine();
                    for (int i = 0; i < listaJugadores.size(); i++) {
                        if (listaJugadores.get(i).getNombreJugador().equals(nombre)) {
                            listaJugadores.remove(i);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Los jugadores que tenemos actualmente son: \n");
                    System.out.println(listaJugadores);
                    break;

                case 6:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opción inválida");

            }
        } while (opcion != 6);
    }

// Fuera del main
    public static int obtenNumeroEntero(String mensaje) {
        int numero = -1;
        do {
            System.out.println(mensaje);
            try {
                numero = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }

    public static double obtenNumeroDouble(String mensaje) {
        double numero = -1;
        do {
            System.out.println(mensaje);
            try {
                numero = Double.parseDouble(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                numero = -1;
            }
        } while (numero == -1);
        return numero;
    }
}
