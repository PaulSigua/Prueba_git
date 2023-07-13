
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonCancelONE implements ActionListener{
    
    private WindowLineONE windowOne;

    public ListenerButtonCancelONE(WindowLineONE windowOne) {
        this.windowOne = windowOne;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        windowOne.getNameTextField().setText("");
        windowOne.getNameTextField().cut();
        windowOne.getIdTextField().setText("");
        windowOne.getCellTextField().setText("");
        windowOne.getAgeTextField().setText("");
        
        windowOne.setVisible(false);
        
        //System.out.println("Se logro xd");
    }
    
}
