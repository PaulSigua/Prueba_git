/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.CombosAndRecharges;
import models.PreRechargeModel;
import view.MainWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerAddTuenti implements ActionListener{
    MainWindow mw;
    PreRechargeModel prm;
    CombosAndRecharges cAndr;

    public ListenerAddTuenti(MainWindow mw, PreRechargeModel prm, CombosAndRecharges cAndr) {
        this.mw = mw;
        this.prm = prm;
        this.cAndr = cAndr;
    }
    
    //Método sobreescrito
    @Override
    public void actionPerformed(ActionEvent arg0) {
        
    }
    
}
