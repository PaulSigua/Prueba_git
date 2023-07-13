/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class DefaultListaClientes extends AbstractListModel<Cliente>{
    private ArrayList<Cliente> listaCliente;

    public DefaultListaClientes() {
        this.listaCliente = new ArrayList();
    }
    
    @Override
    public int getSize() {
        return listaCliente.size();
    }

    @Override
    public Cliente getElementAt(int index) {
        return listaCliente.get(index);
    }

    public void addCliente(Cliente cliente)throws Exception{
        listaCliente.add(cliente);
        int index = listaCliente.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void addClienteTC(Cliente cliente){
        try{
            addCliente(cliente);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se encontro al cliente");
        }
    }
    
}
