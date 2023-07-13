
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonTHREE implements ActionListener{

    WindowLineTHREE windowTHREE;

    public ListenerButtonTHREE(WindowLineTHREE windowThree) {
        this.windowTHREE = windowThree;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Linea tres visible");
        windowTHREE.setVisible(true);
        windowTHREE.setResizable(false);
    }
    
}
