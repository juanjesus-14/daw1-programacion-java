package mainordenador;

/**
 *
 * @author DAW
 */
public class MainOrdenador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Clase Ordenador
        // Incluye atributos típicos: marca, modelo, RAM, procesador, precio y si es portátil o no.        
        //2 constructores 1 sin parametros y otro con todos los parametros

        Ordenador o1 = new Ordenador();
        System.out.println(o1.toString());

        Ordenador o2 = new Ordenador("Asus", "Alurin", 8, "i7 13th", 500.50, false);
        System.out.println(o2.toString());

        Ordenador o3 = new Ordenador("HP", "Inspiron", 16, "i5 12th", 300.50, true);
        System.out.println(o3.toString());

    }

}
