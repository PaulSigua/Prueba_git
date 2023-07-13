package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import view.*;

/**
 *
 * @author mateo
 */
public class ListenerButtonEXIT implements ActionListener {

    private WindowApp windowMain;
    private boolean llave;

    public ListenerButtonEXIT(WindowApp windowMain) {
        this.windowMain = windowMain;
        this.llave = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
