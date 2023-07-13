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

/**
 *
 * @author LENOVO
 */
public class ListenerRecharge implements ActionListener{

    ControlWindow cw;
    RechargeListModel rlm;

    public ListenerRecharge(ControlWindow cw, RechargeListModel rlm) {
        this.cw = cw;
        this.rlm = rlm;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
            RechargeClient recharge = cw.getSelectRecharge();
            rlm.changeElement(recharge, 0);
        }
        catch(IndexOutOfBoundsException ex){
            cw.showDialog("No hay recargas");
        }
    }
    
}
