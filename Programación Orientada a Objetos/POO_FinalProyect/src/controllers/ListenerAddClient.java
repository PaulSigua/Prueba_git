/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client;
import models.DefaultRecharge;
import models.Line;
import models.PreRecharge;
import view.MoviWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerAddClient implements ActionListener{
    MoviWindow mw;
    DefaultRecharge df;

    public ListenerAddClient(MoviWindow mw, DefaultRecharge df) {
        this.mw = mw;
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
            String[] recharge = mw.getDesiredRechargeLine1();
            df.addClientTC(new Client(recharge[0], recharge[1]));
        }
        catch(NullPointerException ex){
            mw.ShowDialog(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ListenerAddClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
