/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanjesus.variables;

/**
 *
 * @author DAW
 */
public class Variables {

    public static void main(String[] args) {
        int saldo_total, saldo, x;
        float saldo_final;
        saldo_total=100;
        saldo=0;
        x=7;
        
//        System.out.print(saldo_total);
//        System.out.println(saldo_total);
        System.out.println("El saldo total es:" + saldo_total);
        System.out.println("El saldo total es:" + (saldo_total + 2 + 2) + "€");
        
        float y;
        double z;
        y = 9;
        z = 5.5;
        
        System.out.println("Dato en pantalla: " + (y+z));
        
        //cadena de caracteres
        String miPrimeraPalabra ="Soy una cadena";
        System.out.println("Mi primera cadena es: " + miPrimeraPalabra);
        System.out.println("Mi primera cadena fue: " + miPrimeraPalabra + " he utilizado las variables, x:" + x + ", y:" + y +", z:" + z);
    }
}
