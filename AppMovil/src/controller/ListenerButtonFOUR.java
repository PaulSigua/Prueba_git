
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonFOUR implements ActionListener{

    WindowLineFOUR windowFOUR;

    public ListenerButtonFOUR(WindowLineFOUR windowFour) {
        this.windowFOUR = windowFour;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Linea cuatro visible");
        windowFOUR.setVisible(true);
        windowFOUR.setResizable(false);
    }
    
}
