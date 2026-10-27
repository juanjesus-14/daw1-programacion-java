package com.mycompany.ex3bbdd;

import java.time.LocalDate;

/**
 * Clase Compra — representa los datos de compra de un electrodoméstico.
 * Es una clase independiente, NO hereda de nadie.
 * Un electrodoméstico puede tener una compra asociada o no (null).
 *
 * DIFERENCIA respecto a Garantia del Examen 2:
 * - fechaCompra es LocalDate en lugar de String
 * - Esto es porque el enunciado lo pide así y la BBDD usa tipo DATE
 */
public class Compra {

    // ─── ATRIBUTOS ───────────────────────────────
    private String codProducto;    // clave que vincula la compra con su electrodoméstico
    private LocalDate fechaCompra; // LocalDate en lugar de String — tipo DATE en MySQL
    private Double importe;        // Double con mayúscula → puede ser null

    // ─── CONSTRUCTORES ───────────────────────────

    public Compra() {
    }

    public Compra(String codProducto, LocalDate fechaCompra, Double importe) {
        this.codProducto = codProducto;
        this.fechaCompra = fechaCompra;
        this.importe = importe;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fecha) {
        this.fechaCompra = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    // ─── TOSTRING ────────────────────────────────
    // LocalDate.toString() devuelve "2026-01-10" automáticamente
    @Override
    public String toString() {
        return "fechaCompra=" + fechaCompra + ", importe=" + importe;
    }
}
