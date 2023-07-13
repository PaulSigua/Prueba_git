package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;


/**
 *
 * @author mateo
 */
public class ListenerButtonONE implements ActionListener{
    
    private WindowLineONE windowOne;
    private RechargeInformation rechargeInfo;
    
    public ListenerButtonONE(WindowLineONE windowOne) {
        this.windowOne = windowOne;
        this.rechargeInfo = new RechargeInformation();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Linea uno visible");
        
        windowOne.setVisible(true);
        windowOne.setResizable(false);
        //rechargeInfo.setVisible(true);
    }
    
}
