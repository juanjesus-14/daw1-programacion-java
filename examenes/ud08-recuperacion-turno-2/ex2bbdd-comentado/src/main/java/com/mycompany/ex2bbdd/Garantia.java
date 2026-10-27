package com.mycompany.ex2bbdd;

/**
 * Clase Garantia — representa la garantía de un ordenador.
 * Es una clase independiente, NO hereda de nadie.
 * Un ordenador puede tener garantía o no tenerla (null).
 */
public class Garantia {

    // ─── ATRIBUTOS ───────────────────────────────
    // 'private' → solo accesibles desde dentro de esta clase
    private String numSerie;      // clave que vincula la garantía con su ordenador
    private String fechaFin;      // fecha en formato String "YYYY-MM-DD"
    private Double importeAnual;  // Double con mayúscula → puede ser null

    // ─── CONSTRUCTORES ───────────────────────────

    // Constructor vacío — por si necesitamos crear una garantía sin datos
    public Garantia() {
    }

    // Constructor completo — se usa al leer de la BBDD o al insertar
    public Garantia(String numSerie, String fechaFin, Double importeAnual) {
        this.numSerie = numSerie;
        this.fechaFin = fechaFin;
        this.importeAnual = importeAnual;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getImporteAnual() {
        return importeAnual;
    }

    public void setImporteAnual(Double importe) {
        this.importeAnual = importe;
    }

    // ─── TOSTRING ────────────────────────────────
    // Se usa dentro del toString() de Ordenador cuando garantia != null
    @Override
    public String toString() {
        return "fechaFin=" + fechaFin + ", importeAnual=" + importeAnual;
    }
}
