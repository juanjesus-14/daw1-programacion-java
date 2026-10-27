package mainclientescuentas;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainClientesCuentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Introduce el directorio en el que estan ubicados los ficheros origen: ");
        String directorio = System.console().readLine();
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        File ficheros = new File(directorio);

        // Importante antes de acceder a los ficheros, verifico la existencia del directorio.
        if (!ficheros.exists()) {
            System.out.println("No podemos ejecutar el programa, no existe el directorio.");
        } else {
            String fichClientes = directorio + "\\clientes.txt"; //D:\origen --> D:\origen\clientes.txt

            try {
                BufferedReader br = new BufferedReader(new FileReader(fichClientes));
                String linea = br.readLine();

                while (linea != null) {
                    Utils.creaCliente(listaClientes, linea, directorio);
                    linea = br.readLine();
                }

            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Utils.muestraClientes3(listaClientes);
        }

    }

}
