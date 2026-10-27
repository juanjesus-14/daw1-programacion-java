/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author juand
 */ 
public class Utils {

    // Método para crear categorías y productos
    public static void creaCatYProd(String linea, ArrayList<Categoria> listaCategorias, int contLinea) {

        // Variables
        String codCategoria;
        String nombreCategoria;

        int idProducto;

        String nombre;
        double precio;
        String marca;

        LocalDate fechaEntrada;

        // Separar línea usando ;
        String[] datos = linea.split(";");

        // Comprobar cantidad de datos
        if (datos.length == 6) {

            try {

                Producto pTemp;
                Categoria cTemp;

                // Guardar datos
                codCategoria = datos[0];
                nombreCategoria = datos[1];

                idProducto = Integer.parseInt(datos[2]);

                nombre = datos[3];

                precio = Double.parseDouble(datos[4]);

                marca = datos[5];

                // Fecha actual
                fechaEntrada = LocalDate.now();

                // Crear producto
                pTemp = new Producto(idProducto, nombre, precio, marca, fechaEntrada);

                // Si no hay categorías
                if (listaCategorias.isEmpty()) {

                    // Crear categoría
                    cTemp = new Categoria(codCategoria, nombreCategoria);

                    // Añadir producto
                    cTemp.asignaProducto(pTemp);

                    // Añadir categoría
                    listaCategorias.add(cTemp);

                    // Relacionar producto/categoría
                    pTemp.asignaCategoria(cTemp);

                } else {

                    // Buscar categoría existente
                    for (int i = 0; i < listaCategorias.size(); i++) {

                        // Si existe
                        if (listaCategorias.get(i).getCodCategoria().equals(codCategoria)) {

                            // Añadir producto
                            listaCategorias.get(i).asignaProducto(pTemp);

                            // Relacionar
                            pTemp.asignaCategoria(listaCategorias.get(i));

                            break;

                        } else if (i == listaCategorias.size() - 1 && !listaCategorias.get(i).getCodCategoria().equals(codCategoria)) {

                            // Crear nueva categoría
                            cTemp = new Categoria(codCategoria, nombreCategoria);

                            // Añadir producto
                            cTemp.asignaProducto(pTemp);

                            // Añadir categoría
                            listaCategorias.add(cTemp);

                            // Relacionar
                            pTemp.asignaCategoria(cTemp);

                            break;
                        }
                    }
                }

            } catch (NumberFormatException nfe) {

                System.out.println("Error numérico en línea " + contLinea);
            }

        } else if (datos.length < 6) {

            System.out.println("Faltan parámetros en línea " + contLinea);

        } else {

            System.out.println("Sobran parámetros en línea " + contLinea);
        }
    }

}
