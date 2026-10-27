/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainconcesionario.act12;

/**
 *
 * @author juand
 */
public class Concesionario {
    
// Constante que define la capacidad máxima del concesionario
    // static -> pertenece a la clase
    // final  -> no puede modificarse
    private static final int CAPACIDAD_MAXIMA = 10;

    // Array que almacenará los vehículos (Auto o Moto)
    // Es de tipo Vehiculo porque usamos polimorfismo
    private Vahiculo[] vehiculos;

    // Variable que indica cuántos vehículos hay realmente guardados
    private int contadorVehiculos;

    // Constructor
    public Concesionario() {

        // Se crea el array con el tamaño definido por la constante
        vehiculos = new Vahiculo[CAPACIDAD_MAXIMA];

        // Al principio no hay vehículos registrados
        contadorVehiculos = 0;
    }

    // Método para registrar un vehículo
    // Recibe un objeto de tipo Vehiculo (Auto o Moto)
    public void registrarVehiculo(Vahiculo vehiculo) {

        // Comprobamos si todavía hay espacio en el array
        if (contadorVehiculos < CAPACIDAD_MAXIMA) {

            // Guardamos el vehículo en la posición actual del contador
            vehiculos[contadorVehiculos] = vehiculo;

            // Incrementamos el contador porque ya hay un vehículo más
            contadorVehiculos++;

            System.out.println("Vehículo registrado correctamente.");

        } else {

            // Si el array está lleno mostramos mensaje
            System.out.println("Capacidad máxima alcanzada.");
        }
    }

    // Método que muestra todos los vehículos registrados
    public void listarVehiculos() {

        // Recorremos solo las posiciones ocupadas
        // No recorremos todo el array, solo hasta contadorVehiculos
        for (int i = 0; i < contadorVehiculos; i++) {

            // Llamamos al método mostrarInformacion()
            // Aquí se aplica polimorfismo:
            // si es Auto ejecuta el de Auto
            // si es Moto ejecuta el de Moto
            vehiculos[i].mostrarInformacion();
        }
    }

    // Método que filtra vehículos por tipo de combustible
    public void filtrarPorCombustible(Combustible combustible) {

        // Recorremos solo los vehículos existentes
        for (int i = 0; i < contadorVehiculos; i++) {

            // Comparamos el combustible del vehículo con el recibido
            // Los enum se comparan con ==
            if (vehiculos[i].getTipoCombustible() == combustible) {

                // Si coincide, mostramos la información
                vehiculos[i].mostrarInformacion();
            }
        }
    }
}
