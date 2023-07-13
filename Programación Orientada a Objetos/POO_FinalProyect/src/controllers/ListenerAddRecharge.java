/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Alternatives;
import models.PreRecharge;
import models.RechargeClient;
import models.RechargeModel;
import view.MoviWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerAddRecharge implements ActionListener{
    MoviWindow mw;
    Alternatives alternatives;
    RechargeModel rm;

    public ListenerAddRecharge(MoviWindow mw, Alternatives alternatives, RechargeModel rm) {
        this.mw = mw;
        this.alternatives = alternatives;
        this.rm = rm;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
            String[] requiredRecharge = mw.getDesiredRechargeLine1();
            RechargeClient recharge = new RechargeClient();
            recharge.setCombo(alternatives.getAvailableLineCombos().get(requiredRecharge[2]));
            int nSlides = alternatives.getAvailableLineRecharge1().get(
                    requiredRecharge[1]).getCost().intValue();
            for(int i=0; i < nSlides; i++){
                recharge.addCombo(alternatives.getAvailableLineCombos().get(requiredRecharge[2]));
            }
            rm.addelementAT(recharge);
        }
        catch(Exception ex){
            mw.ShowDialog("Debe seleccionar una recarga");
        }
        
    }
    
}
