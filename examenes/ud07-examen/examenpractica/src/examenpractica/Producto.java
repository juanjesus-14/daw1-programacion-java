/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Producto {

    // Atributos
    private int idProducto;
    private String nombre;
    private double precio;
    private String marca;
    private LocalDate fechaEntrada;
    private Categoria categoria;

    // Constructor completo
    public Producto(int idProducto,
            String nombre,
            double precio,
            String marca,
            LocalDate fechaEntrada) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.fechaEntrada = fechaEntrada;
    }

    // Constructor vacío
    public Producto() {
    }

    // Getter idProducto
    public int getIdProducto() {
        return idProducto;
    }

    // Setter idProducto
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter precio
    public double getPrecio() {
        return precio;
    }

    // Setter precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Getter marca
    public String getMarca() {
        return marca;
    }

    // Setter marca
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter fechaEntrada
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    // Setter fechaEntrada
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    // Getter categoria
    public Categoria getCategoria() {
        return categoria;
    }

    // Setter categoria
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Asignar categoría al producto
    public void asignaCategoria(Categoria c) {

        this.categoria = c;
    }

    // Mostrar información producto
    @Override
    public String toString() {

        return "Producto: " + nombre
                + "\nID: " + idProducto
                + "\nPrecio: " + precio + "€"
                + "\nMarca: " + marca
                + "\nFecha entrada: " + fechaEntrada;
    }

}
