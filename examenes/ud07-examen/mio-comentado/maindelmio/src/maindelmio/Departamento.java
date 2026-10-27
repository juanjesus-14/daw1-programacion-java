/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindelmio;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Departamento {
    
    private String codDepto;
    private String nombreDepto;
    private ArrayList <Empleado> listaEmp;

    public Departamento(String codDepto, String nombreDepto) {
        this.codDepto = codDepto;
        this.nombreDepto = nombreDepto;
        this.listaEmp = new ArrayList<>();
    }

    public Departamento() {
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public ArrayList<Empleado> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(ArrayList<Empleado> listaEmp) {
        this.listaEmp = listaEmp;
    }
    
    public boolean asignaEmpleado(Empleado e) {
        this.listaEmp.add(e);
        return true;
    }

    public boolean eliminaEmpleado(Empleado e) {
        for (int i = 0; i < this.listaEmp.size(); i++) {
            if (e.getDni().equals(listaEmp.get(i).getDni())) {
                this.listaEmp.remove(e);
                return true;
            }
        }
        return false;
    }
    
    public void listarEmpleados(){
        System.out.print("\n--" + this.nombreDepto+" "+ this.codDepto + "--" );
        for (int i = 0; i < listaEmp.size(); i++) {
            System.out.println("\n<Empleado "+(i+1)+">"+listaEmp.get(i));
        }
    }

    @Override
    public String toString() {
        return "Departamento: " +nombreDepto+
                "\nCódigo: " + codDepto +
                "\nNúmero de empleados: " + this.listaEmp.size();
    }
    
}
