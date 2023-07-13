/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Client;
import models.PreRechargeModel;
import models.RechargeClient;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerAddClient implements ActionListener{
    MainWindow mw; 
    PreRechargeModel prm;

    public ListenerAddClient(MainWindow mw, PreRechargeModel prm) {
        this.mw = mw;
        this.prm = prm;
    }

    //Método sobreescrito
    @Override
    public void actionPerformed(ActionEvent arg0) { 
            String[] cl = mw.getClient();
        try{
            prm.addElement(cl);
        }
        catch(NullPointerException ex){
            throw new NullPointerException("Los campos no estan llenos");
        }
    }
    
}
