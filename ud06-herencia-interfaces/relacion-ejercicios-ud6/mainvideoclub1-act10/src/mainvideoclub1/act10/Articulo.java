package mainvideoclub1.act10;

/**
 *
 * @author $(user)
 */
public class Articulo extends Elemento {

    private TipoArticulo tipo;

    public Articulo(TipoArticulo tipo, String codigo, String nombre, Double precioBase) {
        super(codigo, nombre, precioBase);
        this.tipo = tipo;
    }

    public TipoArticulo getTipo() {
        return tipo;
    }

    public void setTipo(TipoArticulo tipo) {
        this.tipo = tipo;
    }

    //metodos
    @Override
    public double getPrecioFinal() {
        // Aplicamos logica para definir este precio final
        // sumamos a precio base el margen de beneficios
        // para juego generamos un 30% de beneficios
        return (this.precioBase * 1.3);
    }

    @Override
    public int getGarantia() {
        // Importe para contratar la garantia extendia del producto
        return (int) (this.getPrecioFinal() * 0.15);
    }

    @Override
    public String toString() {
        return "Juego\n"
                + super.toString()
                + "\nTipo: " + tipo;
    }

}
