package relación.pkg2.ejercicios.ud1.sentencias.de.control.ej30;

/**
 *
 * @author DAW
 */
public class Relación2EjerciciosUD1SentenciasDeControlEj30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int diaSemana;
        boolean numeroDia = true;

        do {
            try {
                System.out.println("Escribe un numero del 1 al 7:");
                diaSemana = Integer.parseInt(System.console().readLine());
                switch (diaSemana) {
                    case 1:
                        System.out.println("Lunes");
                        numeroDia = false;
                        break;
                    case 2:
                        System.out.println("Martes");
                        numeroDia = false;
                        break;
                    case 3:
                        System.out.println("Miercoles");
                        numeroDia = false;
                        break;
                    case 4:
                        System.out.println("Jueves");
                        numeroDia = false;
                        break;
                    case 5:
                        System.out.println("Viernes");
                        numeroDia = false;
                        break;
                    case 6:
                        System.out.println("Sabado");
                        numeroDia = false;
                        break;
                    case 7:
                        System.out.println("Domingo");
                        numeroDia = false;
                        break;
                    default:
                        System.out.println("Numero incorrecto");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, escribe un numero entre el 1 y el 7");
            }
        } while (numeroDia == true);
    }
}
