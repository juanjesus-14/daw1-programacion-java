package com.mycompany.ex1bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase UtilsEx1 — contiene TODA la lógica de la aplicación.
 * 
 * Todos los métodos son 'static' → se llaman sin crear objeto:
 *   UtilsEx1.cargaDatos(lista)
 *   UtilsEx1.insertaEmp(lista)
 *   etc.
 * 
 * Métodos:
 *   - cargaDatos()     → SELECT empleados + SELECT parejas → llena el ArrayList
 *   - listar()         → muestra el ArrayList por pantalla
 *   - insertaEmp()     → INSERT empleado (+ INSERT pareja opcional)
 *   - insertaPar()     → INSERT pareja para un empleado ya existente
 *   - obtenNumeroEntero() → lee un número entero con validación
 */
public class UtilsEx1 {

    // ═══════════════════════════════════════════════════════════
    // CARGA DE DATOS — lee la BBDD y llena el ArrayList
    // ═══════════════════════════════════════════════════════════
    public static String cargaDatos(ArrayList<Empleado> listaEmpleados) {

        // Este String acumulará el informe de lo que se va cargando
        String resultado = "Reporte de la carga realizada\n";

        // Declaramos la conexión fuera del try para poder cerrarla en finally
        Connection cn = null;

        try {
            // 1. Abrimos conexión usando nuestra clase Conexion
            cn = Conexion.creaConexion();

            // Statement → permite ejecutar consultas SQL simples (sin parámetros ?)
            Statement st = cn.createStatement();

            // ── PASO 1: Cargar todos los empleados ──────────────────
            // executeQuery() → para SELECT, devuelve un ResultSet con las filas
            ResultSet rs = st.executeQuery("select * from empleados");

            // rs.next() avanza al siguiente registro y devuelve false cuando no hay más
            while (rs.next()) {
                // Leemos cada columna por su nombre en la BBDD
                int id          = rs.getInt("numeroEmpleado");
                String dni      = rs.getString("dni");
                String nombre   = rs.getString("nombre");
                String apellidos= rs.getString("apellidos");
                String email    = rs.getString("email");
                String dniPareja= rs.getString("dniPareja"); // puede ser null si no tiene pareja

                // Creamos el objeto Empleado con los datos leídos
                Empleado emp = new Empleado(id, dni, nombre, apellidos, email);

                // Si el empleado tiene pareja, guardamos su DNI en el objeto Pareja interno
                // Esto nos servirá después para asociar la pareja en el paso 2
                if (dniPareja != null) {
                    emp.setDniPareja(dniPareja);
                }

                // Añadimos el empleado al ArrayList
                listaEmpleados.add(emp);
                resultado += "Empleado cargado: " + dni + "\n";
            }
            rs.close(); // siempre cerrar el ResultSet cuando terminamos con él

            // ── PASO 2: Cargar parejas y asociarlas a sus empleados ─
            rs = st.executeQuery("select * from parejas");

            while (rs.next()) {
                String dni      = rs.getString("dni");
                String nombre   = rs.getString("nombre");
                String apellidos= rs.getString("apellidos");

                // Buscamos qué empleado tiene esta pareja
                // Recorremos el ArrayList buscando el empleado cuya pareja tenga ese DNI
                for (int i = 0; i < listaEmpleados.size(); i++) {
                    // getPareja().getDni() → el DNI que guardamos en el paso 1 con setDniPareja()
                    // equalsIgnoreCase → compara ignorando mayúsculas/minúsculas
                    // NUNCA usar == para comparar Strings
                    if (dni.equalsIgnoreCase(listaEmpleados.get(i).getPareja().getDni())) {
                        // Encontramos al empleado → rellenamos nombre y apellidos de su pareja
                        listaEmpleados.get(i).asignaPareja(nombre, apellidos);
                        resultado += "Pareja asociada: " + dni + "\n";
                    }
                }
            }
            rs.close();
            st.close();

        } catch (SQLException sqle) {
            // Capturamos errores de base de datos
            sqle.printStackTrace();
        } finally {
            // finally se ejecuta SIEMPRE, haya error o no
            // Así garantizamos que la conexión siempre se cierra
            Conexion.cierraConexion(cn);
        }
        return resultado;
    }

    // ═══════════════════════════════════════════════════════════
    // LISTAR — muestra todos los empleados del ArrayList
    // ═══════════════════════════════════════════════════════════
    public static void listar(ArrayList<Empleado> listaEmpleados) {
        System.out.println("\n========== EMPLEADOS ==========\n");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("--------------------------------");
            // Al imprimir el objeto, Java llama automáticamente a su toString()
            System.out.println(listaEmpleados.get(i));
            System.out.println("--------------------------------\n");
        }
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR EMPLEADO — pide datos, hace INSERT y añade al ArrayList
    // ═══════════════════════════════════════════════════════════
    public static boolean insertaEmp(ArrayList<Empleado> listaEmpleados) {

        boolean correcto = true;

        // Scanner para leer datos que escribe el usuario
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.creaConexion();

            // ── Calcular el siguiente numeroEmpleado automáticamente ─
            // MAX() → devuelve el valor más alto de esa columna
            String sql = "select max(numeroEmpleado) as numeroEmpleado from empleados";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int numeroEmpleado = 1; // valor por defecto si la tabla está vacía
            while (rs.next()) {
                // Le sumamos 1 al máximo actual para obtener el siguiente
                numeroEmpleado = rs.getInt("numeroEmpleado") + 1;
                System.out.println("Numero de empleado asignado: " + numeroEmpleado);
            }

            // ── Pedir DNI y comprobar que no existe ya ───────────────
            System.out.println("Dime el dni del empleado: ");
            String dni = sc.nextLine(); // nextLine() lee toda la línea incluyendo espacios

            // Buscamos si ya existe un empleado con ese DNI
            // Aquí usamos Statement con SQL concatenado (forma simple, sin PreparedStatement)
            sql = "select dni from empleados where dni='" + dni + "'";
            ResultSet rs2 = st.executeQuery(sql);

            if (rs2.next()) {
                // rs2.next() devuelve true → encontró algún registro → el DNI ya existe
                System.out.println("Ya existe un empleado con dni " + dni);

            } else {
                // No existe → podemos insertar

                // ── Pedir el resto de datos ──────────────────────────
                System.out.println("Dime el nombre del empleado: ");
                String nombre = sc.nextLine();
                System.out.println("Dime los apellidos del empleado: ");
                String apellidos = sc.nextLine();
                System.out.println("Dime el correo del empleado: ");
                String email = sc.nextLine();

                // ── INSERT con PreparedStatement ─────────────────────
                // PreparedStatement → usamos ? como marcadores de posición
                // Más seguro que concatenar (evita SQL Injection)
                sql = "Insert into empleados(numeroEmpleado, dni, nombre, apellidos, email) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);

                // Asignamos valores a cada ? por su posición (empiezan en 1, no en 0)
                ps.setInt(1, numeroEmpleado);  // ? número 1 = numeroEmpleado
                ps.setString(2, dni);           // ? número 2 = dni
                ps.setString(3, nombre);        // ? número 3 = nombre
                ps.setString(4, apellidos);     // ? número 4 = apellidos
                ps.setString(5, email);         // ? número 5 = email

                // executeUpdate() → para INSERT/UPDATE/DELETE (no devuelve filas, devuelve int)
                ps.executeUpdate();

                System.out.println("Empleado añadido correctamente.");

                // Creamos el objeto en memoria para añadirlo al ArrayList
                Empleado eTemp = new Empleado(numeroEmpleado, dni, nombre, apellidos, email);

                // ── Preguntar si quiere asociar una pareja ───────────
                System.out.println("Desea asociarle una pareja?(s/n)");
                // System.console().readLine() → lee una línea de la consola
                String opcion = System.console().readLine().toLowerCase();

                if (opcion.equals("s")) {
                    System.out.println("Dime el dni de la pareja: ");
                    String dniPareja = sc.nextLine();

                    // Comprobamos si la pareja ya existe en la BBDD
                    sql = "select dni from parejas where dni='" + dniPareja + "'";
                    rs = st.executeQuery(sql);

                    if (rs.next()) {
                        System.out.println("Ya existe una pareja con dni " + dniPareja);
                    } else {
                        System.out.println("Dime el nombre de la pareja: ");
                        String nombreP = sc.nextLine();
                        System.out.println("Dime los apellidos de la pareja: ");
                        String apellidosP = sc.nextLine();

                        // INSERT en la tabla parejas
                        sql = "Insert into parejas(dni, nombre, apellidos) values(?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, dniPareja);
                        ps.setString(2, nombreP);
                        ps.setString(3, apellidosP);
                        ps.executeUpdate();

                        // UPDATE en empleados para guardar el dniPareja
                        // Así la próxima vez que carguemos datos sabremos qué pareja tiene
                        sql = "update empleados set dniPareja='" + dniPareja + "' where dni='" + dni + "'";
                        ps = con.prepareStatement(sql);
                        ps.executeUpdate();

                        // Actualizar también el objeto en memoria
                        eTemp.setDniPareja(dniPareja);       // guarda el DNI en la Pareja
                        eTemp.asignaPareja(nombreP, apellidosP); // rellena nombre y apellidos
                    }
                }

                // Añadimos el empleado al ArrayList (con o sin pareja)
                listaEmpleados.add(eTemp);
            }

            con.close(); // cerramos la conexión

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        }
        // NOTA: no cerramos el Scanner aquí porque cerraría System.in
        // y el Main ya no podría leer más datos del teclado
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // INSERTAR PAREJA — añade pareja a un empleado YA existente
    // ═══════════════════════════════════════════════════════════
    public static boolean insertaPar(ArrayList<Empleado> listaEmpleados) {

        boolean correcto = true;
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = Conexion.creaConexion();
            Statement st = con.createStatement();

            // ── Pedir DNI del empleado al que añadir la pareja ───────
            System.out.println("A qué empleado le quieres asociar una pareja?");
            String dniEmp = System.console().readLine();

            // Comprobar que el empleado existe en la BBDD
            String sql = "select dni from empleados where dni='" + dniEmp + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                // El empleado existe → pedimos datos de la pareja

                System.out.println("Dime el dni de la pareja: ");
                String dni = sc.nextLine();

                // Comprobar que la pareja no existe ya
                sql = "select dni from parejas where dni='" + dni + "'";
                rs = st.executeQuery(sql);

                if (rs.next()) {
                    System.out.println("Ya existe una pareja con dni " + dni);
                } else {
                    System.out.println("Dime el nombre de la pareja: ");
                    String nombre = sc.nextLine();
                    System.out.println("Dime los apellidos de la pareja: ");
                    String apellidos = sc.nextLine();

                    // INSERT en parejas
                    sql = "Insert into parejas(dni, nombre, apellidos) values(?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, dni);
                    ps.setString(2, nombre);
                    ps.setString(3, apellidos);
                    ps.executeUpdate();

                    // UPDATE en empleados — vinculamos la pareja al empleado
                    sql = "update empleados set dniPareja='" + dni + "' where dni='" + dniEmp + "'";
                    ps = con.prepareStatement(sql);
                    ps.executeUpdate();

                    // ── Actualizar también el ArrayList en memoria ───
                    // Buscamos el empleado en el ArrayList y le asignamos la pareja
                    for (int i = 0; i < listaEmpleados.size(); i++) {
                        if (listaEmpleados.get(i).getDni().equalsIgnoreCase(dniEmp)) {
                            listaEmpleados.get(i).setDniPareja(dni);
                            listaEmpleados.get(i).asignaPareja(nombre, apellidos);
                            // No hay break porque en teoría solo hay un empleado con ese DNI
                        }
                    }
                }
            } else {
                // El empleado no existe en la BBDD
                System.out.println("El empleado con dni " + dniEmp + " no consta en la base de datos");
            }

            con.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            correcto = false;
        }
        // No cerramos sc para no cerrar System.in
        return correcto;
    }

    // ═══════════════════════════════════════════════════════════
    // UTILIDAD — lee un número entero con validación
    // ═══════════════════════════════════════════════════════════

    /**
     * Convierte un String a entero con validación de errores.
     * Si el String no es un número válido, pide que lo vuelvan a introducir.
     * 
     * @param opcion → el String que viene del sc.nextLine() del menú
     * @return el número entero validado
     */
    public static int obtenNumeroEntero(String opcion) {
        int numero = 0;
        boolean correcto = true; // empieza en true porque el primer intento usa 'opcion'

        do {
            try {
                if (correcto) {
                    // Primer intento: convertimos el String recibido por parámetro
                    numero = Integer.parseInt(opcion);
                } else {
                    // Intentos siguientes (si el anterior falló): pedimos nuevo valor
                    correcto = true;
                    numero = Integer.parseInt(System.console().readLine());
                }
            } catch (NumberFormatException e) {
                // NumberFormatException → el String no era un número (ej: "abc")
                System.out.println("Formato de numero incorrecto");
                correcto = false; // forzamos otra vuelta del do-while
            }
        } while (!correcto); // repetimos hasta que 'correcto' sea true

        return numero;
    }
}
