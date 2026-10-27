package com.mycompany.ex3bbdd;

/**
 * Clase Electrodomestico — clase HIJA de Producto.
 *
 * 'extends Producto' → hereda: fabricante, modelo, codProducto (protected)
 * y sus getters/setters y toString().
 *
 * Añade sus propios atributos: tipo, caracteristicas, consumo,
 * tieneGarantia y el objeto Compra datosCompra.
 *
 * COMPARATIVA con exámenes anteriores:
 * - Como Ordenador en Examen 2: datosCompra puede ser null
 *   (se comprueba con ternaria en toString())
 * - A diferencia de Empleado en Examen 1: aquí NO inicializamos
 *   new Compra() en el constructor — dejamos null directamente
 */
public class Electrodomestico extends Producto {

    // ─── ATRIBUTOS PROPIOS ───────────────────────
    private String tipo;            // lavadora, lavavajillas, nevera...
    private String caracteristicas;
    private String consumo;         // A+, A++, A+++, B...
    private boolean tieneGarantia;  // boolean minúscula → true o false, nunca null
    private Compra datosCompra;     // null si no tiene compra registrada

    // ─── CONSTRUCTORES ───────────────────────────

    public Electrodomestico() {
    }

    // Constructor principal — sin compra (datosCompra queda null)
    // Es el que más se usa: creamos el electrodoméstico y luego
    // le asignamos la compra con setDatosCompra() si la tiene
    public Electrodomestico(String fabricante, String modelo, String codProducto,
                             String tipo, String caracteristicas,
                             String consumo, boolean tieneGarantia) {
        // super() llama al constructor de Producto con los 3 primeros campos
        super(fabricante, modelo, codProducto);
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.consumo = consumo;
        this.tieneGarantia = tieneGarantia;
        // datosCompra queda null implícitamente
    }

    // Constructor con compra incluida — opcional, por si ya tenemos todos los datos
    public Electrodomestico(String fabricante, String modelo, String codProducto,
                             String tipo, String caracteristicas,
                             String consumo, boolean tieneGarantia, Compra datosCompra) {
        super(fabricante, modelo, codProducto);
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.consumo = consumo;
        this.tieneGarantia = tieneGarantia;
        this.datosCompra = datosCompra;
    }

    // ─── GETTERS Y SETTERS ───────────────────────

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String c) {
        this.caracteristicas = c;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    // Para boolean el getter se llama 'is' en lugar de 'get'
    public boolean isTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(boolean tg) {
        this.tieneGarantia = tg;
    }

    public Compra getDatosCompra() {
        return datosCompra;
    }

    // Se llama desde cargaDatos() y desde insertarElectrodomestico()
    // cuando encontramos/insertamos una compra asociada
    public void setDatosCompra(Compra datosCompra) {
        this.datosCompra = datosCompra;
    }

    // ─── TOSTRING ────────────────────────────────
    @Override
    public String toString() {
        return "\nElectrodomestico: "
                // Usamos los atributos protected directamente (sin getters)
                // porque son 'protected' y esta clase los hereda
                + "\n     Fabricante: " + fabricante
                + ", modelo: " + modelo
                + ", codProducto: " + codProducto
                + ", tipo: " + tipo
                + ", caracteristicas: " + caracteristicas
                + ", consumo: " + consumo
                // Ternaria boolean → "Si" o "No" en lugar de true/false
                + ", tieneGarantia: " + (tieneGarantia ? "Si" : "No")
                // Ternaria objeto → comprueba si datosCompra es null
                // Si es null: avisa que no hay fecha de compra
                // Si no es null: llama a datosCompra.toString()
                + (datosCompra == null
                        ? " No hay fecha de compra."
                        : "\n     Compra: " + datosCompra);
    }
}
