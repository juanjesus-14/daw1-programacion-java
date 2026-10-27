/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainconcesionario.act12;

/**
 *
 * @author juand
 */
public abstract class Vahiculo {
    
protected  String marca;
protected  String modelo;
protected  int anio;
protected  Combustible tipoCombustible;

    public Vahiculo(String marca, String modelo, int anio, Combustible tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipoCombustible = tipoCombustible;
    } 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Combustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(Combustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    
    public abstract void mostrarInformacion();
    
}
