package mainvideoclub1.act10;

/**
 *
 * @author $(user)
 */
public abstract class Elemento {

    protected String codigo;
    protected String nombre;
    protected Double precioBase;

    public Elemento(String codigo, String nombre, Double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    //metodos
    public abstract double getPrecioFinal();

    public abstract int getGarantia();

    @Override
    public String toString() {
        return "\nCodigo: " + codigo
                + "\nNombre: " + nombre
                + "\nPrecioBase: " + precioBase;
    }

}
