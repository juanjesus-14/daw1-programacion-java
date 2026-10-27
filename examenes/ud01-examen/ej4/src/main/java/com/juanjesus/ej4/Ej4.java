package com.juanjesus.ej4;

/**
 *
 * @author DAW
 */
public class Ej4 {

    public static void main(String[] args) {

        int modeloA = 30000;
        int modeloB = 36000;
        int bateriaA = 50;
        int bateriaB = 70;
        int bateriaC = 80;
        int bateriaD = 120;
        int precioBateria = 125;
        int paqueteConduccion1 = 1800;
        int paqueteConduccion2 = 0;
        String opcionModelo;
        String opcionBateria;
        String opcionPaquete;
        boolean fin1 = true;
        boolean fin2 = true;

        System.out.println("Seleccione el modelo de coche (a) Modelo 5 (b) Modelo 8:");
        opcionModelo = System.console().readLine();

        switch (opcionModelo) {
            case "a":
                System.out.println("Seleccione el tipo de batería (a) 50 kWh (b) 70 kWh: ");
                opcionBateria = System.console().readLine();

                switch (opcionBateria) {

                    case "a":
                        System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                        System.out.println("Jonda Modelo 5");
                        System.out.println("Precio base: " + modeloA);
                        System.out.println("Bateria de 50 kWh " + (bateriaA * precioBateria));
                        System.out.println("Total: " + (modeloA + (bateriaA * precioBateria)));
                        break;

                    case "b":
                        System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                        System.out.println("Jonda Modelo 5");
                        System.out.println("Precio base: " + modeloA);
                        System.out.println("Bateria de 70 kWh " + (bateriaB * precioBateria));
                        System.out.println("Total: " + (modeloA + (bateriaB * precioBateria)));
                        break;
                }
                break;
            case "b":
                System.out.println("Seleccione el tipo de batería (a) 80 kWh (b) 120 kWh: ");
                opcionBateria = System.console().readLine();

                switch (opcionBateria) {

                    case "a":
                        System.out.println("¿Quiere el paquete de conducción autónoma? (s/n): ");
                        opcionPaquete = System.console().readLine();
                        switch (opcionPaquete) {

                            case "s":

                                System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                                System.out.println("Jonda Modelo 8");
                                System.out.println("Precio base: " + modeloB);
                                System.out.println("Bateria de 80 kWh " + (bateriaC * precioBateria));
                                System.out.println("Con condunccion autonoma: " + paqueteConduccion1);
                                System.out.println("Total: " + (modeloB + (bateriaC * precioBateria) + paqueteConduccion1));
                                break;

                            case "n":

                                System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                                System.out.println("Jonda Modelo 8");
                                System.out.println("Precio base: " + modeloB);
                                System.out.println("Bateria de 80 kWh " + (bateriaC * precioBateria));
                                System.out.println("Sin condunccion autonoma: " + paqueteConduccion2);
                                System.out.println("Total: " + (modeloB + (bateriaC * precioBateria) + paqueteConduccion2));
                                break;
                        }
                        break;

                    case "b":
                        System.out.println("¿Quiere el paquete de conducción autónoma? (s/n): ");
                        opcionPaquete = System.console().readLine();
                        switch (opcionPaquete) {

                            case "s":

                                System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                                System.out.println("Jonda Modelo 8");
                                System.out.println("Precio base: " + modeloB);
                                System.out.println("Bateria de 120 kWh " + (bateriaD * precioBateria));
                                System.out.println("Con condunccion autonoma: " + paqueteConduccion1);
                                System.out.println("Total: " + (modeloB + (bateriaD * precioBateria) + paqueteConduccion1));
                                break;

                            case "n":

                                System.out.println("Gracias. Aquí tiene el presupuesto de su coche.");
                                System.out.println("Jonda Modelo 8");
                                System.out.println("Precio base: " + modeloB);
                                System.out.println("Bateria de 120 kWh " + (bateriaD * precioBateria));
                                System.out.println("Sin condunccion autonoma: " + paqueteConduccion2);
                                System.out.println("Total: " + (modeloB + (bateriaD * precioBateria) + paqueteConduccion2));
                                break;
                        }
                        break;
                }
                break;
        }
    }
}
