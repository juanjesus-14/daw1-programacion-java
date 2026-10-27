/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindelmio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Utils {

// Método que:
// - recibe una línea del fichero
// - crea empleado
// - crea departamento si no existe
// - relaciona empleado y departamento
    public static void creaDepYEmp(String linea, ArrayList<Departamento> listaDeptos, int contLinea) {

        // Variables para almacenar los datos del fichero
        String codDepto;
        String nombreDepto;
        int numEmpleado;
        String dni;
        String nombre;
        String apellidos;
        String email;
        LocalDate fechaContratacion;

        // Separar línea usando ;
        String[] lineaSeparar = linea.split(";");

        // Comprobar que la línea tenga 8 campos
        if (lineaSeparar.length == 8) {

            try {

                // Objetos temporales
                Empleado eTemp;
                Departamento dTemp;

                // Guardar datos del array
                codDepto = lineaSeparar[0];
                nombreDepto = lineaSeparar[1];

                // Convertir String a int
                numEmpleado = Integer.parseInt(lineaSeparar[2]);

                dni = lineaSeparar[3];
                nombre = lineaSeparar[4];
                apellidos = lineaSeparar[5];
                email = lineaSeparar[6];

                // Convertir String a LocalDate
                fechaContratacion = compruebaFecha(lineaSeparar[7]);

                // Crear empleado
                eTemp = new Empleado(numEmpleado, fechaContratacion, dni, nombre, apellidos, email);

                // Si no hay departamentos todavía
                if (listaDeptos.isEmpty()) {

                    // Crear departamento
                    dTemp = new Departamento(codDepto, nombreDepto);

                    // Añadir empleado al departamento
                    dTemp.asignaEmpleado(eTemp);

                    // Añadir departamento a la lista
                    listaDeptos.add(dTemp);

                    // Relacionar empleado con departamento
                    eTemp.asignaDepto(dTemp);

                } else {

                    // Recorrer departamentos existentes
                    for (int i = 0; i < listaDeptos.size(); i++) {

                        // Si el departamento ya existe
                        if (listaDeptos.get(i).getCodDepto().equals(codDepto)) {

                            // Añadir empleado
                            listaDeptos.get(i).asignaEmpleado(eTemp);

                            // Relacionar empleado y departamento
                            eTemp.asignaDepto(listaDeptos.get(i));

                            break;

                        } else if ( // Si estamos en el último
                                // departamento y no existe
                                (i == (listaDeptos.size() - 1)) && (!listaDeptos.get(i).getCodDepto().equals(codDepto))) {

                            // Crear nuevo departamento
                            dTemp = new Departamento(codDepto, nombreDepto);

                            // Añadir empleado
                            dTemp.asignaEmpleado(eTemp);

                            // Guardar departamento
                            listaDeptos.add(dTemp);

                            // Relacionar empleado/departamento
                            eTemp.asignaDepto(dTemp);

                            break;
                        }
                    }
                }

            } catch (NumberFormatException nfe) {

                // Error al convertir número
                System.out.println("Formato de numero en la linea " + contLinea + " incorrecto");
            }

        } else if (lineaSeparar.length < 7) {

            // Faltan datos
            System.out.println("Parámetros de la linea " + contLinea + " insuficientes");

        } else {

            // Sobran datos
            System.out.println("Demasiados parámetros en la línea " + contLinea);
        }
    }

// Método para comprobar y convertir fecha
    public static LocalDate compruebaFecha(String fecha1) {

        // Formato esperado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fecha2 = null;

        try {

            // Convertir String a LocalDate
            fecha2 = LocalDate.parse(fecha1, formato);

        } catch (Exception e) {

            // Error de formato fecha
            System.out.println("Formato de fecha incorrecta");
        }

        // Devolver fecha convertida
        return fecha2;
    }
}
