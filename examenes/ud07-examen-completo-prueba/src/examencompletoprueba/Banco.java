/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencompletoprueba;

//Banco
import java.util.ArrayList;

//-----------------------------------------------------
//- codigo : String
//- nombre : String
//- clientes : ArrayList<Cliente>
//-----------------------------------------------------
//+ Banco(codigo: String, nombre: String)
//+ insertaCliente(cliente: Cliente) : boolean
//+ eliminaCliente(cliente: Cliente) : boolean
//+ buscaCliente(dni: String) : Cliente
//+ listaClientes() : void
//+ toString() : String
//+ getters y setters
public class Banco {

    private String codigo;
    private String nombre;
    private ArrayList<Cliente> listaClientes;

    public Banco(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> Listaclientes) {
        this.listaClientes = Listaclientes;
    }

    public boolean insertaCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        return true;
    }

    public boolean eliminaCliente(Cliente cliente) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (cliente.getDni().equals(listaClientes.get(i).getDni())) {
                this.listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public void listaClientes() {
        System.out.print("\n--" + this.nombre + " " + this.codigo + "--");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("\n<Cliente " + (i + 1) + ">" + listaClientes.get(i));
        }
    }

    public Cliente buscaCliente(String dni) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (listaClientes.get(i).getDni().equals(dni)) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{" + "codigo=" + codigo + ", nombre=" + nombre + ", ListaClientes=" + listaClientes + '}';
    }

}
