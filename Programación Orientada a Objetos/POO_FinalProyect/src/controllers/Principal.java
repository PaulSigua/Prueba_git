/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Alternative;
import models.Alternatives;
import models.PreRecharge;
import models.RechargeModel;
import view.ClaroWindow;
import view.ClientWindow;
import view.MainWindow;
import view.MaxiplusWindow;
import view.MoviWindow;
import view.TuentiWindow;

/**
 *
 * @author LENOVO
 */
public class Principal {
    public static void main (String[] args){
        
        MainWindow mainW = new MainWindow();
        Alternatives a = new Alternatives();
        Alternative recharge = new Alternative(a.getAvailableLineRecharge1());
        Alternative combo = new Alternative(a.getAvailableLineCombos());
        MoviWindow moviW = new MoviWindow();
        moviW.setModelMovi(recharge, combo);
        ClaroWindow claroW = new ClaroWindow();
        claroW.setModelClaro(recharge, combo);
        TuentiWindow tuentiW = new TuentiWindow();
        tuentiW.setModelTuenti(recharge, combo);
        MaxiplusWindow maxiW = new MaxiplusWindow();
        maxiW.setModelMaxiplus(recharge, combo);
        
        ClientWindow clientWindow = new ClientWindow();
        RechargeModel rechargeModel = new RechargeModel();
        ListenerOpenMovi openMovi = new ListenerOpenMovi(moviW);
        mainW.addActionListenerMovi(openMovi);
        ListenerOpenClaro openClaro = new ListenerOpenClaro(claroW);
        mainW.addActionlistenerClaro(openClaro);
        ListenerOpenTuenti openTuenti = new ListenerOpenTuenti(tuentiW);
        mainW.addActionListenerTuenti(openTuenti);
        ListenerOpenMaxi openMaxi = new ListenerOpenMaxi(maxiW);
        mainW.addActionListenerMaxi(openMaxi);
        
        ListenerAddRecharge lar = new ListenerAddRecharge(moviW, a, rechargeModel);
        moviW.addRechargeButtonMovi(lar);
        mainW.setVisible(true);
        clientWindow.setVisible(true);
    }
}
