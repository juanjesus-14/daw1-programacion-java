/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio14;

/**
 *
 * @author juand
 */
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//      Ejercicio 14: Crea una clase Empleado que tenga los siguientes atributos privados: 
//      Nif, Nombre, Sueldo base, Horas extra realizadas en el mes, Tipo de IRPF (%), Casado o no, Número de hijos, Importe de la hora extra. 
//      Este será un atributo static o atributo de clase.
//      - Los objetos Empleado se podrán crear con un constructor por defecto y con un constructor con todos los 
//      parámetros menos el Importe de la hora extra.
//      Además de los métodos getter/setter la clase Empleado tendrá estos métodos:
//      - Método para el cálculo del complemento correspondiente a las horas extra realizadas.
//      - Método para calcular el sueldo bruto (sueldo base + complemento por horas extras)
//      - Método para calcular las retenciones por IRPF. El porcentaje de IRPF se aplica sobre el sueldo bruto, 
//      teniendo en cuenta que el porcentaje que hay que aplicar es el tipo menos 2 puntos si el empleado está casado y 
//      menos 1 punto adicional por cada hijo que tenga.
//      - Método toString() para mostrar los datos de los empleados de la siguiente forma:
//      Una vez creada la clase Empleado, la utilizaremos en un programa que lea empleados y los guarde en un array estático. 
//      El número total de empleados se pide por teclado. El número máximo de empleados es de 20.
//      Después de leer los datos de los empleados se pedirá que se introduzca el importe correspondiente al pago 
//      por hora extra asignándoselo al atributo estático de la clase. A continuación, el programa mostrará el sueldo neto de cada uno de los empleados
        // Comprobación consola
        if (System.console() == null) {
            System.out.println("System.console() es null. Ejecuta este programa desde una terminal/console para usar readLine().");
            return;
        }

        try {
            // Leer número de empleados
            System.out.print("Introduce el número de empleados (máx 20): ");
            String nStr = System.console().readLine();
            int n = Integer.parseInt(nStr);
            if (n < 1) {
                System.out.println("Número de empleados debe ser al menos 1.");
                return;
            }
            if (n > 20) {
                System.out.println("Máximo permitido: 20. Se usará 20.");
                n = 20;
            }

            // Array estático de empleados
            Empleado[] empleados = new Empleado[n];

            // Leer empleados uno a uno
            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Empleado " + (i + 1) + " ---");

                System.out.print("NIF: ");
                String nif = System.console().readLine().trim();

                System.out.print("Nombre (apellidos y nombre): ");
                String nombre = System.console().readLine().trim();

                double sueldoBase = 0.0;
                while (true) {
                    try {
                        System.out.print("Sueldo base: ");
                        sueldoBase = Double.parseDouble(System.console().readLine().trim());
                        if (sueldoBase < 0) {
                            System.out.println("El sueldo base no puede ser negativo.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Valor inválido. Introduce un número para el sueldo base.");
                    }
                }

                int horasExtra = 0;
                while (true) {
                    try {
                        System.out.print("Horas Extras: ");
                        horasExtra = Integer.parseInt(System.console().readLine().trim());
                        if (horasExtra < 0) {
                            System.out.println("Las horas extra no pueden ser negativas.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Valor inválido. Introduce un entero para horas extra.");
                    }
                }

                double tipoIRPF = 0.0;
                while (true) {
                    try {
                        System.out.print("tipo IRPF (porcentaje, p.ej. 15.0): ");
                        tipoIRPF = Double.parseDouble(System.console().readLine().trim());
                        if (tipoIRPF < 0) {
                            System.out.println("El tipo IRPF no puede ser negativo.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Valor inválido. Introduce un número para el IRPF.");
                    }
                }

                boolean casado = false;
                while (true) {
                    System.out.print("Casado (S/N): ");
                    String casadoStr = System.console().readLine().trim();
                    if (casadoStr.equalsIgnoreCase("S") || casadoStr.equalsIgnoreCase("Y") || casadoStr.equalsIgnoreCase("SI")) {
                        casado = true;
                        break;
                    } else if (casadoStr.equalsIgnoreCase("N") || casadoStr.equalsIgnoreCase("NO")) {
                        casado = false;
                        break;
                    } else {
                        System.out.println("Entrada inválida. Introduce 'S' o 'N'.");
                    }
                }

                int numHijos = 0;
                while (true) {
                    try {
                        System.out.print("Número de hijos: ");
                        numHijos = Integer.parseInt(System.console().readLine().trim());
                        if (numHijos < 0) {
                            System.out.println("El número de hijos no puede ser negativo.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Valor inválido. Introduce un entero para el número de hijos.");
                    }
                }

                // Crear empleado y guardarlo en el array
                empleados[i] = new Empleado(nif, nombre, sueldoBase, horasExtra, tipoIRPF, casado, numHijos);
            }

            // Pedir el importe de la hora extra y asignarlo al atributo static
            double importeHora = 0.0;
            while (true) {
                try {
                    System.out.print("\nIntroduce el importe por hora extra (p.ej. 20.0): ");
                    importeHora = Double.parseDouble(System.console().readLine().trim());
                    if (importeHora < 0) {
                        System.out.println("El importe no puede ser negativo.");
                        continue;
                    }
                    Empleado.setImporteHoraExtra(importeHora);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Valor inválido. Introduce un número para el importe.");
                }
            }

            // Mostrar sueldo neto de cada empleado junto a sus datos
            System.out.println("\n--- RESULTADOS ---");
            for (int i = 0; i < empleados.length; i++) {
                Empleado e = empleados[i];
                System.out.println(e.toString()); // muestra los datos en formato solicitado
                System.out.printf("Sueldo Bruto: %.2f%n", e.sueldoBruto());
                System.out.printf("Retenciones IRPF: %.2f%n", e.retencionesIRPF());
                System.out.printf("Sueldo Neto: %.2f%n", e.sueldoNeto());
                System.out.println(); // línea en blanco entre empleados
            }

        } catch (Exception ex) {
            System.out.println("Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
