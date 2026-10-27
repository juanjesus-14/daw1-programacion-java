package mainvideoclub1.act10;

import java.util.ArrayList;

/**
 *
 * @author $(user)
 */
public class VideoClub {

    private ArrayList<Elemento> inventario;

    public VideoClub() {
        this.inventario = new ArrayList<Elemento>();
    }

    // metodos
    public void agregarElemento(Elemento e) {
        this.inventario.add(e);
    }

    public void mostrarInventario() {
        System.out.println("-- Listado del Inventario --");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i));
        }
    }

    public ArrayList<Elemento> buscarpornombre(String nombre) {

        ArrayList<Elemento> atemp = new ArrayList<Elemento>();
        for (int i = 0; i < this.inventario.size(); i++) {
            if (this.inventario.get(i).getNombre().equals(nombre)) {
                atemp.add(this.inventario.get(i));
            }
        }
        return atemp;
    }

}
