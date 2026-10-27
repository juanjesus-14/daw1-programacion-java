/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainempleado.act4;

/**
 *
 * @author juand
 */
public class MainEmpleadoAct4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Empleado E1 = new Empleado("Juan");
        Empleado D1 = new Directivo("Raul");
        Operario OP1 = new Operario("Alfonso");
        Oficial OF1 = new Oficial("Pablo");
        Tecnico T1 = new Tecnico("Luis");

        System.out.println(E1);
        System.out.println(D1);
        System.out.println(OP1);
        System.out.println(OF1);
        System.out.println(T1);

    }

}
