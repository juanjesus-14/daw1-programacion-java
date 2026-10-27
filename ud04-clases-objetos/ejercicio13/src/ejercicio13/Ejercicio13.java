/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio13;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio 13: 
//        Realiza de nuevo la entrega de la clase cuenta, mejorando la versión anterior. Debes además sobrecargar el 
//        método toString para visualizar las actualizaciones en la cuenta y realizar un manejo de errores en la 
//        lectura de los datos con bloques try-catch. 
        ArrayList<Cuenta> lista = new ArrayList<>();

        // Menú
        int opcion = -1;

        try {
            do {
                System.out.println("----------Menú----------");
                System.out.println("1.- Crear cuenta.");
                System.out.println("2.- Accede a tu cuenta.");
                System.out.println("3.- Salir");

                try {
                    opcion = Integer.parseInt(System.console().readLine());
                } catch (NumberFormatException e) {
                    //System.out.println("Por favor, introduce una opción válida.");
                    opcion = -1;
                }

                switch (opcion) {
                    case 1:
                        Cuenta temp;
                        String nombre;
//            Cuenta c1 = new Cuenta("Jose Miguel", "0183-1234-56-1234567890", 2.1, 500.0);
                        System.out.println("Dime tu nombre para darte de alta:");
                        nombre = System.console().readLine();
                        temp = new Cuenta(nombre);
                        lista.add(temp);
                        System.out.println("Su cuenta ha sido creada."
                                + "\n" + temp);
                        break;
                    case 2:
                        System.out.println("Dime tu password:");
                        String password = System.console().readLine();
                        // "0183-1234-56-00000" + password y esto lo buscamos en la lista.
                        for (int i = 0; i < lista.size(); i++) {
                            // Si localizo la cuenta, saco el menú 2
                            if (lista.get(i).getNumeroCuenta().equals("0183-1234-56-00000" + password)) {
                                // Menú de operaciones en la cuenta
                                int opcion2 = -1;
                                do {
                                    System.out.println("---Menú - Operaciones---");
                                    System.out.println("1.- Ingreso.");
                                    System.out.println("2.- Reintegro.");
                                    System.out.println("3.- Transferencia.");
                                    System.out.println("4.- Situación cuenta.");
                                    System.out.println("5.- Salir");

                                    try {
                                        opcion2 = Integer.parseInt(System.console().readLine());
                                    } catch (NumberFormatException e) {
                                        //System.out.println("Introduce una opción válida.");
                                        opcion2 = -1;
                                    }
                                    double money = 0;
                                    boolean operacionOK = false;
                                    switch (opcion2) {
                                        case 1:
                                            System.out.println("Dinero a ingresar:");
                                            money = Double.parseDouble(System.console().readLine());
                                            lista.get(i).ingreso(money);
                                            break;
                                        case 2:
                                            System.out.println("Dinero a retirar:");
                                            money = Double.parseDouble(System.console().readLine());
                                            operacionOK = lista.get(i).reintegro(money);
                                            if (operacionOK) {
                                                System.out.println("Reintegro realizado correctamente.");
                                            } else {
                                                System.out.println("No tiene dinero suficiente en cuenta.");
                                            }
                                            break;
                                        case 3:
                                            // Transferencia.
                                            System.out.println("Dinero a transferir:");
                                            money = Double.parseDouble(System.console().readLine());
                                            System.out.println("Dime la cuenta destino:");
                                            String cuentaDestino = System.console().readLine();
                                            for (int j = 0; j < lista.size(); j++) {
                                                // si localizo la cuenta destino, podré realizar la transferencia.
                                                if (lista.get(j).getNumeroCuenta().equals("0183-1234-56-00000" + cuentaDestino)) {
                                                    operacionOK = lista.get(i).transferencia(lista.get(j), money);
                                                    if (operacionOK) {
                                                        System.out.println("Transferencia realizada correctamente.");
                                                    } else {
                                                        System.out.println("No tiene dinero suficiente en cuenta para la transferencia.");
                                                    }
                                                } else if (j == lista.size() && (!lista.get(j).getNumeroCuenta().equals("0183-1234-56-00000" + cuentaDestino))) {
                                                    System.out.println("Cuenta destino no encontrada.");
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.println("El estado actual de tu cuenta es:");
                                            System.out.println(lista.get(i));
                                            break;
                                        case 5:
                                            System.out.println("Operaciones finalizadas.");
                                            break;
                                        default:
                                            System.out.println("Introduce una opción correcta.");
                                    }
                                } while (opcion2 != 5);
                            } else if ((i == lista.size() - 1) && (!lista.get(i).getNumeroCuenta().equals("0183-1234-56-00000" + password))) {
                                System.out.println("Cuenta no encontrada.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Gracias por utilizar nuestro banco.");
                        break;
                    default:
                        System.out.println("La opción introducida no es correcta");
                }
            } while (opcion != 3);
        } catch (Exception e) {
            System.out.println("Cajero no disponible.");
        }

    }

}

