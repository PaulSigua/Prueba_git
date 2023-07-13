/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
//Importación de librerias/clases que se necesitan
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
//Método que nos permite usar una lista de clientes
public class DefaulListClients extends AbstractListModel<Client>{
    private ArrayList<Client> listClient;

    //Constructor
    public DefaulListClients() {
        this.listClient = new ArrayList();
    }
    
    //Método sobreescrito que nos devuleve el tamaño de la lista
    @Override
    public int getSize() {
        return listClient.size();
    }

    //Método sobreescrito que nos devuelve un elemento entero
    @Override
    public Client getElementAt(int c) {
        return listClient.get(c);
    }
    
    //Método para agregar un cliente
    public void addCliente(Client client)throws Exception{
        // "try y catch" para capturar excepciones
        try{
            listClient.add(client);
        int index = listClient.size();
        fireIntervalAdded(this, index, index);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se encontro al cliente");
        }
    }

    @Override
    public String toString() {
        return "DefaulListClients{" + "listClient=" + listClient + '}';
    }
   
}
