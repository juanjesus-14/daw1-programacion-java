package mainvideoclub1.act10;

import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class MainVideoclub1Act10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

// -Crear un objeto VideoClub.
        VideoClub videoC = new VideoClub();

// - Añadir al inventario varios elementos de disƟntos Ɵpos(Juego y ArƟculo).
//     Juego(boolean esFisico, String codigo, String nombre, Double precioBase) 
//     Articulo(TipoArticulo tipo, String codigo, String nombre, Double precioBase) 
        Juego j1 = new Juego(false, "MINE123", "Minecraft", 20.50);
        Juego j2 = new Juego(false, "GTA_6", "GTA", 10.6);
        Articulo a1 = new Articulo(TipoArticulo.MANDO, "Mando_1", "Mando PS1", 12.25);
        Articulo a2 = new Articulo(TipoArticulo.MANDO, "Mando_2", "Mando PS2", 18.25);
        Articulo a3 = new Articulo(TipoArticulo.MANDO, "Mando_3", "Mando PS2", 21.25);

        videoC.agregarElemento(j1);
        videoC.agregarElemento(j2);
        videoC.agregarElemento(a1);
        videoC.agregarElemento(a2);
        videoC.agregarElemento(a3);

// - Mostrar el inventario completo.
        videoC.mostrarInventario();

// - Realizar una búsqueda de elementos por nombre y mostrar los resultados obtenidos.
        ArrayList<Elemento> resultBusqueda = videoC.buscarpornombre("Mando");
        if (resultBusqueda.isEmpty()) {
            System.out.println("El elemento buscado no se encuentra");
        }else{
            for (int i = 0; i < resultBusqueda.size(); i++) {
                System.out.println(resultBusqueda.get(i));
            }
        }

        resultBusqueda = videoC.buscarpornombre("Mando PS2");
        if (resultBusqueda.isEmpty()) {
            System.out.println("El elemento buscado no se encuentra");
        }else{
            for (int i = 0; i < resultBusqueda.size(); i++) {
                System.out.println(resultBusqueda.get(i));
            }
        }
        
    }

}
