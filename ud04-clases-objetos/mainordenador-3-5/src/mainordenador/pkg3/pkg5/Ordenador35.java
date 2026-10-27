package mainordenador.pkg3.pkg5;

/**
 *
 * @author $(user)
 */
public class Ordenador35 {

    // Creamos nuestro objeto ordenador
    // Atributos (que definen el estado del objeto)
    private String marca;
    private String modelo;
    private int RAM;
    private String procesador;
    private double precio;
    private boolean portatil;
    private int idInventario;

    // Constructor
    public Ordenador35() {
        this.portatil = false;
    }

    public Ordenador35(String marca, String modelo, int RAM, String procesador, double precio, boolean portatil ,int idinventario) {
        this.marca = marca;
        this.modelo = modelo;
        this.RAM = RAM;
        this.procesador = procesador;
        this.precio = precio;
        this.portatil = portatil;
        this.idInventario = idinventario;

    }

    // Métodos get - devuelven al main el valor actual del objeto del atributo 
    // oportuno referenciado en el método get
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getRAM() {
        return this.RAM;
    }

    public String getProcesador() {
        return this.procesador;
    }

    public double getPrecio() {
        return this.precio;
    }

    public boolean getPortatil() {
        return this.portatil;
    }

    public int getIdInventario() {
        return this.idInventario;
    }

    // Métodos set - establecen el valor del atributo del objeto
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPortatil(boolean portatil) {
        this.portatil = portatil;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    @Override
    public String toString() {
        return "\nOrdenor: Id: " + this.idInventario + ","
                + " \nMarca: " + this.marca + ","
                + "\nModelo: " + this.modelo + ","
                + "\nRAM: " + this.RAM + ","
                + "\nProcesador: " + this.procesador + ","
                + "\nPrecio: " + this.precio + ","
                + "\nPortatil: " + this.portatil + ".";
    }

    //metodo que amplia la RAM existente 
    public void ampliarRAM(int RAM) {
        this.RAM += RAM; //equivalente a this.ram + ram;
    }
}
