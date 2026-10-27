package funcionjava;

import java.util.Scanner;

public class Funcionjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String opcionBateria;
        String opcionModelo = escribeMensajeOp("Seleccione el modelo de coche (a) Modelo 5 (b) Modelo 8: ");

        if (opcionModelo.equals("a")) {
            opcionBateria = escribeMensajeOp("Seleccione el tipo de bateria (a) 50 kWh (b) 70 kWh: ");
            muestraPresupuesto(opcionModelo, opcionBateria);
        } else if (opcionModelo.equals("b")) {
            opcionBateria = escribeMensajeOp("Selecciona el tipo de bateria (a) 80 kWh (b) 120 kWh: ");
            muestraPresupuesto(opcionModelo, opcionBateria);
        } else {
            System.out.println("Debes elegir una opcion (a/b).");
        }
    }

    public static String escribeMensajeOp(String mensaje) {
        System.out.println(mensaje);
        return System.console().readLine().toLowerCase();
    }

    public static void muestraPresupuesto(String opcionModelo, String opcionBateria) {
        int modelo5 = 30000;
        int modelo8 = 36000;
        int preciokWh = 125;
        int conduccionAutonoma = 1800;

        if (opcionModelo.equals("a")) {

            if (opcionBateria.equals("a")) {
                System.out.println("Aqui tiene el presupuesto: ");
                System.out.println("Modelo 5.");
                System.out.println("Precio base= " + modelo5 + " euros.");
                System.out.println("Bateria de 50 kWh= " + (50 * preciokWh) + " euros.");
                System.out.println("Total= " + (modelo5 + (50 * preciokWh)) + " euros.");
            } else if (opcionBateria.equals("b")) {
                System.out.println("Aqui tiene el presupuesto: ");
                System.out.println("Modelo 5.");
                System.out.println("Precio base= " + modelo5 + " euros.");
                System.out.println("Bateria de 70 kWh= " + (70 * preciokWh) + " euros.");
                System.out.println("Total= " + (modelo5 + (70 * preciokWh)) + " euros.");
            } else {
                System.out.println("Debes elegir una opcion (a/b).");
            }
        } else if (opcionModelo.equals("b")) {

            String opcionAutonoma = escribeMensajeOp("¿Quiere el paquete de conduccion autonoma? (s/n): ");
            System.out.println("Aqui tiene el presupuesto: ");

            if (opcionBateria.equals("a")) {
                System.out.println("Modelo 8.");
                System.out.println("Precio base= " + modelo8 + " euros.");
                System.out.println("Bateria de 80 kWh= " + (80 * preciokWh) + " euros.");
                if (opcionAutonoma.equals("s")) {
                    System.out.println("Paquete de conduccion autonoma= " + conduccionAutonoma + " euros.");
                } else if (opcionAutonoma.equals("n")) {
                    System.out.println("Sin paquete de conduccion autonoma= 0 euros");
                } else {
                    System.out.println("Debes elegir una opcion (s/n).");
                }
                System.out.println("Total= " + (modelo8 + (80 * preciokWh)) + " euros");
            } else if (opcionBateria.equals("b")) {
                System.out.println("Modelo 8.");
                System.out.println("Precio base= " + modelo8 + " euros.");
                System.out.println("Bateria de 120 kWh= " + (120 * preciokWh) + " euros.");
                if (opcionAutonoma.equals("s")) {
                    System.out.println("Paquete de conduccion autonoma= " + conduccionAutonoma + " euros.");
                } else if (opcionAutonoma.equals("n")) {
                    System.out.println("Sin paquete de conduccion autonoma= 0 euros.");
                } else {
                    System.out.println("Debes elegir una opcion (s/n).");
                }
                System.out.println("Total= " + (modelo8 + (120 * preciokWh)) + " euros.");
            } else {
                System.out.println("Debes elegir una opcion (a/b).");
            }
        }
    }
}
