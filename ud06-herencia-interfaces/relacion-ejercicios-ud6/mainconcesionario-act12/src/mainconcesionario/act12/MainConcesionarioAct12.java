/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainconcesionario.act12;

/**
 *
 * @author juand
 */
public class MainConcesionarioAct12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Concesionario concesionario = new Concesionario();

        try {
            Auto auto1 = new Auto(5, "Toyota", "Corolla", 2022, Combustible.GASOLINA);
            Auto auto2 = new Auto(4, "Ford", "Focus", 2021, Combustible.DIESEL);

            Moto moto1 = new Moto(600, "Honda", "CBR600", 2020, Combustible.GASOLINA);
            Moto moto2 = new Moto(1000, "Yamaha", "R1", 2023, Combustible.GASOLINA);

            concesionario.registrarVehiculo(auto1);
            concesionario.registrarVehiculo(auto2);
            concesionario.registrarVehiculo(moto1);
            concesionario.registrarVehiculo(moto2);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nLISTADO COMPLETO:");
        concesionario.listarVehiculos();

        System.out.println("\nSOLO GASOLINA:");
        concesionario.filtrarPorCombustible(Combustible.GASOLINA);
    }
}
