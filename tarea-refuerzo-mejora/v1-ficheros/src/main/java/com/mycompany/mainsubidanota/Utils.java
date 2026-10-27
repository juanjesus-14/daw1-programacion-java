package com.mycompany.mainsubidanota;

import java.io.*;
import java.util.*;

public class Utils {

    private static final String RUTA_PERSONAS = "personas.txt";
    private static final String RUTA_MASCOTAS = "mascotas.txt";
    private static final String SEP = ";";

    // ═══════════════════════════════════════════════════════════
    // GENERAR LOG DE FICHEROS Y DIRECTORIOS
    // ═══════════════════════════════════════════════════════════
    public static void generarLog(Scanner sc) {
        System.out.println("Introduce la ruta a explorar: ");
        String ruta = sc.nextLine().trim();

        File directorio = new File(ruta);
        if (!directorio.exists() || !directorio.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
            return;
        }

        String rutaLog = "log_resumen.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaLog))) {
            explorarDirectorio(directorio, bw);
            System.out.println("Log generado en: " + rutaLog);
        } catch (IOException e) {
            System.out.println("Error al escribir el log: " + e.getMessage());
        }
    }

    private static void explorarDirectorio(File dir, BufferedWriter bw) throws IOException {
        File[] contenido = dir.listFiles();
        if (contenido == null) {
            return;
        }
        for (File f : contenido) {
            String tipo = f.isDirectory() ? "D" : "F";
            String linea = tipo + SEP + f.getName() + SEP + f.getAbsolutePath();
            bw.write(linea);
            bw.newLine();
            System.out.println(linea);
            if (f.isDirectory()) {
                explorarDirectorio(f, bw);
            }
        }
    }

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS DESDE FICHEROS
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Persona> lista) {
        String resultado = "Reporte de la carga:\n";

        // PASO 1: cargar personas
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_PERSONAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length >= 6) {
                    Persona pTemp = new Persona(
                            d[0].trim(), d[1].trim(), d[2].trim(),
                            d[3].trim(), d[4].trim(), d[5].trim()
                    );
                    lista.add(pTemp);
                    resultado += "Persona cargada: " + d[0].trim() + "\n";
                }
            }
        } catch (IOException e) {
            resultado += "Error al leer personas.txt: " + e.getMessage() + "\n";
        }

        // PASO 2: cargar mascotas y asociarlas
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_MASCOTAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length >= 4) {
                    try {
                        Mascota mTemp = new Mascota(
                                d[0].trim(), d[1].trim(),
                                Integer.parseInt(d[2].trim()), d[3].trim()
                        );
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getDni().equalsIgnoreCase(d[0].trim())) {
                                lista.get(i).asignaMascota(mTemp);
                                resultado += "Mascota asociada: " + d[1].trim() + " a " + d[0].trim() + "\n";
                            }
                        }
                    } catch (NumberFormatException e) {
                        resultado += "Edad no válida en línea: " + linea + "\n";
                    }
                }
            }
        } catch (IOException e) {
            resultado += "Error al leer mascotas.txt: " + e.getMessage() + "\n";
        }

        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // LISTAR
    // ═══════════════════════════════════════════════════════════
    public static void listar(ArrayList<Persona> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR PERSONA
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarPersona(Scanner sc, ArrayList<Persona> lista) {
        boolean correcto = true;

        try {
            System.out.println("Dime el DNI de la persona: ");
            String dni = sc.nextLine().trim();

            // Comprobar si ya existe en la lista
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDni().equalsIgnoreCase(dni)) {
                    System.out.println("Ya existe una persona con DNI: " + dni);
                    return false;
                }
            }

            System.out.println("Dime el nombre: ");
            String nombre = sc.nextLine().trim();
            System.out.println("Dime los apellidos: ");
            String apellidos = sc.nextLine().trim();
            System.out.println("Dime el email: ");
            String email = sc.nextLine().trim();
            System.out.println("Dime el teléfono: ");
            String telefono = sc.nextLine().trim();
            System.out.println("Dime la dirección: ");
            String direccion = sc.nextLine().trim();

            // Escribir en fichero
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_PERSONAS, true))) {
                bw.write(dni + SEP + nombre + SEP + apellidos + SEP + email + SEP + telefono + SEP + direccion);
                bw.newLine();
            }

            // Actualizar lista en memoria
            Persona pTemp = new Persona(dni, nombre, apellidos, email, telefono, direccion);
            lista.add(pTemp);
            System.out.println("Persona insertada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en personas.txt: " + e.getMessage());
            correcto = false;
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR MASCOTA
    // ═══════════════════════════════════════════════════════════
    public static boolean insertarMascota(Scanner sc, ArrayList<Persona> lista) {
        boolean correcto = true;

        try {
            System.out.println("DNI de la persona a la que asociar la mascota: ");
            String dniPersona = System.console().readLine().trim();

            Persona propietario = null;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getDni().equalsIgnoreCase(dniPersona)) {
                    propietario = lista.get(i);
                    break;
                }
            }

            if (propietario == null) {
                System.out.println("No existe persona con DNI: " + dniPersona);
                return false;
            }

            System.out.println("Persona encontrada: " + propietario.getNombre());

            System.out.println("Dime el nombre de la mascota: ");
            String nombreMascota = sc.nextLine().trim();
            System.out.println("Dime la edad de la mascota: ");
            int edad = obtenNumeroEntero(sc.nextLine());
            System.out.println("Dime la raza de la mascota: ");
            String raza = sc.nextLine().trim();

            // Escribir en fichero
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_MASCOTAS, true))) {
                bw.write(dniPersona + SEP + nombreMascota + SEP + edad + SEP + raza);
                bw.newLine();
            }

            // Actualizar lista en memoria
            Mascota mTemp = new Mascota(dniPersona, nombreMascota, edad, raza);
            propietario.asignaMascota(mTemp);
            System.out.println("Mascota insertada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en mascotas.txt: " + e.getMessage());
            correcto = false;
        }

        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // MODIFICAR PERSONA (fichero temporal)
    // ═══════════════════════════════════════════════════════════
    public static boolean modificarPersona(Scanner sc, ArrayList<Persona> lista) {
        boolean correcto = true;

        System.out.println("DNI de la persona a modificar: ");
        String dni = sc.nextLine().trim();

        Persona aModificar = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDni().equalsIgnoreCase(dni)) {
                aModificar = lista.get(i);
                break;
            }
        }

        if (aModificar == null) {
            System.out.println("No existe persona con DNI: " + dni);
            return false;
        }

        System.out.println("Datos actuales: " + aModificar);
        System.out.println("(Pulsa ENTER para dejar el valor sin cambios)");

        System.out.println("Nuevo nombre [" + aModificar.getNombre() + "]: ");
        String nombre = sc.nextLine();
        if (!nombre.isEmpty()) {
            aModificar.setNombre(nombre);
        }

        System.out.println("Nuevos apellidos [" + aModificar.getApellidos() + "]: ");
        String apellidos = sc.nextLine();
        if (!apellidos.isEmpty()) {
            aModificar.setApellidos(apellidos);
        }

        System.out.println("Nuevo email [" + aModificar.getEmail() + "]: ");
        String email = sc.nextLine();
        if (!email.isEmpty()) {
            aModificar.setEmail(email);
        }

        System.out.println("Nuevo teléfono [" + aModificar.getTelefono() + "]: ");
        String telefono = sc.nextLine();
        if (!telefono.isEmpty()) {
            aModificar.setTelefono(telefono);
        }

        System.out.println("Nueva dirección [" + aModificar.getDireccion() + "]: ");
        String direccion = sc.nextLine();
        if (!direccion.isEmpty()) {
            aModificar.setDireccion(direccion);
        }

        // Reescribir fichero con fichero temporal
        File original = new File(RUTA_PERSONAS);
        File temporal = new File("personas_tmp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(original)); BufferedWriter bw = new BufferedWriter(new FileWriter(temporal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length > 0 && d[0].trim().equalsIgnoreCase(dni)) {
                    bw.write(aModificar.getDni() + SEP + aModificar.getNombre() + SEP
                            + aModificar.getApellidos() + SEP + aModificar.getEmail() + SEP
                            + aModificar.getTelefono() + SEP + aModificar.getDireccion());
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al modificar personas.txt: " + e.getMessage());
            correcto = false;
        }

        original.delete();
        temporal.renameTo(original);

        if (correcto) {
            System.out.println("Persona modificada correctamente.");
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // ELIMINAR MASCOTA (fichero temporal)
    // ═══════════════════════════════════════════════════════════
    public static boolean eliminarMascota(Scanner sc, ArrayList<Persona> lista) {
        boolean correcto = true;

        System.out.println("DNI de la persona propietaria: ");
        String dniPersona = sc.nextLine().trim();

        Persona propietario = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDni().equalsIgnoreCase(dniPersona)) {
                propietario = lista.get(i);
                break;
            }
        }

        if (propietario == null) {
            System.out.println("No existe persona con DNI: " + dniPersona);
            return false;
        }

        if (propietario.getMascotas().isEmpty()) {
            System.out.println(propietario.getNombre() + " no tiene mascotas.");
            return false;
        }

        System.out.println("Mascotas de " + propietario.getNombre() + ":");
        for (int i = 0; i < propietario.getMascotas().size(); i++) {
            System.out.println("  " + (i + 1) + ". " + propietario.getMascotas().get(i).getNombre());
        }

        System.out.println("Nombre de la mascota a eliminar: ");
        String nombreMascota = sc.nextLine().trim();

        Mascota aEliminar = null;
        for (int i = 0; i < propietario.getMascotas().size(); i++) {
            if (propietario.getMascotas().get(i).getNombre().equalsIgnoreCase(nombreMascota)) {
                aEliminar = propietario.getMascotas().get(i);
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("No se encontró esa mascota.");
            return false;
        }

        final String dniFinal = dniPersona;
        final String nombreFinal = aEliminar.getNombre();

        File original = new File(RUTA_MASCOTAS);
        File temporal = new File("mascotas_tmp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(original)); BufferedWriter bw = new BufferedWriter(new FileWriter(temporal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length >= 2
                        && d[0].trim().equalsIgnoreCase(dniFinal)
                        && d[1].trim().equalsIgnoreCase(nombreFinal)) {
                    continue; // saltar esta línea
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al modificar mascotas.txt: " + e.getMessage());
            correcto = false;
        }

        original.delete();
        temporal.renameTo(original);

        propietario.getMascotas().remove(aEliminar);
        if (correcto) {
            System.out.println("Mascota eliminada correctamente.");
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // ELIMINAR PERSONA (fichero temporal en personas y mascotas)
    // ═══════════════════════════════════════════════════════════
    public static boolean eliminarPersona(Scanner sc, ArrayList<Persona> lista) {
        boolean correcto = true;

        System.out.println("DNI de la persona a eliminar: ");
        String dni = sc.nextLine().trim();

        Persona aEliminar = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDni().equalsIgnoreCase(dni)) {
                aEliminar = lista.get(i);
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("No existe persona con DNI: " + dni);
            return false;
        }

        System.out.println("¿Seguro que deseas eliminar a " + aEliminar.getNombre() + " y sus mascotas? (S/N): ");
        String confirm = System.console().readLine().trim().toUpperCase();
        if (!confirm.equals("S")) {
            System.out.println("Operación cancelada.");
            return false;
        }

        // Fichero temporal para personas
        File originalP = new File(RUTA_PERSONAS);
        File temporalP = new File("personas_tmp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(originalP)); BufferedWriter bw = new BufferedWriter(new FileWriter(temporalP))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length > 0 && d[0].trim().equalsIgnoreCase(dni)) {
                    continue;
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al modificar personas.txt: " + e.getMessage());
            correcto = false;
        }

        originalP.delete();
        temporalP.renameTo(originalP);

        // Fichero temporal para mascotas
        File originalM = new File(RUTA_MASCOTAS);
        File temporalM = new File("mascotas_tmp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(originalM)); BufferedWriter bw = new BufferedWriter(new FileWriter(temporalM))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] d = linea.split(SEP);
                if (d.length > 0 && d[0].trim().equalsIgnoreCase(dni)) {
                    continue;
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al modificar mascotas.txt: " + e.getMessage());
            correcto = false;
        }

        originalM.delete();
        temporalM.renameTo(originalM);

        lista.remove(aEliminar);
        if (correcto) {
            System.out.println("Persona y sus mascotas eliminadas correctamente.");
        }
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // UTILIDAD — lee un número entero con validación
    // ═══════════════════════════════════════════════════════════
    public static int obtenNumeroEntero(String num) {
        int numero = 0;
        boolean correcto = true;
        do {
            try {
                if (correcto) {
                    numero = Integer.parseInt(num);
                } else {
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato de numero incorrecto");
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }
}
