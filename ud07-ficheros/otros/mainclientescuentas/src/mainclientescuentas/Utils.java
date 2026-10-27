package mainclientescuentas;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author $(user)
 */
public class Utils {

    public static boolean creaCliente(ArrayList<Cliente> lista, String linea, String directorio) {

        boolean correcto = true;
        // Formato
        // DNi; Nombre; Apellidos

        String[] parseoDatos = linea.split(";");

        if (parseoDatos.length == 3) {

            // Opcion1 busco el dni en el ficherode cuetas y me traigo la informacion de cuenta asociada al dni.
//            Cuenta cu = buscaCuenta(parseoDatos[0], directorio);
//            lista.add(new Cliente(parseoDatos[0], parseoDatos[1], parseoDatos[2], cu));


            // Opción 2. Recupero todos los datos de cliente y cuenta y se los envío al constructor de Cliente.           
            // public Cliente(String dni, String nombre, String apellidos, String numCuenta, String nombreBanco)
            String numCuenta = "";
            String nombreBanco = "";
            boolean encontrado = true;
            String dni = parseoDatos[0];

            try {

                BufferedReader br = new BufferedReader(new FileReader(directorio + "\\cuentas.txt"));
                String lineaCuenta = br.readLine();
                while (lineaCuenta != null) {
                    String[] lineaArray = lineaCuenta.split(";");

                    if (lineaArray[0].equals(dni)) {
                         numCuenta = lineaArray[1];
                          nombreBanco = lineaArray[2];
                        break;
                    }

                    lineaCuenta = br.readLine();
                }
            } catch (FileNotFoundException fnfe) {
                encontrado = false;
            } catch (IOException ioe) {
                encontrado = false;
            } catch (Exception e) {
                encontrado = false;
            }
            Cliente cliTemp = new Cliente(parseoDatos[0], parseoDatos[1], parseoDatos[2], numCuenta, nombreBanco);

            lista.add(cliTemp);

        } else {
            correcto = false;
        }
        return correcto;
    }

    public static Cuenta buscaCuenta(String dni, String directorio) {
        boolean encontrado = true;
        Cuenta cu = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(directorio + "\\cuentas.txt"));
            String linea = br.readLine();
            // dni parametro
            // formato fichero --> dni, nombreBanco, numCuenta

            while (linea != null) {
                String[] lineaArray = linea.split(";");

                if (lineaArray[0].equals(dni)) {
                    cu = new Cuenta(lineaArray[1], lineaArray[2]);
                    break;
                }

                linea = br.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            encontrado = false;
        } catch (IOException ioe) {
            encontrado = false;
        } catch (Exception e) {
            encontrado = false;
        }

        return cu;
    }

    public static void muestraClientes(ArrayList<Cliente> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void muestraClientes2(ArrayList<Cliente> lista) {
        Iterator<Cliente> it = lista.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void muestraClientes3(ArrayList<Cliente> lista) {
        for (Cliente c : lista) {
            System.out.println(c);
        }
    }
}
