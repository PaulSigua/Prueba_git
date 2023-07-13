
package usosdelford.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import usosdelford.*;

/**
 *
 * @author mateo
 */
public class ListenerDeleteButton implements ActionListener{

    private WindowFormulary windowFormulary;

    public ListenerDeleteButton(WindowFormulary windowFormulary) {
        this.windowFormulary = windowFormulary;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        windowFormulary.deleteInfo();
    }
    
}
