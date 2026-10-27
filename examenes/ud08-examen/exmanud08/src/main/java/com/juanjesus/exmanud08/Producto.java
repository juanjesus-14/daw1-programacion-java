package com.juanjesus.exmanud08;

/**
 *
 * @author $(user)
 */
public class Producto {

    // Atributos comunes a cualquier producto
    protected String fabricante;
    protected String modelo;
    protected String codProducto;

    public Producto() {
    }

    public Producto(String fabricante, String modelo, String codProducto) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.codProducto = codProducto;
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

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String cod) {
        this.codProducto = cod;
    }
}
