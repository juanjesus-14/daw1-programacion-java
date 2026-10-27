package com.mycompany.ex2bbdd;

/**
 * Clase Equipo — clase PADRE (superclase) de Ordenador.
 * Contiene los atributos comunes a cualquier equipo informático.
 *
 * Sus atributos son 'protected' para que Ordenador los use directamente.
 */
public class Equipo {

    // ─── ATRIBUTOS ───────────────────────────────
    // 'protected' → accesibles desde esta clase Y desde Ordenador (clase hija)
    protected String numSerie;    // identificador único del equipo (como el DNI en Persona)
    protected String fabricante;
    protected String modelo;

    // ─── CONSTRUCTORES ───────────────────────────

    public Equipo() {
    }

    // ATENCIÓN al orden de parámetros: (fabricante, modelo, numSerie)
    // Cuando Ordenador llame a super() debe respetar ESTE mismo orden
    public Equipo(String fabricante, String modelo, String numSerie) {
        this.numSerie = numSerie;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

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

    // ─── TOSTRING ────────────────────────────────
    // Ordenador llamará a super.toString() para reutilizar esto
    @Override
    public String toString() {
        return "numSerie='" + numSerie + "'"
                + ", fabricante='" + fabricante + "'"
                + ", modelo='" + modelo + "'";
    }
}
