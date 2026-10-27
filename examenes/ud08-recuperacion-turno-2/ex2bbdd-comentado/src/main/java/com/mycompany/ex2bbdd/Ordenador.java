package com.mycompany.ex2bbdd;

/**
 * Clase Ordenador — clase HIJA de Equipo.
 *
 * 'extends Equipo' → hereda: numSerie, fabricante, modelo (protected)
 * y sus getters/setters y toString().
 *
 * Añade sus propios atributos: formato, ram, procesador, hdd,
 * tieneGarantia y el objeto Garantia.
 *
 * DIFERENCIA CLAVE respecto al Examen 1 (Empleado/Pareja):
 * - En Empleado, la Pareja se inicializaba como 'new Pareja()' (nunca null)
 *   porque necesitábamos llamar a getPareja().getDni() sin comprobar null
 * - Aquí la Garantia SÍ puede ser null — la comprobamos con el ternario
 *   en toString() antes de usarla
 */
public class Ordenador extends Equipo {

    // ─── ATRIBUTOS PROPIOS DE ORDENADOR ──────────
    private String formato;
    private String ram;
    private String procesador;
    private String hdd;
    private boolean tieneGarantia;  // boolean minúscula → no puede ser null (true/false)
    private Garantia garantia;       // null si no tiene garantía registrada

    // ─── CONSTRUCTORES ───────────────────────────

    public Ordenador() {
    }

    // Constructor principal — recibe todos los datos incluyendo tieneGarantia
    // La garantia queda null hasta que se llame a setGarantia()
    public Ordenador(String numSerie, String fabricante, String modelo,
                     String formato, String ram, String procesador,
                     String hdd, boolean tieneGarantia) {

        // IMPORTANTE: el orden del super() debe coincidir con el constructor de Equipo
        // Equipo(String fabricante, String modelo, String numSerie)
        super(fabricante, modelo, numSerie);

        this.formato = formato;
        this.ram = ram;
        this.procesador = procesador;
        this.hdd = hdd;
        this.tieneGarantia = tieneGarantia;
        // garantia queda null implícitamente
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    // Para boolean el getter se llama 'is' en lugar de 'get'
    public boolean isTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(boolean tg) {
        this.tieneGarantia = tg;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    // Se llama desde cargaDatos() cuando encuentra una garantía asociada
    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    // ─── TOSTRING ────────────────────────────────
    @Override
    public String toString() {
        return "\nOrdenador: "
                // super.toString() → llama al toString() de Equipo
                // devuelve: numSerie + fabricante + modelo
                + "\n     " + super.toString()
                + ", formato=" + formato
                + ", ram=" + ram
                + ", procesador=" + procesador
                + ", hdd=" + hdd
                // Ternaria para boolean → "Si" o "No" en lugar de true/false
                + ", tieneGarantia: " + (tieneGarantia ? "Si" : "No")
                // Ternaria para objeto que puede ser null:
                // Si garantia == null → avisa que no hay datos
                // Si garantia != null → llama a su toString() (fechaFin + importeAnual)
                + (garantia == null
                        ? " - Sin datos de garantía."
                        : "\n     Garantia: " + garantia);
    }
}
