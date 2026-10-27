package maincoche;

/**
 *
 * @author $(user)
 */
public class Rueda {

    //private int numRuedas = 0;
    private String diametro;

    public Rueda(String diametro) {
        this.diametro = diametro;
    }

    public void girar() {
        System.out.println("La rueda " + this.diametro + " esta girando.");
    }

    public String getDiametro() {
        return this.diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

}
