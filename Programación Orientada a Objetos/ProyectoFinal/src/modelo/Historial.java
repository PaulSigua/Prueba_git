/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Historial {
    private int tiempo;
    private Cliente cliente;

    
    public Historial(int tiempo, Cliente cliente) {        
        this.tiempo = tiempo;
        this.cliente = cliente;       
    }    
    
    public String getNombre() {
        return cliente.getNombre();
    }

    public void setNombre(String nombre) {
        this.cliente.setNombre(nombre);
    }

    public String getApellido() {
         return cliente.getApellido();
    }

    public void setApellido(String apellido) {
        this.cliente.setApellido(apellido);
    }

    public String getCedula() {
        return cliente.getCedula();
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "tiempo de atención: " + tiempo + " | " + cliente + '}' + "\n";
    }
}
