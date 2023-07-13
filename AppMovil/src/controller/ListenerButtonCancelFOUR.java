
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonCancelFOUR implements ActionListener{

    WindowLineFOUR windowFour;

    public ListenerButtonCancelFOUR(WindowLineFOUR windowFour) {
        this.windowFour = windowFour;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        windowFour.getNameTextField().setText("");
        windowFour.getNameTextField().cut();
        windowFour.getIdTextField().setText("");
        windowFour.getCellTextField().setText("");
        windowFour.getAgeTextField().setText("");
        
        windowFour.setVisible(false);
    }
    
}
