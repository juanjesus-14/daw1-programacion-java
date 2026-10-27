package com.juanjesus.maininventarioit;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainInventarioIT {

    public static void main(String[] args) {
        // Ejercicio Herencia: Ordenador -> Portátil-Sobremesa

        //creacion manual
        PC pc1 = new PC(1, 650, "ATX", "Asus", "ROG Stix", 32, "Ryzen 7", 1499.99, true);
        Portatil portatil1 = new Portatil(1, 1.45, 10, "HP", "Pavilion 15", 16, "Intel i7", 899.99, false);

        System.out.println(pc1);
        System.out.println(portatil1);

        //creacion mediante menu (ArrayList). Crea PC, Crea Portatil, elimina, lista
        ArrayList<Ordenador> inventario = new ArrayList<>();
        String opcion;
        boolean terminar = false;
        String SiNo;
        int id = 0;

        do {
            System.out.println("-- Menu --");
            System.out.println("Pulsa 1 para dar de alta un ordenador, pulsa 2 para dar de baja, pulsa 3 para listar, pulsa 4 para modificar y escriba salir para terminar");
            opcion = System.console().readLine();
            if (opcion.equalsIgnoreCase("Salir")) {
                terminar = true;
            } else {
                int op = -1;
                try {
                    op = Integer.parseInt(opcion);
                    switch (op) {

                        case 1:
                            System.out.println("Pulsa 1 para crear un PC y 2 para crear un Portatil");
                            int opcion1 = Integer.parseInt(System.console().readLine());

                            if (opcion1 == 1) {
                                PC pcTemp = creaPC();
                                id++;
                                pcTemp.setIdInventario(id);
                                System.out.println("Marca: ");
                                pcTemp.setMarca(System.console().readLine());
                                System.out.println("Modelo: ");
                                pcTemp.setModelo(System.console().readLine());
                                System.out.println("RAM: ");
                                pcTemp.setRam(obtenNumeroEntero(System.console().readLine()));
                                System.out.println("Procesador:");
                                pcTemp.setProcesador(System.console().readLine());
                                System.out.println("Tipo Formato: ");
                                pcTemp.setTipoFormato(System.console().readLine());
                                System.out.println("Monitor S/N: ");
                                do {
                                    SiNo = System.console().readLine().toLowerCase();
                                    if (SiNo.equals("s") || SiNo.equals("n")) {
                                        pcTemp.setIncluyeMonitor(SiNo.equals("s") ? true : false);
                                    } else {
                                        System.out.println("Debes escribir una S o una N");
                                    }
                                } while ((!SiNo.equals("s")) && (!SiNo.equals("n")));
                                System.out.println("Precio: ");
                                pcTemp.setPrecio(obtenNumeroDouble(System.console().readLine()));
                                inventario.add(pcTemp);

                            } else if (opcion1 == 2) {
                                Portatil portatilTemp = creaPortatil();
                                id++;
                                portatilTemp.setIdInventario(id);
                                System.out.println("Marca: ");
                                portatilTemp.setMarca(System.console().readLine());
                                System.out.println("Modelo: ");
                                portatilTemp.setModelo(System.console().readLine());
                                System.out.println("RAM: ");
                                portatilTemp.setRam(obtenNumeroEntero(System.console().readLine()));
                                System.out.println("Procesador:");
                                portatilTemp.setProcesador(System.console().readLine());
                                System.out.println("Peso: ");
                                portatilTemp.setPeso(obtenNumeroDouble(System.console().readLine()));
                                System.out.println("Autonomia bateria: ");
                                portatilTemp.setAutonomiaBateria(obtenNumeroEntero(System.console().readLine()));
                                System.out.println("Garantia: ");
                                do {
                                    SiNo = System.console().readLine().toLowerCase();
                                    if (SiNo.equals("s") || SiNo.equals("n")) {
                                        portatilTemp.setGarantia(SiNo.equals("s") ? true : false);
                                    } else {
                                        System.out.println("Debes escribir una S o una N");
                                    }
                                } while ((!SiNo.equals("s")) && (!SiNo.equals("n")));
                                System.out.println("Precio: ");
                                portatilTemp.setPrecio(obtenNumeroDouble(System.console().readLine()));
                                inventario.add(portatilTemp);
                            } else {
                                System.out.println("Opcion incorrecta");
                            }
                            break;

                        case 2:
                            System.out.println("Introduce el ID del ordenador a eliminar:");
                            int idElim = obtenNumeroEntero(System.console().readLine());
                            boolean eliminado = false;
                            for (int i = 0; i < inventario.size(); i++) {
                                if (inventario.get(i).getIdInventario() == idElim) {
                                    inventario.remove(i);
                                    eliminado = true;
                                    System.out.println("Ordenador eliminado correctamente.");
                                    break;
                                }
                            }
                            if (!eliminado) {
                                System.out.println("No existe ningún ordenador con ese ID.");
                            }
                            break;

                        case 3:
                            System.out.println("Indica si quieres todo el listado pulsa 1, si quieres que se ordene por tipo pulsa 2, pulsa 3 para obtener solo los PCs y pulsa 4 para obtener solo los Portatiles");
                            String op2 = System.console().readLine();
                            int modo = obtenNumeroEntero(op2);
                            if (modo != 1) {
                                listarInventario(modo, inventario);
                            } else {
                                System.out.println("Por favor, pulsa una opcion correcta");
                            }
                            break;

                        case 4:
                            System.out.println("Introduce el ID del ordenador a modificar:");
                            int idMod = obtenNumeroEntero(System.console().readLine());
                            Ordenador ordMod = null;
                            for (Ordenador ord : inventario) {
                                if (ord.getIdInventario() == idMod) {
                                    ordMod = ord;
                                    break;
                                }
                            }
                            if (ordMod == null) {
                                System.out.println("No existe ningún ordenador con ese ID.");
                                break;
                            }
                            boolean salirSubmenu = false;
                            do {
                                System.out.println("-- SUBMENÚ MODIFICAR --");
                                System.out.println("1. Modificar precio");
                                System.out.println("2. Ampliar RAM");
                                System.out.println("3. Salir");
                                int opMod = obtenNumeroEntero(System.console().readLine());
                                switch (opMod) {
                                    case 1:
                                        System.out.println("Precio actual: " + ordMod.getPrecio());
                                        System.out.println("Nuevo precio:");
                                        ordMod.setPrecio(obtenNumeroDouble(System.console().readLine()));
                                        System.out.println("Precio actualizado correctamente.");
                                        break;

                                    case 2:
                                        System.out.println("RAM actual: " + ordMod.getRam());
                                        System.out.println("¿Cuánta RAM deseas añadir?");
                                        int ramExtra = obtenNumeroEntero(System.console().readLine());
                                        ordMod.setRam(ordMod.getRam() + ramExtra);
                                        System.out.println("RAM ampliada correctamente.");
                                        break;

                                    case 3:
                                        salirSubmenu = true;
                                        break;

                                    default:
                                        System.out.println("Opción incorrecta.");
                                }
                            } while (!salirSubmenu);
                            break;
                        default:
                            System.out.println("Por favor, introduzca una de las opciones del menu.");
                    }
                } catch (Exception e) {
                    System.out.println("Por favor, introduzaca un valor válido");
                }
            }

        } while (!terminar);

        //Opcion listar --> recorre el ArrayList e indica de que tipo es cada objeto(instanceof)
    }

    public static void listarInventario(int modo, ArrayList<Ordenador> inventario) {
// modo igual 1(listo todos los elementos en el orden en el que estan en el Arraylist)
//modo igual 2(listo primero los pcs y luego los portatiles)
//modo (igual 3 listo solo los pc)
//modo (igual 4 listo solo los portatiles)
// instanceof

        switch (modo) {
            case 1:
                System.out.println("Listado de elementos en el inventaio");
                //opcion 1 para recorrer el ArrayList
                for (int i = 0; i < inventario.size(); i++) {
                    System.out.println(inventario.get(i));
                }
            //opcion 2 - forEach
//                for (Ordenador ord : inventario) {
//                    System.out.println(ord);
//                }
//                break;

            case 2://modo igual 2(listo primero los pcs y luego los portatiles)
                System.out.println("Listado de los elementosen el inventario.");
                System.out.println("-- PCs --");
                for (Ordenador ord : inventario) {
                    if (ord instanceof PC) {
                        System.out.println(ord);
                    }
                }
                System.out.println("-- Portátiles --");
                for (Ordenador ord : inventario) {
                    if (ord instanceof Portatil) {
                        System.out.println(ord);
                    }
                }
                break;

            case 3:
                System.out.println("Listado de PCs:");
                for (Ordenador ord : inventario) {
                    if (ord instanceof PC) {
                        System.out.println(ord);
                    }
                }
                break;

            case 4:
                System.out.println("Listado de Portátiles:");
                for (Ordenador ord : inventario) {
                    if (ord instanceof Portatil) {
                        System.out.println(ord);
                    }
                }
                break;

            default:
                System.out.println("Opción de listado incorrecta.");

        }
    }

    public static PC creaPC() {
        PC pcTemp = new PC();
        System.out.println(pcTemp.toString());

        return pcTemp;
    }

    public static Portatil creaPortatil() {
        Portatil ptTemp = new Portatil();
        System.out.println(ptTemp.toString());

        return ptTemp;
    }

    //funciones 
    public static double obtenNumeroDouble(String opcion) {
        double numero = -1;
        boolean correcto = true;
        do {

            try {
                if (correcto) {
                    numero = Double.parseDouble(opcion);
                } else {
                    correcto = true;
                    numero = Double.parseDouble(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(opcion);
                } else {
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de número incorrecto.");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

}
