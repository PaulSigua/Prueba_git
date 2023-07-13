/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//Importación de librerias/clases
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client;
import models.DefaulListClients;
import view.ControlWindow;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
//Método de la clase ListenerContinue
public class ListenerContinue implements ActionListener{
    DefaulListClients listClients;
    MainWindow mw;

    //Constructor e inicialización de atributos

    public ListenerContinue(DefaulListClients listClients, MainWindow mw) {
        this.listClients = listClients;
        this.mw = mw;
    }
    

    //Método abstracto
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String[] client = mw.getClient();
        try{
            listClients.addCliente(new Client(client[0], client[1]));
            
        } catch (Exception ex) {
            Logger.getLogger(ListenerContinue.class.getName()).log(Level.SEVERE, null, "Ya no hay clientes");
        }
    }
    
}
