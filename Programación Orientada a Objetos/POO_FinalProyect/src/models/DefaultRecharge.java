/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DefaultRecharge extends AbstractListModel<Client>{
    private ArrayList<Client> listaCliente;

    public DefaultRecharge() {
        this.listaCliente = new ArrayList();
    }
    
    @Override
    public int getSize() {
        return listaCliente.size();
    }

    @Override
    public Client getElementAt(int index) {
        return listaCliente.get(index);
    }

    public void addClient(Client client)throws Exception{
        listaCliente.add(client);
        int index = listaCliente.size();
        fireIntervalAdded(this, index, index);
    }
    
    public void addClientTC(Client client){
        try{
            addClient(client);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se encontro al cliente");
        }
    }
}
