/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Categoria {

    // Atributos
    private String codCategoria;
    private String nombreCategoria;
    private ArrayList<Producto> listaProductos;

    // Constructor completo
    public Categoria(String codCategoria,
            String nombreCategoria) {

        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;

        // Inicializar ArrayList
        listaProductos = new ArrayList<>();
    }

    // Constructor vacío
    public Categoria() {

        listaProductos = new ArrayList<>();
    }

    // Getter codCategoria
    public String getCodCategoria() {
        return codCategoria;
    }

    // Setter codCategoria
    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    // Getter nombreCategoria
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    // Setter nombreCategoria
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // Getter listaProductos
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    // Setter listaProductos
    public void setListaProductos(
            ArrayList<Producto> listaProductos) {

        this.listaProductos = listaProductos;
    }

    // Añadir producto
    public boolean asignaProducto(Producto p) {

        listaProductos.add(p);

        return true;
    }

    // Eliminar producto
    public boolean eliminaProducto(Producto p) {

        for (int i = 0; i < listaProductos.size(); i++) {

            if (listaProductos.get(i).getIdProducto() == p.getIdProducto()) {

                listaProductos.remove(i);

                return true;
            }
        }

        return false;
    }

    // Mostrar productos
    public void listarProductos() {

        System.out.println("\n-- " + nombreCategoria + " --");

        for (int i = 0; i < listaProductos.size(); i++) {

            System.out.println("\n<Producto " + (i + 1) + ">");

            System.out.println(listaProductos.get(i));
        }
    }

    // Mostrar información categoría
    @Override
    public String toString() {

        return "Categoría: "
                + nombreCategoria
                + "\nCódigo: "
                + codCategoria
                + "\nNúmero productos: "
                + listaProductos.size();
    }

}
