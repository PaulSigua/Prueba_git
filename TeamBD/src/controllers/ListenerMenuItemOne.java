
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

/**
 *
 * @author mateo
 */
public class ListenerMenuItemOne implements ActionListener{

    WindowMain windowMain;
    HelpWindow helpWindow;

    public ListenerMenuItemOne(WindowMain windowMain, HelpWindow helpWindow) {
        this.windowMain = windowMain;
        this.helpWindow = helpWindow;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        helpWindow.setVisible(true);
        helpWindow.setResizable(false);
        helpWindow.show(true);
    }
    
}
