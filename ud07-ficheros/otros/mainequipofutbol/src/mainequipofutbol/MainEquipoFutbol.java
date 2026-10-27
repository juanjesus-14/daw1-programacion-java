package mainequipofutbol;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author DAW
 */
public class MainEquipoFutbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Jugador> lista = new LinkedList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("equiposFutbol.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String posicion = datos[2];
                int dorsal = Integer.parseInt(datos[3]);
                int edad = Integer.parseInt(datos[4]);

                Jugador j = new Jugador(id, nombre, posicion, dorsal, edad);

                lista.add(j);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }

        System.out.println("LISTADO DE JUGADORES");

        for (Jugador j : lista) {
            System.out.println(j);
        }
    }
}
