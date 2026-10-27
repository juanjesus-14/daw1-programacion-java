package maincuenta;

/**
 *
 * @author DAW
 */
public class MainCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Ejercicio3 Escribe una clase Cuenta para representar una cuenta bancaria. Los datos de la cuenta son: nombre del cliente (String), número de cuenta (String), tipo de interés (double) y saldo (double). La clase contendrá los siguientes métodos:
//          - Constructor por defecto, constructor con todos los parámetros, constructor copia.
//          - Métodos setters/getters para asignar y obtener los datos de la cuenta.
//          - Métodos ingreso y reintegro. Un ingreso consiste en aumentar el saldo en la cantidad que se indique. Esa cantidad no puede ser negativa. Un reintegro consiste en disminuir el saldo en una cantidad pero antes se debe comprobar que hay saldo suficiente. La cantidad no puede ser negativa. Los métodos ingreso y reintegro devuelven true si la operación se ha podido realizar o false en caso contrario.
//          - Método transferencia que permita pasar dinero de una cuenta a otra siempre que en la cuenta de origen haya dinero suficiente para poder hacerla. Ejemplo de uso del método transferencia: cuentaOrigen.transferencia(cuentaDestino, importe); que indica que queremos hacer una transferencia desde cuentaOrigen a cuentaDestino del importe indicado.
//          - Crear una clase ejecutable para probar la clase Cuenta creada y sus distintos métodos.
        Cuenta c1 = new Cuenta("Jesús", "0245", 2.1, 500.50);
        Cuenta c2 = new Cuenta("Juan", "1245", 1.1, 50.50);

        System.out.println(c1);
        System.out.println(c2);
        c1.transferencia(c2, 300);
        System.out.println(c1);
        System.out.println(c2);
        c1.ingreso(150);
        System.out.println(c1);
        c2.reintegro(100);
        System.out.println(c2);
    }
}
