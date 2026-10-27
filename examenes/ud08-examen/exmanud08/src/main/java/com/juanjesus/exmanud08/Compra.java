package com.juanjesus.exmanud08;

import java.sql.Date;

/**
 *
 * @author $(user)
 */

public class Compra {

    private String codProducto;
    private String fechaCompra;
    private Double importe;

    public Compra(String codProducto, String fechaCompra, Double importe) {
        this.codProducto = codProducto;
        this.fechaCompra = fechaCompra;
        this.importe = importe;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fecha) {
        this.fechaCompra = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        // Muestra fecha e importe de la compra
        return "fechaCompra=" + fechaCompra + ", importe=" + importe;
    }
}
