
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonCancelTHREE implements ActionListener{

    WindowLineTHREE windowThree;

    public ListenerButtonCancelTHREE(WindowLineTHREE windowThree) {
        this.windowThree = windowThree;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        windowThree.getNameTextField().setText("");
        windowThree.getNameTextField().cut();
        windowThree.getIdTextField().setText("");
        windowThree.getCellTextField().setText("");
        windowThree.getAgeTextField().setText("");
        
        windowThree.setVisible(false);
    }
    
}
