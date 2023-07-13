/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.RechargeClient;
import models.RechargeListModel;
import view.ControlWindow;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerAddMaxi implements ActionListener{

    //Creación de atributos
    MainWindow mw;
    ControlWindow cw;
    RechargeListModel rlm;

    public ListenerAddMaxi(MainWindow mw, ControlWindow cw, RechargeListModel rlm) {
        this.mw = mw;
        this.cw = cw;
        this.rlm = rlm;
    }
    
    //Método sobreescrito
    @Override
    public void actionPerformed(ActionEvent arg0) {
        
    }
    
}
