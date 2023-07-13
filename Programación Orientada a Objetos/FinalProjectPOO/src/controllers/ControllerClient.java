/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//Importación de librerias/clases
import models.DefaulListClients;
import view.ControlWindow;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
//Método del controlador del cliente
public class ControllerClient {
    //Definición de los atributos a usarse
    DefaulListClients listClients;
    ControlWindow controlW;
    MainWindow mw;

    //Constructor de la clase)inicializacion de los métodos)
    public ControllerClient(DefaulListClients listClients, ControlWindow controlW, MainWindow mw) {
        this.listClients = listClients;
        this.controlW = controlW;
        this.mw = mw;
        
        ListenerContinue listenerContinue = new ListenerContinue(listClients, mw);
        mw.addActionListenerContinueRecharge(listenerContinue);
        controlW.setModelControlWindow(listClients);
        
    }
    
}
