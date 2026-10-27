package com.mycompany.ex3bbdd;

/**
 * Clase Producto — clase PADRE (superclase) de Electrodomestico.
 * Contiene los atributos comunes a cualquier producto.
 *
 * Sus atributos son 'protected' para que Electrodomestico los use directamente
 * sin necesidad de getters (igual que Persona en Examen 1 y Equipo en Examen 2).
 */
public class Producto {

    // ─── ATRIBUTOS ───────────────────────────────
    // 'protected' → accesibles desde esta clase Y desde Electrodomestico
    protected String fabricante;
    protected String modelo;
    protected String codProducto;  // identificador único (como dni en Persona, numSerie en Equipo)

    // ─── CONSTRUCTORES ───────────────────────────

    public Producto() {
    }

    public Producto(String fabricante, String modelo, String codProducto) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.codProducto = codProducto;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fab) {
        this.fabricante = fab;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }

    // ─── TOSTRING ────────────────────────────────
    // Electrodomestico llamará a super.toString() para reutilizar esto
    @Override
    public String toString() {
        return "fabricante=" + fabricante
                + ", modelo=" + modelo
                + ", codProducto=" + codProducto;
    }
}
