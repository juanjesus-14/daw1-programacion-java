/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainempleados.act6;

/**
 *
 * @author juand
 */
public class MainEmpleadosAct6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Comercial c1 = new Comercial("Ana", 35, 1500, 300);
        Comercial c2 = new Comercial("Luis", 28, 1500, 100);

        Repartidor r1 = new Repartidor("Juan", 22, 1200, "zona 3");
        Repartidor r2 = new Repartidor("Pedro", 30, 1200, "zona 1");

        c1.plus();
        c2.plus();
        r1.plus();
        r2.plus();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(r1);
        System.out.println(r2);
    }
}
