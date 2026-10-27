package mainequipofutbol;

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

        Equipo e1 = new Equipo("Málaga CF", "Rosaleda", 30044, "P.º Martiricos, s/n", "Málaga", "Segunda división", false);
        Equipo e2 = new Equipo("Real Betis", "Benito Villamarin", 60000, "Av. de la Palmera 1", "Sevilla", "Primera división", false);

        System.out.println(e1);
        System.out.println(e2);

    }

}
