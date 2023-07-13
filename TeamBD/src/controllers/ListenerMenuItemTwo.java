
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

/**
 *
 * @author mateo
 */
public class ListenerMenuItemTwo implements ActionListener{

    WindowMain windowMain;

    public ListenerMenuItemTwo(WindowMain windowMain) {
        this.windowMain = windowMain;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
