package repaso.ud.pkg1;

/**
 *
 * @author DAW
 */
public class RepasoUD1 {

    //Variables
    //Variables estatica de clase
    static int contadorObjetos = 0;

    //constante
    public static final double PI = 3.14159;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //tipos primitivos
        byte b = 10;
        short s = 300;
        int i = 5000;
        long l = 1000000L;
        float f = 5.75f;
        double d = 123.456;
        char c = 'H';
        boolean bool = true;

        //Cadenas
        String texto = "Hola javeros y javeras";

        //Operadores
        int suma = i + b;
        int resta = i - s;
        int multiplicacion = b * 2;
        double division = d / 2;
        int resto = i % 7;

        //Asignacion compuesta
        i += 10; //equivale a i = 1 + 10;
        s *= 2; //equivale a s = s * 2;

        //incremento y decremento
        System.out.println("b: " + b);
        b++;
        System.out.println("b: " + b);
        System.out.println("l: " + l);
        l--;
        System.out.println("l: " + l);
        System.out.println("l: " + l--);
        System.out.println("l: " + l);
        System.out.println("l: " + --l);

        //Relacionales
        boolean esMayor = d > f;
        boolean esIgual = b == 15;
        boolean distinto = i != 0; //! significa negar

        //Logicos
        boolean resultadoLogico = !(5 == 6);
        System.out.println("Result: " + resultadoLogico);
        resultadoLogico = (esIgual && bool);
        System.out.println("Es Igual: " + esIgual);
        System.out.println("Bool: " + bool);
        System.out.println("Result2: " + resultadoLogico);
        System.out.println("Result3: " + (bool || esIgual)); // || significa uno o otro
        System.out.println("Es mayor: " + esMayor);
        resultadoLogico = (esMayor && bool) && esIgual;
        System.out.println("Result4: " + resultadoLogico);

        //Operador ternario
        String mensaje = (resultadoLogico) ? "Condicion verdadera" : "Condicion falsa";
        System.out.println("Mensaje: " + mensaje);

        //Sentencias de control
        if (b > 5 && b < 20) {
            System.out.println("b esta entre 5 y 20.");
        } else if (b > 20) {
            System.out.println("b es mayor 20.");
        } else {
            System.out.println("b es menor que 5.");
        }

        //switch
        System.out.println("c: " + c);
        switch (c) {
            case 'H':
                System.out.println("Hombre.");
                break;
            case 'M':
                System.out.println("Mujer.");
                break;
            default:
                System.out.println("No se ha informado.");
        }

        System.out.println("\nBucle for\n"); // \n deja una linea en blanco delante o detras 

        for (int j = 1; j <= 5; j++) {
            System.out.println("Iteracion: " + j);
        }

        System.out.println("\nBucle for"); // \n deja una linea en blanco delante o detras 

        for (int j = 1; j <= 5; j++) {
            if (j < 3) {
                continue;
            }
            if (j == 5) {
                break;
            }
            System.out.println("Iteracion: " + j);
        }

        //While
        System.out.println("Bucle while");
        int numero = 0;
        esMayor = true;
        while (numero < 10 && esMayor) {
            if (numero == 5) {
                esMayor = false;
                //continue;
                break;
            }
            System.out.println("Iteracion: " + numero);
            numero++;
        }

        //do-while
        System.out.println("\nDo-While");
        do {
            System.out.println("Voy por: " + numero);
            numero++;
        } while (numero < 10 || esMayor);

        //Lectura por consola
        boolean primerNumeroKo = true;
        boolean segundoNumeroKo = true;
        int primerNumero = 0;
        int segundoNumero = 0;

        do {
            try {
                System.out.println("Por favor introduce el primer numero entero: ");
                primerNumero = Integer.parseInt(System.console().readLine());
                primerNumeroKo = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Por favor, escribe en formato numerico");
            }
        } while (primerNumeroKo == true);
        do {
            try {
                System.out.println("Por favor introduce el segundo numero entero: ");
                segundoNumero = Integer.parseInt(System.console().readLine());
                segundoNumeroKo = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Por favor, escribe en formato numerico");
            }
        } while (segundoNumeroKo == true);

        System.out.println("El resultado de la suma es: " + (primerNumero + segundoNumero));

    }

}
