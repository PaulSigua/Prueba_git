package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

/**
 *
 * @author mateo
 */
public class ListenerSeccionOneButton implements ActionListener {

    private SectionsWindow sectionsWindow;
    private boolean key;

    public ListenerSeccionOneButton(SectionsWindow sectionsWindow) {
        this.sectionsWindow = new SectionsWindow();
        this.key = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Si funciona el boton");
        sectionsWindow.getMainPanel().removeAll();
        this.key = true;
        sectionsWindow.getSeccionOnePanel().setVisible(key);
        System.out.println("/////////////////");
    }

}
