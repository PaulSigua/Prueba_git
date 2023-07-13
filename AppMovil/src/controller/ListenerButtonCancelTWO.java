
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonCancelTWO implements ActionListener{

    WindowLineTWO windowTwo;

    public ListenerButtonCancelTWO(WindowLineTWO windowTwo) {
        this.windowTwo = windowTwo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        windowTwo.getNameTextField().setText("");
        windowTwo.getNameTextField().cut();
        windowTwo.getIdTextField().setText("");
        windowTwo.getCellTextField().setText("");
        windowTwo.getAgeTextField().setText("");
        
        windowTwo.setVisible(false);
    }
    
}
