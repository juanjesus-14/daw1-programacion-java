package relación.pkg2.ejercicios.ud1.sentencias.de.control;

/**
 *
 * @author DAW
 */
public class Relación2EjerciciosUD1SentenciasDeControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String diaSemana;
        boolean errorDia = true;
        do {
            System.out.println("Escribe el dia de la semana: ");
            diaSemana = System.console().readLine().toLowerCase();
            switch (diaSemana) {
                case "lunes":
                    System.out.println("Entorno de desarrollo");
                    errorDia = false;
                    break;
                case "martes":
                    System.out.println("Digitalizacion");
                    errorDia = false;

                    break;
                case "miercoles":
                    System.out.println("Sistemas informaticos");
                    errorDia = false;
                    break;
                case "jueves":
                    System.out.println("Base de datos");
                    errorDia = false;              
                    break;
                case "viernes":
                    System.out.println("Programacion");
                    errorDia = false;
                    break;
                default:
                    System.out.println("Dia incorrecto escribelo bien");
            }
        }while (errorDia == true);
    }
}
