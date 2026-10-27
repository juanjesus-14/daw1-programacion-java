/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exprueba1;

/**
 *
 * @author juand
 */
public class ExPrueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Apartado a) - pide la ruta y genera el log
        System.out.print("Introduce la ruta de los ficheros origen: ");
        String rutaOrigen = System.console().readLine();

        Utils.generaLog(rutaOrigen);

        // Apartado b) - construye el nombre dinámico y carga los datos
        String nombreFichero = Utils.construyeNombreFichero();
        String rutaFichero = rutaOrigen + "\\" + nombreFichero;

        Universidad uni = Utils.cargaDatos(rutaFichero);

        Utils.mostrarOrganigrama(uni);
        Utils.mostrarProfesoresPorFacultad(uni);
    }
}
