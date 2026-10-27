package mainvideoclub1.act10;

/**
 *
 * @author $(user)
 */
public class Juego extends Elemento {

    private boolean esFisico;

    public Juego(boolean esFisico, String codigo, String nombre, Double precioBase) {
        super(codigo, nombre, precioBase);
        this.esFisico = esFisico;
    }

    public boolean isEsFisico() {
        return esFisico;
    }

    public void setEsFisico(boolean esFisico) {
        this.esFisico = esFisico;
    }

    //metodos
    @Override
    public double getPrecioFinal() {
        // Aplicamos logica para definir este precio final
        // sumamos a precio base el margen de beneficios
        // para juego generamos un 40% de beneficios
        return (this.precioBase * 1.4);
    }

    @Override
    public int getGarantia() {
        // Importe para contratar la garantia extendia del producto
        return (int)(this.getPrecioFinal() * 0.2);
    }

    @Override
    public String toString() {
        return "Juego\n"
                + super.toString()
                + "\nEs Fisico: " + (esFisico ? "si" : "no");
    }

}
