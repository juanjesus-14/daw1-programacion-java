package maincoche;

/**
 *
 * @author $(user)
 */
public class Motor {

    private int potencia;
    private boolean encendido;

    public Motor(int potencia, boolean encendido) {
        this.potencia = potencia;
        this.encendido = encendido;
    }

    public Motor(int potencia) {
        this.potencia = potencia;
        this.encendido = false;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean getEncendido() {
        return this.encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public void encenderMotor() {
        System.out.println("Encendiendo el motor!!!");
        this.encendido = true;
    }

    public void apagarMotor() {
        System.out.println("Paramos el motor!!!");
        this.encendido = false;
    }

    @Override
    public String toString() {
        //Opcion 1
        //return "Motor(potencia): " + this.potencia + "\nMotor(encendido): " + (this.encendido() ? "Si" : "No");
        
        //Opcion 2
        //el siguiente if es equivalente a: (this.encendido ? "Si" : "No")
        String resultado;
        if(this.encendido){
            resultado = "Si";
        }else{
            resultado= "No";
        }
                return "Motor(potencia): " + this.potencia + "\nMotor(encendido): " + resultado;
    }
}

