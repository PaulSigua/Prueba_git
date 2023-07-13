
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;


/**
 *
 * @author mateo
 */
public class ListenerButtonTWO implements ActionListener{

    WindowLineTWO windowTwo;

    public ListenerButtonTWO(WindowLineTWO windowTwo) {
        this.windowTwo = windowTwo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Linea dos visible");
        windowTwo.setVisible(true);
        windowTwo.setResizable(false);
    }
    
}
