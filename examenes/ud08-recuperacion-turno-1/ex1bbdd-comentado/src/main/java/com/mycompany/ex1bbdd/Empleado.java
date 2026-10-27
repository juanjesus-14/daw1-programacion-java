package com.mycompany.ex1bbdd;

/**
 * Clase Empleado — clase HIJA de Persona.
 * 
 * 'extends Persona' significa que hereda todo de Persona:
 *   - los atributos protected: dni, nombre, apellidos, email
 *   - los métodos: getters, setters, getNombreCompleto(), toString()
 * 
 * Además añade sus propios atributos: numeroEmpleado y pareja.
 */
public class Empleado extends Persona {

    // ─── ATRIBUTOS PROPIOS DE EMPLEADO ───────────
    private int numeroEmpleado;

    // La pareja se guarda como un OBJETO Pareja dentro del empleado
    // IMPORTANTE: se inicializa como 'new Pareja()' (vacía), NUNCA como null
    // Si fuera null, cualquier llamada a pareja.getDni() daría NullPointerException
    private Pareja pareja;

    // ─── CONSTRUCTOR ─────────────────────────────
    public Empleado(int numeroEmpleado, String dni, String nombre, String apellidos, String email) {
        // 'super(...)' llama al constructor de Persona con esos 4 datos
        // OBLIGATORIO cuando la clase padre no tiene constructor vacío
        // (o cuando queremos usar el constructor con parámetros)
        super(dni, nombre, apellidos, email);

        this.numeroEmpleado = numeroEmpleado;

        // Creamos una Pareja vacía — sus atributos serán null hasta que se rellenen
        // Así getPareja() nunca devuelve null y evitamos NullPointerException
        this.pareja = new Pareja();
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    // ─── MÉTODOS PROPIOS ─────────────────────────

    /**
     * Asigna nombre y apellidos a la pareja del empleado.
     * El objeto Pareja ya existe (se creó en el constructor),
     * solo le ponemos los datos con sus setters.
     * Devuelve true si todo fue bien.
     */
    public boolean asignaPareja(String nombre, String apellidos) {
        boolean asignado = false;

        // Usamos los setters del objeto Pareja para rellenar sus datos
        this.pareja.setNombre(nombre);
        this.pareja.setApellidos(apellidos);

        asignado = true;
        return asignado;
    }

    /**
     * Asigna el DNI al objeto Pareja del empleado.
     * Se llama ANTES que asignaPareja() durante la carga de datos.
     * Primero ponemos el DNI (setDniPareja), luego nombre y apellidos (asignaPareja).
     */
    public void setDniPareja(String dni) {
        // Solo asignamos si el DNI no está vacío
        if (!dni.isEmpty()) {
            this.pareja.setDni(dni);  // metemos el dni dentro del objeto Pareja
        }
    }

    // ─── TOSTRING ────────────────────────────────
    @Override
    public String toString() {
        // super.toString() → llama al toString() de Persona
        // que devuelve: DNI + Nombre + Apellidos + Email
        return super.toString()
                + "\nNumero de Empleado: " + numeroEmpleado
                // Operador ternario: si pareja no tiene nombre, no mostramos nada
                // Si tiene nombre, mostramos "Pareja: " + los datos de la pareja
                // pareja.getNombre() == null → la pareja está vacía (sin datos)
                + (pareja.getNombre() == null ? "" : "\nPareja: " + this.pareja);
    }
}
